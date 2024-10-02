from fastapi import APIRouter
from .handlers import  generate_response, generate_response, ChangeSubOffering
from .schemas import OrderPricePlanOfferRequest, ResponseBase


router = APIRouter()


@router.post('/', response_model=ResponseBase)
async def orderPricePlanOffer(request: OrderPricePlanOfferRequest):
    try:
        CBS_response = ChangeSubOffering(request)
        result = generate_response(CBS_response)
        response =  {
            'OrderNbr':result
        }
        return response
    except Exception as error:
        raise error
