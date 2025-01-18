from pydantic import BaseModel

class CommonHeaders(BaseModel):
    requestId : str|None = None
    username : str|None = 102
    password : str|None = '7/PuyYwNpRtSX7jDpxnl2ECAvuVYH2Mu9zxqgPGJrPYYK73MCZN7DvrDepA='