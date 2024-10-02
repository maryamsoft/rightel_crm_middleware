from fastapi import HTTPException
from lxml import etree
from utils import body
import requests


def send_request(data):
    headers = {
        'Content-Type': 'text/xml; charset=utf-8'
    }
    data.msisdn=9235000018
    payload = f'''
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bcs="http://www.huawei.com/bme/cbsinterface/bcservices" xmlns:cbs="http://www.huawei.com/bme/cbsinterface/cbscommon" xmlns:bcc="http://www.huawei.com/bme/cbsinterface/bccommon">
        <soapenv:Header/>
        <soapenv:Body>
            <bcs:ChangeSubOfferingRequestMsg>'''\
            +body.header_tag('ChangeSubOffering')+\
             body.content_tag(data)+\
            '''
            </bcs:ChangeSubOfferingRequestMsg>
        </soapenv:Body>
        </soapenv:Envelope>
        '''
    response = requests.request("POST", 'http://172.22.26.40:8080/services/BcServices', headers=headers, data=payload)
    if response.status_code==200:
        return response.content
    else:
        raise HTTPException(status_code=response.status_code, detail="Bad content")
        
        
def generate_response(cbs_response) :
    xml_root:etree = etree.fromstring(cbs_response)
    nsp_body ={'soapenv':'http://schemas.xmlsoap.org/soap/envelope/'}
    Body = xml_root.find('soapenv:Body', nsp_body)
    ch_body = Body.getchildren()[0]
    result =  Body.find(f'.//{{{ch_body.nsmap["bcc"]}}}OfferingID')
    offeringId = result.text
    return offeringId
    
    