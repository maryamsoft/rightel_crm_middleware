import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import Response
from utils.soap_client import BC_soap_client
from .schemas import PaygCheckRequest


def payg_check_request(data:PaygCheckRequest):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/QueryCustomerInfo.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    values = {
         **data.__dict__,
         "datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
    }
    xml_data = template.render(**values)
    print("request:", xml_data)
    return BC_soap_client.call_service('PaygCheckRequest', xml_data)
    

def generate_response(cbs_response) :
    print('response:', cbs_response)
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
        ATTRIBUTE_STATUS_title = root.find('.//bcc:Code', namespaces)
        ATTRIBUTE_STATUS_value = root.find('.//bcc:Value', namespaces)
        RESPONSE_CODE = result_code.text
        sub_identity = root.find('.//bcc:SubIdentity', namespaces)
        if sub_identity is not None:
            subscriberNumber = sub_identity.find('bcc:SubIdentity', namespaces).text
        return {
                "attributeStatus":ATTRIBUTE_STATUS_value.text.strip(),
                "responseDesc": "Successful",
                "subscriberNumber": subscriberNumber,
                "responseCode": RESPONSE_CODE
            }
    return None


