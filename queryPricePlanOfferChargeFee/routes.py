from fastapi import APIRouter, Response
from .handlers import  generate_response, queryChargeFee
from .schemas import QueryPricePlanOfferChargeFeeRequest, ResponseBase
from fastapi.responses import JSONResponse
from utils import header


router = APIRouter()

@router.post('', response_model=ResponseBase)
async def queryPricePlanOfferChargeFee(request: QueryPricePlanOfferChargeFeeRequest,  response: Response):
    try:
        CBS_response = queryChargeFee(request)
        result = generate_response(CBS_response)
        if result:
            header.successful_header(response)
            return result
        return JSONResponse(content= {
            'OrderNbr':None
        })
    except Exception as error:
        raise error
