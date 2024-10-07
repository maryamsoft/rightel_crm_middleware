from fastapi import FastAPI
from orderPricePlan.routes import router as orderPricePlanRoutes
from recharge.routes import router as rechargesRoutes
from queryPostpaidHotBill.routes import router as queryPostpaidHotBillRoutes
from payPostpaidHotBill.routes import router as payPostpaidHotBillRoutes

app = FastAPI()


app.include_router(orderPricePlanRoutes, prefix="/cbs/wrapper/orderPricePlanOffer", tags=["orderPricePlan"])
app.include_router(rechargesRoutes, prefix="/cbs/wrapper/recharge", tags=["recharge"])
app.include_router(queryPostpaidHotBillRoutes, prefix="/cbs/wrapper/queryPostpaidHotBill", tags=["queryPostpaidHotBill"])
app.include_router(payPostpaidHotBillRoutes, prefix="/cbs/wrapper/payPostpaidHotBill", tags=["payPostpaidHotBill"])
