from pydantic import BaseModel
from typing import List, Optional, Tuple


class IncreaseCreditRequest(BaseModel):
    MSISDN: str
    IncreaseValue: str
    BankId: int
    AU: str


class IncreaseCreditResponse(BaseModel):
    Balance: int
    