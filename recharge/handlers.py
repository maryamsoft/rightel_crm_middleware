import os
import xml.etree.ElementTree as ET
from string import Template
from datetime import datetime
from utils.soap_client import soap_client
from fastapi import HTTPException, Security, status


def recharge_handler(data):
    print('data:', {**data.__dict__})
    print("datetime:",datetime.now().strftime("%Y-%m-%dT%H:%M:%S"))
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/Recharge.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    xml_data = template.substitute({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S")})
    print("request:", xml_data)
    return soap_client.call_service('Recharge', xml_data)



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