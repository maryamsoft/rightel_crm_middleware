from fastapi import Request, HTTPException, Response
from fastapi.responses import JSONResponse
from utils import header
from datetime import datetime
import pytz

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
    
def convert_uts_to_asia_tehran(utcDateTime=None):
    if utcDateTime==None:
        utcDateTime = datetime.now().strftime('%Y-%m-%dT%H:%M:%S.000Z')
    utc = datetime.strptime(utcDateTime, '%Y-%m-%dT%H:%M:%S.000Z').replace(tzinfo=pytz.UTC)
    currentDateTime = utc.astimezone(pytz.timezone('Asia/Tehran'))
    return currentDateTime