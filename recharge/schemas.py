from pydantic import BaseModel
from typing import List, Optional, Tuple

class RechargeRequest(BaseModel):
    msisdn: str
    amount: str
    bankId: Optional[int] = None
    au: Optional[str] = None
    paymentType: Optional[str] = "1"
    faceValueDtoList: Optional[List[dict]] = None
    callerID: Optional[str] = None
    paymentMethod: Optional[int] = 1
    voucherType: Optional[str] = None
    location: Optional[str] = None
    serialNumber: Optional[str] = None
