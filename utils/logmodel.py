import json
class logmodel:
    def __init__(self, ServiceUrl, RequestHeader,RequestBody,ResponsetHeader,ResponseBody):
        self.ServiceUrl = ServiceUrl.__str__()
        self.RequestHeader = RequestHeader.__str__()
        self.RequestBody = RequestBody.__str__()
        self.ResponsetHeader = ResponsetHeader.__str__()
        self.ResponseBody = ResponseBody.__str__()
    def JsonString(self):
        json_data = json.dumps(self.__dict__)
        return json_data
