import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, status
from utils.soap_client import BC_soap_client
from utils import body 
from .schemas import PaygChangeRequest
from utils.custom_handler import CustomException
from utils.utils import get_login_and_password


def payg_change_request_handler(data:PaygChangeRequest):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/changeSubInfo.txt', 'r') as file:
        template = file.read()
    # system_auth_info = get_login_and_password(data.modifiedBy)
    template = Template(template)
    opTypeMapper = {
        "210":0, #Activate Data PAYG Service (Default Value) /current is :1
        "211":1, #Deactivate Data PAYG Service /current is :0
    }
    data.opType = opTypeMapper[data.opType]
    xml_data = template.render({
        **data.__dict__,
        "datetime": datetime.now().strftime("%Y%m%dT%H%M%S%f"),
        # **system_auth_info
    })
    print("request:", xml_data)
    return BC_soap_client.call_service('Recharge', xml_data)

def generate_response(cbs_response, data) :
    print("cbs_response:", cbs_response)
    root = ET.fromstring(cbs_response)
    namespaces = {
    'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
    'bcs': 'http://www.huawei.com/bme/cbsinterface/bcservices',
    'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
    'bcc': 'http://www.huawei.com/bme/cbsinterface/bccommon'
    }

    result_code = root.find('.//cbs:ResultCode', namespaces)
    result_desc = root.find('.//cbs:ResultDesc', namespaces)
    attributeStatus = 1 if data.opType else 0
    
    if result_code is not None and result_code.text == '0':
        return {
                "attributeStatus":attributeStatus,
                "responseDesc": "Successful",
                "subscriberNumber": data.subscriberNumber,
                "responseCode": "0"
            }
    elif result_code is not None and result_code.text == '20000005':
        return {
                "attributeStatus":attributeStatus,
                "responseDesc": data.subscriberNumber,
                "subscriberNumber": "",
                "responseCode": "10018"
            }
    else:
        raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())
