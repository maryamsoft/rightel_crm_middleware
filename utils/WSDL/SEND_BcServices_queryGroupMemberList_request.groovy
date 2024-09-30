dest.setServiceOperation("BMQueryService","queryGroupMemberList")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.querygroupmemberlist.io.QueryGroupMemberListRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.QueryGroupMemberListRequestMsg.QueryGroupMemberListRequest

destArgs1.beginRowNum = srcMidVar.BeginRowNum

def destMidVar = destArgs1.subGroupAccessCode

def srcMidVar0 = srcArgs0.QueryGroupMemberListRequestMsg.QueryGroupMemberListRequest.SubGroupAccessCode

destMidVar.groupCode = srcMidVar0.SubGroupCode

destMidVar.groupKey = srcMidVar0.SubGroupKey

destArgs1.totalNumber = srcMidVar.TotalNumber

def srcMidVar1 = srcArgs0.QueryGroupMemberListRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar1.AccessMode

def srcMidVar2 = srcArgs0.QueryGroupMemberListRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

destArgs0.password = srcMidVar2.Password

destArgs0.remoteAddress = srcMidVar2.RemoteIP

destArgs0.businessCode = srcMidVar1.BusinessCode

destArgs0.messageSeq = srcMidVar1.MessageSeq

destArgs0.msgLanguageCode = srcMidVar1.MsgLanguageCode

def srcMidVar3 = srcArgs0.QueryGroupMemberListRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar3.ChannelID

destArgs0.operatorId = srcMidVar3.OperatorID

def srcMidVar4 = srcArgs0.QueryGroupMemberListRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar4.BEID

destArgs0.brId = srcMidVar4.BRID

def srcMidVar5 = srcArgs0.QueryGroupMemberListRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar5.TimeType

destArgs0.timeZoneId = srcMidVar5.TimeZoneID

destArgs0.version = srcMidVar1.Version

mappingList(srcMidVar1.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs1.fetchRowNum = srcMidVar.FetchRowNum
