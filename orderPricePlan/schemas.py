from typing import Annotated, Optional
from pydantic import BaseModel
from pydantic import BaseModel


class OrderPricePlanOfferRequest(BaseModel):
    msisdn: str
    offerCode: str
    channelId: int
    au: str
    amount: int
    discountFee: Optional[int]
    bankId: str
    payFlag: str
    CallerId: Optional[int]
    
    
class ResponseBase(BaseModel):
    OrderNbr: str

