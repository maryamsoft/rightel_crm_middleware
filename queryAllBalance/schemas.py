from typing import Annotated
from pydantic import BaseModel
from pydantic import BaseModel


class OrderPricePlanOfferRequest(BaseModel):
    msisdn: str
    offerCode: str
    channelId: int
    au: str
    amount: int
    discountFee: Annotated[None, "discountFee"]
    bankId: str
    payFlag: str
    CallerID: Annotated[None, "CallerID"]
    
    
class ResponseBase(BaseModel):
    OrderNbr: str

