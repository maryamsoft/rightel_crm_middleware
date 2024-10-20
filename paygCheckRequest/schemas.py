from pydantic import BaseModel
from typing import List, Optional, Tuple

class PaygCheckRequest(BaseModel):
    subscriberNumber: int

class PaygCheckResponse(BaseModel):
    attributeStatus: str
    responseDesc: str
    subscriberNumber: str
    responseCode: str