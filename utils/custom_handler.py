from fastapi import Request, HTTPException, Response
from fastapi.responses import JSONResponse
from utils import header

class CustomException(Exception):
    def __init__(self,status, detail: str):
        self.status = status
        self.detail = detail

async def custom_exception_handler(request: Request, exc: CustomException):
    return JSONResponse(
        status_code =200,
        content={"detail": f"{exc.detail}"},
        headers= header.unsuccessful_header(Response, exc.status, exc.detail)
    )