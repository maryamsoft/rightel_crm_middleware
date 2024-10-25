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
        AllBalanceDtoList_BalanceType = root.find('.//bcs:BalanceType', namespaces)
        print("balance_type", AllBalanceDtoList_BalanceType)
        AllBalanceDtoList_BalanceName = root.find('.//bcs:BalanceTypeName', namespaces)
        AllBalanceDtoList_BalanceValue = root.find('.//bcs:Amount', namespaces)
        AllBalanceDtoList_UnitType = root.find('.//bcs:CurrencyID', namespaces)
        AllBalanceDtoList_EffDate = root.find('.//bcs:EffectiveTime', namespaces)
        InitBal = root.find('.//bcs:InitialAmount', namespaces)
        IsShowBal = root.find('.//bcs:BalanceTypeName', namespaces)
        IsShowExpTime = root.find('.//bcs:ExpireTime', namespaces)
        GrossBal = '0'
        res = {
            "AllBalanceDtoList": {
                "BalanceType": AllBalanceDtoList_BalanceType.text,
                "BalanceName": AllBalanceDtoList_BalanceName.text,
                "BalanceValue": AllBalanceDtoList_BalanceValue.text,
                "UnitType": AllBalanceDtoList_UnitType.text,
                "EffDate": AllBalanceDtoList_EffDate.text,
            },
           "GrossBal" : GrossBal
        }
        if InitBal is not None:
            res["InitBal"] = InitBal.text
        if IsShowBal is not None:
            res["IsShowBal"] = IsShowBal.text
        if IsShowExpTime is not None:
            res["IsShowExpTime"] = IsShowExpTime.text
        return res

    raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail=result_desc.text)
