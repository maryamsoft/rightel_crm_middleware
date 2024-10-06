from fastapi import APIRouter
from .handlers import  ChangeRecharge, generate_response
from .schemas import RechargeRequest


router = APIRouter()

@router.post('/')
async def orderPricePlanOffer(request: RechargeRequest):
    try:
        CBS_response = ChangeRecharge(request)
        result = generate_response(CBS_response)
        response =  {
            'OrderNbr':result
        }
        return response
    except Exception as error:
        raise error
