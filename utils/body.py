from datetime import datetime

def create_standard_msisdn(msisdn):
    #Making a ten-digit msisdn 
    MSISDN = int(msisdn)
    if MSISDN > 10 :
        if str(MSISDN).startswith("98"):
            return  str(MSISDN)[2:]
        elif str(MSISDN).startswith("0"):
           return str(MSISDN)[1:]