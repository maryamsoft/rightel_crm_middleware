import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from utils.soap_client import BC_soap_client
from fastapi import HTTPException, Security, status
from utils.custom_handler import CustomException


def query_postpaid_hotbill_handler(data):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/QueryPostpaidHotBill.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    xml_data = template.render({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S")})
    print("request:", xml_data)
    return BC_soap_client.call_service('QueryPostpaidHotBill', xml_data)


def generate_response(cbs_response) :
    print('cbs_response:', cbs_response)
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
        PayableAmount = root.find('.//ars:PayableAmount', namespaces).text
        OUTSTANDING = PayableAmount
        InvoiceID = root.find('.//ars:AccountCode', namespaces).text
        PaymentID = root.find('.//ars:PaymentID', namespaces).text
        BillingCycleStartDate = root.find('.//ars:BillCycleBeginTime', namespaces).text
        EndDate = root.find('.//ars:EndTime', namespaces).text
        return {
            "PayableAmount": PayableAmount,
            "InvoiceId": InvoiceID,
            "PaymentId": PaymentID,
            "BillingCycleStartDate": BillingCycleStartDate,
            "EndDate": EndDate,
            "OUTSTANDING": OUTSTANDING,
            # "AcctItemListDtoList":AcctItemListDtoList,
            # "SUBSCRIPTION":SUBSCRIPTION,
            # "AddSubscription":AddSubscription,
            # "TOTAL_AMOUNT":TOTAL_AMOUNT,
            # "TAX":TAX,
            # "MDSP":MDSP,
        }

    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())