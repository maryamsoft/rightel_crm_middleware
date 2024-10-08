from fastapi import APIRouter
from .handlers import  generate_response, generate_response, ChangeSubOffering
from .schemas import OrderPricePlanOfferRequest, ResponseBase
from fastapi.responses import JSONResponse


router = APIRouter()

@router.post('', response_model=ResponseBase)
async def orderPricePlanOffer(request: OrderPricePlanOfferRequest):
    try:
        CBS_response = ChangeSubOffering(request)
        result = generate_response(CBS_response)
        if result:
            response =  {
                'OrderNbr':result
            }
            return response
        return JSONResponse(content= {
            'OrderNbr':None
        })
    except Exception as error:
        raise error
