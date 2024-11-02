import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, status
from utils.soap_client import BC_soap_client
from utils import body 
from .schemas import QuerySubscriberRGUsageRequest


def query_subscriber_rgusage(data:QuerySubscriberRGUsageRequest):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/QueryCustomerInfo.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    values = {
         **data.__dict__,
         "datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),
    }
    xml_data = template.render(**values)
    print("request:", xml_data)
    return BC_soap_client.call_service('QuerySubscriberRGUsage', xml_data)
    
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
        free_unit_items = root.findall('.//bcs:FreeUnitItem', namespaces)
        response = {
            "offerUsageList": []
        }
        for free_unit_item in free_unit_items:
            offering_name = free_unit_item.find('.//bcs:OfferingName', namespaces)
            offering_id = free_unit_item.find('.//bcs:OfferingID', namespaces)
            purchase_seq = free_unit_item.find('.//bcs:PurchaseSeq', namespaces)
            scenario_usage_list = free_unit_item.findall('.//bcs:ScenarioUsageList', namespaces)
            usageRGList = []
            for scenario_usage in scenario_usage_list:
                rg_code = scenario_usage.find('.//bcs:ScenarioCode', namespaces)
                used_amount = scenario_usage.find('.//bcs:UsedAmount', namespaces)
                usageRGList.append({
                    "rgCode": rg_code.text.strip(),
                    "usedAmount": used_amount.text.strip()
                })
            response['offerUsageList'].append({
                "offerName": offering_name.text.strip(),
                "offerCode": offering_id.text.strip(),
                "purchaseId": purchase_seq.text.strip(),
                "usageRGList": usageRGList
            })
        return response
    raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST)


