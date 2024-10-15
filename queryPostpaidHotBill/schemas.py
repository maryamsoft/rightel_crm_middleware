from pydantic import BaseModel

class QueryPostpaidHotBillRequest(BaseModel):
    msisdn: str
