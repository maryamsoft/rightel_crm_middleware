from fastapi import APIRouter, Response, Header
from .handlers import  recharge_handler, generate_response_normal, generate_response_exciting, generate_response
from .schemas import RechargeRequest, CommonHeaders
from utils import header
from typing import Annotated

router = APIRouter()

@router.post('')
async def recharge_pps(request: RechargeRequest, response: Response, headers: Annotated[CommonHeaders, Header()]):
    try:
        if headers.requestId:
            request.requestId=headers.requestId
        xml_response = recharge_handler(request)
        result = generate_response(xml_response)
        # if request.paymentType == "1":
        #     result = generate_response_normal(xml_response)
        # else:
        #     result = generate_response_exciting(xml_response)
        header.successful_header(response)
        return result
    except Exception as error:
        raise error
