from fastapi import APIRouter
from .handlers import  query_postpaid_hotbill_handler, generate_response
from .schemas import QueryPostpaidHotBillRequest


router = APIRouter()

@router.post('')
async def queryPostpaidHotBill(request: QueryPostpaidHotBillRequest):
    try:
        xml_response = query_postpaid_hotbill_handler(request)
        result = generate_response(xml_response)
        
        return result
    except Exception as error:
        raise error
