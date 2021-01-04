# -*- coding: utf-8 -*-
"""
# @Author: Liushaogeng
# @Date:  2020-12-29 15:00:00
# @Last Modified by:  Liushaogeng
# @Last Modified time: 2020-12-29 15:00:00
# @Description: 配置文件解析类
"""
import ConfigParser

class Config:
    """
    配置文件解析类
    """
    def read(self, filename):
        """
        读取文件，返回文件句柄
        :param filename:
        :return:
        """
        config = ConfigParser.ConfigParser()
        config.readfp(open(filename))
        return config

