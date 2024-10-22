from fastapi import APIRouter, Response



def successful_header(response:Response):
    
    response.headers["returnCode"] = "0"
    response.headers["returnMsg"] = "Successful" 
    
def unsuccessful_header(response:Response, responseCode="", responseMsg=""):
    response.headers["returnCode"] = responseCode
    response.headers["returnMsg"] = responseMsg