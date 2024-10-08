from fastapi import APIRouter, Response
from .handlers import  generate_response, ChangeSubOffering
from .schemas import OrderPricePlanOfferRequest, ResponseBase
from fastapi.responses import JSONResponse
from utils import header


router = APIRouter()

@router.post('', response_model=ResponseBase)
async def orderPricePlanOffer(request: OrderPricePlanOfferRequest,  response: Response):
    try:
        CBS_response = ChangeSubOffering(request)
        result = generate_response(CBS_response)
        if result:
            response_content =  {
                'OrderNbr':result
            }
            header.successful_header(response)
            return response_content
        return JSONResponse(content= {
            'OrderNbr':None
        })
    except Exception as error:
        raise error
