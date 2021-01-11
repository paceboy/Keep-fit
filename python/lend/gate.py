# coding: utf-8
import json
import sys
import time
import requests

from infoflow import InfoFlow


class Gate:
    url = "https://www.gateio.pro/json_svr/"
    orderbook_url = url + "get_lend_orderbook?u=16&c=83150"
    orderbook_data = {'asset': 'USDT'}

    c2loan_url = url + "query_c2cloan"
    c2loan_data = {'type':'c2cloan_order_list','fiat_type':'CNY', 'borrow_amount_seq':'0',
                    'lend_amount_seq':'0', 'borrow_period':'0', 'lend_period':'0', 'borrow_paytype':'0', 'lend_paytype':'0'}

    content_type = {'Content-Type':'application/json'}

    def getorderbook(self):
        """
        获取当前币币理财的贷款利率
        :return:
        """
        headers = {
            'Cookie': 'ref_uid=888888; idb=1608633975; market_title=usdt; b_notify=1; lang=cn; c2crisktip=1; l_d_data_USDT_time=1609034509670; help_cate=c2c; autoInvestRisktip=1; uid=888888; nickname=gateaccount; is_on=1; pver=84fa5001f42c4731b334edcebb32f3fa; csrftoken=2c0a228fdd1b8321fe4330ae2bd2a61bbc7c7624923c47c3; login_notice_check=%2F; show_chat=0; nav_index=3; lasturl=%2Fmargin%2Flend%2FUSDT; login_notice_check=%2F'
        }

        response = requests.request("POST", self.orderbook_url, headers=headers, data=self.orderbook_data)

        print(response.text)



    def getc2loanrecord(self):
        """
        获取当前法币的贷款利率
        :return:
        """
        headers = {
            'Cookie': 'login_notice_check=%2F'
        }

        response = requests.request("POST", self.c2loan_url, headers=headers, data=self.c2loan_data)

        print(response.text)
        return response.text

    def filterexpectloanrecords(self):
        """
        获取期望的贷款记录:年化超过8%，贷款天数<=30，最少贷款数<10000
        :return:
        """
        expect_loan_records = []

        all_loan_record = self.getc2loanrecord()
        try:
            records = json.loads(all_loan_record)["c2cloan_order"]
        except:
            records = ""

        if len(records) != 0:
            for index, item in enumerate(records):
                # 符合预期
                if self.is_expect(item):
                    dic = {'index': index, 'loan_name': item[0], 'total': item[2], 'min_loan': item[6],
                           'annualized_interest_rate': item[3]*365, 'day_interest_rate': item[3], 'loan_days': item[5], 'digital_type': item[8]}
                    expect_loan_records.append(dic)
                    if index > 3:
                        break
        return expect_loan_records

    def is_expect(self, record):
        """
        此借贷单子是否符合预期:年化超过8%，贷款天数<=30，最少贷款数<10000, 有抵押
        :param record:3贷款日化, 6 最小贷款额度，8 抵押数字货币类型，9 抵押与否，15是否售罄，18 是否记录删除
        :return:
        """
        if record[6] < 5000 and record[3]*365 >= 8.5 and record[5] <= 30 and record[15] == 0 and record[18] == 0 and len(record[8]) > 0 and self.is_mortgage(record[9]):
            return True
        return False

    def is_mortgage(self, mortgage):
        """
        如果有抵押数字货币
        :param mortgage:
        :return:
        """
        if len(mortgage) > 0:
            for index, item in enumerate(mortgage):
                if item > 0:
                    return True
        return False

    def main(self):
        # self.getorderbook()
        infoflow = InfoFlow()
        # infoflow.sendmsg("test")
        records = self.filterexpectloanrecords()
        if len(records) > 0:
            infoflow.sendmsg(records)
            infoflow.sendmsg("------有符合利率期望的Loan单子了-----")

gate = Gate()

while True:
    gate.main()
    time.sleep(30)