from typing import Annotated
from pydantic import BaseModel
from utils.schemas import CommonHeaders


class queryAllBalanceRequest(CommonHeaders):
    MSISDN: str
    
#Response_Schema  
class queryAllBalanceResponse(BaseModel):
    AllBalanceDtoList: object

