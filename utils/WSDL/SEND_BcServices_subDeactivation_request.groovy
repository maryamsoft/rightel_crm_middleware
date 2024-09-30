import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("SubscriberService","deactivateSub")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.deactivatesub.io.DeactivateSubRequest"

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

def srcMidVar = srcArgs0.SubDeactivationRequestMsg.RequestHeader

destArgs0.businessCode = srcMidVar.BusinessCode

destArgs0.messageSeq = srcMidVar.MessageSeq

destArgs0.msgLanguageCode = srcMidVar.MsgLanguageCode

destArgs0.version = srcMidVar.Version

def srcMidVar0 = srcArgs0.SubDeactivationRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar0.LoginSystemCode

destArgs0.password = srcMidVar0.Password

destArgs0.remoteAddress = srcMidVar0.RemoteIP

mappingList(srcMidVar.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

def srcMidVar1 = srcArgs0.SubDeactivationRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.SubDeactivationRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.SubDeactivationRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

def srcMidVar4 = srcArgs0.SubDeactivationRequestMsg.SubDeactivationRequest

destArgs1.opType = srcMidVar4.OpType

def destMidVar = destArgs1.subDeactivationInfo

mappingList(srcMidVar4.AdditionalProperty,destMidVar.additionalProperties,listMapping1)

def destMidVar0 = destArgs1.subPreDeactivationInfo

mappingList(srcMidVar4.AdditionalProperty,destMidVar0.additionalProperties,listMapping2)

def destMidVar1 = destArgs1.subAccessCode

def srcMidVar5 = srcArgs0.SubDeactivationRequestMsg.SubDeactivationRequest.SubAccessCode

destMidVar1.primaryIdentity = srcMidVar5.PrimaryIdentity

destMidVar1.subscriberKey = srcMidVar5.SubscriberKey

destArgs0.interMode = srcMidVar.AccessMode
destArgs1.originalIdentity = srcMidVar5.PrimaryIdentity

mappingList(srcMidVar4.SubProperty,destArgs1.subProperty,listMapping1)

destArgs1.effectiveTime = parseDate(srcMidVar4.EffectiveTime,Constant4Model.DATE_FORMAT)
  