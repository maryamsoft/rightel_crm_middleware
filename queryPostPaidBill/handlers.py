import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, Security, status
from utils.soap_client import AR_soap_client


def query_post_paid_bill_handler(data):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/queryInvoice.txt', 'r') as file:
        query_invoice_template = file.read()
    query_invoice_template = Template(query_invoice_template)
    query_invoice = query_invoice_template.render({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S")})
    return AR_soap_client.call_service('QueryInvoice', query_invoice)
    

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
        osb_request = {
            "PayableAmount": root.find('.//ars:AdditionalProperty[arc:Code="CN_PAYABLE_AMOUNT"]/arc:Value', namespaces).text.strip(),
            "InvoiceId": root.find('.//ars:InvoiceInfo/ars:AcctCode', namespaces).text.strip(),
            "PaymentId": root.find('.//ars:AdditionalProperty[arc:Code="CN_PAYMENT_ID"]/arc:Value', namespaces).text.strip(),
            "Status": root.find('.//ars:Status', namespaces).text.strip(),
        }
        BillingCycleStartDate = root.find('.//ars:BillCycleBeginTime', namespaces)
        BillingCycleEndDate = root.find('.//ars:BillCycleEndTime', namespaces)
        BillingCycleID = root.find('.//ars:BillCycleID', namespaces)
        DateIssuance = root.find('.//ars:InvoiceDate', namespaces)
        outstainding = root.find('.//ars:OpenAmount', namespaces)
        # AcctItemListDtoList = root.findall('.//ars:AcctItemListDtoList', namespaces)
        if BillingCycleStartDate is not None:
            osb_request['BillingCycleStartDate'] = BillingCycleStartDate.text.strip()
        if BillingCycleEndDate is not None:
            osb_request['BillingCycleEndDate'] = BillingCycleEndDate.text.strip()
        if BillingCycleID is not None:
            osb_request['BillingCycleID'] = BillingCycleID.text.strip()
        if DateIssuance is not None:
            osb_request['DateIssuance'] = DateIssuance.text.strip()
        if outstainding is not None:
            osb_request['OUTSTAINDING'] = outstainding.text.strip()
        # if AcctItemListDtoList is not None:
        #     osb_request['AcctItemListDtoList'] = AcctItemListDtoList.text.strip()

        return osb_request


    
    raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST)

