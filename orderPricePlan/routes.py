from fastapi import APIRouter, Request, Response,  Depends
from fastapi.responses import JSONResponse
from utils import common
from fastapi import APIRouter
from .services import call_cbs
from .handlers import separationDoServiceOrderPricePlan, send_request, generate_response, parse_response
from .schemas import OrderPricePlanOfferRequest, ResponseBase


router = APIRouter()


@router.post('/doservice')
async def CheckRequestType(request: Request):
    # content_type = request.headers['Content-Type']
    # if content_type == 'application/xml':
    #     request_body = await request.body()
    #     convert_xml_to_string = str(request_body, encoding='utf-8')
    #     if common.is_do_service(convert_xml_to_string):
    #         print('convert_xml_to_string:', convert_xml_to_string)
    request_body = await request.body()
    separationDoServiceOrderPricePlan(request_body)
    return Response(content='ok', media_type="application/xml")


@router.post('/', response_model=ResponseBase)
async def orderPricePlanOffer(request: OrderPricePlanOfferRequest):
    CBS_response = send_request(request)
    # result = generate_response(CBS_response)
    result = parse_response(CBS_response)
    response =  {
        'OrderNbr':result
    }
    return response
    
