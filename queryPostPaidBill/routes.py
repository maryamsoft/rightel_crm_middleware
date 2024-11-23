from fastapi import APIRouter, Response, status
from .handlers import  query_post_paid_bill_handler, generate_response
from .schemas import QueryPostPaidRequest, ResponseBase
from utils import header
from fastapi.responses import JSONResponse

router = APIRouter()

@router.post('', response_model=ResponseBase)
async def queryPostPaidBill(request: QueryPostPaidRequest, response: Response):
    try:
        CBS_response = query_post_paid_bill_handler(request)
        result = generate_response(CBS_response)
        if result:
            header.successful_header(response)   
            return result
        
        header.unsuccessful_header(response)
        return JSONResponse(content={}, status_code=status.HTTP_200_OK)
    except Exception as error:
        raise error
