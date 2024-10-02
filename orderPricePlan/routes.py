from fastapi import APIRouter
from fastapi import APIRouter
from .handlers import send_request, generate_response
from .schemas import OrderPricePlanOfferRequest, ResponseBase


router = APIRouter()



@router.post('/', response_model=ResponseBase)
async def orderPricePlanOffer(request: OrderPricePlanOfferRequest):
    CBS_response = send_request(request)
    result = generate_response(CBS_response)
    response =  {
        'OrderNbr':result
    }
    return response
    
