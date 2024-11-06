from fastapi import APIRouter, Response
from .handlers import  generate_response, payg_change_request_handler
from .schemas import PaygChangeRequest, PaygChangeResponse
from fastapi.responses import JSONResponse
from utils import header


router = APIRouter()

@router.post('', response_model=PaygChangeResponse)
async def paygChangeRequest(request:PaygChangeRequest ,  response: Response):
    try:
        xml_response = payg_change_request_handler(request)
        result = generate_response(xml_response, request)
        header.successful_header(response)
        return result
    except Exception as error:
        raise error
