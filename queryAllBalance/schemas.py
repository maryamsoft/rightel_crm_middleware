from typing import Annotated
from pydantic import BaseModel
from pydantic import BaseModel


class queryAllBalanceRequest(BaseModel):
    msisdn: str
    
    
class queryAllBalanceResponse(BaseModel):
    OrderNbr: str

