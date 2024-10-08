import os
import xml.etree.ElementTree as ET
from string import Template
from datetime import datetime
from fastapi import HTTPException, Security, status
from utils.soap_client import AR_soap_client


def queryInvoice(data):
    data.msisdn = 9235000018
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/queryInvoice.txt', 'r') as file:
        query_invoice_template = file.read()
    query_invoice_template = Template(changeSubOffering_template)
    query_invoice = query_invoice_template.substitute({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S")})
    return AR_soap_client.call_service('QueryInvoice', payment)
    

def generate_response(cbs_response) :
        root = ET.fromstring(cbs_response)
        namespaces = {
        'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
        'ars': 'http://www.huawei.com/bme/cbsinterface/arservices',
        'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
        'bcc': 'http://www.huawei.com/bme/cbsinterface/bccommon'
    }

        result_code = root.find('.//cbs:ResultCode', namespaces)
        result_desc = root.find('.//cbs:ResultDesc', namespaces)
        if result_code is not None and result_code.text == '0':
            result= [[]]
            invoiceInfo = len(root.findall(".//InvoiceInfo"))
            i = 0
            for instance in range(invoiceInfo):
                if arr[instance] != 0:
                    multi_arr[i].append(arr[instance])
            else:
                i += 1
                multi_arr.insert(i,[])
                
            AcctItemListDtoList = {
                "AcctItemTypeName",
                "Amount",
                "Usage"
            }

            {
                "PayableAmount",
                "InvoiceID",
                "PaymentID",
                "AcctItemListDtoList":AcctItemListDtoList,
                "Subscription",
                "AddSubscription",
                "TotalAmout",
                "Tax",
                "OutStanding",
                "BillingCycleStartDate",
                "EndDate"

            }

        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail= result_desc.text)

