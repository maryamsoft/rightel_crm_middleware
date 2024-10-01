from utils.soap_client import soap_client


def map_order_price_plan_to_change_sub_offering(data):
    req = {
        'PrimaryIdentity': '',
        'OfferingCode': '',
        'PurchaseSeq': '',
        'CN_CHANNEL_ID': '',
        'C_FREE_FIRSTMRC': '',
        'CN_PAY_FLAG': '',
        'CN_AU': '',
        'CN_FIRST_AMOUNT': '',
        'CN_BANK_ID': '',
        'CN_CALLER_ID': '',
        'Mode': '',
        'OperationCode': '',
    }


def call_cbs(data):
    response = soap_client.service.ChangeSubOffering(**data)
