from pydantic import BaseModel
from typing import List, Optional, Tuple, Annotated
from utils.schemas import CommonHeaders

class IncreaseCreditRequest(CommonHeaders):
    msisdn: str
    increaseValue: str
    paymentMethod: int
    bankId: int
    au: str
