from fastapi import APIRouter, Response
from .handlers import  generate_response, increase_credit
from .schemas import  IncreaseCreditRequest
from fastapi.responses import JSONResponse
from utils import header
from utils.logmodel import CMLog
from utils.logservice import logger

router = APIRouter()

@router.post('')
async def increaseCredit(request:IncreaseCreditRequest ,  response: Response):
    try:
        xml_response = increase_credit(request)
        result = generate_response(xml_response)
        if result:
            headers = header.successful_header(response)
            logger.debug(CMLog(method = 'increaseCredit', ResponseBody=result).JsonString())
        else:
            headers = header.unsuccessful_header(response, '1', 'nok')
            
        return JSONResponse(content={}, headers=headers, status_code=200)
    except Exception as error:
        raise error