import os
import xml.etree.ElementTree as ET
from string import Template
from datetime import datetime
from utils.soap_client import BC_soap_client
from fastapi import HTTPException, Security, status


def pay_postpaid_hot_bill_handler(data):
    print('data:', {**data.__dict__})
    print("datetime:",datetime.now().strftime("%Y-%m-%dT%H:%M:%S"))
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/Payment.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    dict_data = {**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S")}
    xml_data = template.substitute({k: v for k, v in dict_data.items() if v is not None})
    print("request:", xml_data)
    return BC_soap_client.call_service('PayPostpaidHotBill', xml_data)



def generate_response(response) :
        root = ET.fromstring(response)
        namespaces = {
        'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
        'bcs': 'http://www.huawei.com/bme/cbsinterface/bcservices',
        'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
        'bcc': 'http://www.huawei.com/bme/cbsinterface/bccommon'
        }
        balance = root.find('.//arc:NewBalanceAmt', namespaces)
        if balance is not None:
            return {
                    "Balance": balance.text.strip()
                }
        
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST)