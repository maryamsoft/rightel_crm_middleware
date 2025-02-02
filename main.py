import datetime
from fastapi import FastAPI, Request,Response, Header
from starlette.background import BackgroundTask
from utils.logservice import logger
from utils.logmodel import logmodel
from orderPricePlan.routes import router as orderPricePlanRoutes
from recharge.routes import router as rechargesRoutes
from queryPostpaidHotBill.routes import router as queryPostpaidHotBillRoutes
from queryPostPaidBill.routes import router as queryPostpaidBillRoutes
from payPostpaidBill.routes import router as payPostpaidBillRoutes
from checkCreditLimit.routes import router as checkCreditLimitRoutes
from increaseCredit.routes import router as increaseCreditRoutes
from querySubscriberRGUsage.routes import router as querySubscriberRGUsageRoutes
from paygCheckRequest.routes import router as paygCheckRequestRoutes
from queryAllBalance.routes import router as queryAllBalance
from paygChangeRequest.routes import router as paygChangeRequestRoutes
from utils.custom_handler import custom_exception_handler, CustomException
from recharge.schemas import CommonHeaders
from typing import Annotated
from utils import header
## include others
import json

app = FastAPI()
app.add_exception_handler(CustomException, custom_exception_handler)


@app.middleware('http')
async def router_middleware(request:Request, call_next):
    request_body = await request.body()
    try:
        request_json = json.loads(request_body)
        username = request.headers.get('username', None)
        password = request.headers.get('password', None)
        requestId = request.headers.get('requestId', None)
        if username and password: 
            request_json['username'] = username
            request_json['password'] = password
            request_json['requestId'] = requestId
        
        request._body = json.dumps(request_json).encode('utf-8')
    except  json.JSONDecodeError as e:
        pass
    
    logger.debug(logmodel(ServiceUrl=request.url,
                                   RequestHeader= request.headers,
                                   RequestBody=request._body,
                                   ResponsetHeader="",
                                   ResponseBody="",
                                   TimeSpan=0).JsonString())
    print('request:', request._body)
    return await call_next(request) 

app.include_router(orderPricePlanRoutes, prefix="/cbs/wrapper/orderPricePlanOffer", tags=["orderPricePlan"])
app.include_router(rechargesRoutes, prefix="/cbs/wrapper/recharge", tags=["recharge"])
app.include_router(queryPostpaidHotBillRoutes, prefix="/cbs/wrapper/queryPostpaidHotBill", tags=["queryPostpaidHotBill"])
app.include_router(queryPostpaidBillRoutes, prefix="/cbs/wrapper/queryPostpaidBill", tags=["queryPostpaidBill"])
app.include_router(payPostpaidBillRoutes, prefix="/cbs/wrapper/payPostpaidBill", tags=["payPostpaidBill"])
app.include_router(checkCreditLimitRoutes, prefix="/cbs/wrapper/checkCreditLimit", tags=["checkCreditLimit"])
app.include_router(increaseCreditRoutes, prefix="/cbs/wrapper/increaseCredit", tags=["increaseCredit"])
app.include_router(querySubscriberRGUsageRoutes, prefix="/cbs/wrapper/querySubscriberRGUsage", tags=["querySubscriberRGUsage"])
app.include_router(paygCheckRequestRoutes, prefix="/CM/paygCheckRequest", tags=["paygCheckRequest"])
app.include_router(paygChangeRequestRoutes, prefix="/CM/paygChangeRequest", tags=["paygChangeRequest"])
app.include_router(queryAllBalance, prefix="/cbs/wrapper/queryAllBalance", tags=["queryAllBalance"])

