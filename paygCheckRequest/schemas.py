from pydantic import BaseModel
from typing import List, Optional, Tuple


class PaygCheckRequest(BaseModel):
    subscriberNumber: int
    opType: str
    modifiedAt: str
    modifiedBy: int

class PaygCheckResponse(BaseModel):
    attributeStatus: str
    responseDesc: str
    subscriberNumber: str
    responseCode: str