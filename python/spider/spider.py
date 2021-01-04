# -*- coding: utf-8 -*-
"""
# @Author: Liushaogeng
# @Date:  2020-12-29 15:00:00
# @Last Modified by:  Liushaogeng
# @Last Modified time: 2020-12-29 15:00:00
"""

from bs4 import BeautifulSoup
import threading
from Queue import Queue
from urllib2 import urlopen

import re
import time

import html_save

stop_flag = "stop"
class Spider:
    """
    Spider 网页爬取核心实现
    """
    # 抓取过的网页url
    page_urls_dict = {}

    # 线程锁
    lock = threading.Lock()

    # 初始化
    def __init__(self, config_parser):
        self.config_parser = config_parser
        max_thread = int(self.config_parser.get("spider", "thread_count"))
        self.sem = threading.Semaphore(max_thread)  # 线程的最大数量
        self.queue = Queue()
        self.limit = int(self.config_parser.get("spider", "max_depth"))
        self.crawl_interval = int(self.config_parser.get("spider", "crawl_interval"))
        self.crawl_timeout = int(self.config_parser.get("spider", "crawl_timeout"))

    def execute(self, page_url):
        """
        抓取网页
        :param page_url:
        :return:
        """
        resp = self.__getrespandsave(page_url)
        sub_urls = self.__parseresp(page_url, resp)
        for url in sub_urls:
            self.queue.put(url)

        while True:
            url = self.queue.get()
            # 停止标示且后续无数据,且无子线程则退出
            if url == stop_flag and self.queue.empty() \
                    and threading.active_count() == 1:
                break
            # 跳过本次
            if url == stop_flag:
                continue
            self.sem.acquire()
            self.lock.acquire()
            print "----- sem.acquire() -----"
            self.lock.release()
            t = threading.Thread(target=self.__getrespandsaveandparse, args=(url,))
            t.start()

    def __getrespandsave(self, page_url):
        """
        获取网页同时存储
        :param page_url:
        :return:返回网页内容
        """
        self.lock.acquire()
        print("active count = ", threading.active_count()-1)
        self.lock.release()

        # 获取网页内容
        html = urlopen(page_url, timeout=self.crawl_interval)
        response = html.read()

        # 存储文件
        self._save(response, page_url)
        return response

    def __getrespandsaveandparse(self, page_url):
        """
        获取网页同时存储
        :param page_url:
        :return:返回网页内容
        """
        try:
            time.sleep(self.crawl_interval)
            resp = self.__getrespandsave(page_url)
            sub_urls = self.__parseresp(page_url, resp)
            for url in sub_urls:
                self.queue.put(url)
        except Exception as e:
            print("getrespandsavethreadsafe Exception: %s" % e)
        finally:
            self.lock.acquire()
            print("----- sem.release() -----")
            self.lock.release()
            self.sem.release()

    def __parseresp(self, page_url, resp):
        """
        解析网页内容
        :param page_url:
        :return:返回网页内容
        """
        new_page_urls = []
        bsObj = BeautifulSoup(resp, "html.parser")
        for link in bsObj.findAll("a"):
            if 'href' in link.attrs:
                res = re.match("(http|https)://[^\s]+", link.attrs['href'])
                if res:
                    if link.attrs['href'] not in self.page_urls_dict:
                        new_page = link.attrs['href']
                        # 防止重复：key存在代表已经抓取过一次
                        if new_page in self.page_urls_dict.keys():
                            continue
                        self.page_urls_dict[new_page] = self.page_urls_dict[page_url] + 1
                        # 达到层级深度
                        if self.page_urls_dict[new_page] > self.limit:
                            self.lock.acquire()
                            print "----- out of limit -----"
                            self.lock.release()
                            new_page_urls.append(stop_flag)
                            break
                        new_page_urls.append(new_page)
        # 已经无数据
        if len(new_page_urls) == 0:
            new_page_urls.append(stop_flag)
        return new_page_urls

    def executerecurse(self, page_url):
        """
        弃用原因：递归调用方法，多线程不好控制
        抓取网页
        :param page_url:
        :return:
        """
        try:
            print("active count = ", threading.active_count())
            if len(page_url) == 0:
                return
            # 判断深度是否超过极限
            current_count = self.page_urls_dict[page_url]
            limit = int(self.config_parser.get("spider", "max_depth"))
            if current_count >= limit:
                print("reach limit")
                return

            # 获取网页内容
            html = urlopen(page_url, timeout=60)
            response = html.read()

            # 存储文件
            self._save(response, page_url)

            # 解析子url
            bsObj = BeautifulSoup(response, "html.parser")
            for link in bsObj.findAll("a"):
                if 'href' in link.attrs:
                    res = re.match("(http|https)://[^\s]+", link.attrs['href'])
                    if res:
                        if link.attrs['href'] not in self.page_urls_dict:
                            new_page = link.attrs['href']
                            self.page_urls_dict[new_page] = self.page_urls_dict[page_url] + 1
                            self.executerecurse(new_page)
            print ("execute ok " + page_url)
            self.executerecurse("")
        except Exception as e:
            print("Exception: %s" % e)
        finally:
            pass

    def _save(self, content, url):
        """
        存储html内容为文件
        :param content:
        :param url:
        :return:
        """
        # 存储文件
        html_url = self.config_parser.get("spider", "target_url")
        res = re.match(html_url, url)
        if res:
            output = self.config_parser.get("spider", "output_directory")
            hmtlSave = html_save.HtmlSave(url, output)
            hmtlSave.save(content)

    def size(self):
        """
        测试函数
        :return:
        """
        return 0
