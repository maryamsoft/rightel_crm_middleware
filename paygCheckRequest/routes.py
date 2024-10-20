from fastapi import APIRouter, Response
from .handlers import generate_response, payg_check_request
from .schemas import PaygCheckRequest, PaygCheckResponse
from fastapi.responses import JSONResponse
from utils import header

router = APIRouter()


@router.post('')
async def paygCheckRequest(request: PaygCheckRequest, response: Response):
    try:
        xml_response = payg_check_request(request)
        return xml_response
        result = generate_response(xml_response)
        return result
    except Exception as error:
        raise error
