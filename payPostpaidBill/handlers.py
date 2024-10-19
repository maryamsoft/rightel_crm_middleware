import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from utils.soap_client import BC_soap_client
from fastapi import HTTPException, Security, status


def pay_postpaid_bill_handler(data):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/Payment.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    map_bankId = {
        1: 1001,
        2: 2001,
        3: 3001
        # TODO: Add more bankId mappings
    }
    values = {
         **data.__dict__,
         "datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
         "BankId": map_bankId.get(data.BankId, 1001)
    }
    xml_data = template.render(**values)
    return BC_soap_client.call_service('PayPostpaidHotBill', xml_data)



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
        return {
            "responseCode": None,
            "responseDesc": None
        }
    return None    
    raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST)