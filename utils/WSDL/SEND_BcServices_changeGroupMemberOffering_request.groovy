import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("BMGroupService","changeGroupMemberOffering")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.changegroupmemberoffering.io.ChangeGroupMemberOfferingRequest"

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

	dest.businessCode = src.BusinessCode
	
	def srcMidVar0 = src.OperatorInfo
	
	dest.channelId = srcMidVar0.ChannelID
	
	def srcMidVar1 = src.AccessSecurity
	
	dest.loginSystem = srcMidVar1.LoginSystemCode
	
	dest.messageSeq = src.MessageSeq
	
	dest.msgLanguageCode = src.MsgLanguageCode
	
	dest.operatorId = srcMidVar0.OperatorID
	
	dest.password = srcMidVar1.Password
	
	def srcMidVar2 = src.TimeFormat
	
	dest.timeType = srcMidVar2.TimeType
	
	dest.timeZoneId = srcMidVar2.TimeZoneID
	
	dest.version = src.Version
	
	dest.remoteAddress = srcMidVar1.RemoteIP
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	def srcMidVar3 = src.OwnershipInfo
	
	dest.beId = srcMidVar3.BEID
	
	dest.brId = srcMidVar3.BRID
	
	dest.interMode = src.AccessMode
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.groupCode = src.SubGroupCode
	
	dest.groupKey = src.SubGroupKey
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	def srcMidVar4 = src.NewExpirationTime
	
	dest.expMode = srcMidVar4.Mode
	
	listMapping8.call(src.OfferingKey,dest.offeringKey)
	
		dest.effDate=parseDate(src.NewEffectiveTime, Constant4Model.DATE_FORMAT)
	
		dest.expDate=parseDate(srcMidVar4.Time, Constant4Model.DATE_FORMAT)
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

		dest.effDate=parseDate(src.EffectiveTime, Constant4Model.DATE_FORMAT)
	
		dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	def destMidVar0 = dest.property
	
	destMidVar0.propCode = src.PropCode
	
	destMidVar0.complexFlag = src.PropType
	
	destMidVar0.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar0.subProps,listMapping14)
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

		dest.effDate=parseDate(src.EffectiveTime, Constant4Model.DATE_FORMAT)
	
		dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	def destMidVar2 = dest.property
	
	destMidVar2.propCode = src.PropCode
	
	destMidVar2.complexFlag = src.PropType
	
	destMidVar2.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar2.subProps,listMapping17)
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

	def destMidVar1 = dest.productInst
	
	destMidVar1.networkType = src.NetworkType
	
	destMidVar1.packageFlag = src.PackageFlag
	
	destMidVar1.parentProdId = src.ParentProdID
	
	destMidVar1.primaryFlag = src.PrimaryFlag
	
	destMidVar1.prodId = src.ProductID
	
	destMidVar1.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping16)
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

		dest.offeringInst.activeTime=parseDate(src.ActivationTime.ActiveTime, Constant4Model.DATE_FORMAT)
	
		dest.offeringInst.activeTimeLimit=parseDate(src.ActivationTime.ActiveTimeLimit, Constant4Model.DATE_FORMAT)
	
	def destMidVar = dest.offeringInst
	
	def srcMidVar5 = src.ActivationTime
	
	destMidVar.activeMode = srcMidVar5.Mode
	
	destMidVar.bundleFlag = src.BundledFlag
	
	def srcMidVar6 = src.EffectiveTime
	
	dest.effMode = srcMidVar6.Mode
	
		dest.effDate=parseDate(srcMidVar6.Time, Constant4Model.DATE_FORMAT)
	
		dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	destMidVar.offeringClass = src.OfferingClass
	
	listMapping10.call(src.OfferingKey,destMidVar.offeringKey)
	
	listMapping11.call(src.ParentOfferingKey,destMidVar.parentOfferingKey)
	
	listMapping12.call(src.RelGOfferingKey,destMidVar.relGOfferingKey)
	
	destMidVar.status = src.Status
	
		destMidVar.trialEndTime=parseDate(src.TrialEndTime, Constant4Model.DATE_FORMAT)
	
		destMidVar.trialStartTime=parseDate(src.TrialStartTime, Constant4Model.DATE_FORMAT)
	
	mappingList(src.OInstProperty,dest.properties,listMapping13)
	
	mappingList(src.ProductInst,dest.productInsts,listMapping15)
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	dest.expMode = "I"
	
	listMapping19.call(src.OfferingKey,dest.offeringKey)
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	listMapping3.call(src.SubGroupAccessCode,dest.groupAccessCode)
	
	listMapping4.call(src.SubAccessCode,dest.subAccessCode)
	
	mappingList(src.ModifyOffering,dest.modifyOfferingInsts,listMapping7)
	
	mappingList(src.AddOffering,dest.addOfferingInsts,listMapping9)
	
	mappingList(src.DelOffering,dest.delOfferingInsts,listMapping18)

	mappingList(src.AdditionalProperty,dest.simplePropertyList,listMapping1)
	
}

def srcMidVar = srcArgs0.ChangeGroupMemberOfferingRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.ChangeGroupMemberOfferingRequest,destArgs1)
