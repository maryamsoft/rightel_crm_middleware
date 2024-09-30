dest.setServiceOperation("BMGroupService","delGroupMember")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.delgroupmember.io.DelGroupMemberRequest"

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	def srcMidVar0 = src.AccessSecurity
	
	dest.loginSystem = srcMidVar0.LoginSystemCode
	
	dest.password = srcMidVar0.Password
	
	dest.remoteAddress = srcMidVar0.RemoteIP
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	dest.businessCode = src.BusinessCode
	
	dest.messageSeq = src.MessageSeq
	
	dest.msgLanguageCode = src.MsgLanguageCode
	
	def srcMidVar1 = src.OperatorInfo
	
	dest.channelId = srcMidVar1.ChannelID
	
	dest.operatorId = srcMidVar1.OperatorID
	
	def srcMidVar2 = src.OwnershipInfo
	
	dest.beId = srcMidVar2.BEID
	
	dest.brId = srcMidVar2.BRID
	
	def srcMidVar3 = src.TimeFormat
	
	dest.timeType = srcMidVar3.TimeType
	
	dest.timeZoneId = srcMidVar3.TimeZoneID
	
	dest.version = src.Version
	
	dest.interMode = src.AccessMode
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.subscriberKey = src.SubscriberKey
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.paymentRelationKey = src.PayRelationKey
	
}

def srcMidVar = srcArgs0.DelGroupMemberRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

def destMidVar = destArgs1.delMemberInfo

def srcMidVar4 = srcArgs0.DelGroupMemberRequestMsg.DelGroupMemberRequest.EffectiveTime

destMidVar.expMode = srcMidVar4.Mode

destMidVar.expDate=parseDate(srcMidVar.DelGroupMemberRequest.EffectiveTime.Time,"yyyyMMddHHmmss")

def srcMidVar5 = srcArgs0.DelGroupMemberRequestMsg.DelGroupMemberRequest

destArgs1.returnPublicFreeUnit = srcMidVar5.ReturnPublicFreeUnit

listMapping2.call(srcMidVar5.GroupMember,destArgs1.subAccessCode)

def srcMidVar6 = srcArgs0.DelGroupMemberRequestMsg.DelGroupMemberRequest.DelGroupMemberOffering

def destMidVar0 = destArgs1.subOfferingInfo

mappingList(srcMidVar6.OfferingKey,destMidVar0.delSuppOfferings,listMapping3)

def destMidVar1 = destArgs1.groupAccessCode

def srcMidVar7 = srcArgs0.DelGroupMemberRequestMsg.DelGroupMemberRequest.SubGroupAccessCode

destMidVar1.groupCode = srcMidVar7.SubGroupCode

destMidVar1.groupKey = srcMidVar7.SubGroupKey

def srcMidVar8 = srcArgs0.DelGroupMemberRequestMsg.DelGroupMemberRequest.PaymentRelation.NewDFTAcct

destArgs1.acctKey = srcMidVar8.AcctKey

destArgs1.payRelationKey = srcMidVar8.PayRelationKey

def srcMidVar9 = srcArgs0.DelGroupMemberRequestMsg.DelGroupMemberRequest.PaymentRelation

mappingList(srcMidVar9.DelPayRelation,destArgs1.delPayRelationInfoList,listMapping4)
