from fastapi import FastAPI
from payg import routes as payg_router
app = FastAPI()


app.include_router(payg_router)
# app.include_router()
