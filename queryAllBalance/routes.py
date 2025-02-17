from fastapi import APIRouter, Response, status
from .handlers import generate_response, customerInfo
from .schemas import queryAllBalanceRequest, queryAllBalanceResponse
from utils import header
from fastapi.responses import JSONResponse
from datetime import datetime
from utils.logmodel import CMLog
from utils.logservice import logger
router = APIRouter()


@router.post('', response_model=queryAllBalanceResponse)
async def queryAllBalance(request: queryAllBalanceRequest, response: Response):
        CM_request_time =  datetime.now()
        CBS_response = customerInfo(request)
        result = generate_response(CBS_response)
        if result:
                header.successful_header(response)
                CM_response_time =  datetime.now()
                difference=CM_response_time- CM_request_time
                logger.debug(CMLog(method = 'queryAllBalance', ResponseBody=result, CM_difference = difference).JsonString())
                return result
                
        header.unsuccessful_header(response)
        return JSONResponse(content={}, status_code=status.HTTP_200_OK)
