from pydantic import BaseModel
from typing import List, Optional, Tuple
from utils.schemas import CommonHeaders

class PayPostpaidBillRequest(CommonHeaders):
    msisdn: str
    amount: str
    bankId: Optional[int]
    au: Optional[str]
    businessType: Optional[int]
    paymentMethod: Optional[int]
    paymentId: Optional[str]
    invoiceId: Optional[str]
    CallerId: Optional[str]
    CN_ChannelId: Optional[str]