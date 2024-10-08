from fastapi import APIRouter
from .handlers import generate_response, ChangeSubOffering
from .schemas import OrderPricePlanOfferRequest, ResponseBase
from http import Request


router = APIRouter()


@router.post('/', response_model=ResponseBase)
async def queryAllBalance(request: Request):
    CBS_response = ChangeSubOffering(request)
    result = generate_response(CBS_response)
    response =  {
        'OrderNbr':result
    }
    return response
