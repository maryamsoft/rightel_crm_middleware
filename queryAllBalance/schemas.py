from typing import Annotated
from pydantic import BaseModel
from pydantic import BaseModel


class queryAllBalanceRequest(BaseModel):
    MSISDN: str
    
    
class queryAllBalanceResponse(BaseModel):
    AllBalanceDtoList: object

