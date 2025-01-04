#!/usr/bin/python3
import requests
import threading
import time
from datetime import datetime
thread_count = 500
thread_interval = 1/thread_count
def _call_webservice(thread_number):
    begin_time = datetime.now()
    url = "http://172.22.0.166:8000/cbs/wrapper/queryAllBalance"
    headers= {'content-type': 'application/json'}
    payload = {"MSISDN": "989210452132"}  
    response = requests.post(url,json=payload,headers=headers,timeout=100,proxies= {'http':''})
    end_time = datetime.now()
    # print(f"{thread_number}: {response.content}")
    print(f"'begin time:' {begin_time} {end_time-begin_time}")

threads = []
while True:
    for i in range(thread_count) :
        time.sleep(thread_interval)
        thread = threading.Thread(target=_call_webservice,args=(i,))
        threads.append(thread)
        thread.start()


