import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, status
from utils.soap_client import BC_soap_client
from utils import body 
from .schemas import IncreaseCreditRequest


def increase_credit(data:IncreaseCreditRequest):
    print('data:', {**data.__dict__})
    print("datetime:",datetime.now().strftime("%Y-%m-%dT%H:%M:%S"))
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/Payment.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    values = {
         **data.__dict__,
         "datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
    }
    xml_data = template.render(**values)
    print("request:", xml_data)
    return BC_soap_client.call_service('IncreaseCredit', xml_data)
    

def generate_response(cbs_response) :
    root = ET.fromstring(cbs_response)
    namespaces = {
    'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
    'bcs': 'http://www.huawei.com/bme/cbsinterface/bcservices',
    'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
    'bcc': 'http://www.huawei.com/bme/cbsinterface/bccommon'
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


