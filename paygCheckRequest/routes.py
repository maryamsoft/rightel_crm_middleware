from fastapi import APIRouter, Response
from .handlers import generate_response, payg_check_request
from .schemas import PaygCheckRequest, PaygCheckResponse
from fastapi.responses import JSONResponse
from utils import header
from utils.logmodel import CMLog
from utils.logservice import logger
from datetime import datetime

        
router = APIRouter()

@router.post('', response_model=PaygCheckResponse)
async def paygCheckRequest(request:PaygCheckRequest, response: Response):
    try:
        CM_request_time =  datetime.now()
        xml_response = payg_check_request(request)
        result = generate_response(xml_response)
        CM_response_time =  datetime.now()
        difference=CM_response_time- CM_request_time
        logger.debug(CMLog(method = 'orderPricePlanOffer', ResponseBody=result, CM_difference = difference).JsonString())
        return result
        return JSONResponse(content= {
                'OrderNbr':None
            })
    except Exception as error:
        raise error
