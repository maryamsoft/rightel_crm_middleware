import os
import xml.etree.ElementTree as ET
from jinja2 import Template
from datetime import datetime
from utils.soap_client import BC_soap_client
from fastapi import HTTPException, Security, status


def query_postpaid_hotbill_handler(data):
    print('data:', {**data.__dict__})
    print("datetime:",datetime.now().strftime("%Y-%m-%dT%H:%M:%S"))
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/QueryPostpaidHotBill.txt', 'r') as file:
        template = file.read()
    template = Template(template)
    xml_data = template.render({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S")})
    print("request:", xml_data)
    return BC_soap_client.call_service('QueryPostpaidHotBill', xml_data)

def generate_response(response) :
        return response