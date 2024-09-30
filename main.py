from fastapi import FastAPI
from orderPricePlan import routes as orderPricePlan_router
app = FastAPI()


app.include_router(orderPricePlan_router.router)
