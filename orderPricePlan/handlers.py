from lxml import etree
from zeep import Client

def separationDoServiceOrderPricePlan(request_body):
    xml_root:etree = etree.fromstring(request_body)
    nsp_body = xml_root.nsmap['ocs']
    in0 = xml_root.find(f'.//{{{nsp_body}}}in0')
    tmp = in0.text.split("<MSISDN>")[1]
    MSISDN = tmp.split("</MSISDN>")[0]
    tmp = in0.text.split("<ChannelID>")[1]
    ChannelID = tmp.split("</ChannelID>")[0]
    tmp = in0.text.split("<OfferCode>")[1]
    OfferCode = tmp.split("</OfferCode>")[0]
    tmp = in0.text.split("<AU>")[1]
    AU = tmp.split("</AU>")[0]
    tmp = in0.text.split("<Amount>")[1]
    Amount = tmp.split("</Amount>")[0]
    tmp = in0.text.split("<PayFlag>")[1]
    PayFlag = tmp.split("</PayFlag>")[0]
    tmp = in0.text.split("<BankID>")[1]
    BankID = tmp.split("</BankID>")[0]
    tmp = in0.text.split("<DiscountFee>")[1]
    DiscountFee = tmp.split("</DiscountFee>")[0]

    print(DiscountFee, MSISDN ,ChannelID ,OfferCode ,AU ,Amount ,PayFlag ,BankID)
    generate_order_price_plan_CBS_Request()
    return True


def generate_order_price_plan_CBS_Request():
    # client = Client('/opt/projects/fastapi/crm_middleware/WSDL/ChangeSubOffering.xml')
    # client = Client('/opt/projects/fastapi/crm_middleware/utils/WSDL/CBSInterface_BC_Services.wsdl')
    # client = Client('http://172.22.26.40:8080/services/BcServices')
    # result = client.service.ChangeSubOffering(OperatorID=101)
    # print(result)
    # assert result == 62.137
    
    request_to_CBS = True
    cbs_response= open('/opt/projects/fastapi/crm_middleware/orderPricePlan/templates/responses/ChangeSubOffering.txt', 'r')
    # print('read:', cbs_response.read())
    xml_root:etree = etree.fromstring(cbs_response.read())
    print('root:', xml_root)
    nsp_body ={'soapenv':'http://schemas.xmlsoap.org/soap/envelope/'}
    body = xml_root.find('soapenv:Body', nsp_body)
    print('body:', body.), 
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
    
    
    