dest.setServiceOperation("BMQueryService","queryFreeUnit")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.queryfreeunit.io.QueryFreeUnitRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.pSeq = src.PurchaseSeq
    dest.oCode = src.OfferingCode
	dest.oId = src.OfferingID
	
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

	dest.groupKey = src.SubGroupKey
	
	dest.groupCode = src.SubGroupCode
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.accoutKey = src.AccountKey
	
	dest.accoutCode = src.AccountCode
	
	dest.primaryIdentity = src.PrimaryIdentity
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.QueryFreeUnitRequestMsg.RequestHeader

destArgs0.version = srcMidVar.Version

def srcMidVar0 = srcArgs0.QueryFreeUnitRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar0.TimeType

destArgs0.timeZoneId = srcMidVar0.TimeZoneID

def srcMidVar1 = srcArgs0.QueryFreeUnitRequestMsg.QueryFreeUnitRequest

def oKeyExt = destArgs1.offeringKey
oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

listMapping0.call(srcMidVar1.OfferingKey,oKeyExt)

def srcMidVar2 = srcArgs0.QueryFreeUnitRequestMsg.QueryFreeUnitRequest.QueryObj

listMapping1.call(srcMidVar2.CustAccessCode,destArgs1.custAccessCode)

listMapping2.call(srcMidVar2.SubAccessCode,destArgs1.subAccessCode)

listMapping3.call(srcMidVar2.SubGroupAccessCode,destArgs1.groupAccessCode)

listMapping5.call(srcMidVar2.AcctAccessCode,destArgs1.acctAccessCode)

destArgs0.interMode = srcMidVar.AccessMode

def srcMidVar3 = srcArgs0.QueryFreeUnitRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar3.LoginSystemCode

destArgs0.password = srcMidVar3.Password

destArgs0.remoteAddress = srcMidVar3.RemoteIP

mappingList(srcMidVar.AdditionalProperty,destArgs0.simpleProperty,listMapping4)

destArgs0.businessCode = srcMidVar.BusinessCode

destArgs0.messageSeq = srcMidVar.MessageSeq

destArgs0.msgLanguageCode = srcMidVar.MsgLanguageCode

def srcMidVar4 = srcArgs0.QueryFreeUnitRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar4.ChannelID

destArgs0.operatorId = srcMidVar4.OperatorID

def srcMidVar5 = srcArgs0.QueryFreeUnitRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar5.BEID

destArgs0.brId = srcMidVar5.BRID

destArgs1.effectiveFilterFlag = srcArgs0.QueryFreeUnitRequestMsg.QueryFreeUnitRequest.EffectiveFilterFlag

destArgs1.accurateQuery = srcArgs0.QueryFreeUnitRequestMsg.QueryFreeUnitRequest.AccurateQuery