from fastapi import APIRouter, Response, status
from .handlers import  generate_response, check_credit_limit
from .schemas import  CheckCreditLimitRequest, CheckCreditLimitResponse
from fastapi.responses import JSONResponse
from utils import header



router = APIRouter()

@router.post('', response_model=CheckCreditLimitResponse)
async def checkCreditLimit(request:CheckCreditLimitRequest ,  response: Response):
    try:
        xml_response = check_credit_limit(request)
        result = generate_response(xml_response)
        if result:
            header.successful_header(response)   
            return result
        
        header.unsuccessful_header(response)
        return JSONResponse(content={}, status_code=status.HTTP_200_OK)
        
    except Exception as error:
        raise error