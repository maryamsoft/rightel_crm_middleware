from pydantic import BaseModel
from typing import List, Optional, Tuple


class IncreaseCreditRequest(BaseModel):
    msisdn: str
    increaseValue: str
    bankId: int
    au: str


    