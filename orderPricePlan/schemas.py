from typing import Annotated, Optional
from pydantic import BaseModel, validator
from fastapi import FastAPI, HTTPException


app = FastAPI()

class OrderPricePlanOfferRequest(BaseModel):
    msisdn: str
    offerCode: str
    channelId: int
    au: Optional[str]
    amount: Optional[str]
    bankId: Optional[str]
    payFlag: str
    CallerId: Optional[str]
    discountFee: Optional[str]
    
    @validator('payFlag', always=True)
    def check_au_bankId_amount(cls, v, values):
        if str(v) == '2' and (values.get('au')  is None or values.get('bankId')  is None or values.get('amount')  is None):
            raise ValueError('au and bankId and amount are required when payFlag is "2"')
        return v


class ResponseBase(BaseModel):
    OrderNbr: str