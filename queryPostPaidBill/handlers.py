import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from fastapi import HTTPException, Security, status
from utils.soap_client import AR_soap_client


def queryInvoice(data):
    
    data.msisdn = 9235000018
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/queryInvoice.txt', 'r') as file:
        query_invoice_template = file.read()
    query_invoice_template = Template(query_invoice_template)
    query_invoice = query_invoice_template.render({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S")})
    return AR_soap_client.call_service('QueryInvoice', query_invoice)
    

def generate_response(cbs_response) :
    pass

