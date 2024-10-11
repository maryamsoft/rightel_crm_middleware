import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from utils.soap_client import AR_soap_client
from fastapi import HTTPException, Security, status
from .schemas import RechargeRequest


def recharge_handler(data:RechargeRequest):
    print('data:', {**data.__dict__})
    print("datetime:",datetime.now().strftime("%Y-%m-%dT%H:%M:%S"))
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/Recharge.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    xml_data = template.render({
        **data.__dict__,
        "datetime": datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
    })
    print("request:", xml_data)
    return AR_soap_client.call_service('Recharge', xml_data)



def generate_response(response) :
    print('response:', response)
    root = ET.fromstring(response)
    namespaces = {
    'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
    'ars': 'http://www.huawei.com/bme/cbsinterface/arservices',
    'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
    'arc': 'http://cbs.huawei.com/ar/wsservice/arcommon'
    }
    result_code = root.find('.//cbs:ResultCode', namespaces)
    result_desc = root.find('.//cbs:ResultDesc', namespaces)
    if result_code is not None and result_code.text == '0':
        balance = root.find('.//arc:NewBalanceAmt', namespaces)
        if balance is not None:
            return {
                    "Balance": balance.text.strip()
            }
    
    raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST)