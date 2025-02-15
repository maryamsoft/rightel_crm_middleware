from fastapi import APIRouter, Response
from .handlers import  generate_response, query_subscriber_rgusage
from .schemas import QuerySubscriberRGUsageRequest, QuerySubscriberRGUsageResponse
from fastapi.responses import JSONResponse
from utils import header
from utils.logmodel import CMLog
from utils.logservice import logger

router = APIRouter()

@router.post('', response_model=QuerySubscriberRGUsageResponse)
async def querySubscriberRGUsage(request:QuerySubscriberRGUsageRequest ,  response: Response):
    try:
        xml_response = query_subscriber_rgusage(request)
        result = generate_response(xml_response)
        if result:
            header.successful_header(response)
            logger.debug(CMLog(method = 'querySubscriberRGUsage', ResponseBody=result).JsonString())  
            return result
        
        return JSONResponse(content= {})
    except Exception as error:
        raise error