from fastapi import APIRouter, Response, status
from .handlers import generate_response, customerInfo
from .schemas import queryAllBalanceRequest, queryAllBalanceResponse
from utils import header
from fastapi.responses import JSONResponse
from datetime import datetime

router = APIRouter()


@router.post('', response_model=queryAllBalanceResponse)
async def queryAllBalance(request: queryAllBalanceRequest, response: Response):
        CM_request_time =  datetime.now()
        print('CM_request_time:', CM_request_time)
        CBS_response = customerInfo(request)
        result = generate_response(CBS_response)
        if result:
                header.successful_header(response)
                CM_response_time =  datetime.now()
                print('CM_response_time:', datetime.now())
                print('CM_difference:', CM_response_time- CM_request_time)
                return result
                
        header.unsuccessful_header(response)
        print('CM_response_time:', datetime.now())
        return JSONResponse(content={}, status_code=status.HTTP_200_OK)
