from pydantic import BaseModel
from typing import List, Optional, Tuple
from utils.schemas import CommonHeaders

class PaygCheckRequest(CommonHeaders):
    subscriberNumber: int
    opType: str
    modifiedAt: str
    modifiedBy: int
    
    
#Response_Schema
class PaygCheckResponse(BaseModel):
    attributeStatus: str
    responseDesc: str
    subscriberNumber: str
    responseCode: str