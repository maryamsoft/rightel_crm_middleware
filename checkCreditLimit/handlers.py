import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, status
from utils.soap_client import AR_soap_client
from utils import body 


def check_credit_limit(data):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/QueryBalance.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    values = {
         **data.__dict__,
         "datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
    }
    xml_data = template.render(**values)
    print("request:", xml_data)
    return AR_soap_client.call_service('CheckCreditLimit', xml_data)
    
def generate_response(cbs_response) :
    print('response:', cbs_response)
    root = ET.fromstring(cbs_response)
    namespaces = {
    'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
    'ars': 'http://www.huawei.com/bme/cbsinterface/arservices',
    'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
    'arc': 'http://cbs.huawei.com/ar/wsservice/arcommon'
    }
    result_code = root.find('.//cbs:ResultCode', namespaces)
    result_desc = root.find('.//cbs:ResultDesc', namespaces)
    if result_code is not None and result_code.text == '0':
        # Balance = root.find('.//arc:NewBalanceAmt', namespaces)
        CreditLimit = root.find('.//ars:TotalCreditAmount', namespaces)
        DefaultCL = root.find('.//ars:Amount', namespaces)
        # NonDefaultCL = root.find('.//arc:', namespaces) TODO: Add NonDefaultCL
        CreditUsed = root.find('.//ars:TotalUsageAmount', namespaces)
        CreditAvailable = root.find('.//ars:TotalRemainAmount', namespaces)
        return {
                    # "Balance": Balance.text.strip(),
                    "CreditLimit": CreditLimit.text.strip(),
                    "DefaultCL": DefaultCL.text.strip(),
                    # "NonDefaultCL": NonDefaultCL.text.strip(),
                    "CreditUsed": CreditUsed.text.strip(),
                    "CreditAvailable": CreditAvailable.text.strip()
        }
    
    return None
    raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST)


