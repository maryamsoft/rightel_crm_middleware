from typing import Annotated, Optional
from pydantic import BaseModel
from pydantic import BaseModel


class QueryPostPaidRequest(BaseModel):
    MSISDN: str
    BillingCycleId: Optional[str] = None

    
    
class ResponseBase(BaseModel):
    OrderNbr: str

