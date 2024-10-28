from pydantic import BaseModel
from typing import List, Optional, Tuple, Dict


class Message(BaseModel):
    modifiedAt: str
    opType: str
    subscriberNumber: str
    modifiedBy: str

class PaygChangeRequest(BaseModel):
    mobileNum: str
    action: str
    sessionId: str
    message: Message

class PaygChangeResponse(BaseModel):
    pass