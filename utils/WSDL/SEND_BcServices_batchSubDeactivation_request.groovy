dest.setServiceOperation("SubscriberService","batchDeactiveSub")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.batch.deactivesubscriber.io.BatchDeactiveSubRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}


def destMidVar = destArgs1.batchOperationInfo

def srcMidVar = srcArgs0.BatchSubDeactivationRequestMsg.BatchSubDeactivationRequest

destMidVar.requestFileName = srcMidVar.FileName

def srcMidVar0 = srcArgs0.BatchSubDeactivationRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar0.LoginSystemCode

destArgs0.password = srcMidVar0.Password

destArgs0.remoteAddress = srcMidVar0.RemoteIP

def srcMidVar1 = srcArgs0.BatchSubDeactivationRequestMsg.RequestHeader

mappingList(srcMidVar1.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar1.BusinessCode

destArgs0.msgLanguageCode = srcMidVar1.MsgLanguageCode

destArgs0.messageSeq = srcMidVar1.MessageSeq

def srcMidVar2 = srcArgs0.BatchSubDeactivationRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar2.ChannelID

destArgs0.operatorId = srcMidVar2.OperatorID

def srcMidVar3 = srcArgs0.BatchSubDeactivationRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar3.BEID

destArgs0.brId = srcMidVar3.BRID

def srcMidVar4 = srcArgs0.BatchSubDeactivationRequestMsg.RequestHeader.TimeFormat

destArgs0.timeZoneId = srcMidVar4.TimeZoneID

destArgs0.timeType = srcMidVar4.TimeType

destArgs0.version = srcMidVar1.Version

def destMidVar0 = destArgs1.deactivateSubRequest

destMidVar0.opType = srcMidVar.OpType

destArgs1.requestFileName = srcMidVar.FileName

destArgs0.interMode = srcMidVar1.AccessMode
