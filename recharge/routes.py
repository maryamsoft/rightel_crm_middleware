from fastapi import APIRouter
from .handlers import  recharge_handler, generate_response
from .schemas import RechargeRequest


router = APIRouter()

@router.post('/')
async def recharge_pps(request: RechargeRequest):
    try:
        xml_response = recharge_handler(request)
        result = generate_response(xml_response)
        return result
    except Exception as error:
        raise error
