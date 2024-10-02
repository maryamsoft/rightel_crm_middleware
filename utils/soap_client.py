import requests
from fastapi import HTTPException

class SOAPClient:
    def __init__(self, wsdl_url):
        self.wsdl_url = wsdl_url

    def call_service(self, service_name, xml_data):
        headers = {'Content-Type': 'text/xml; charset=utf-8'}
        response = requests.post(self.wsdl_url, data=xml_data, headers=headers)
        response.raise_for_status()
        if response.status_code==200:
            return response.content
        else:
            raise HTTPException(status_code=response.status_code, detail="Bad content")


BC_soap_client = SOAPClient("http://172.22.26.40:8080/services/BcServices")
AR_soap_client = SOAPClient("http://172.22.26.40:8080/services/ArServices")