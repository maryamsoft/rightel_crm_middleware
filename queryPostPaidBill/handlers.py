import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, Security, status
from utils.soap_client import AR_soap_client
from utils.custom_handler import CustomException
from utils.utils import get_login_and_password


def query_post_paid_bill_handler(data):
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/queryInvoice.txt', 'r') as file:
        query_invoice_template = file.read()
    # system_auth_info = get_login_and_password()
    query_invoice_template = Template(query_invoice_template)
    query_invoice = query_invoice_template.render({**data.__dict__,"datetime":datetime.now().strftime("%Y%m%dT%H%M%S%f"),
                                                #    **system_auth_info
                                                })
    print('query_invoice:', query_invoice)
    return AR_soap_client.call_service('QueryInvoice', query_invoice)
    

def generate_response(cbs_response) :
    print('cbs-response:', cbs_response)
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
        PayableAmount = root.find('.//ars:AdditionalProperty[arc:Code="CN_PAYABLE_AMOUNT"]/arc:Value', namespaces)
        InvoiceId = root.find('.//ars:InvoiceInfo/ars:AcctCode', namespaces)
        PaymentId = root.find('.//ars:AdditionalProperty[arc:Code="CN_PAYMENT_ID"]/arc:Value', namespaces)
        final_resppnse = {
            "PayableAmount": PayableAmount.text.strip(),
            "InvoiceId": InvoiceId.text.strip(),
            "PaymentId": PaymentId.text.strip(),
            
        }
        status =  root.find('.//ars:Status', namespaces)
        final_resppnse['Status'] = 0 if status and status.text.strip() == 'C' else 1
        BillingCycleStartDate = root.find('.//ars:BillCycleBeginTime', namespaces)
        BillingCycleEndDate = root.find('.//ars:BillCycleEndTime', namespaces)
        BillingCycleID = root.find('.//ars:BillCycleID', namespaces)
        DateIssuance = root.find('.//ars:InvoiceDate', namespaces)
        outstanding = root.find('.//ars:OpenAmount', namespaces)
        # AcctItemListDtoList = root.findall('.//ars:AcctItemListDtoList', namespaces)
        if BillingCycleStartDate is not None:
            billing_cycle_start_date_str = str(BillingCycleStartDate.text.strip())
            billing_cycle_start_date = datetime.strptime(billing_cycle_start_date_str, '%Y%m%d%H%M%S')
            final_resppnse['BillingCycleStartDate'] = billing_cycle_start_date.strftime('%Y-%m-%d')
        if BillingCycleEndDate is not None:
            billing_cycle_end_date_str = str(BillingCycleEndDate.text.strip())
            billing_cycle_end_date = datetime.strptime(billing_cycle_end_date_str, '%Y%m%d%H%M%S')
            final_resppnse['BillingCycleEndDate'] = billing_cycle_end_date.strftime('%Y-%m-%d')
        if BillingCycleID is not None:
            final_resppnse['BillingCycleID'] = BillingCycleID.text.strip()
        if DateIssuance is not None:
            final_resppnse['DateIssuance'] = DateIssuance.text.strip()
        if outstanding is not None:
            final_resppnse['OUTSTANDING'] = outstanding.text.strip()
        # if AcctItemListDtoList is not None:
        #     final_resppnse['AcctItemListDtoList'] = AcctItemListDtoList.text.strip()

        return final_resppnse


    raise CustomException(status=result_code.text.strip(), detail=result_desc.text.strip())
    

