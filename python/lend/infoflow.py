# coding: utf-8
import json

import requests


class InfoFlow:

    """
    如流类，当前可支持发送消息
    """
    # url = "http://apiin.im.baidu.com/api/msg/groupmsgsend?access_token=d232d061a80bd6cf25638952d7de74f64"
    url = "http://apiin.im.baidu.com/api/msg/groupmsgsend?access_token=da33c8cc94e228d67f4dc6c525c16ccf0"

    def sendmsg(self, msg):
        """
        给如流某个群发消息，当前群号为4020337
        :param msg:
        :return:
        """
        msg_json = json.dumps(msg, ensure_ascii=False)
        payload = {'message': {'header': {'toid': [4020337]}, 'body': [{'content': msg_json, 'type': 'TEXT'}, {'atuserids': ['liushaogeng'], 'atall':False, 'type':'AT'}]}}
        # payload = "{\"message\":{\n        \"header\":{\n            \"toid\":[4020337]\n        },\n        \"body\":[\n            {\n                \"content\":\"test\", \n                \"type\":\"TEXT\"\n            },\n            {\n                \"atuserids\":[\"liushaogeng\"],\n                \"atall\":false, \n                \"type\":\"AT\"\n            }\n        ]\n    }}"

        headers = {
            'Content-Type': 'text/plain',
            'Cookie': 'BAIDUID=2811771E6632049684FE9F201CC7BBC6:FG=1'
        }

        response = requests.request("POST", self.url, headers=headers, data=json.dumps(payload))

        print(response.text)
