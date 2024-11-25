from typing import Annotated, Optional
from pydantic import BaseModel


class QueryPostPaidRequest(BaseModel):
    MSISDN: str

    
    
class ResponseBase(BaseModel):
    PayableAmount:str
    InvoiceId:str
    PaymentId:str
    BillingCycleStartDate:str
    BillingCycleEndDate:str
    BillingCycleID:str
    DateIssuance:str
    Status:str
    OUTSTAINDING:str

