dest.setServiceOperation("BMQueryService","querySubInfoExToCube")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.querySubInfoExtToCube.io.QuerySubInfoExToCubeRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def destMidVar = destArgs1.subAccessCode

def srcMidVar = srcArgs0.QuerySubInfoExToCubeRequestMsg.QuerySubInfoExToCubeRequest.AccessInfo

destMidVar.primaryIdentity = srcMidVar.ObjectId

def srcMidVar0 = srcArgs0.QuerySubInfoExToCubeRequestMsg.RequestHeader

destArgs0.messageSeq = srcMidVar0.MessageSeq

def srcMidVar1 = srcArgs0.QuerySubInfoExToCubeRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar1.LoginSystemCode

destArgs0.password = srcMidVar1.Password

destArgs0.remoteAddress = srcMidVar1.RemoteIP

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar0.BusinessCode

destArgs0.interMode = srcMidVar0.AccessMode

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

def srcMidVar2 = srcArgs0.QuerySubInfoExToCubeRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar2.ChannelID

destArgs0.operatorId = srcMidVar2.OperatorID

def srcMidVar3 = srcArgs0.QuerySubInfoExToCubeRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar3.BEID

destArgs0.brId = srcMidVar3.BRID

def srcMidVar4 = srcArgs0.QuerySubInfoExToCubeRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar4.TimeType

destArgs0.timeZoneId = srcMidVar4.TimeZoneID

destArgs0.version = srcMidVar0.Version
