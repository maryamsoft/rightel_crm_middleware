from pydantic import BaseModel
from typing import List, Optional, Tuple


class PaygCheckRequest(BaseModel):
    # MSISDN: str
    # mobileNum: str
    # action: str
    # sessionId: str
    subscriberNumber: str
    opType: str
    modifiedAt: str
    modifiedBy: int
    sessionId: str

class PaygCheckResponse(BaseModel):
    attributeStatus: str
    responseDesc: str
    subscriberNumber: str
    responseCode: str