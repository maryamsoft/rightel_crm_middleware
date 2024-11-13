from typing import Optional

from pydantic import BaseModel

class QueryPostpaidHotBillRequest(BaseModel):
    MSISDN: str


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
    PayableAmount





