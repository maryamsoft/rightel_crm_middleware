from fastapi import APIRouter, Response, Header
from .handlers import  recharge_handler,generate_normal_response, generate_exciting_response, generate_response
from .schemas import RechargeRequest, CommonHeaders
from utils import header
from typing import Annotated

router = APIRouter()

@router.post('')
async def recharge_pps(request: RechargeRequest, response: Response):
    try:
        xml_response = recharge_handler(request)
        # result = generate_response(xml_response)
        if request.paymentType == "1":
            result = generate_normal_response(xml_response)
        else:
            result = generate_exciting_response(xml_response)
        header.successful_header(response)
        return result
    except Exception as error:
        raise error
