from fastapi import APIRouter, Response
from .handlers import  recharge_handler, generate_response_normal, generate_response_exciting, generate_response
from .schemas import RechargeRequest
from utils import header

router = APIRouter()

@router.post('')
async def recharge_pps(request: RechargeRequest, response: Response):
    try:
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
