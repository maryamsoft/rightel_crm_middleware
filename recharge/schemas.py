from pydantic import BaseModel
from typing import List, Optional, Tuple

class RechargeRequest(BaseModel):
    MSISDN: str
    Amount: str
    BankId: Optional[int] = None
    AU: Optional[str] = None
    PaymentType: Optional[str] = "1"
    FaceValueDtoList: Optional[List[Tuple[int, int]]] = None
    CallerID: Optional[str] = None
    PaymentMethod: Optional[int] = 1
    VoucherType: Optional[str] = None
    Location: Optional[str] = None
    SerialNumber: Optional[str] = None
