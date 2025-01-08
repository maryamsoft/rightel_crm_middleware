from pydantic import BaseModel
from typing import List, Optional, Tuple

class CheckCreditLimitRequest(BaseModel):
    MSISDN: str

class CheckCreditLimitResponse(BaseModel):
    Balance: Optional[int]
    CreditLimit: int
    DefaultCL: int
    NonDefaultCl: Optional[int]
    CreditUsed: int
    CreditAvailable: int
    IncreaseLimit: int
    MaximumDepositAmount: int
    CurrentDepositAmount: int
    RemainDepositAmount: int
    