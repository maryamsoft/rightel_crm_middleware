dest.setServiceOperation("BMQueryService","queryGroupListBySubscriber")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.querygrouplistbysubscriber.io.QueryGroupListBySubscriberRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.QueryGroupListBySubscriberRequestMsg.RequestHeader

mappingList(srcMidVar.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

def destMidVar = destArgs1.subAccessCode

def srcMidVar0 = srcArgs0.QueryGroupListBySubscriberRequestMsg.QueryGroupListBySubscriberRequest.SubAccessCode

destMidVar.primaryIdentity = srcMidVar0.PrimaryIdentity

destMidVar.subscriberKey = srcMidVar0.SubscriberKey

def srcMidVar1 = srcArgs0.QueryGroupListBySubscriberRequestMsg.QueryGroupListBySubscriberRequest

destArgs1.subGroupType = srcMidVar1.SubGroupType

destArgs0.interMode = srcMidVar.AccessMode

def srcMidVar2 = srcArgs0.QueryGroupListBySubscriberRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

destArgs0.password = srcMidVar2.Password

destArgs0.remoteAddress = srcMidVar2.RemoteIP

destArgs0.businessCode = srcMidVar.BusinessCode

destArgs0.messageSeq = srcMidVar.MessageSeq

destArgs0.msgLanguageCode = srcMidVar.MsgLanguageCode

def srcMidVar3 = srcArgs0.QueryGroupListBySubscriberRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar3.ChannelID

destArgs0.operatorId = srcMidVar3.OperatorID

def srcMidVar4 = srcArgs0.QueryGroupListBySubscriberRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar4.BEID

destArgs0.brId = srcMidVar4.BRID

def srcMidVar5 = srcArgs0.QueryGroupListBySubscriberRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar5.TimeType

destArgs0.timeZoneId = srcMidVar5.TimeZoneID

destArgs0.version = srcMidVar.Version
