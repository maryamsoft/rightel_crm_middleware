from fastapi import APIRouter
from .handlers import  pay_postpaid_hot_bill_handler, generate_response
from .schemas import PayPostpaidHotBillRequest


router = APIRouter()

@router.post('/')
async def pay_postpaid_hot_bill(request: PayPostpaidHotBillRequest):
    try:
        xml_response = pay_postpaid_hot_bill_handler(request)
        result = generate_response(xml_response)
        return result
    except Exception as error:
        raise error
