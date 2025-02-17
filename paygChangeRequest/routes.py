from fastapi import APIRouter, Response
from .handlers import  generate_response, payg_change_request_handler
from .schemas import PaygChangeRequest, PaygChangeResponse
from fastapi.responses import JSONResponse
from utils import header
from utils.logmodel import CMLog
from utils.logservice import logger
from datetime import datetime


router = APIRouter()

@router.post('', response_model=PaygChangeResponse)
async def paygChangeRequest(request:PaygChangeRequest ,  response: Response):
    try:
        CM_request_time =  datetime.now()
        xml_response = payg_change_request_handler(request)
        result = generate_response(xml_response, request)
        header.successful_header(response)
        CM_response_time =  datetime.now()
        difference=CM_response_time- CM_request_time
        logger.debug(CMLog(method = 'paygChangeRequest', ResponseBody=result, CM_difference = difference).JsonString())
        return result
    except Exception as error:
        raise error
