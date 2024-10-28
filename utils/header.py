from fastapi import APIRouter, Response



def successful_header(response:Response):
    response.headers["returnCode"] = "0"
    response.headers["returnMsg"] = "Successful" 
    return {
        "returnCode":"0",
        "returnMsg":"Successful"
    }
    
def unsuccessful_header(response:Response, responseCode="", responseMsg=""):
    # response.headers["returnCode"] = responseCode
    # response.headers["returnMsg"] = responseMsg
    return {
        "returnCode":responseCode,
        "returnMsg":responseMsg
    }