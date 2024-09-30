dest.setServiceOperation("BMQueryService","queryGroupMemberBasicInfo")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.querymemberbasicinfo.io.QueryGroupMemberBasicInfoRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.QueryGroupMemberBasicInfoRequestMsg.QueryGroupMemberBasicInfoRequest

def destMidVar = destArgs1.groupAccessCode

def srcMidVar0 = srcMidVar.SubGroupAccessCode

destMidVar.groupCode = srcMidVar0.SubGroupCode

destMidVar.groupKey = srcMidVar0.SubGroupKey

destArgs1.memberShortNo = srcMidVar.SubGroupMemberShortNo

def destMidVar1 = destArgs1.subAccessCode

def srcMidVar1 = srcMidVar.SubAccessCode

destMidVar1.primaryIdentity = srcMidVar1.PrimaryIdentity

destMidVar1.subscriberKey = srcMidVar1.SubscriberKey

def srcMidVar2 = srcArgs0.QueryGroupMemberBasicInfoRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar2.AccessMode

def srcMidVar3 = srcMidVar2.AccessSecurity

destArgs0.loginSystem = srcMidVar3.LoginSystemCode

destArgs0.password = srcMidVar3.Password

destArgs0.remoteAddress = srcMidVar3.RemoteIP

destArgs0.businessCode = srcMidVar3.BusinessCode

destArgs0.messageSeq = srcMidVar2.MessageSeq

destArgs0.msgLanguageCode = srcMidVar2.MsgLanguageCode

def srcMidVar4 = srcMidVar2.OperatorInfo

destArgs0.channelId = srcMidVar4.ChannelID

destArgs0.operatorId = srcMidVar4.OperatorID

def srcMidVar5 = srcMidVar2.OwnershipInfo

destArgs0.beId = srcMidVar5.BEID

destArgs0.brId = srcMidVar5.BRID

def srcMidVar6 = srcMidVar2.TimeFormat

destArgs0.timeType = srcMidVar6.TimeType

destArgs0.timeZoneId = srcMidVar6.TimeZoneID

destArgs0.version = srcMidVar2.Version

mappingList(srcMidVar1.AdditionalProperty,destArgs0.simpleProperty,listMapping0)
