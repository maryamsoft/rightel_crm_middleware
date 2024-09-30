import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("BMGroupService","changeGroupOffering")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.changegroupoffering.io.ChangeGroupOfferingRequest"

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
	
	def srcMidVar3 = src.OwnershipInfo
	
	dest.beId = srcMidVar3.BEID
	
	dest.brId = srcMidVar3.BRID
	
	dest.remoteAddress = srcMidVar1.RemoteIP
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	dest.interMode = src.AccessMode
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.groupCode = src.SubGroupCode
	
	dest.groupKey = src.SubGroupKey
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	listMapping6.call(src.OfferingKey,dest.offeringKey)
	
		dest.effDate=parseDate(src.NewEffectiveTime, Constant4Model.DATE_FORMAT)
	
	def srcMidVar5 = src.NewExpirationTime
	
	dest.expMode = srcMidVar5.Mode
	
		dest.expDate=parseDate(srcMidVar5.Time, Constant4Model.DATE_FORMAT)
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

		dest.effDate=parseDate(src.EffectiveTime, Constant4Model.DATE_FORMAT)
	
		dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	def destMidVar0 = dest.property
	
	destMidVar0.propCode = src.PropCode
	
	destMidVar0.complexFlag = src.PropType
	
	destMidVar0.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar0.subProps,listMapping10)
	
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

def listMapping15

listMapping15 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->

		dest.effDate=parseDate(src.EffectiveTime, Constant4Model.DATE_FORMAT)
	
		dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	def destMidVar2 = dest.property
	
	destMidVar2.propCode = src.PropCode
	
	destMidVar2.complexFlag = src.PropType
	
	destMidVar2.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar2.subProps,listMapping15)
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	def destMidVar1 = dest.productInst
	
	destMidVar1.networkType = src.NetworkType
	
	destMidVar1.packageFlag = src.PackageFlag
	
	destMidVar1.parentProdId = src.ParentProdID
	
	destMidVar1.primaryFlag = src.PrimaryFlag
	
	destMidVar1.prodId = src.ProductID
	
	destMidVar1.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping14)
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

		dest.offeringInst.activeTime=parseDate(src.ActivationTime.ActiveTime, Constant4Model.DATE_FORMAT)
	
		dest.offeringInst.activeTimeLimit=parseDate(src.ActivationTime.ActiveTimeLimit, Constant4Model.DATE_FORMAT)
	
	def destMidVar = dest.offeringInst
	
	def srcMidVar6 = src.ActivationTime
	
	destMidVar.activeMode = srcMidVar6.Mode
	
	destMidVar.bundleFlag = src.BundledFlag
	
	destMidVar.offeringClass = src.OfferingClass
	
	def srcMidVar7 = src.EffectiveTime
	
	dest.effMode = srcMidVar7.Mode
	
		dest.effDate=parseDate(srcMidVar7.Time, Constant4Model.DATE_FORMAT)
	
		dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	listMapping8.call(src.OfferingKey,destMidVar.offeringKey)
	
	mappingList(src.OInstProperty,dest.properties,listMapping9)
	
	listMapping11.call(src.ParentOfferingKey,destMidVar.parentOfferingKey)
	
	listMapping12.call(src.RelGOfferingKey,destMidVar.relGOfferingKey)
	
	destMidVar.status = src.Status
	
		destMidVar.trialEndTime=parseDate(src.TrialEndTime, Constant4Model.DATE_FORMAT)
	
		destMidVar.trialStartTime=parseDate(src.TrialStartTime, Constant4Model.DATE_FORMAT)
	
	mappingList(src.ProductInst,dest.productInsts,listMapping13)
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	dest.expMode = "I"
	
	dest.expDate = parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	listMapping17.call(src.OfferingKey,dest.offeringKey)
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar6 = dest.property
	
	destMidVar6.propCode = src.PropCode
	
	destMidVar6.value = src.Value
	
	destMidVar6.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar6.subProps,listMapping19)
	
}

def listMapping22

listMapping22 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping21

listMapping21 = 
{
    src,dest  ->

	dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar10 = dest.property
	
	destMidVar10.propCode = src.PropCode
	
	destMidVar10.complexFlag = src.PropType
	
	destMidVar10.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar10.subProps,listMapping22)
	
}

def listMapping20

listMapping20 = 
{
    src,dest  ->

	def destMidVar9 = dest.productInst
	
	destMidVar9.networkType = src.NetworkType
	
	destMidVar9.packageFlag = src.PackageFlag
	
	destMidVar9.parentProdId = src.ParentProdID
	
	destMidVar9.primaryFlag = src.PrimaryFlag
	
	destMidVar9.prodId = src.ProductID
	
	destMidVar9.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping21)
	
}

def srcMidVar = srcArgs0.ChangeGroupOfferingRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

def srcMidVar4 = srcArgs0.ChangeGroupOfferingRequestMsg.ChangeGroupOfferingRequest

listMapping2.call(srcMidVar4.SubGroupAccessCode,destArgs1.groupAccessCode)

mappingList(srcMidVar4.ModifyOffering,destArgs1.modifyOfferingInsts,listMapping5)

mappingList(srcMidVar4.AddOffering,destArgs1.addOfferingInsts,listMapping7)

mappingList(srcMidVar4.DelOffering,destArgs1.delOfferingInsts,listMapping16)

def destMidVar3 = destArgs1.newPrimaryOffering

def srcMidVar8 = srcArgs0.ChangeGroupOfferingRequestMsg.ChangeGroupOfferingRequest.PrimaryOffering.EffectiveTime

destMidVar3.effMode = srcMidVar8.Mode

destMidVar3.effDate=parseDate(srcMidVar8.Time,Constant4Model.DATE_FORMAT)

def destMidVar4 = destArgs1.oldPrimaryOffering

def srcMidVar9 = srcArgs0.ChangeGroupOfferingRequestMsg.ChangeGroupOfferingRequest.PrimaryOffering.OldPrimaryOffering

destMidVar4.oId = srcMidVar9.OfferingID

destMidVar4.oCode = srcMidVar9.OfferingCode

destMidVar4.pSeq = srcMidVar9.PurchaseSeq

def destMidVar5 = destArgs1.newPrimaryOffering.offeringInst

def srcMidVar10 = srcArgs0.ChangeGroupOfferingRequestMsg.ChangeGroupOfferingRequest.PrimaryOffering.NewPrimaryOffering

destMidVar5.bundleFlag = srcMidVar10.BundledFlag

destMidVar5.offeringClass = srcMidVar10.OfferingClass

mappingList(srcMidVar10.OfferingInstProperty,destMidVar3.properties,listMapping18)

def destMidVar7 = destArgs1.newPrimaryOffering.offeringInst.offeringKey

def srcMidVar11 = srcArgs0.ChangeGroupOfferingRequestMsg.ChangeGroupOfferingRequest.PrimaryOffering.NewPrimaryOffering.OfferingKey

destMidVar7.oId = srcMidVar11.OfferingID

destMidVar7.oCode = srcMidVar11.OfferingCode

destMidVar7.pSeq = srcMidVar11.PurchaseSeq

def destMidVar8 = destArgs1.newPrimaryOffering.offeringInst.parentOfferingKey

def srcMidVar12 = srcArgs0.ChangeGroupOfferingRequestMsg.ChangeGroupOfferingRequest.PrimaryOffering.NewPrimaryOffering.ParentOfferingKey

destMidVar8.oId = srcMidVar12.OfferingID

destMidVar8.oCode = srcMidVar12.OfferingCode

destMidVar8.pSeq = srcMidVar12.PurchaseSeq

destMidVar5.status = srcMidVar10.Status

destMidVar3.offeringInst.trialEndTime=parseDate(srcMidVar10.TrialEndTime,Constant4Model.DATE_FORMAT)

destMidVar3.offeringInst.trialStartTime=parseDate(srcMidVar10.TrialStartTime,Constant4Model.DATE_FORMAT)

mappingList(srcMidVar10.ProductInst,destMidVar3.productInsts,listMapping20)

destArgs1.handlingChargeFlag = srcMidVar4.HandlingChargeFlag

mappingList(srcMidVar4.AdditionalProperty,destArgs1.simplePropertyList,listMapping1)

