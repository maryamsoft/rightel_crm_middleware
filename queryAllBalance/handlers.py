import requests
import os
from lxml import etree
from utils import body
from jinja2 import Template
from datetime import datetime
from utils.soap_client import BC_soap_client
import xml.etree.ElementTree as ET


def customerInfo(data):
    # data.msisdn=9210451762
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/CustomerInfo.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    values = {
         **data.__dict__,
         "datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
    }
    xml_data = template.render(**values)
    # print("request:", xml_data)
    return BC_soap_client.call_service('QueryCustomerInfo', xml_data)

    

def generate_response(cbs_response) :
    # print("cbs_response", cbs_response)
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
        balance_type = root.find('.//bcs:BalanceType', namespaces)
        print("balance_type", balance_type)
        balance_type_name = root.find('.//bcs:BalanceTypeName', namespaces)
        total_amount = root.find('.//bcs:TotalAmount', namespaces)
        amount = root.find('.//bcs:Amount', namespaces)
        effective_time = root.find('.//bcs:EffectiveTime', namespaces)
    
    raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail= result_desc.text)
