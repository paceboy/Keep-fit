# -*- coding: utf-8 -*-
# @Author: Liushaogeng
# @Date:  2020-12-29 15:00:00
# @Last Modified by:  Liushaogeng
# @Last Modified time: 2021-01-04 15:00:00
# @Description: 单元测试函数

import pytest
import sys
sys.path.append("..")
from spider.spider import Spider
from spider import config_load

def test_size():
    config = config_load.Config()
    config_parser = config.read("../docs/conf/spider.conf")
    spider = Spider(config_parser)
    assert 0 == spider.size()

def test_execute():
    config = config_load.Config()
    config_parser = config.read("../docs/conf/spider.conf")
    spider = Spider(config_parser)
    url = "http://www.baidu.com"
    spider.page_urls_dict[url] = 0
    spider.execute("http://www.baidu.com")

if __name__ == '__main__':
    pytest.main(['test_spider.py'])