from typing import Annotated, Optional
from pydantic import BaseModel
from utils.schemas import CommonHeaders

class QueryPostPaidRequest(CommonHeaders):
    MSISDN: str

    
#Response_Schema    
class ResponseBase(BaseModel):
    PayableAmount:str
    InvoiceId:str
    PaymentId:str
    BillingCycleStartDate:str
    BillingCycleEndDate:str
    BillingCycleID:str
    DateIssuance:str
    Status:str
    OUTSTANDING:str

