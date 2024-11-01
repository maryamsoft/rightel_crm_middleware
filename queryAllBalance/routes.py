from fastapi import APIRouter
from fastapi import APIRouter, Response
from .handlers import generate_response, customerInfo
from .schemas import queryAllBalanceRequest, queryAllBalanceResponse


router = APIRouter()


@router.post('/')
async def queryAllBalance(request: queryAllBalanceRequest):
    CBS_response = customerInfo(request)
    result = generate_response(CBS_response)
    return result
