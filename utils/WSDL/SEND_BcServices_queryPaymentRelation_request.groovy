dest.setServiceOperation("BMQueryService","queryPaymentRelation")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.querypamentrelation.io.QueryPaymentRelationRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.accoutCode = src.AccountCode
	
	dest.accoutKey = src.AccountKey
	
	dest.payType = src.PayType
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping1

listMapping1 = 
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

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.groupCode = src.SubGroupCode
	
	dest.groupKey = src.SubGroupKey
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.QueryPaymentRelationRequestMsg.QueryPaymentRelationRequest

def destMidVar = destArgs1.anyAccessCode

listMapping0.call(srcMidVar.PayAccount,destMidVar.acctAccessCode)

def srcMidVar0 = srcArgs0.QueryPaymentRelationRequestMsg.QueryPaymentRelationRequest.PaymentObj

listMapping1.call(srcMidVar0.CustAccessCode,destMidVar.custAccessCode)

listMapping2.call(srcMidVar0.SubAccessCode,destMidVar.subAccessCode)

listMapping3.call(srcMidVar0.SubGroupAccessCode,destMidVar.groupAccessCode)

def srcMidVar1 = srcArgs0.QueryPaymentRelationRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar1.AccessMode

def srcMidVar2 = srcArgs0.QueryPaymentRelationRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

destArgs0.password = srcMidVar2.Password

destArgs0.remoteAddress = srcMidVar2.RemoteIP

mappingList(srcMidVar1.AdditionalProperty,destArgs0.simpleProperty,listMapping4)

destArgs0.businessCode = srcMidVar1.BusinessCode

destArgs0.messageSeq = srcMidVar1.MessageSeq

destArgs0.msgLanguageCode = srcMidVar1.MsgLanguageCode

def srcMidVar3 = srcArgs0.QueryPaymentRelationRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar3.ChannelID

destArgs0.operatorId = srcMidVar3.OperatorID

def srcMidVar4 = srcArgs0.QueryPaymentRelationRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar4.BEID

destArgs0.brId = srcMidVar4.BRID

def srcMidVar5 = srcArgs0.QueryPaymentRelationRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar5.TimeType

destArgs0.timeZoneId = srcMidVar5.TimeZoneID

destArgs0.version = srcMidVar1.Version

destArgs1.queryPaymentLimitUsageFlag=srcMidVar.QueryCondition.QueryPaymentLimitUsageFlag
destArgs1.totalNumber = srcMidVar.TotalRowNum
destArgs1.beginRowNum = srcMidVar.BeginRowNum
destArgs1.fetchRowNum = srcMidVar.FetchRowNum