from fastapi import APIRouter, Response
from .handlers import  generate_response, query_subscriber_rgusage
from .schemas import QuerySubscriberRGUsageRequest, QuerySubscriberRGUsageResponse
from fastapi.responses import JSONResponse
from utils import header


router = APIRouter()

@router.post('', response_model=QuerySubscriberRGUsageResponse)
async def querySubscriberRGUsage(request:QuerySubscriberRGUsageRequest ,  response: Response):
    try:
        xml_response = query_subscriber_rgusage(request)
        result = generate_response(xml_response)
        return result
    except Exception as error:
        raise error