from pydantic import BaseModel
from typing import List, Optional, Tuple


class QuerySubscriberRGUsageRequest(BaseModel):
    msisdn: str

class UsageRGList(BaseModel):
    rgCode: str
    usedAmount: str

class OfferUsageList(BaseModel):
    offerName: str
    offerCode: str
    purchaseId: str
    usageRGList: List[UsageRGList]


class QuerySubscriberRGUsageResponse(BaseModel):
    offerUsageList: List[OfferUsageList]
    responseCode: str
    responseDesc: str
    

