dest.setServiceOperation("AccountService","feeDeduction")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.account.feededuction.io.FeeDeductionRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.taxCode = src.TaxCode
	
	dest.taxAmt = src.TaxAmount
	
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.chargeAmt = src.ChargeAmt
	
	dest.chargeCode = src.ChargeCode
	
	dest.chargeSeq = src.ChargeSeq
	
	dest.currencyId = src.CurrencyID
	
	dest.discountAmt = src.DiscountAmt
	
	dest.invoiceTime = src.InvoiceTime
	
	dest.salesTime = src.SalesTime
	
	dest.waiveAmt = src.WaiveAmt
	
	dest.additionalInfo = src.AdditionalInfo
	
	mappingList(src.AdditionalProperty,dest.simplePropertyList,listMapping2)
	
	mappingList(src.Tax,dest.taxInfoList,listMapping3)
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.payType = src.PayType
	
	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.accoutCode = src.AccountCode
	
	dest.accoutKey = src.AccountKey
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.customerCode = src.CustomerCode
	
	dest.customerKey = src.CustomerKey
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.groupCode = src.SubGroupCode
	
	dest.groupKey = src.SubGroupKey
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.operationCode = src.OperationCode
	
	mappingList(src.OperationProperty,dest.operationProperty,listMapping9)
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.FeeDeductionRequestMsg.FeeDeductionRequest

mappingList(srcMidVar.AdditionalProperty,destArgs1.simplePropertyList,listMapping0)

mappingList(srcMidVar.DeductInfo,destArgs1.deductInfoList,listMapping1)

def srcMidVar0 = srcArgs0.FeeDeductionRequestMsg.FeeDeductionRequest.DeductObj

listMapping4.call(srcMidVar0.AcctAccessCode,destArgs1.acctAccessCode)

listMapping5.call(srcMidVar0.CustAccessCode,destArgs1.custAccessCode)

listMapping6.call(srcMidVar0.SubAccessCode,destArgs1.subAccessCode)

listMapping7.call(srcMidVar0.SubGroupAccessCode,destArgs1.groupAccessCode)

listMapping8.call(srcMidVar.OperationInfo,destArgs1.operationInfo)

destArgs1.deductSerialNo = srcMidVar.DeductSerialNo

def destFeeReservationSupport = destArgs1.feeReservationSupport

destFeeReservationSupport.serviceTransactionId = srcMidVar.ServiceTransactionID

def srcMidVar1 = srcArgs0.FeeDeductionRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar1.AccessMode

def srcMidVar2 = srcArgs0.FeeDeductionRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

destArgs0.password = srcMidVar2.Password

destArgs0.remoteAddress = srcMidVar2.RemoteIP

mappingList(srcMidVar1.AdditionalProperty,destArgs0.simpleProperty,listMapping10)

destArgs0.businessCode = srcMidVar1.BusinessCode

destArgs0.messageSeq = srcMidVar1.MessageSeq

destArgs0.msgLanguageCode = srcMidVar1.MsgLanguageCode

def srcMidVar3 = srcArgs0.FeeDeductionRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar3.ChannelID

destArgs0.operatorId = srcMidVar3.OperatorID

def srcMidVar4 = srcArgs0.FeeDeductionRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar4.BEID

destArgs0.brId = srcMidVar4.BRID

def srcMidVar5 = srcArgs0.FeeDeductionRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar5.TimeType

destArgs0.timeZoneId = srcMidVar5.TimeZoneID

destArgs0.version = srcMidVar1.Version
