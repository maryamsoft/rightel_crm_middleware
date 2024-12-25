import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from utils.soap_client import AR_soap_client
from utils.custom_handler import CustomException
from utils.utils import get_login_and_password
            

def check_credit_limit(data):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/QueryBalance.txt', 'r') as file:
        template = file.read()
    system_auth_info = get_login_and_password()
    template = Template(template)
    values = {
         **data.__dict__,
         "datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
         **system_auth_info
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
        Balance = root.find('.//ars:BalanceResult[arc:BalanceType="C_MAIN_BILLING_ACCOUNT"]/arc:TotalAmount', namespaces)
        CreditLimit = root.find('.//ars:AccountCredit/ars:TotalCreditAmount', namespaces)
        DefaultCL = root.find('.//ars:CreditAmountInfo/ars:Amount', namespaces)
        NonDefaultCL = root.find('.//ars:BalanceResult[arc:BalanceType="C_DEPOSIT_ACCOUNT"]/arc:TotalAmount', namespaces)
        CreditUsed = root.find('.//ars:AccountCredit/ars:TotalUsageAmount', namespaces)
        CreditAvailable = root.find('.//ars:AccountCredit/ars:TotalRemainAmount', namespaces)
        IncreaseLimit = root.find('.//ars:MaximumDepositAmount', namespaces)
        response = {
            "Balance": Balance.text.strip() if Balance is not None else 0,
            "CreditLimit": CreditLimit.text.strip(),
            "DefaultCL": DefaultCL.text.strip() if DefaultCL is not None else 0,
            "CreditUsed": CreditUsed.text.strip(),
            "CreditAvailable": CreditAvailable.text.strip(),
            "NonDefaultCL" : NonDefaultCL.text.strip() if NonDefaultCL is not None else None,
            "IncreaseLimit" : IncreaseLimit.text.strip() if IncreaseLimit is not None else 0,
        }
        return response
    else:
        raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())

    
    


