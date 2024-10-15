from pydantic import BaseModel
from typing import List, Optional, Tuple

class PayPostpaidHotBillRequest(BaseModel):
    MSISDN: str
    Amount: str
    BankId: Optional[int]
    AU: Optional[str]
    BusinessType: Optional[int]
    PaymentMethod: Optional[int]
    PaymentId: Optional[str]
    InvoiceId: Optional[str]
    CallerID: Optional[str]