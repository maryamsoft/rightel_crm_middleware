from fastapi import APIRouter, Response, status
from .handlers import  query_postpaid_hotbill_handler, generate_response
from .schemas import QueryPostpaidHotBillRequest
from utils import header
from fastapi.responses import JSONResponse

router = APIRouter()

@router.post('')
async def queryPostpaidHotBill(request: QueryPostpaidHotBillRequest, response: Response):
    try:
        xml_response = query_postpaid_hotbill_handler(request)
        result = generate_response(xml_response)
        if result:
            header.successful_header(response)   
            return result
        
        header.unsuccessful_header(response)
        return JSONResponse(content={}, status_code=status.HTTP_200_OK)
        
    except Exception as error:
        raise error
