from fastapi import APIRouter, Response
from .handlers import  generate_response, payg_change_request
from .schemas import PaygChangeRequest, PaygChangeResponse
from fastapi.responses import JSONResponse
from utils import header


router = APIRouter()

@router.post('', response_model=PaygChangeResponse)
async def paygChangeRequest(request:PaygChangeRequest ,  response: Response):
    pass