from fastapi import APIRouter, Response
from .handlers import  recharge_handler, generate_response
from .schemas import RechargeRequest
from utils import header

router = APIRouter()

@router.post('')
async def recharge_pps(request: RechargeRequest, response: Response):
    try:
        xml_response = recharge_handler(request)
        result = generate_response(xml_response)
        header.successful_header(response)
        return result
    except Exception as error:
        raise error
