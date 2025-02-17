import json
from utils.custom_handler import convert_uts_to_asia_tehran
from datetime import datetime
class logmodel:
    def __init__(self, ServiceUrl, RequestHeader,RequestBody,ResponsetHeader,ResponseBody,TimeSpan):
        self.ServiceUrl = ServiceUrl.__str__()
        self.RequestHeader = RequestHeader.__str__()
        self.RequestBody = RequestBody.__str__()
        self.ResponsetHeader = ResponsetHeader.__str__()
        self.ResponseBody = ResponseBody.__str__()
        self.TimeSpan = TimeSpan/1000
    def JsonString(self):
        json_data = json.dumps(self.__dict__)
        return json_data

class mainLog:
    def __init__(self,ServiceUrl, RequestHeader,RequestBody):
        self.RequestTime =  convert_uts_to_asia_tehran().strftime("%Y-%m-%dT%H:%M:%S:%f")
        self.ServiceUrl = ServiceUrl.__str__()
        self.RequestHeader = RequestHeader.__str__()
        self.RequestBody = RequestBody.__str__()
    def JsonString(self):
        json_data = json.dumps(self.__dict__)
        return json_data

class CMLog:
    def __init__(self,ResponseBody,method, CM_difference):
        self.ResponseTime =  datetime.now().strftime("%Y-%m-%dT%H:%M:%S:%f")
        self.method =  method.__str__()
        self.ResponseBody =  ResponseBody.__str__()
        self.CM_difference =  CM_difference.__str__()
    def JsonString(self):
        json_data = json.dumps(self.__dict__)
        return json_data