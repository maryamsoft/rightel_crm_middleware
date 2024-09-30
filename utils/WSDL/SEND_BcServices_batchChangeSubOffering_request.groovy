import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("SubscriberService","batchChangeSubOffer")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.batch.changesuboffer.io.BathChangeSubOfferRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar5 = dest.property
	
	destMidVar5.propCode = src.PropCode
	
	destMidVar5.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar5.subProps,listMapping2)
	
	destMidVar5.complexFlag = src.PropType
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

listMapping17 =
{
	src,dest  ->

	dest.effDate = parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)

	dest.expDate = parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)

	def destMidVar17 = dest.property

	destMidVar17.propCode = src.PropCode

	destMidVar17.complexFlag = src.PropType

	mappingList(src.SubPropInst,destMidVar17.subProps,listMapping5)

	destMidVar17.value = src.Value
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	def destMidVar7 = dest.productInst
	
	destMidVar7.networkType = src.NetworkType
	
	destMidVar7.packageFlag = src.PackageFlag
	
	destMidVar7.parentProdId = src.ParentProdID
	
	destMidVar7.primaryFlag = src.PrimaryFlag
	
	destMidVar7.prodId = src.ProductID
	
	mappingList(src.PInstProperty,dest.properties,listMapping17)
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar13 = dest.property
	
	destMidVar13.propCode = src.PropCode
	
	destMidVar13.complexFlag = src.PropType
	
	destMidVar13.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar13.subProps,listMapping8)
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar16 = dest.property
	
	destMidVar16.propCode = src.PropCode
	
	destMidVar16.complexFlag = src.PropType
	
	destMidVar16.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar16.subProps,listMapping11)
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	def destMidVar15 = dest.productInst
	
	destMidVar15.networkType = src.NetworkType
	
	destMidVar15.packageFlag = src.PackageFlag
	
	destMidVar15.parentProdId = src.ParentProdID
	
	destMidVar15.primaryFlag = src.PrimaryFlag
	
	destMidVar15.prodId = src.ProductID
	
	destMidVar15.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping10)
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

			dest.offeringInst.activeTime=parseDate(src.ActivationTime.ActiveTime,Constant4Model.DATE_FORMAT)
	
			dest.offeringInst.activeTimeLimit=parseDate(src.ActivationTime.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	def destMidVar11 = dest.offeringInst
	
	def srcMidVar14 = src.ActivationTime
	
	destMidVar11.activeMode = srcMidVar14.Mode
	
	destMidVar11.bundleFlag = src.BundledFlag
	
	def srcMidVar15 = src.EffectiveTime
	
	dest.effMode = srcMidVar15.Mode
	
			dest.effDate=parseDate(srcMidVar15.Time,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	destMidVar11.offeringClass = src.OfferingClass
	
	def destMidVar12 = dest.offeringInst.offeringKey
	
	def srcMidVar16 = src.OfferingKey
	
	destMidVar12.oId = srcMidVar16.OfferingID
	
	destMidVar12.oCode = srcMidVar16.OfferingCode
	
	destMidVar12.pSeq = srcMidVar16.PurchaseSeq
	
	mappingList(src.OInstProperty,dest.properties,listMapping7)
	
	def destMidVar14 = dest.offeringInst.parentOfferingKey
	
	def srcMidVar17 = src.ParentOfferingKey
	
	destMidVar14.oId = srcMidVar17.OfferingID
	
	destMidVar14.oCode = srcMidVar17.OfferingCode
	
	destMidVar14.pSeq = srcMidVar17.PurchaseSeq
	
	mappingList(src.ProductInst,dest.productInsts,listMapping9)
	
	destMidVar11.status = src.Status
	
	listMapping12.call(src.RelGOfferingKey,destMidVar11.relGOfferingKey)
	
			destMidVar11.trialEndTime=parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
			destMidVar11.trialStartTime=parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
	
}

def listMapping15

listMapping15 = 
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

			dest.effDate=parseDate(src.NewEffectiveTime,Constant4Model.DATE_FORMAT)
	
	listMapping15.call(src.OfferingKey,dest.offeringKey)
	
	def srcMidVar18 = src.NewExpirationTime
	
	dest.expMode = srcMidVar18.Mode
	
			dest.expDate=parseDate(srcMidVar18.Time,Constant4Model.DATE_FORMAT)
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	def srcMidVar19 = src.OfferingKey
	
	dest.oId = srcMidVar19.OfferingID
	
	dest.oCode = srcMidVar19.OfferingCode
	
	dest.pSeq = srcMidVar19.PurchaseSeq
	
}

def srcMidVar = srcArgs0.BatchChangeSubOfferingRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar.LoginSystemCode

destArgs0.password = srcMidVar.Password

destArgs0.remoteAddress = srcMidVar.RemoteIP

def srcMidVar0 = srcArgs0.BatchChangeSubOfferingRequestMsg.RequestHeader

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar0.BusinessCode

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

def srcMidVar1 = srcArgs0.BatchChangeSubOfferingRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.BatchChangeSubOfferingRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.BatchChangeSubOfferingRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

def destMidVar = destArgs1.batchOperationInfo

def srcMidVar4 = srcArgs0.BatchChangeSubOfferingRequestMsg.BatchChangeSubOfferingRequest

destMidVar.requestFileName = srcMidVar4.FileName

def destMidVar0 = destArgs1.changeSubOfferingRequest.changeSubOfferingInfo.newPrimaryOffering

def srcMidVar5 = srcArgs0.BatchChangeSubOfferingRequestMsg.BatchChangeSubOfferingRequest.PrimaryOffering.EffectiveTime

destMidVar0.effMode = srcMidVar5.Mode

destMidVar0.effDate=parseDate(srcMidVar5.Time,Constant4Model.DATE_FORMAT)

def destMidVar1 = destArgs1.changeSubOfferingRequest.changeSubOfferingInfo.subBrand

def srcMidVar6 = srcArgs0.BatchChangeSubOfferingRequestMsg.BatchChangeSubOfferingRequest.PrimaryOffering

destMidVar1.brand = srcMidVar6.NewBrand

def destMidVar2 = destArgs1.changeSubOfferingRequest.changeSubOfferingInfo.newPrimaryOffering.offeringInst

def srcMidVar7 = srcArgs0.BatchChangeSubOfferingRequestMsg.BatchChangeSubOfferingRequest.PrimaryOffering.NewPrimaryOffering

destMidVar2.bundleFlag = srcMidVar7.BundledFlag

destMidVar2.offeringClass = srcMidVar7.OfferingClass

def destMidVar3 = destArgs1.changeSubOfferingRequest.changeSubOfferingInfo.newPrimaryOffering.offeringInst.offeringKey

def srcMidVar8 = srcArgs0.BatchChangeSubOfferingRequestMsg.BatchChangeSubOfferingRequest.PrimaryOffering.NewPrimaryOffering.OfferingKey

destMidVar3.oId = srcMidVar8.OfferingID

destMidVar3.oCode = srcMidVar8.OfferingCode

destMidVar3.pSeq = srcMidVar8.PurchaseSeq

def destMidVar4 = destArgs1.changeSubOfferingRequest.changeSubOfferingInfo.newPrimaryOffering.offeringInst.parentOfferingKey

def srcMidVar9 = srcArgs0.BatchChangeSubOfferingRequestMsg.BatchChangeSubOfferingRequest.PrimaryOffering.NewPrimaryOffering.ParentOfferingKey

destMidVar4.oId = srcMidVar9.OfferingID

destMidVar4.oCode = srcMidVar9.OfferingCode

destMidVar4.pSeq = srcMidVar9.PurchaseSeq

mappingList(srcMidVar7.OfferingInstProperty,destMidVar0.properties,listMapping1)

destMidVar0.offeringInst.trialEndTime=parseDate(srcMidVar6.NewPrimaryOffering.TrialEndTime,Constant4Model.DATE_FORMAT)

destMidVar2.status = srcMidVar7.Status

destMidVar0.offeringInst.trialStartTime=parseDate(srcMidVar6.NewPrimaryOffering.TrialStartTime,Constant4Model.DATE_FORMAT)

mappingList(srcMidVar7.ProductInst,destMidVar0.productInsts,listMapping4)

def destMidVar9 = destArgs1.changeSubOfferingRequest.changeSubOfferingInfo.oldPrimaryOffering

def srcMidVar12 = srcArgs0.BatchChangeSubOfferingRequestMsg.BatchChangeSubOfferingRequest.PrimaryOffering.OldPrimaryOffering

destMidVar9.oId = srcMidVar12.OfferingID

destMidVar9.oCode = srcMidVar12.OfferingCode

destMidVar9.pSeq = srcMidVar12.PurchaseSeq

def srcMidVar13 = srcArgs0.BatchChangeSubOfferingRequestMsg.BatchChangeSubOfferingRequest.SupplementaryOffering

def destMidVar10 = destArgs1.changeSubOfferingRequest.changeSubOfferingInfo

mappingList(srcMidVar13.AddOffering,destMidVar10.addSuppOfferings,listMapping6)

mappingList(srcMidVar13.ModifyOffering,destMidVar10.modifySuppOfferings,listMapping14)

destArgs1.requestFileName = srcMidVar4.FileName

destArgs0.interMode = srcMidVar0.AccessMode

mappingList(srcMidVar13.DelOffering,destMidVar10.delSuppOfferings,listMapping16)

destArgs1.changeSubOfferingRequest.handlingChargeFlag = srcMidVar4.HandlingChargeFlag
