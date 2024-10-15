from fastapi import APIRouter, Response
from .handlers import  generate_response, increase_credit
from .schemas import  IncreaseCreditRequest, IncreaseCreditResponse
from fastapi.responses import JSONResponse
from utils import header


router = APIRouter()

@router.post('')
async def increaseCredit(request:IncreaseCreditRequest ,  response: Response):
    try:
        xml_response = increase_credit(request)
        return xml_response
        result = generate_response(xml_response)
        return result
    except Exception as error:
        raise error