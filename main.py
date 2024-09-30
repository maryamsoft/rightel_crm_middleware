from fastapi import FastAPI
from orderPricePlan.routes import router as orderPricePlanRoutes
app = FastAPI()


app.include_router(orderPricePlanRoutes, prefix="/orderPricePlan", tags=["orderPricePlan"])

# app.include_router()
