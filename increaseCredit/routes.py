from fastapi import APIRouter, Response
from .handlers import  generate_response, increase_credit
from .schemas import  IncreaseCreditRequest
from fastapi.responses import JSONResponse
from utils import header


router = APIRouter()

@router.post('')
async def increaseCredit(request:IncreaseCreditRequest ,  response: Response):
    try:
        xml_response = increase_credit(request)
        result = generate_response(xml_response)
        if result:
            headers = header.successful_header(response)
        else:
            headers = header.unsuccessful_header(response, '1', 'nok')
            
        return JSONResponse(content={}, headers=headers, status_code=200)
    except Exception as error:
        raise error