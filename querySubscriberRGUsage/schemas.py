from pydantic import BaseModel
from typing import List, Optional, Tuple


class QuerySubscriberRGUsageRequest(BaseModel):
    msisdn: str

class UsageRGList(BaseModel):
    rgCode: str
    usedAmount: str
    calculatedAmount: str

class OfferUsageList(BaseModel):
    offerName: str|None=None
    offerCode: str|None=None
    purchaseId: str|None=None
    usageRGList: List[UsageRGList]


class QuerySubscriberRGUsageResponse(BaseModel):
    offerUsageList: List[OfferUsageList]
    responseCode: str
    responseDesc: str
    

