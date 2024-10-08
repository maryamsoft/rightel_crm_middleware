import os
import xml.etree.ElementTree as ET
from string import Template
from datetime import datetime
from fastapi import HTTPException, Security, status
from utils.soap_client import BC_soap_client


def ChangeSubOffering(data):
    print('data:', {**data.__dict__})
    print("datetime:",datetime.now().strftime("%Y-%m-%dT%H:%M:%S"))
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/ChangeSubOffering.txt', 'r') as file:
        changeSubOffering_template = file.read()
    changeSubOffering_template = Template(changeSubOffering_template)
    changeSubOffering = changeSubOffering_template.substitute({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),"C_FREE_PAY_FLAG" : 0 if data.payFlag==1 else 1})
    return BC_soap_client.call_service('ChangeSubOffering', changeSubOffering)
    

def generate_response(cbs_response) :
        root = ET.fromstring(cbs_response)
        namespaces = {
        'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
        'bcs': 'http://www.huawei.com/bme/cbsinterface/bcservices',
        'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
        'bcc': 'http://www.huawei.com/bme/cbsinterface/bccommon'
    }

        result_code = root.find('.//cbs:ResultCode', namespaces)
        result_desc = root.find('.//cbs:ResultDesc', namespaces)
        if result_code is not None and result_code.text == '0':
            offering_id = root.find('.//bcc:OfferingID', namespaces)
            if offering_id is not None:
                return offering_id.text.strip()

        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail= result_desc.text)


    #old_way
    #     xml_root:etree = etree.fromstring(cbs_response)
    #     nsp_body ={'soapenv':'http://schemas.xmlsoap.org/soap/envelope/'}
    #     Body = xml_root.find('soapenv:Body', nsp_body)
    #     ch_body = Body.getchildren()[0]
    #     result =  Body.find(f'.//{{{ch_body.nsmap["bcc"]}}}OfferingID')
    #     offeringId = result.text
    #     return offeringId

