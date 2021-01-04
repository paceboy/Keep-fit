# -*- coding: utf-8 -*-
"""
# @Author: Liushaogeng
# @Date:  2020-12-29 15:00:00
# @Last Modified by:  Liushaogeng
# @Last Modified time: 2020-12-29 15:00:00
# @Description: 网页爬取
"""

from spider.spider import Spider
from spider import config_load

# 1、读取配置文件
config = config_load.Config()
config_parser = config.read("docs/conf/spider.conf")
list_file_path = config_parser.get("spider", "url_list_file")
print "list_file_path "
print list_file_path


# 2、读取种子文件
feed_config_parser = config.read(list_file_path + "seed.conf")
seeds = feed_config_parser.get("seed", "url")

for value in seeds.split(","):
    print value
    # 3、抓取网页
    spider = Spider(config_parser)
    spider.page_urls_dict[value] = 0
    spider.execute(value)