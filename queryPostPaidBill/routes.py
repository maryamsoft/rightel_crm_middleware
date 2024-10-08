from fastapi import APIRouter
from .handlers import  generate_response, generate_response, payment
from .schemas import OrderPricePlanOfferRequest, ResponseBase
from http import Request


router = APIRouter()

@router.post('/', response_model=ResponseBase)
async def queryPostPaidBill(request: Request):
    try:
        CBS_response = payment(request)
        result = generate_response(CBS_response)
        response =  {}
        return response
    except Exception as error:
        raise error
