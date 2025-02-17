from fastapi import APIRouter, Response, status
from .handlers import  query_postpaid_hotbill_handler, generate_response
from .schemas import QueryPostpaidHotBillRequest
from utils import header
from fastapi.responses import JSONResponse
from utils.logmodel import CMLog
from utils.logservice import logger
from datetime import datetime


router = APIRouter()

@router.post('')
async def queryPostpaidHotBill(request: QueryPostpaidHotBillRequest, response: Response):
    try:
        CM_request_time =  datetime.now()
        xml_response = query_postpaid_hotbill_handler(request)
        result = generate_response(xml_response)
        if result:
            header.successful_header(response)
            CM_response_time =  datetime.now()
            difference=CM_response_time- CM_request_time
            logger.debug(CMLog(method = 'queryPostpaidHotBill', ResponseBody=result, CM_difference = difference).JsonString())  
            return result
        
        header.unsuccessful_header(response)
        return JSONResponse(content={}, status_code=status.HTTP_200_OK)
        
    except Exception as error:
        raise error
