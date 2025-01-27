import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from utils.soap_client import AR_soap_client
from fastapi import HTTPException, Security, status
from .schemas import RechargeRequest
from utils.custom_handler import CustomException
from utils.utils import get_login_and_password


def recharge_handler(data:RechargeRequest):
    print('data:', data)
    app_path = os.path.dirname(os.path.abspath(__file__))
    
    with open(app_path+'/templates/payloads/Recharge.txt', 'r') as file:
        template = file.read()
    # system_auth_info = get_login_and_password()
    template = Template(template)
    xml_data = template.render({
        **data.__dict__,
        "datetime": datetime.now().strftime("%Y%m%dT%H%M%S%f") if data.requestId is None else data.requestId ,
        # **system_auth_info
    })
    print("request:", xml_data)
    return AR_soap_client.call_service('Recharge', xml_data)


def generate_normal_response(response):
    print('normal-cbs-response:', response)
    try:
        root = ET.fromstring(response)
        namespaces = {
            'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
            'ars': 'http://www.huawei.com/bme/cbsinterface/arservices',
            'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
            'arc': 'http://cbs.huawei.com/ar/wsservice/arcommon'
        }
        result_code = root.find('.//cbs:ResultCode', namespaces)
        result_desc = root.find('.//cbs:ResultDesc', namespaces)
        if result_code is not None and result_code.text == '0':
            new_balance =  root.find('.//ars:BalanceChgInfo[arc:BalanceType="C_2001"]', namespaces)
            balance =  new_balance.find('.//arc:NewBalanceAmt', namespaces)
            if new_balance is not None:
                return {
                    "Balance": balance.text.strip()
                }
    except :
        raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())

def generate_exciting_response(response):
    print('exciting-cbs-response:', response)
    root = ET.fromstring(response)
    namespaces = {
        'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
        'ars': 'http://www.huawei.com/bme/cbsinterface/arservices',
        'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
        'arc': 'http://cbs.huawei.com/ar/wsservice/arcommon'
    }
    result_code = root.find('.//cbs:ResultCode', namespaces)
    result_desc = root.find('.//cbs:ResultDesc', namespaces)
    if result_code is not None and result_code.text == '0':
        result = []
        for balance in root.findall('.//ars:BalanceChgInfo', namespaces):
            benefit_bal_dto = {}
            new_balance_amt = balance.find('.//arc:NewBalanceAmt', namespaces)
            acct_res_code = balance.find('.//arc:BalanceType', namespaces)
            benefit_bal_dto['AcctResCode'] = acct_res_code.text.strip()
            benefit_bal_dto['Balance'] = int(new_balance_amt.text.strip())
            eff_date = balance.find('.//arc:EffectiveTime', namespaces)
            benefit_bal_dto['EffDate'] = eff_date.text.strip()
            exp_date_item = balance.find('.//arc:ExpireTime', namespaces)
            benefit_bal_dto['ExpDate'] = exp_date_item.text.strip()
                
            result.append(benefit_bal_dto)
           
        return result
    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())


def generate_response(response):
    print('cbs-response:', response)
    root = ET.fromstring(response)
    namespaces = {
        'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
        'ars': 'http://www.huawei.com/bme/cbsinterface/arservices',
        'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
        'arc': 'http://cbs.huawei.com/ar/wsservice/arcommon'
    }
    result_code = root.find('.//cbs:ResultCode', namespaces)
    result_desc = root.find('.//cbs:ResultDesc', namespaces)
    if result_code is not None and result_code.text == '0':
        new_balance = root.find('.//arc:NewBalanceAmt', namespaces)
        if new_balance is not None:
            return {
                "Balance": new_balance.text.strip()
            }
    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())
# def  generate_response_normal(response) :
#     print('normal:', response)
#     root = ET.fromstring(response)
#     namespaces = {
#     'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
#     'ars': 'http://www.huawei.com/bme/cbsinterface/arservices',
#     'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
#     'arc': 'http://cbs.huawei.com/ar/wsservice/arcommon'
#     }
#     result_code = root.find('.//cbs:ResultCode', namespaces)
#     result_desc = root.find('.//cbs:ResultDesc', namespaces)
#     if result_code is not None and result_code.text == '0':
#         new_balance = root.find('.//arc:NewBalanceAmt', namespaces)
#         old_balance = root.find('.//arc:OldBalanceAmt', namespaces)
#         # ExpDate = root.find('.//ars:ExpDate', namespaces)
#         add_balance = int(new_balance.text.strip()) - int(old_balance.text.strip())
#         if new_balance is not None:
#             return {
#                 "Balance": new_balance.text.strip(),
#                 "AddBalance": add_balance,
#             }
    
#     raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST)



# def generate_response_exciting(response) :
#     print('exciting:', response)
#     root = ET.fromstring(response)
#     namespaces = {
#         'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
#         'ars': 'http://www.huawei.com/bme/cbsinterface/arservices',
#         'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
#         'arc': 'http://cbs.huawei.com/ar/wsservice/arcommon'
#     }
#     result_code = root.find('.//cbs:ResultCode', namespaces)
#     result_desc = root.find('.//cbs:ResultDesc', namespaces)
#     if result_code is not None and result_code.text == '0':
#         new_balance = root.find('.//arc:NewBalanceAmt', namespaces)
#         old_balance = root.find('.//arc:OldBalanceAmt', namespaces)
#         exp_date = root.find('.//ars:BalanceChgInfo[arc:BalanceType="C_1080"]/arc:ExpDate', namespaces)
#         add_balance = 0

#         benefit_bal_dto_list = []
#         for balance in root.findall('.//ars:BalanceChgInfo', namespaces):
#             benefit_bal_dto = {}
#             acct_res_code = balance.find('./arc:CurrencyID', namespaces)
#             if acct_res_code is not None:
#                 benefit_bal_dto['AcctResCode'] = acct_res_code.text.strip()
#             new_balance_amt = balance.find('./arc:NewBalanceAmt', namespaces)
#             old_balance_amt = balance.find('./arc:OldBalanceAmt', namespaces)
#             if new_balance_amt is not None and old_balance_amt is not None:
#                 benefit_bal_dto['Balance'] = int(new_balance_amt.text.strip()) - int(old_balance_amt.text.strip())
#             eff_date = balance.find('./arc:EffDate', namespaces)
#             if eff_date is not None:
#                 benefit_bal_dto['EffDate'] = eff_date.text.strip()
#             exp_date_item = balance.find('./arc:ExpDate', namespaces)
#             if exp_date_item is not None:
#                 benefit_bal_dto['ExpDate'] = exp_date_item.text.strip()

#             benefit_bal_dto_list.append(benefit_bal_dto)
#         if new_balance is not None:
#             return {
#                 "Balance": new_balance.text.strip(),
#                 "AddBalance": add_balance,
#                 "ExpDate": exp_date.text.strip(),
#                 "BenefitBalDtoList": benefit_bal_dto_list
#             }

#     raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())

