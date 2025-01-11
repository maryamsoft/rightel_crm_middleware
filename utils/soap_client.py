import requests
from fastapi import HTTPException
from utils.logservice import logger
from utils.logmodel import logmodel
import datetime

class SOAPClient:
    def __init__(self, wsdl_url):
        self.wsdl_url = wsdl_url

    def call_service(self, service_name, xml_data):
        headers = {'Content-Type': 'text/xml; charset=utf-8'}
        req_time = datetime.datetime.now()
        
        print('CBS_request_time:', req_time)
        response = requests.post(self.wsdl_url, data=xml_data, headers=headers, verify=False)
        
        response.raise_for_status()
        difference = datetime.datetime.now() - req_time
        print('CBS_response_time:', datetime.datetime.now())
        print('CBS_difference:', difference)
        
        if response.status_code==200:
            logger.debug(logmodel(ServiceUrl=self.wsdl_url,
                                   RequestHeader=headers,
                                   RequestBody=xml_data,
                                   ResponsetHeader=response.headers,
                                   ResponseBody=response.content,
                                   TimeSpan=difference.microseconds).JsonString())
            return response.content
        else:
            logger.debug(logmodel(RemoteIP=self.wsdl_url,
                                   RequestHeader=headers,
                                   RequestBody=xml_data,
                                   ResponsetHeader="status code is:"+response.status_code,
                                   ResponseBody="Bad content",
                                   TimeSpan=difference.microseconds).JsonString())
            raise HTTPException(status_code=response.status_code, detail="Bad content")


# BC_soap_client = SOAPClient("http://172.22.26.40:8080/services/BcServices")
# AR_soap_client = SOAPClient("http://172.22.26.40:8080/services/ArServices")
# ArCustomized_soap_client = SOAPClient("http://172.22.26.40:8080/services/ArCustomizedServices")
# BB_soap_client = SOAPClient("http://172.22.26.40:8080/services/BBServices")



BC_soap_client = SOAPClient("https://172.22.20.119:8081/services/BcServices")
AR_soap_client = SOAPClient("https://172.22.20.119:8081/services/ArServices")
ArCustomized_soap_client = SOAPClient("https://172.22.20.119:8081/services/ArCustomizedServices")
BB_soap_client = SOAPClient("https://172.22.20.119:8081/services/BBServices")