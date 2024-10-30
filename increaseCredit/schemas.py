from pydantic import BaseModel
from typing import List, Optional, Tuple, Annotated


class IncreaseCreditRequest(BaseModel):
    msisdn: str
    increaseValue: str
    bankId: int
    au: str
