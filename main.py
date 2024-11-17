import datetime
from fastapi import FastAPI, Request,Response
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


app = FastAPI()
def log_info(model:logmodel):
    logger.debug(model)

@app.middleware("http")
async def log_middle(request: Request, call_next):
    req_time = datetime.datetime.now()
    req_body = await request.body()
    response = await call_next(request)
    res_body = b''
    if hasattr(response, "body"):
            res_body = response.body
    elif hasattr(response, "body_iterator"):
        async for chunk in response.body_iterator:
            res_body += chunk
    difference = datetime.datetime.now() - req_time
    mylogmodel=logmodel(ServiceUrl=request.url,
                                   RequestHeader=request.headers,
                                   RequestBody=req_body,
                                   ResponsetHeader=response.headers,
                                   ResponseBody=res_body,
                                   TimeSpan=difference.microseconds).JsonString()
    task = BackgroundTask(log_info, mylogmodel)
    return Response(content=res_body, status_code=response.status_code, 
        headers=dict(response.headers), media_type=response.media_type, background=task)


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

