from fastapi import APIRouter, Response



def successful_header(response:Response):
    
    response.headers["returnCode"] = "0"
    response.headers["returnMsg"] = "Successful" 