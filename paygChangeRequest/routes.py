from fastapi import APIRouter, Response
from .handlers import  generate_response, ChangeSubOffering
from .schemas import  ResponseBase
from fastapi.responses import JSONResponse
from utils import header


router = APIRouter()

@router.post('', response_model=ResponseBase)
async def paygChangeRequest(request ,  response: Response):
    pass