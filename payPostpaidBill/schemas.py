from pydantic import BaseModel
from typing import List, Optional, Tuple

class PayPostpaidBillRequest(BaseModel):
    msisdn: str
    amount: str
    bankId: Optional[int]
    au: Optional[str]
    businessType: Optional[int]
    paymentMethod: Optional[int]
    paymentId: Optional[str]
    invoiceId: Optional[str]
    callerId: Optional[str]