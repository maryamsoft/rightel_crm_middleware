import requests
import os
from lxml import etree
from utils import body
from string import Template
from datetime import datetime
from utils.soap_client import BC_soap_client


def ChangeSubOffering(data):
    data.msisdn=9235000018
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/ChangeSubOffering.txt', 'r') as file:
        changeSubOffering_template = file.read()
    changeSubOffering_template = Template(changeSubOffering_template)
    changeSubOffering = changeSubOffering_template.substitute({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),"C_FREE_PAY_FLAG" : 0 if data.payFlag==1 else 1})
    return BC_soap_client.call_service('ChangeSubOffering', changeSubOffering)
    

def generate_response(cbs_response) :
    xml_root:etree = etree.fromstring(cbs_response)
    nsp_body ={'soapenv':'http://schemas.xmlsoap.org/soap/envelope/'}
    Body = xml_root.find('soapenv:Body', nsp_body)
    ch_body = Body.getchildren()[0]
    result =  Body.find(f'.//{{{ch_body.nsmap["bcc"]}}}OfferingID')
    offeringId = result.text
    return offeringId
