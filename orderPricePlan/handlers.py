from lxml import etree
from zeep import Client
from datetime import datetime

def separationDoServiceOrderPricePlan(request_body):
    response = generate_order_price_plan_CBS_Request()
    response = None
    # generate_response(response)
    return True


def generate_order_price_plan_CBS_Request():
    client = Client('/opt/projects/fastapi/crm_middleware/utils/WSDL/CBSInterface_BC_Services.wsdl')
    ##chatgpt###
    # Create the ChangeSubOfferingRequest
    
    # request = {
    #     'RequestHeader': {
    #         'Version': '1.0',  # Example Version
    #         'TransactionID': 'TRANS123456',  # Example Transaction ID
    #         'Timestamp': '2023-10-01T00:00:00Z' , # Example Timestamp in ISO 8601 format
    #         },
        
    #     'ChangeSubOfferingRequest': {
    #         'SubAccessCode': 'SUB123456',  # Example Sub Access Code
    #         'PrimaryOffering': {
    #             'OldPrimaryOffering': {
    #                 'OInstProperty': [
    #                     {'PropertyName': 'OldProperty1', 'PropertyValue': 'Value1'},
    #                     {'PropertyName': 'OldProperty2', 'PropertyValue': 'Value2'}
    #                 ]
    #             },
    #             'NewPrimaryOffering': {
    #                 'OfferingID': 'NEW_OFFER_001',  # Example Offering ID
    #                 'OfferingName': 'New Offering Name'
    #             },
    #             'NewBrand': 'NewBrandName',
    #             'EffectiveTime': '2023-10-01T00:00:00Z'  # Example Effective Time in ISO 8601 format
    #         },
    #         'SupplementaryOffering': {
    #             'AddOffering': [
    #                 {
    #                     'EffectiveTime': '2023-10-01T00:00:00Z',
    #                     'ExpirationTime': '2024-10-01T00:00:00Z',
    #                     'ActivationTime': '2023-10-01T00:00:00Z'
    #                 }
    #             ],
    #             'DelOffering': [
    #                 {
    #                     'OfferingKey': 'DEL_OFFER_001',
    #                     'AdditionalProperty': [
    #                         {'PropertyName': 'C_DELOFFER_REMOVEROURCE', 'PropertyValue': '1'}
    #                     ],
    #                     'OInstProperty': [
    #                         {
    #                             'EffectiveTime': '2023-10-01T00:00:00Z',
    #                             'ExpirationTime': '2024-10-01T00:00:00Z'
    #                         }
    #                     ],
    #                     'ExpirationTime': '2024-10-01T00:00:00Z'
    #                 }
    #             ],
    #             'ModifyOffering': [
    #                 {
    #                     'OfferingKey': 'MOD_OFFER_001',
    #                     'NewEffectiveTime': '2023-10-01T00:00:00Z',
    #                     'NewExpirationTime': '2024-10-01T00:00:00Z',
    #                     'ExtendOfferingHours': 24,
    #                     'NewPurchaseSeq': 'PURCHASE_SEQ_001'
    #                 }
    #             ]
    #         },
    #         'HandlingChargeFlag': 'Y',
    #         'ServiceTransactionID': 'SERVICE_TRANS_001',
    #         'OperationCode': 'OP123',
    #         'AdditionalProperty': [
    #             {'PropertyName': 'ExtraProperty1', 'PropertyValue': 'ExtraValue1'}
    #         ],
    #         'DeductInfo': [
    #             {
    #                 'ChargeCode': 'CHARGE001',
    #                 'SalesTime': '2023-10-01T00:00:00Z',
    #                 'InvoiceTime': '2023-10-01T00:00:00Z',
    #                 'ChargeAmt': 1000,
    #                 'DiscountAmt': 100,
    #                 'WaiveAmt': 50,
    #                 'CurrencyID': 1,
    #                 'Tax': [
    #                     {'TaxType': 'VAT', 'TaxAmount': 50}
    #                 ],
    #                 'AdditionalInfo': 'Additional info here',
    #                 'AdditionalProperty': [
    #                     {'PropertyName': 'TaxProperty', 'PropertyValue': 'TaxValue'}
    #                 ]
    #             }
    #         ],
    #         'SalesInfo': {
    #             'SalesID': 'SALES123',
    #             'SalesAmount': 950
    #         },
    #         'NewPOPurchaseSeq': 'NEW_PO_SEQ_001'
    #     }
    # }

    # # Make the request
    # try:
    #     response = client.service.ChangeSubOffering(request)
    #     print(response)
    # except Exception as e:
    #     print(f"Error: {e}")
       
    
def generate_request(data):
    C_FREE_PAY_FLAG = 0 if data.payFlag==1 else 1
    data.msisdn=9235000018
    request = f'''
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bcs="http://www.huawei.com/bme/cbsinterface/bcservices" xmlns:cbs="http://www.huawei.com/bme/cbsinterface/cbscommon" xmlns:bcc="http://www.huawei.com/bme/cbsinterface/bccommon">
        <soapenv:Header/>
        <soapenv:Body>
            <bcs:ChangeSubOfferingRequestMsg>
                <RequestHeader>
                    <cbs:Version>1</cbs:Version>
                    <cbs:BusinessCode>ChangeSubOffering</cbs:BusinessCode>
                    <cbs:MessageSeq>{datetime.now()}</cbs:MessageSeq>
                    <cbs:AccessSecurity>
                    <cbs:LoginSystemCode>102</cbs:LoginSystemCode>
                    <cbs:Password>7/PuyYwNpRtSX7jDpxnl2ECAvuVYH2Mu9zxqgPGJrPYYK73MCZN7DvrDepA=</cbs:Password>
                    </cbs:AccessSecurity>
                    <cbs:OperatorInfo>
                    <cbs:OperatorID>101</cbs:OperatorID>
                    </cbs:OperatorInfo>
                </RequestHeader>
                <ChangeSubOfferingRequest>
                    <bcs:SubAccessCode>
                    <bcc:PrimaryIdentity>{data.msisdn}</bcc:PrimaryIdentity>
                    </bcs:SubAccessCode>
                    <bcs:SupplementaryOffering>
                    <bcs:AddOffering>
                        <bcc:OfferingKey>
                            <bcc:OfferingCode>sms_rate_language</bcc:OfferingCode>
                            <bcc:PurchaseSeq>{data.offerCode}</bcc:PurchaseSeq>
                        </bcc:OfferingKey>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_CHANNEL_ID</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.channelId}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>C_FREE_FIRSTMRC</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{C_FREE_PAY_FLAG}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_PAY_FLAG</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.payFlag}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_AU</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.au}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_FIRST_AMOUNT</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.amount}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_BANK_ID</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.bankId}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_CALLER_ID</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.CallerID}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcs:EffectiveTime>
                            <bcc:Mode>I</bcc:Mode>
                        </bcs:EffectiveTime>
                    </bcs:AddOffering>
                    </bcs:SupplementaryOffering>
                    <bcs:OperationCode>4052485</bcs:OperationCode>
                </ChangeSubOfferingRequest>
            </bcs:ChangeSubOfferingRequestMsg>
        </soapenv:Body>
        </soapenv:Envelope>'''
    
    print(request)
        
        
def generate_response(cbs_response=None) :
    cbs_response= open('/opt/projects/fastapi/crm_middleware/orderPricePlan/templates/responses/ChangeSubOffering.txt', 'r')
    xml_root:etree = etree.fromstring(cbs_response.read())
    print('root:', xml_root)
    nsp_body ={'soapenv':'http://schemas.xmlsoap.org/soap/envelope/'}
    Body = xml_root.find('soapenv:Body', nsp_body)
    ch_body = Body.getchildren()[0]
    result =  Body.find(f'.//{{{ch_body.nsmap["bcc"]}}}OfferingID')
    offeringId = result.text
    print('result:', offeringId)
    
    