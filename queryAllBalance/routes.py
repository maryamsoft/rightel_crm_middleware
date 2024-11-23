from fastapi import APIRouter, Response, status
from .handlers import generate_response, customerInfo
from .schemas import queryAllBalanceRequest, queryAllBalanceResponse
from utils import header
from fastapi.responses import JSONResponse

router = APIRouter()


@router.post('', response_model=queryAllBalanceResponse)
async def queryAllBalance(request: queryAllBalanceRequest, response: Response):
    CBS_response = customerInfo(request)
    result = generate_response(CBS_response)
    if result:
            header.successful_header(response)   
            return result
        
    header.unsuccessful_header(response)
    return JSONResponse(content={}, status_code=status.HTTP_200_OK)
