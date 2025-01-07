import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, status
from utils.soap_client import BC_soap_client
from utils import body 
from .schemas import QuerySubscriberRGUsageRequest
from utils.custom_handler import CustomException
from utils.utils import get_login_and_password


def query_subscriber_rgusage(data:QuerySubscriberRGUsageRequest):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/QueryCustomerInfo.txt', 'r') as file:
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
    return BC_soap_client.call_service('QuerySubscriberRGUsage', xml_data)
    
# def generate_response(cbs_response) :
#     print('response:', cbs_response)
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
#         free_unit_items = root.findall('.//bcs:FreeUnitItem', namespaces)
#         response = {
#             "offerUsageList": [],
#             "responseDesc":"Successful",
#             "responseCode":0
#         }
#         for free_unit_item in free_unit_items:
#             offering_name = free_unit_item.find('.//bcs:OfferingName', namespaces)
#             offering_id = free_unit_item.find('.//bcc:OfferingID', namespaces)
#             purchase_seq = free_unit_item.find('.//bcc:PurchaseSeq', namespaces)
#             scenario_usage_list = free_unit_item.findall('.//bcs:ScenarioUsageList', namespaces)
#             usageRGList = []
#             for scenario_usage in scenario_usage_list:
#                 rg_code = scenario_usage.find('.//bcs:ScenarioCode', namespaces)
#                 used_amount = scenario_usage.find('.//bcs:UsedAmount', namespaces)
#                 calculated_amount = scenario_usage.find('.//bcs:UsedAmount', namespaces).text.strip()
#                 # if rg_code == 'National':
#                 #     used_amount = int(used_amount) * (1024 * 1024 / 378)
#                 # elif rg_code == 'InHouseMessenger':
#                 #     used_amount = int(used_amount) * 4
#                 usageRGList.append({
#                     "rgCode": rg_code,
#                     "usedAmount": used_amount,
#                     "calculatedAmount": calculated_amount
#                 })
#             response['offerUsageList'].append({
#                 "offerName": offering_name.text.strip(),
#                 "offerCode": offering_id.text.strip(),
#                 "purchaseId": purchase_seq.text.strip(),
#                 "usageRGList": usageRGList
#             })
#         return response
    
#     raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())

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
        free_unit_items = root.findall('.//bcs:FreeUnitItem', namespaces)
        response = {
            "offerUsageList": [],
            "responseDesc":"Successful",
            "responseCode":0
        }
        
        for free_unit_item in free_unit_items:
            
            FreeUnitItemDetails = free_unit_item.findall('.//bcs:FreeUnitItemDetail', namespaces)
            usageRGList = []
            for FreeUnitItemDetail in FreeUnitItemDetails:
                offering_name = FreeUnitItemDetail.find('.//bcs:OfferingName', namespaces)
                offering_id = FreeUnitItemDetail.find('.//bcc:OfferingID', namespaces)
                purchase_seq = FreeUnitItemDetail.find('.//bcc:PurchaseSeq', namespaces)
                scenario_usage_list = FreeUnitItemDetail.findall('.//bcs:ScenarioUsageList', namespaces)
                
                usageRGList = []
                for scenario_usage in scenario_usage_list:
                    rg_code = scenario_usage.find('.//bcs:ScenarioCode', namespaces).text.strip()
                    used_amount = scenario_usage.find('.//bcs:UsedAmount', namespaces).text.strip()
                    calculated_amount = scenario_usage.find('.//bcs:UsedAmount', namespaces).text.strip()
                    usageRGList.append({
                        "rgCode": rg_code,
                        "usedAmount": used_amount,
                        "calculatedAmount": calculated_amount
                    })
                    
                response['offerUsageList'].append({
                    "offerName": offering_name.text.strip() if offering_name is not None else None,
                    "offerCode": offering_id.text.strip() if offering_id is not None else None,
                    "purchaseId": purchase_seq.text.strip() if purchase_seq is not None else None,
                    "usageRGList": usageRGList
                })
        return response
    
    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())

