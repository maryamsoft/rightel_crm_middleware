dest.setServiceOperation("BMQueryService","queryAccumulationUsage")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.queryaccumulationusage.io.QueryAccumulationUsageRequest"

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

	dest.accoutCode = src.AccountCode
	
	dest.accoutKey = src.AccountKey
	
	dest.payType = src.PayType
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.customerCode = src.CustomerCode
	
	dest.customerKey = src.CustomerKey
	
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

def listMapping1

listMapping1 = 
{
    src,dest  ->

	listMapping2.call(src.AcctAccessCode,dest.acctAccessCode)
	
	listMapping3.call(src.CustAccessCode,dest.custAccessCode)
	
	listMapping4.call(src.SubAccessCode,dest.subAccessCode)
	
	listMapping5.call(src.SubGroupAccessCode,dest.subGroupAccessCode)
	
}

def srcMidVar = srcArgs0.QueryAccumulationUsageRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar.AccessMode

def srcMidVar0 = srcArgs0.QueryAccumulationUsageRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar0.LoginSystemCode

destArgs0.password = srcMidVar0.Password

destArgs0.remoteAddress = srcMidVar0.RemoteIP

mappingList(srcMidVar.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar.BusinessCode

destArgs0.messageSeq = srcMidVar.MessageSeq

destArgs0.msgLanguageCode = srcMidVar.MsgLanguageCode

def srcMidVar1 = srcArgs0.QueryAccumulationUsageRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.QueryAccumulationUsageRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.QueryAccumulationUsageRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar.Version

def srcMidVar4 = srcArgs0.QueryAccumulationUsageRequestMsg.QueryAccumulationUsageRequest

destArgs1.accmTypeCode = srcMidVar4.AccmType

listMapping1.call(srcMidVar4.QueryObj,destArgs1.queryObj)
