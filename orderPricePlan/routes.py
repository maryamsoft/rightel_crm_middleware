from fastapi import APIRouter, Request, Response,  Depends
from fastapi.responses import JSONResponse
from utils import common
from .handlers import separationDoServiceOrderPricePlan
router = APIRouter()


@router.post('/api/osb/cbs/orderPricePlan-doservice')
async def CheckRequestType(request: Request):
    content_type = request.headers['Content-Type']
    if content_type == 'application/xml':
        request_body = await request.body()
        convert_xml_to_string = str(request_body, encoding='utf-8')
        if common.is_do_service(convert_xml_to_string):
            print('convert_xml_to_string:', convert_xml_to_string)
    separationDoServiceOrderPricePlan(request_body)
    return Response(content='ok', media_type="application/xml")