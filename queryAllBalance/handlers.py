import os
from jinja2 import Template
from datetime import datetime
from utils.soap_client import BC_soap_client
import xml.etree.ElementTree as ET
from fastapi import HTTPException, Security, status
from datetime import datetime
from utils.custom_handler import CustomException, convert_uts_to_asia_tehran
from utils.utils import get_login_and_password

def customerInfo(data):
    # data.msisdn=9210451762
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path + '/templates/payloads/CustomerInfo.txt', 'r') as file:
        template = file.read()
    system_auth_info = get_login_and_password()
    template = Template(template)
    values = {
        **data.__dict__,
        "datetime": datetime.now().strftime("%Y-%m-%dT%H:%M:%S.%f"),
        **system_auth_info
    }
    xml_data = template.render(**values)
    # print("request:", xml_data)
    return BC_soap_client.call_service('QueryCustomerInfo', xml_data)



def generate_response(cbs_response):
    tt = convert_uts_to_asia_tehran(datetime.now().strftime('%Y-%m-%dT%H:%M:%S.000Z')).strftime('%Y-%m-%d %H:%M:%S')
    print('tt:', tt)
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
        response = {
            "AllBalanceDtoList":{
                "AllBalanceDto": []
            }
        }
        balance_results = root.findall('.//bcs:BalanceResult', namespaces)
        free_unit_items = root.findall('.//bcs:FreeUnitItem', namespaces)
        for balance_result in balance_results:
            balance_details = balance_result.findall('.//bcs:BalanceDetail', namespaces)
            balance_type = balance_result.find('.//bcs:BalanceType', namespaces)
            balance_name = balance_result.find('.//bcs:BalanceTypeName', namespaces)
            print('balance_type:', balance_name.text.strip())
            en_balance_name = balance_name.text.strip().split("|")[0]
            comments = balance_result.find('.//bcs:BalanceTypeName', namespaces)
            unit_type = 1
            is_show_bal = 'N' if balance_type.text.startswith('u_') else 'Y'
            is_show_exp_time = 'Y'
            gross_bal = 0
            for detail in balance_details:
                balance_value =  detail.find('.//bcs:Amount', namespaces)
                eff_date = detail.find('.//bcs:EffectiveTime', namespaces)
                exp_date = detail.find('.//bcs:ExpireTime', namespaces)
                init_bal = detail.find('.//bcs:InitialAmount', namespaces)
                response['AllBalanceDtoList']['AllBalanceDto'].append({
                    "BalanceType": balance_type.text.strip(),
                    "BalanceName": en_balance_name,
                    "BalanceValue": balance_value.text.strip(),
                    "Comments": comments.text.strip(),
                    "UnitType": unit_type,
                    "EffDate": convert_uts_to_asia_tehran(datetime.strptime(eff_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%dT%H:%M:%S.000Z')).strftime('%Y-%m-%d %H:%M:%S'),
                    "ExpDate": convert_uts_to_asia_tehran(datetime.strptime(exp_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%dT%H:%M:%S.000Z')).strftime('%Y-%m-%d %H:%M:%S'),
                    "InitBal": init_bal.text.strip(),
                    "IsShowBal": is_show_bal,
                    "IsShowExpTime": is_show_exp_time,
                    "GrossBal": gross_bal, 
                })
                
        for free_unit_item in free_unit_items:
            balance_type = free_unit_item.find('.//bcs:FreeUnitType', namespaces)
            en_balance_type = balance_type.text.strip().split("|")[0]
            balance_name = free_unit_item.find('.//bcs:FreeUnitTypeName', namespaces)
            freeunit_Details = free_unit_item.findall('.//bcs:FreeUnitItemDetail', namespaces)
            comments = free_unit_item.find('.//bcs:FreeUnitTypeName', namespaces)
            measure_unit = free_unit_item.find('.//bcs:MeasureUnit', namespaces)
            unit_type = 2 if measure_unit.text.strip() == '1003' else 3 if measure_unit.text.strip() == '1101' else 4
            
            is_show_bal = 'N' if balance_type.text.strip().startswith('u_') else 'Y'
            is_show_exp_time = 'Y'
            gross_bal = 0
            free_count = 0
            for detail in freeunit_Details:
                balance_value = detail.find('.//bcs:CurrentAmount', namespaces)
                eff_date = detail.find('.//bcs:EffectiveTime', namespaces)
                exp_date = detail.find('.//bcs:ExpireTime', namespaces)
                init_bal = detail.find('.//bcs:InitialAmount', namespaces)
                response['AllBalanceDtoList']['AllBalanceDto'].append({
                    "BalanceType": en_balance_type,
                    "BalanceName": balance_name.text.strip(),
                    "BalanceValue": balance_value.text.strip(),
                    "Comments": comments.text.strip(),
                    "UnitType": unit_type,
                    "EffDate": convert_uts_to_asia_tehran(datetime.strptime(eff_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%dT%H:%M:%S.000Z')).strftime('%Y-%m-%d %H:%M:%S'),
                    "ExpDate": convert_uts_to_asia_tehran(datetime.strptime(exp_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%dT%H:%M:%S.000Z')).strftime('%Y-%m-%d %H:%M:%S'),
                    "InitBal": init_bal.text.strip(),
                    "IsShowBal": is_show_bal,
                    "IsShowExpTime": is_show_exp_time,
                    "GrossBal": gross_bal,

                })

        return response

    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())
