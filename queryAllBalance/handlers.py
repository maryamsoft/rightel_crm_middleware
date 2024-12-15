import os
from jinja2 import Template
from datetime import datetime
from utils.soap_client import BC_soap_client
import xml.etree.ElementTree as ET
from fastapi import HTTPException, Security, status
from datetime import datetime
from utils.custom_handler import CustomException
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
        "datetime": datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
        **system_auth_info
    }
    xml_data = template.render(**values)
    print("request:", xml_data)
    return BC_soap_client.call_service('QueryCustomerInfo', xml_data)



def generate_response(cbs_response):
    print("cbs_response", cbs_response)
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
            balance_detail = balance_result.find('.//bcs:BalanceDetail', namespaces)
            balance_type = balance_result.find('.//bcs:BalanceType', namespaces)
            balance_name = balance_result.find('.//bcs:BalanceTypeName', namespaces)
            comments = balance_result.find('.//bcs:BalanceTypeName', namespaces)
            unit_type = 1
            eff_date = balance_result.find('.//bcs:EffectiveTime', namespaces)
            exp_date = balance_result.find('.//bcs:ExpireTime', namespaces)
            init_bal = balance_result.find('.//bcs:InitialAmount', namespaces)
            is_show_bal = 'N' if balance_type.text.startswith('u_') else 'Y'
            is_show_exp_time = 'Y'
            gross_bal = 0
            for detail in balance_detail:
                print('detail:', detail)
                balance_value = balance_result.find('.//bcs:BalanceDetail/bcs:Amount', namespaces)
                print('balance_value:',balance_value)
                response['AllBalanceDtoList']['AllBalanceDto'].append({
                    "BalanceType": balance_type.text.strip(),
                    "BalanceName": balance_name.text.strip(),
                    "BalanceValue": balance_value.text.strip(),
                    "Comments": comments.text.strip(),
                    "UnitType": unit_type,
                    "EffDate": datetime.strptime(eff_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%d %H:%M:%S'),
                    "ExpDate": datetime.strptime(exp_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%d %H:%M:%S'),
                    "InitBal": init_bal.text.strip(),
                    "IsShowBal": is_show_bal,
                    "IsShowExpTime": is_show_exp_time,
                    "GrossBal": gross_bal,
                    
                })
        for free_unit_item in free_unit_items:
            freeUnit_detail = free_unit_item.find('.//bcs:FreeUnitItemDetail', namespaces)
            balance_type = free_unit_item.find('.//bcs:FreeUnitType', namespaces)
            balance_name = free_unit_item.find('.//bcs:FreeUnitTypeName', namespaces)
            comments = free_unit_item.find('.//bcs:FreeUnitTypeName', namespaces)
            measure_unit = free_unit_item.find('.//bcs:MeasureUnit', namespaces)
            unit_type = 2 if measure_unit.text.strip() == '1003' else 3 if measure_unit.text.strip() == '1101' else 4
            eff_date = free_unit_item.find('.//bcs:EffectiveTime', namespaces)
            exp_date = free_unit_item.find('.//bcs:ExpireTime', namespaces)
            init_bal = free_unit_item.find('.//bcs:InitialAmount', namespaces)
            is_show_bal = 'N' if balance_type.text.strip().startswith('u_') else 'Y'
            is_show_exp_time = 'Y'
            gross_bal = 0
            for detail in freeUnit_detail:
                balance_value = free_unit_item.find('.//bcs:FreeUnitItemDetail/bcs:CurrentAmount', namespaces)
                print('balance_value:',balance_value)
                response['AllBalanceDtoList']['AllBalanceDto'].append({
                    "BalanceType": balance_type.text.strip(),
                    "BalanceName": balance_name.text.strip(),
                    "BalanceValue": balance_value.text.strip(),
                    "Comments": comments.text.strip(),
                    "UnitType": unit_type,
                    "EffDate": datetime.strptime(eff_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%d %H:%M:%S'),
                    "ExpDate": datetime.strptime(exp_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%d %H:%M:%S'),
                    "InitBal": init_bal.text.strip(),
                    "IsShowBal": is_show_bal,
                    "IsShowExpTime": is_show_exp_time,
                    "GrossBal": gross_bal,
                    
                })
        return response

    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())


# import os
# from jinja2 import Template
# from datetime import datetime
# from utils.soap_client import BC_soap_client
# import xml.etree.ElementTree as ET
# from fastapi import HTTPException, Security, status
# from datetime import datetime
# from utils.custom_handler import CustomException

# def customerInfo(data):
#     # data.msisdn=9210451762
#     app_path = os.path.dirname(os.path.abspath(__file__))
#     with open(app_path + '/templates/payloads/CustomerInfo.txt', 'r') as file:
#         template = file.read()
#     template = Template(template)
#     values = {
#         **data.__dict__,
#         "datetime": datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
#     }
#     xml_data = template.render(**values)
#     print("request:", xml_data)
#     return BC_soap_client.call_service('QueryCustomerInfo', xml_data)



# def generate_response(cbs_response):
#     print("cbs_response", cbs_response)
#     root = ET.fromstring(cbs_response)
#     namespaces = {
#         'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
#         'bcs': 'http://www.huawei.com/bme/cbsinterface/bcservices',
#         'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
#         'bcc': 'http://www.huawei.com/bme/cbsinterface/bccommon'
#     }

#     result_code = root.find('.//cbs:ResultCode', namespaces)
#     result_desc = root.find('.//cbs:ResultDesc', namespaces)
#     if result_code is not None and result_code.text == '0':
#         response = {
#             "AllBalanceDtoList":{
#                 "AllBalanceDto": []
#             }
#         }
#         balance_results = root.findall('.//bcs:BalanceResult', namespaces)
#         free_unit_items = root.findall('.//bcs:FreeUnitItem', namespaces)
#         for balance_result in balance_results:
#             balance_type = balance_result.find('.//bcs:BalanceType', namespaces)
#             balance_name = balance_result.find('.//bcs:BalanceTypeName', namespaces)
#             balance_value = balance_result.find('.//bcs:BalanceDetail/bcs:Amount', namespaces)
#             comments = balance_result.find('.//bcs:BalanceTypeName', namespaces)
#             unit_type = 1
#             eff_date = balance_result.find('.//bcs:EffectiveTime', namespaces)
#             exp_date = balance_result.find('.//bcs:ExpireTime', namespaces)
#             init_bal = balance_result.find('.//bcs:InitialAmount', namespaces)
#             is_show_bal = 'N' if balance_type.text.startswith('u_') else 'Y'
#             is_show_exp_time = 'Y'
#             gross_bal = 0
            
#             response['AllBalanceDtoList']['AllBalanceDto'].append({
#                 "BalanceType": balance_type.text.strip(),
#                 "BalanceName": balance_name.text.strip(),
#                 "BalanceValue": balance_value.text.strip(),
#                 "Comments": comments.text.strip(),
#                 "UnitType": unit_type,
#                 "EffDate": datetime.strptime(eff_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%d %H:%M:%S'),
#                 "ExpDate": datetime.strptime(exp_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%d %H:%M:%S'),
#                 "InitBal": init_bal.text.strip(),
#                 "IsShowBal": is_show_bal,
#                 "IsShowExpTime": is_show_exp_time,
#                 "GrossBal": gross_bal,
                
#             })
#         for free_unit_item in free_unit_items:
#             balance_type = free_unit_item.find('.//bcs:FreeUnitType', namespaces)
#             balance_name = free_unit_item.find('.//bcs:FreeUnitTypeName', namespaces)
#             balance_value = free_unit_item.find('.//bcs:FreeUnitItemDetail/bcs:CurrentAmount', namespaces)
#             comments = free_unit_item.find('.//bcs:FreeUnitTypeName', namespaces)
#             measure_unit = free_unit_item.find('.//bcs:MeasureUnit', namespaces)
#             unit_type = 2 if measure_unit.text.strip() == '1003' else 3 if measure_unit.text.strip() == '1101' else 4
#             eff_date = free_unit_item.find('.//bcs:EffectiveTime', namespaces)
#             exp_date = free_unit_item.find('.//bcs:ExpireTime', namespaces)
#             init_bal = free_unit_item.find('.//bcs:InitialAmount', namespaces)
#             is_show_bal = 'N' if balance_type.text.strip().startswith('u_') else 'Y'
#             is_show_exp_time = 'Y'
#             gross_bal = 0

#             response['AllBalanceDtoList']['AllBalanceDto'].append({
#                 "BalanceType": balance_type.text.strip(),
#                 "BalanceName": balance_name.text.strip(),
#                 "BalanceValue": balance_value.text.strip(),
#                 "Comments": comments.text.strip(),
#                 "UnitType": unit_type,
#                 "EffDate": datetime.strptime(eff_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%d %H:%M:%S'),
#                 "ExpDate": datetime.strptime(exp_date.text.strip(), '%Y%m%d%H%M%S').strftime('%Y-%m-%d %H:%M:%S'),
#                 "InitBal": init_bal.text.strip(),
#                 "IsShowBal": is_show_bal,
#                 "IsShowExpTime": is_show_exp_time,
#                 "GrossBal": gross_bal,
                
#             })
#         return response

#     raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())
