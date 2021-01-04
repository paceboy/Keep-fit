# -*- coding: utf-8 -*-
"""
    @Author: Liushaogeng
    @Date:  2020-12-29 15:00:00
    @Last Modified by:  Liushaogeng
    @Last Modified time: 2020-12-29 15:00:00
"""


class HtmlSave:
    """
    网页内容存储函数
    """
    filename = ''
    path = ''

    def save(self, str):
        """
        将字符串存储到文件
        str 存储的内容
        """
        amendfilename = self.path + self.filename.replace('/', '_')
        with open(amendfilename, 'wb') as f:
            f.write(str)
            f.close()

    def __init__(self, filename, path):
        self.filename = filename
        self.path = path