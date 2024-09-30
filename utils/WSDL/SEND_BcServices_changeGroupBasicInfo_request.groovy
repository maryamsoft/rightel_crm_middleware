dest.setServiceOperation("BMGroupService","changeGroupBasicInfo")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.changegroupbasicinfo.io.ChangeGroupBasicInfoRequest"

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
	def srcMidVar9 = src.DestGroupAccessCode
	dest.groupKey = srcMidVar9.SubGroupKey
	dest.groupCode = srcMidVar9.SubGroupCode

}

def listMapping3

listMapping3 =
{
	src,dest  ->
	def srcMidVar10 = src.SrcGroupAccessCode
	dest.groupKey = srcMidVar10.SubGroupKey
	dest.groupCode = srcMidVar10.SubGroupCode

}

def listMapping4

listMapping4 =
{
	src,dest  ->
	def srcMidVar11 = src.DestGroupAccessCode
	dest.groupKey = srcMidVar11.SubGroupKey
	dest.groupCode = srcMidVar11.SubGroupCode

}

def listMapping5

listMapping5 =
{
	src,dest  ->
	def srcMidVar12 = src.SrcGroupAccessCode
	dest.groupKey = srcMidVar12.SubGroupKey
	dest.groupCode = srcMidVar12.SubGroupCode

}
def srcMidVar = srcArgs0.ChangeGroupBasicInfoRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar.BEID

destArgs0.brId = srcMidVar.BRID

def srcMidVar0 = srcArgs0.ChangeGroupBasicInfoRequestMsg.RequestHeader

destArgs0.businessCode = srcMidVar0.BusinessCode

def srcMidVar1 = srcArgs0.ChangeGroupBasicInfoRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.ChangeGroupBasicInfoRequestMsg.RequestHeader.AccessSecurity

destArgs0.password = srcMidVar2.Password

def srcMidVar3 = srcArgs0.ChangeGroupBasicInfoRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.remoteAddress = srcMidVar2.RemoteIP

def destMidVar = destArgs1.subGroupAccessCode

def srcMidVar4 = srcArgs0.ChangeGroupBasicInfoRequestMsg.ChangeGroupBasicInfoRequest.SubGroupAccessCode

destMidVar.groupCode = srcMidVar4.SubGroupCode

destMidVar.groupKey = srcMidVar4.SubGroupKey

def destMidVar0 = destArgs1.changeGroupBasicInfo.groupInfo

def srcMidVar5 = srcArgs0.ChangeGroupBasicInfoRequestMsg.ChangeGroupBasicInfoRequest.SubGroupBasicInfo

destMidVar0.groupName = srcMidVar5.SubGroupName

def destMidVar1 = destArgs1.changeGroupBasicInfo

mappingList(srcMidVar5.SubGroupProperty,destMidVar1.properties,listMapping1)

destArgs0.interMode = srcMidVar0.AccessMode

def srcMidVar6 = srcArgs0.ChangeGroupBasicInfoRequestMsg.ChangeGroupBasicInfoRequest.SubGroupProhibitGroup
def srcMidVar7 = srcMidVar6.AddProhibitGroup
def srcMidVar8 = srcMidVar6.DelProhibitGroup

def destMidVar2= destArgs1.subGroupProhibitGroup
def destMidVar3 = destMidVar2.addProhibitGroupInfo
def destMidVar4 = destMidVar2.delProhibitGroupInfo

mappingList(srcMidVar7.DestGroupList,destMidVar3.destGroupList,listMapping2)
mappingList(srcMidVar7.SrcGroupList,destMidVar3.srcGroupList,listMapping3)
mappingList(srcMidVar8.DestGroupList,destMidVar4.destGroupList,listMapping4)
mappingList(srcMidVar8.SrcGroupList,destMidVar4.srcGroupList,listMapping5)



