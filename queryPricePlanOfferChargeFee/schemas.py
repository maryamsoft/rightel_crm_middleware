from pydantic import BaseModel
from fastapi import FastAPI
from utils.schemas import CommonHeaders

app = FastAPI()

class QueryPricePlanOfferChargeFeeRequest(CommonHeaders):
    msisdn: str
    offerCode: str
    channelId: int
    payFlag: str


class ResponseBase(BaseModel):
    MaximumDiscount : str
    Tax : str
    OfferFee : str
