from typing import Optional

from pydantic import BaseModel

class QueryPostpaidHotBillRequest(BaseModel):
    MSISDN: str


class QueryPostpaidHotBillResponse(BaseModel):
    PayableAmount: float
    InvoiceID: str
    PaymentID: str
    Subscription: Optional[float]
    AddSubscription: Optional[float]
    TotalAmout: Optional[float]
    Tax: Optional[float]
    OutStanding: Optional[float]
    BillingCycleStartDate: str
    EndDate: str
