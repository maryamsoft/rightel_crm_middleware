from fastapi import APIRouter, Response, status
from .handlers import  pay_postpaid_bill_handler, generate_response
from .schemas import PayPostpaidBillRequest
from utils import header
from fastapi.responses import JSONResponse
from utils.logmodel import CMLog
from utils.logservice import logger
router = APIRouter()

@router.post('')
async def pay_postpaid_bill(request: PayPostpaidBillRequest, response:Response):
    try:
        xml_response = pay_postpaid_bill_handler(request)
        result = generate_response(xml_response)
        if result:
            header.successful_header(response)
            logger.debug(CMLog(method = 'pay_postpaid_bill', ResponseBody=result).JsonString())
            return result
        headers = header.unsuccessful_header(response)
        return JSONResponse(content={},headers=headers, status_code=status.HTTP_200_OK)
        
    except Exception as error:
        raise error
