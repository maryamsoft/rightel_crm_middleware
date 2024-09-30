dest.setServiceOperation("BMGroupService","changeGroupStatus")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.changegroupstatus.io.ChangeGroupStatusRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.ChangeGroupStatusRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar.BEID

destArgs0.brId = srcMidVar.BRID

def srcMidVar0 = srcArgs0.ChangeGroupStatusRequestMsg.RequestHeader

destArgs0.businessCode = srcMidVar0.BusinessCode

def srcMidVar1 = srcArgs0.ChangeGroupStatusRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.ChangeGroupStatusRequestMsg.RequestHeader.AccessSecurity

destArgs0.password = srcMidVar2.Password

def srcMidVar3 = srcArgs0.ChangeGroupStatusRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

destArgs0.remoteAddress = srcMidVar2.RemoteIP

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

def destMidVar = destArgs1.groupAccessCode

def srcMidVar4 = srcArgs0.ChangeGroupStatusRequestMsg.ChangeGroupStatusRequest.SubGroupAccessCode

destMidVar.groupCode = srcMidVar4.SubGroupCode

destMidVar.groupKey = srcMidVar4.SubGroupKey

def destMidVar0 = destArgs1.changeGroupStatusInfo

def srcMidVar5 = srcArgs0.ChangeGroupStatusRequestMsg.ChangeGroupStatusRequest

destMidVar0.newStatus = srcMidVar5.NewStatus

destMidVar0.oldStatus = srcMidVar5.OldStatus

destMidVar0.opType = srcMidVar5.OpType

destArgs0.interMode = srcMidVar0.AccessMode
