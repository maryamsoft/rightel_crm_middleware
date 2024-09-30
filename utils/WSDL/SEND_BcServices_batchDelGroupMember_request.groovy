dest.setServiceOperation("BMGroupService","batchDelGroupMember")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.batch.delmember.io.BatchDelGroupMemberRequest"

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

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}

def srcMidVar = srcArgs0.BatchDelGroupMemberRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar.LoginSystemCode

destArgs0.password = srcMidVar.Password

destArgs0.remoteAddress = srcMidVar.RemoteIP

def srcMidVar0 = srcArgs0.BatchDelGroupMemberRequestMsg.RequestHeader

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar0.BusinessCode

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

def srcMidVar1 = srcArgs0.BatchDelGroupMemberRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.BatchDelGroupMemberRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.BatchDelGroupMemberRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

def srcMidVar4 = srcArgs0.BatchDelGroupMemberRequestMsg.BatchDelGroupMemberRequest.DelGroupMemberOffering

def destMidVar = destArgs1.subOfferingInfo

mappingList(srcMidVar4.OfferingKey,destMidVar.delSuppOfferings,listMapping1)

def srcMidVar5 = srcArgs0.BatchDelGroupMemberRequestMsg.BatchDelGroupMemberRequest.EffectiveTime

destArgs1.effMode = srcMidVar5.Mode

destArgs1.effDate=parseDate(srcMidVar5.Time,"yyyyMMddHHmmss")

def srcMidVar6 = srcArgs0.BatchDelGroupMemberRequestMsg.BatchDelGroupMemberRequest

destArgs1.requestFileName = srcMidVar6.FileName

destArgs1.returnPublicFreeUnit = srcMidVar6.ReturnPublicFreeUnit

def destMidVar0 = destArgs1.groupAccessCode

def srcMidVar7 = srcArgs0.BatchDelGroupMemberRequestMsg.BatchDelGroupMemberRequest.SubGroupAccessCode

destMidVar0.groupCode = srcMidVar7.SubGroupCode

destMidVar0.groupKey = srcMidVar7.SubGroupKey

destArgs0.interMode = srcMidVar0.AccessMode
