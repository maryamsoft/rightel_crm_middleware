from lxml import etree
from zeep import Client

def separationDoServiceOrderPricePlan(request_body):
    # xml_root:etree = etree.fromstring(request_body)
    # nsp_body = xml_root.nsmap['ocs']
    # in0 = xml_root.find(f'.//{{{nsp_body}}}in0')
    # tmp = in0.text.split("<MSISDN>")[1]
    # MSISDN = tmp.split("</MSISDN>")[0]
    # tmp = in0.text.split("<ChannelID>")[1]
    # ChannelID = tmp.split("</ChannelID>")[0]
    # tmp = in0.text.split("<OfferCode>")[1]
    # OfferCode = tmp.split("</OfferCode>")[0]
    # tmp = in0.text.split("<AU>")[1]
    # AU = tmp.split("</AU>")[0]
    # tmp = in0.text.split("<Amount>")[1]
    # Amount = tmp.split("</Amount>")[0]
    # tmp = in0.text.split("<PayFlag>")[1]
    # PayFlag = tmp.split("</PayFlag>")[0]
    # tmp = in0.text.split("<BankID>")[1]
    # BankID = tmp.split("</BankID>")[0]
    # tmp = in0.text.split("<DiscountFee>")[1]
    # DiscountFee = tmp.split("</DiscountFee>")[0]

    # print(DiscountFee, MSISDN ,ChannelID ,OfferCode ,AU ,Amount ,PayFlag ,BankID)
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
    
    # Load the XSD schema
    
# Create the factory for your 'ChangeSubOfferingRequest'

    client = Client('/opt/projects/fastapi/crm_middleware/utils/WSDL/CBSInterface_BC_Services.wsdl')
    change_sub_offering_request = client.get_type('ns0:ChangeSubOfferingRequest')

    # Create the request payload
    request_data = change_sub_offering_request(
        SubAccessCode={'PrimaryIdentity': 'sub123'},
        PrimaryOffering={
            'OldPrimaryOffering': {
                # 'OfferingKey': {
                #     'OfferingID': '12345',
                #     'OfferingInstanceID': '54321'
                # },
                'OInstProperty': [
                    {'PropCode':'Prop1','PropType':'Type1', 'Value': 'Value1'}
                ]
            },
            'NewPrimaryOffering': {
                # 'OfferingKey': {
                #     'OfferingID': '67890',
                #     'OfferingInstanceID': '09876'
                # }
            },
            'EffectiveTime': {'Mode': 'Immediate'}
        },
        SupplementaryOffering={
            'AddOffering': [
                {
                    'OfferingKey': {
                        'OfferingCode': '23456',
                        'PurchaseSeq': '65432'
                    },
                    'EffectiveTime': {'Mode': 'Immediate'}
                }
            ],
            'DelOffering': [
                {
                    'OfferingKey': {
                        'OfferingID': '23457',
                        # 'OfferingInstanceID': '65433'
                    },
                    # 'AdditionalProperty': [
                    #     {'PropertyID': 'C_DELOFFER_REMOVEROURCE', 'PropertyValue': '1'}
                    # ]
                }
            ]
        },
        HandlingChargeFlag='Yes',
        ServiceTransactionID='TX12345'
    )

    # Send the request (replace with actual service URL)
    response = client.service.ChangeSubOffering(request_data)

    # Print the response
    print(response)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
        
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
    
    