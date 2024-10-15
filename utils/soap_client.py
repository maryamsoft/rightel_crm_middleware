import requests
from fastapi import HTTPException
from utils.logservice import logger
from utils.logmodel import logmodel

class SOAPClient:
    def __init__(self, wsdl_url):
        self.wsdl_url = wsdl_url

    def call_service(self, service_name, xml_data):
        headers = {'Content-Type': 'text/xml; charset=utf-8'}
        response = requests.post(self.wsdl_url, data=xml_data, headers=headers)
        response.raise_for_status()
        if response.status_code==200:
            logger.debug(logmodel(ServiceUrl=self.wsdl_url,
                                   RequestHeader=headers,
                                   RequestBody=xml_data,
                                   ResponsetHeader=response.headers,
                                   ResponseBody=response.content).JsonString())
            return response.content
        else:
            logger.debug(logmodel(RemoteIP=self.wsdl_url,
                                   RequestHeader=headers,
                                   RequestBody=xml_data,
                                   ResponsetHeader="status code is:"+response.status_code,
                                   ResponseBody="Bad content").JsonString())
            raise HTTPException(status_code=response.status_code, detail="Bad content")


BC_soap_client = SOAPClient("http://172.22.26.40:8080/services/BcServices")
AR_soap_client = SOAPClient("http://172.22.26.40:8080/services/ArServices")
BB_soap_client = SOAPClient("http://172.22.26.40:8080/services/BBServices")