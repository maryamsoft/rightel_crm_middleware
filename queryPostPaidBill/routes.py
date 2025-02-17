from fastapi import APIRouter, Response, status
from .handlers import  query_post_paid_bill_handler, generate_response
from .schemas import QueryPostPaidRequest, ResponseBase
from utils import header
from fastapi.responses import JSONResponse
from utils.logmodel import CMLog
from utils.logservice import logger
from datetime import datetime


router = APIRouter()

@router.post('', response_model=ResponseBase)
async def queryPostPaidBill(request: QueryPostPaidRequest, response: Response):
    try:
        CM_request_time =  datetime.now()
        CBS_response = query_post_paid_bill_handler(request)
        result = generate_response(CBS_response)
        if result:
            header.successful_header(response)
            CM_response_time =  datetime.now()
            difference=CM_response_time- CM_request_time
            logger.debug(CMLog(method = 'queryPostPaidBill', ResponseBody=result, CM_difference = difference).JsonString())
            return result
        
        header.unsuccessful_header(response)
        return JSONResponse(content={}, status_code=status.HTTP_200_OK)
    except Exception as error:
        raise error
