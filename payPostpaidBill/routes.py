from fastapi import APIRouter, Response, status
from .handlers import  pay_postpaid_bill_handler, generate_response
from .schemas import PayPostpaidBillRequest
from utils import header
from fastapi.responses import JSONResponse

router = APIRouter()

@router.post('/')
async def pay_postpaid_bill(request: PayPostpaidBillRequest, response:Response):
    try:
        xml_response = pay_postpaid_bill_handler(request)
        result = generate_response(xml_response)
        if result:
            header.successful_header(response)
            return result
        
        return JSONResponse(content={}, status_code=status.HTTP_200_OK)
        
    except Exception as error:
        raise error
