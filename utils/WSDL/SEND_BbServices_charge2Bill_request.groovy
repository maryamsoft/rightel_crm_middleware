dest.setServiceOperation("AccountService","charge2Bill")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.account.chargetobill.io.Charge2BillRequest"

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.interMode = src.AccessMode
	
	def srcMidVar0 = src.AccessSecurity
	
	dest.loginSystem = srcMidVar0.LoginSystemCode
	
	dest.password = srcMidVar0.Password
	
	dest.remoteAddress = srcMidVar0.RemoteIP
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	dest.businessCode = src.BusinessCode
	
	dest.messageSeq = src.MessageSeq
	
	dest.msgLanguageCode = src.MsgLanguageCode
	
	def srcMidVar1 = src.OperatorInfo
	
	dest.channelId = srcMidVar1.ChannelID
	
	dest.operatorId = srcMidVar1.OperatorID
	
	def srcMidVar2 = src.OwnershipInfo
	
	dest.beId = srcMidVar2.BEID
	
	dest.brId = srcMidVar2.BRID
	
	dest.version = src.Version
	
	def srcMidVar3 = src.TimeFormat
	
	dest.timeType = srcMidVar3.TimeType
	
	dest.timeZoneId = srcMidVar3.TimeZoneID
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.accoutCode = src.AccountCode
	
	dest.accoutKey = src.AccountKey
	
	dest.payType = src.PayType
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.groupCode = src.SubGroupCode
	
	dest.groupKey = src.SubGroupKey
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.taxAmt = src.TaxAmount
	
	dest.taxCode = src.TaxCode
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.additionalInfo = src.AdditionalInfo
	
	mappingList(src.AdditionalProperty,dest.simplePropertyList,listMapping8)
	
	dest.chargeAmt = src.ChargeAmt
	
	dest.chargeCode = src.ChargeCode
	
	dest.chargeSeq = src.ChargeSeq
	
	dest.currencyId = src.CurrencyID
	
	dest.discountAmt = src.DiscountAmt
	
	dest.invoiceTime = src.InvoiceTime
	
	dest.salesTime = src.SalesTime
	
	dest.waiveAmt = src.WaiveAmt
	
	mappingList(src.Tax,dest.taxList,listMapping9)
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.customerCode = src.CustomerCode
	
	dest.customerKey = src.CustomerKey
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	listMapping3.call(src.AcctAccessCode,dest.acctAccessCode)
	
	dest.charge2BillSerialNo = src.Charge2BillSerialNo
	
	listMapping4.call(src.SubAccessCode,dest.subAccessCode)
	
	listMapping5.call(src.SubGroupAccessCode,dest.subGroupAccessCode)
	
	listMapping10.call(src.CustAccessCode,dest.custAccessCode)
	
	mappingList(src.ChargeItemList,dest.chargeItemList,listMapping6)
	
	mappingList(src.AdditionalProperty,dest.simplePropertyList,listMapping7)
	
}

def srcMidVar = srcArgs0.Charge2BillRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.Charge2BillRequest,destArgs1)
