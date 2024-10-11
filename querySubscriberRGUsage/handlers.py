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
    pass


