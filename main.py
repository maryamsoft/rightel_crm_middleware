from fastapi import FastAPI
from orderPricePlan.routes import router as orderPricePlanRoutes
from recharge.routes import router as rechargesRoutes

app = FastAPI()


app.include_router(orderPricePlanRoutes, prefix="/cbs/wrapper/orderPricePlanOffer", tags=["orderPricePlan"])
app.include_router(rechargesRoutes, prefix="/cbs/wrapper/rechargeOffer", tags=["recharge"])


