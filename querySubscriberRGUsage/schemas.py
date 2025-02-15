from pydantic import BaseModel
from typing import List, Optional, Tuple
from utils.schemas import CommonHeaders

class QuerySubscriberRGUsageRequest(CommonHeaders):
    msisdn: str


#Response_Schema
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
    

