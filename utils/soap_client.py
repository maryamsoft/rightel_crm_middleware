import requests


class SOAPClient:
    def __init__(self, wsdl_url):
        self.wsdl_url = wsdl_url

    def call_service(self, service_name, xml_data):
        headers = {'Content-Type': 'text/xml; charset=utf-8'}
        response = requests.post(self.wsdl_url, data=xml_data, headers=headers)
        response.raise_for_status()
        return response.text


soap_client = SOAPClient("http://example.com/your-service?wsdl")