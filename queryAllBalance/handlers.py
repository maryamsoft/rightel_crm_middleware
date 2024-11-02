import requests
import os
from lxml import etree
from utils import body
from jinja2 import Template
from datetime import datetime
from utils.soap_client import BC_soap_client
import xml.etree.ElementTree as ET
from fastapi import HTTPException, Security, status


def customerInfo(data):
    # data.msisdn=9210451762
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path + '/templates/payloads/CustomerInfo.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    values = {
        **data.__dict__,
        "datetime": datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
    }
    xml_data = template.render(**values)
    # print("request:", xml_data)
    return BC_soap_client.call_service('QueryCustomerInfo', xml_data)



def generate_response(cbs_response):
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
            balance_type = balance_result.find('.//bcs:BalanceType', namespaces)
            balance_name = balance_result.find('.//bcs:BalanceTypeName', namespaces)
            balance_value = balance_result.find('.//bcs:BalanceDetail/bcs:Amount', namespaces)
            comments = balance_result.find('.//bcs:BalanceTypeName', namespaces)
            unit_type = 1
            eff_date = balance_result.find('.//bcs:EffectiveTime', namespaces)
            exp_date = balance_result.find('.//bcs:ExpireTime', namespaces)
            init_bal = balance_result.find('.//bcs:InitialAmount', namespaces)
            is_show_bal = 'N' if balance_type.text.startswith('u_') else 'Y'
            is_show_exp_time = 'Y'
            gross_bal = 0

            response['AllBalanceDtoList']['AllBalanceDto'].append({
                "BalanceType": balance_type.text,
                "BalanceName": balance_name.text,
                "BalanceValue": balance_value.text,
                "Comments": comments.text,
                "UnitType": unit_type,
                "EffDate": eff_date.text,
                "ExpDate": exp_date.text,
                "InitBal": init_bal.text,
                "IsShowBal": is_show_bal,
                "IsShowExpTime": is_show_exp_time,
                "GrossBal": gross_bal
            })
        for free_unit_item in free_unit_items:
            balance_type = free_unit_item.find('.//bcs:FreeUnitType', namespaces)
            balance_name = free_unit_item.find('.//bcs:FreeUnitTypeName', namespaces)
            balance_value = free_unit_item.find('.//bcs:FreeUnitItemDetail/bcs:CurrentAmount', namespaces)
            comments = free_unit_item.find('.//bcs:FreeUnitTypeName', namespaces)
            measure_unit = free_unit_item.find('.//bcs:MeasureUnit', namespaces)
            unit_type = 2 if measure_unit.text.strip() == '1003' else 3 if measure_unit.text.strip() == '1101' else 4
            eff_date = free_unit_item.find('.//bcs:EffectiveTime', namespaces)
            exp_date = free_unit_item.find('.//bcs:ExpireTime', namespaces)
            init_bal = free_unit_item.find('.//bcs:InitialAmount', namespaces)
            is_show_bal = 'N' if balance_type.text.strip().startswith('u_') else 'Y'
            is_show_exp_time = 'Y'
            gross_bal = 0

            response['AllBalanceDtoList']['AllBalanceDto'].append({
                "BalanceType": balance_type.text.strip(),
                "BalanceName": balance_name.text.strip(),
                "BalanceValue": balance_value.text.strip(),
                "Comments": comments.text.strip(),
                "UnitType": unit_type,
                "EffDate": eff_date.text.strip(),
                "ExpDate": exp_date.text.strip(),
                "InitBal": init_bal.text.strip(),
                "IsShowBal": is_show_bal,
                "IsShowExpTime": is_show_exp_time,
                "GrossBal": gross_bal
            })

        return response

    raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail=result_desc.text)
