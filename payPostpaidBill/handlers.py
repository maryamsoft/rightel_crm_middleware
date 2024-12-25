import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from utils.soap_client import AR_soap_client
from fastapi import HTTPException, Security, status
from utils.custom_handler import CustomException
from utils.utils import get_login_and_password

def pay_postpaid_bill_handler(data):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/Payment.txt', 'r') as file:
        template = file.read()
    system_auth_info = get_login_and_password()
    template = Template(template)
    
    values = {
         **data.__dict__,
         "datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
         **system_auth_info
    }
    xml_data = template.render(**values)
    print('request:', xml_data)
    return AR_soap_client.call_service('PayPostpaidHotBill', xml_data)



def generate_response(cbs_response) :
    print('cbs-response:', cbs_response)
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
    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())    
    