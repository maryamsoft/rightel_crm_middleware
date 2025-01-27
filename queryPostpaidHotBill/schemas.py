from typing import Optional
from utils.schemas import CommonHeaders
from pydantic import BaseModel

class QueryPostpaidHotBillRequest(CommonHeaders):
    MSISDN: str

#Response_Schema
class QueryPostpaidHotBillResponse(BaseModel):
    PayableAmount: float
    InvoiceId: str
    PaymentId: str
    Subscription: Optional[float]
    AddSubscription: Optional[float]
    TotalAmout: Optional[float]
    Tax: Optional[float]
    OUTSTANDING: Optional[float]
    BillingCycleStartDate: str
    EndDate: str





