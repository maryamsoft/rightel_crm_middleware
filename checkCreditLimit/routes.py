from fastapi import APIRouter, Response, status
from .handlers import  generate_response, check_credit_limit
from .schemas import  CheckCreditLimitRequest, CheckCreditLimitResponse
from fastapi.responses import JSONResponse
from utils import header
from utils.logmodel import CMLog
from utils.logservice import logger
from datetime import datetime

router = APIRouter()

@router.post('', response_model=CheckCreditLimitResponse)
async def checkCreditLimit(request:CheckCreditLimitRequest ,  response: Response):
    try:
        CM_request_time =  datetime.now()
        xml_response = check_credit_limit(request)
        result = generate_response(xml_response)       
        if result:
            header.successful_header(response)
            CM_response_time =  datetime.now()
            difference=CM_response_time- CM_request_time
            logger.debug(CMLog(method = 'checkCreditLimit', ResponseBody=result, CM_difference = difference).JsonString())
            return result
        
        header.unsuccessful_header(response)
        return JSONResponse(content={}, status_code=status.HTTP_200_OK)
        
    except Exception as error:
        raise error