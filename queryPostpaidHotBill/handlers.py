import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, Security, status
from utils.soap_client import ArCustomized_soap_client
from utils.custom_handler import CustomException


def query_postpaid_hotbill_handler(data):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/QueryDebt.txt', 'r') as file:
        query_debt_template = file.read()
    query_debt_template = Template(query_debt_template)
    query_debt = query_debt_template.render({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S")})
    print('query_invoice:', query_debt)
    return ArCustomized_soap_client.call_service('QueryDebt', query_debt)


def generate_response(cbs_response) :
    print('cbs_response:', cbs_response)
    root = ET.fromstring(cbs_response)
    namespaces = {
        'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
        'ars': 'http://www.huawei.com/bme/cbsinterface/arservices',
        'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
        'arc': 'http://www.huawei.com/bme/cbsinterface/arcustomizedservices'
    }
    result_code = root.find('.//cbs:ResultCode', namespaces)
    result_desc = root.find('.//cbs:ResultDesc', namespaces)
    if result_code is not None and result_code.text == '0':
        PayableAmount = root.find('.//arc:PayableAmount', namespaces).text.strip()
        OUTSTANDING = PayableAmount
        InvoiceID = root.find('.//arc:AccountCode', namespaces).text.strip()
        PaymentID = root.find('.//arc:PaymentID', namespaces).text.strip()
        BillingCycleStartDate = root.find('.//arc:BillCycleBeginTime', namespaces).text.strip()
        EndDate = root.find('.//arc:EndTime', namespaces).text.strip()
        billing_cycle_start_date = datetime.strptime(BillingCycleStartDate, '%Y%m%d%H%M%S')
        billing_cycle_end_date = datetime.strptime(EndDate, '%Y%m%d%H%M%S')
        return {
            "PayableAmount": int(PayableAmount),
            "InvoiceId": InvoiceID,
            "PaymentId": PaymentID,
            "BillingCycleStartDate": billing_cycle_start_date.strftime('%Y-%m-%d'),
            "EndDate": billing_cycle_end_date.strftime('%Y-%m-%d'),
            "OUTSTANDING": int(OUTSTANDING),
            # "AcctItemListDtoList":AcctItemListDtoList,
            # "SUBSCRIPTION":SUBSCRIPTION,
            # "AddSubscription":AddSubscription,
            # "TOTAL_AMOUNT":TOTAL_AMOUNT,
            # "TAX":TAX,
            # "MDSP":MDSP,
        }

    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())