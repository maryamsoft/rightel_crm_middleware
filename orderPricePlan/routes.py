from fastapi import APIRouter
from typing import Annotated
from pydantic import BaseModel
from .services import dict_to_xml

router = APIRouter()


class OrderPricePlanOfferRequest(BaseModel):
    msisdn: str
    offerCode: str
    channelId: int
    au: str
    amount: int
    discountFee: Annotated[None, "discountFee"]
    bankId: str
    payFlag: str

@router.post("/")
async def orderPricePlanOffer(request: OrderPricePlanOfferRequest):

    return dict_to_xml(request.dict())