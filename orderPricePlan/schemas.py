from typing import Annotated
from pydantic import BaseModel
from pydantic import BaseModel, create_model
from datetime import datetime
from typing import List
from typing_extensions import TypedDict

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

