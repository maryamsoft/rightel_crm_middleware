import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, status
from utils.soap_client import BC_soap_client
from utils import body 
from utils.custom_handler import CustomException
from utils.utils import get_login_and_password


def ChangeSubOffering(data):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/ChangeSubOffering.txt', 'r') as file:
        changeSubOffering_template = file.read()
    changeSubOffering_template = Template(changeSubOffering_template)
    changeSubOffering = changeSubOffering_template.render({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
                                                           "C_FREE_PAY_FLAG" : 0 if str(data.payFlag)=="1" else 1})
    print('request:', changeSubOffering)
    system_auth_info = get_login_and_password()
    return BC_soap_client.call_service('ChangeSubOffering', {**changeSubOffering, **system_auth_info})
    

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
        offering_id = root.find('.//bcc:PurchaseSeq', namespaces)
        if offering_id is not None:
            return offering_id.text.strip()

    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())
        
    

