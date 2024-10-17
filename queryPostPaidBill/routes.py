from fastapi import APIRouter
from .handlers import  query_post_paid_bill_handler, generate_response
from .schemas import QueryPostPaidRequest, ResponseBase
# from http import Request


router = APIRouter()

@router.post('/', response_model=ResponseBase)
async def queryPostPaidBill(request: QueryPostPaidRequest):
    try:
        CBS_response = query_post_paid_bill_handler(request)
        result = generate_response(CBS_response)
        response =  {}
        return response
    except Exception as error:
        raise error
