from pydantic import BaseModel
from typing import List, Optional, Tuple, Dict
from utils.schemas import CommonHeaders

class Message(BaseModel):
    modifiedAt: str
    opType: str
    subscriberNumber: str
    modifiedBy: str

class PaygChangeRequest(CommonHeaders):
    subscriberNumber: int
    opType: str
    modifiedAt: str
    modifiedBy: int

#Response_Schema
class PaygChangeResponse(BaseModel):
    attributeStatus: str
    responseDesc: str
    subscriberNumber: str
    responseCode: str