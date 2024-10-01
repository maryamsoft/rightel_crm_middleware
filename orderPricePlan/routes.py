from fastapi import APIRouter, Request, Response,  Depends
from fastapi.responses import JSONResponse
from utils import common
from fastapi import APIRouter
from typing import Annotated
from pydantic import BaseModel
from .services import ChangeSubOffering
from .handlers import separationDoServiceOrderPricePlan, generate_request


router = APIRouter()


@router.post('/doservice')
async def CheckRequestType(request: Request):
    # content_type = request.headers['Content-Type']
    # if content_type == 'application/xml':
    #     request_body = await request.body()
    #     convert_xml_to_string = str(request_body, encoding='utf-8')
    #     if common.is_do_service(convert_xml_to_string):
    #         print('convert_xml_to_string:', convert_xml_to_string)
    request_body = await request.body()
    separationDoServiceOrderPricePlan(request_body)
    return Response(content='ok', media_type="application/xml")



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


@router.post('/')
async def orderPricePlanOffer(request: OrderPricePlanOfferRequest):
    # generate_request(request)
    ChangeSubOffering(request)
    # return call_cbs(request.dict())
