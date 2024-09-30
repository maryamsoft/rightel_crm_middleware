import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("BMGroupService","groupDeactivation")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.groupdeactivation.io.GroupDeactivationRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.GroupDeactivationRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar.LoginSystemCode

destArgs0.password = srcMidVar.Password

destArgs0.remoteAddress = srcMidVar.RemoteIP

def srcMidVar0 = srcArgs0.GroupDeactivationRequestMsg.RequestHeader

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar0.BusinessCode

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

def srcMidVar1 = srcArgs0.GroupDeactivationRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.GroupDeactivationRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.GroupDeactivationRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

def destMidVar = destArgs1.groupAccessCode

def srcMidVar4 = srcArgs0.GroupDeactivationRequestMsg.GroupDeactivationRequest.SubGroupAccessCode

destMidVar.groupCode = srcMidVar4.SubGroupCode

destMidVar.groupKey = srcMidVar4.SubGroupKey

destArgs0.interMode = srcMidVar0.AccessMode

def srcMidVar5 = srcArgs0.GroupDeactivationRequestMsg.GroupDeactivationRequest

destArgs1.effectiveTime = parseDate(srcMidVar5.EffectiveTime,Constant4Model.DATE_FORMAT)

destArgs1.delMembersFlag = srcArgs0.GroupDeactivationRequestMsg.GroupDeactivationRequest.DelMembersFlag
