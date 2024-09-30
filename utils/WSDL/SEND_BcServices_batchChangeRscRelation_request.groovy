dest.setServiceOperation("CustomerService","batchChangeRscRelation")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.customer.batch.changerscrelation.io.BatchChangeRscRelationRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
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

def srcMidVar = srcArgs0.BatchChangeRscRelationRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar.AccessMode

def srcMidVar0 = srcArgs0.BatchChangeRscRelationRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar0.LoginSystemCode

destArgs0.password = srcMidVar0.Password

destArgs0.remoteAddress = srcMidVar0.RemoteIP

mappingList(srcMidVar.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar.BusinessCode

destArgs0.messageSeq = srcMidVar.MessageSeq

destArgs0.msgLanguageCode = srcMidVar.MsgLanguageCode

def srcMidVar1 = srcArgs0.BatchChangeRscRelationRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.BatchChangeRscRelationRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.BatchChangeRscRelationRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar.Version

def srcMidVar4 = srcArgs0.BatchChangeRscRelationRequestMsg.BatchChangeRscRelationRequest

destArgs1.requestFileName = srcMidVar4.FileName

listMapping1.call(srcMidVar4.CustAccessCode,destArgs1.custAccessCode)

listMapping2.call(srcMidVar4.SubAccessCode,destArgs1.subAccessCode)

listMapping3.call(srcMidVar4.SubGroupAccessCode,destArgs1.groupAccessCode)
