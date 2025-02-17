from fastapi import APIRouter, Response
from .handlers import  generate_response, query_subscriber_rgusage
from .schemas import QuerySubscriberRGUsageRequest, QuerySubscriberRGUsageResponse
from fastapi.responses import JSONResponse
from utils import header
from utils.logmodel import CMLog
from utils.logservice import logger
from datetime import datetime


router = APIRouter()

@router.post('', response_model=QuerySubscriberRGUsageResponse)
async def querySubscriberRGUsage(request:QuerySubscriberRGUsageRequest ,  response: Response):
    try:
        CM_request_time =  datetime.now()
        xml_response = query_subscriber_rgusage(request)
        result = generate_response(xml_response)
        if result:
            header.successful_header(response)
            CM_response_time =  datetime.now()
            difference=CM_response_time- CM_request_time
            logger.debug(CMLog(method = 'querySubscriberRGUsage', ResponseBody=result, CM_difference = difference).JsonString())  
            return result
        
        return JSONResponse(content= {})
    except Exception as error:
        raise error