# -*- coding: utf-8 -*-
"""
# @Author: Liushaogeng
# @Date:  2020-12-29 15:00:00
# @Last Modified by:  Liushaogeng
# @Last Modified time: 2020-12-29 15:00:00
# @Description: 多线程测试使用
"""

import threading
import time

max_connections = 4 # 定义最大线程数
pool_sema = threading.BoundedSemaphore(max_connections)
sem = threading.Semaphore(max_connections)  # 限制线程的最大数量为4个
lock = threading.Lock()

def gothread():
    """
    测试多线程函数
    :param:
    :return:
    """
    # with sem:  # 锁定线程的最大数量
    #
    for i in range(8):
        lock.acquire()
        print(threading.current_thread().name, i)
        print "activecount = ", threading.active_count()
        lock.release()

        time.sleep(3)
    sem.release()

if __name__ == '__main__':
    for i in range(15):
        if sem.acquire():
            threading.Thread(target=gothread).start()