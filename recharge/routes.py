from fastapi import APIRouter, Response, Header
from .handlers import  recharge_handler,generate_normal_response, generate_exciting_response
from .schemas import RechargeRequest, CommonHeaders
from utils import header
from typing import Annotated
from utils.logmodel import CMLog
from utils.logservice import logger
from datetime import datetime


router = APIRouter()

@router.post('')
async def recharge_pps(request: RechargeRequest, response: Response):
    try:
        CM_request_time =  datetime.now()
        xml_response = recharge_handler(request)
        if request.paymentType == "1":
            result = generate_normal_response(xml_response)
        else:
            result = generate_exciting_response(xml_response)
        header.successful_header(response)
        CM_response_time =  datetime.now()
        difference=CM_response_time- CM_request_time
        logger.debug(CMLog(method = 'rechargePPs', ResponseBody=result, CM_difference = difference).JsonString())  
        return result
    except Exception as error:
        raise error
