from pydantic import BaseModel
from typing import List, Optional, Tuple, Dict


class PaygChangeRequest(BaseModel):
    subscriberNumber: int
    opType: str
    modifiedAt: str
    modifiedBy: int

class PaygChangeResponse(BaseModel):
    attributeStatus: str
    responseDesc: str
    subscriberNumber: str
    responseCode: str