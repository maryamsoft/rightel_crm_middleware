from typing import Annotated
from pydantic import BaseModel
from pydantic import BaseModel


class QueryPostPaidRequest(BaseModel):
    MSISDN: str
    BillingCycleId: str

    
    
class ResponseBase(BaseModel):
    OrderNbr: str

