from fastapi import FastAPI
from orderPricePlan.routes import router as orderPricePlanRoutes
from recharge.routes import router as rechargesRoutes
from queryPostpaidHotBill.routes import router as queryPostpaidHotBillRoutes
from queryPostPaidBill.routes import router as queryPostpaidBillRoutes
from payPostpaidBill.routes import router as payPostpaidBillRoutes
from checkCreditLimit.routes import router as checkCreditLimitRoutes
from increaseCredit.routes import router as increaseCreditRoutes
from querySubscriberRGUsage.routes import router as querySubscriberRGUsageRoutes
from paygCheckRequest.routes import router as paygCheckRequestRoutes


app = FastAPI()


app.include_router(orderPricePlanRoutes, prefix="/cbs/wrapper/orderPricePlanOffer", tags=["orderPricePlan"])
app.include_router(rechargesRoutes, prefix="/cbs/wrapper/recharge", tags=["recharge"])
app.include_router(queryPostpaidHotBillRoutes, prefix="/cbs/wrapper/queryPostpaidHotBill", tags=["queryPostpaidHotBill"])
app.include_router(queryPostpaidBillRoutes, prefix="/cbs/wrapper/queryPostpaidBill", tags=["queryPostpaidBill"])
app.include_router(payPostpaidBillRoutes, prefix="/cbs/wrapper/payPostpaidBill", tags=["payPostpaidBill"])
app.include_router(checkCreditLimitRoutes, prefix="/cbs/wrapper/checkCreditLimit", tags=["checkCreditLimit"])
app.include_router(increaseCreditRoutes, prefix="/cbs/wrapper/increaseCredit", tags=["increaseCredit"])
app.include_router(querySubscriberRGUsageRoutes, prefix="/cbs/wrapper/querySubscriberRGUsage", tags=["querySubscriberRGUsage"])
app.include_router(querySubscriberRGUsageRoutes, prefix="/cbs/wrapper/querySubscriberRGUsage", tags=["querySubscriberRGUsage"])
app.include_router(paygCheckRequestRoutes, prefix="/cbs/wrapper/paygCheckRequest", tags=["paygCheckRequest"])

