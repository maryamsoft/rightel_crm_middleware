from pydantic import BaseModel
from typing import List, Optional, Tuple


class QuerySubscriberRGUsageRequest(BaseModel):
    msisdn: str
    opType: str
    modifiedAt: str
    modifiedBy: int
    sessionId: str


class QuerySubscriberRGUsageResponse(BaseModel):
    SUBSCRIBER_NUMBER: str
    ATTRIBUTE_STATUS: str
    RESPONSE_CODE: str