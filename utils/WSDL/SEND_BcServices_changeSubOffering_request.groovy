import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("SubscriberService","changeSubOffering")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.changesuboffering.io.ChangeSubOfferingRequest"

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

	dest.effDate = parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.expDate = parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar2 = dest.property
	
	destMidVar2.propCode = src.PropCode
	
	destMidVar2.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar2.subProps,listMapping2)
	
	destMidVar2.value = src.Value
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->
    
  dest.oCode = src.OfferingCode

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.oCode = src.OfferingCode

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.effDate = parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.expDate = parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar4 = dest.property
	
	destMidVar4.propCode = src.PropCode
	
	destMidVar4.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar4.subProps,listMapping7)
	
	destMidVar4.value = src.Value
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	def destMidVar3 = dest.productInst
	
	destMidVar3.networkType = src.NetworkType
	
	destMidVar3.packageFlag = src.PackageFlag
	
	destMidVar3.parentProdId = src.ParentProdID
	
	destMidVar3.primaryFlag = src.PrimaryFlag
	
	destMidVar3.prodId = src.ProductID
	
	destMidVar3.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping6)
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.oCode = src.OfferingCode

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.effDate = parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.expDate = parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar8 = dest.property
	
	destMidVar8.propCode = src.PropCode
	
	destMidVar8.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar8.subProps,listMapping12)
	
	destMidVar8.value = src.Value
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	dest.oCode = src.OfferingCode

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

	dest.effDate = parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.expDate = parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar10 = dest.property
	
	destMidVar10.propCode = src.PropCode
	
	destMidVar10.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar10.subProps,listMapping16)
	
	destMidVar10.value = src.Value
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->

	def destMidVar9 = dest.productInst
	
	destMidVar9.networkType = src.NetworkType
	
	destMidVar9.packageFlag = src.PackageFlag
	
	destMidVar9.parentProdId = src.ParentProdID
	
	mappingList(src.PInstProperty,dest.properties,listMapping15)
	
	destMidVar9.primaryFlag = src.PrimaryFlag
	
	destMidVar9.prodId = src.ProductID
	
	destMidVar9.productType = src.ProductType
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	dest.oCode = src.OfferingCode

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	def destMidVar7 = dest.offeringInst
	
	def srcMidVar10 = src.ActivationTime
	
	destMidVar7.activeTime = parseDate(srcMidVar10.ActiveTime,Constant4Model.DATE_FORMAT)    
	
	destMidVar7.activeTimeLimit = parseDate(srcMidVar10.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	destMidVar7.activeMode = srcMidVar10.Mode
	
	destMidVar7.bundleFlag = src.BundledFlag
	
	def srcMidVar11 = src.EffectiveTime
	
	dest.effMode = srcMidVar11.Mode
	
	dest.effDate = parseDate(srcMidVar11.Time,Constant4Model.DATE_FORMAT)
	
	dest.expDate = parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	destMidVar7.offeringClass = src.OfferingClass
	
	def destMidVar18 = dest.offeringInst.offeringKey
	
	destMidVar18._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	listMapping10.call(src.OfferingKey,destMidVar18)
	
	mappingList(src.OInstProperty,dest.properties,listMapping11)
	
	def destMidVar13 = dest.offeringInst.parentOfferingKey
	
	destMidVar13._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	listMapping13.call(src.ParentOfferingKey,destMidVar13)
	
	mappingList(src.ProductInst,dest.productInsts,listMapping14)
	
	def destMidVar16 = dest.offeringInst.relGOfferingKey
	
	destMidVar16._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	listMapping17.call(src.RelGOfferingKey,destMidVar16)
	
	destMidVar7.status = src.Status
	
	destMidVar7.trialEndTime = parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
	destMidVar7.trialStartTime = parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	dest._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	dest.oCode = src.OfferingCode

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	nameValueListToObject(src.AdditionalProperty,dest.additionalProperty,"Value","Code")
	
	def destMidVar12 = dest.additionalProperty.simplePropertyList[0]
	
	def srcMidVar12 = src.AdditionalProperty[0]
	
	destMidVar12.code = srcMidVar12.Code
	
	destMidVar12.value = srcMidVar12.Value
	
  dest.expirationTime = parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	listMapping19.call(src.OfferingKey,dest.offeringKeyInfo)
	
	mappingList(src.OInstProperty,dest.oInstPropertys,listMapping11)	

}


def listMapping23

listMapping23 = 
{
    src,dest  ->
    
  	dest.oCode = src.OfferingCode

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}


def listMapping21

listMapping21 = 
{
    src,dest  ->
    
  	dest.oCode = src.OfferingCode

	dest.oId = src.OfferingID
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping20

listMapping20 = 
{
    src,dest  ->

	dest._class = "com.huawei.ngcbs.cm.subscriber.changesuboffering.io.ModifyOfferingInstInfoExt"

	dest.effDate = parseDate(src.NewEffectiveTime,Constant4Model.DATE_FORMAT)
	
	def srcMidVar13 = src.NewExpirationTime
	
	dest.expMode = srcMidVar13.Mode
	
	dest.expDate = parseDate(srcMidVar13.Time,Constant4Model.DATE_FORMAT)

	dest.extendOfferingHours = src.ExtendOfferingHours

	dest.newPurchaseSeq = src.NewPurchaseSeq
	
	def destMidVar17 = dest.offeringKey
	
	destMidVar17._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	listMapping21.call(src.OfferingKey,destMidVar17)
	
}

def listMapping22

listMapping22 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.ChangeSubOfferingRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar.AccessMode

def srcMidVar0 = srcArgs0.ChangeSubOfferingRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar0.LoginSystemCode

destArgs0.password = srcMidVar0.Password

destArgs0.remoteAddress = srcMidVar0.RemoteIP

mappingList(srcMidVar.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar.BusinessCode

destArgs0.messageSeq = srcMidVar.MessageSeq

destArgs0.msgLanguageCode = srcMidVar.MsgLanguageCode

def srcMidVar1 = srcArgs0.ChangeSubOfferingRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.ChangeSubOfferingRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.ChangeSubOfferingRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar.Version

def destMidVar = destArgs1.changeSubOfferingInfo.newPrimaryOffering

def srcMidVar4 = srcArgs0.ChangeSubOfferingRequestMsg.ChangeSubOfferingRequest.PrimaryOffering.EffectiveTime

destMidVar.effMode = srcMidVar4.Mode

destMidVar.effDate = parseDate(srcMidVar4.Time,Constant4Model.DATE_FORMAT)

def destMidVar0 = destArgs1.changeSubOfferingInfo.subBrand

def srcMidVar5 = srcArgs0.ChangeSubOfferingRequestMsg.ChangeSubOfferingRequest.PrimaryOffering

destMidVar0.brand = srcMidVar5.NewBrand

def destMidVar1 = destArgs1.changeSubOfferingInfo.newPrimaryOffering.offeringInst

def srcMidVar6 = srcArgs0.ChangeSubOfferingRequestMsg.ChangeSubOfferingRequest.PrimaryOffering.NewPrimaryOffering

if(isNotNull(srcMidVar6))
{
	def destMidVar19 = destArgs1.changeSubOfferingInfo.newPrimaryOffering.offeringInst.offeringKey
    
	destMidVar19._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
        
	listMapping3.call(srcMidVar6.OfferingKey,destMidVar19)
    
	def destMidVar20 = destArgs1.changeSubOfferingInfo.newPrimaryOffering.offeringInst.parentOfferingKey
    
	destMidVar20._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	listMapping4.call(srcMidVar6.ParentOfferingKey,destMidVar20)
}

destMidVar1.bundleFlag = srcMidVar6.BundledFlag

destMidVar1.offeringClass = srcMidVar6.OfferingClass

mappingList(srcMidVar6.OfferingInstProperty,destMidVar.properties,listMapping1)

mappingList(srcMidVar6.ProductInst,destMidVar.productInsts,listMapping5)

destMidVar1.status = srcMidVar6.Status

destMidVar1.trialEndTime = parseDate(srcMidVar6.TrialEndTime,Constant4Model.DATE_FORMAT)

destMidVar1.trialStartTime = parseDate(srcMidVar6.TrialStartTime,Constant4Model.DATE_FORMAT)

def destMidVar5 = destArgs1.changeSubOfferingInfo.oldPrimaryOffering

destMidVar5._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

def destMidVar6 = destArgs1.changeSubOfferingInfo

listMapping19.call(srcMidVar5.OldPrimaryOffering,destMidVar5)

def srcMidVar7 = srcArgs0.ChangeSubOfferingRequestMsg.ChangeSubOfferingRequest.PrimaryOffering.OldPrimaryOffering

def srcMidVar8 = srcArgs0.ChangeSubOfferingRequestMsg.ChangeSubOfferingRequest

listMapping8.call(srcMidVar8.SubAccessCode,destArgs1.subAccessCode)

def srcMidVar9 = srcArgs0.ChangeSubOfferingRequestMsg.ChangeSubOfferingRequest.SupplementaryOffering

mappingList(srcMidVar9.AddOffering,destMidVar6.addSuppOfferings,listMapping9)

def destMidVar11 = destArgs1.delSupplementOfferingInfo

mappingList(srcMidVar9.DelOffering,destMidVar11.delSupplementOfferingInfos,listMapping18)

mappingList(srcMidVar9.ModifyOffering,destMidVar6.modifySuppOfferings,listMapping20)


destArgs1.handlingChargeFlag = srcMidVar8.HandlingChargeFlag

destArgs1.newPOPurchaseSeq = srcMidVar8.NewPOPurchaseSeq

def destFeeReservationSupport = destArgs1.feeReservationSupport

destFeeReservationSupport.serviceTransactionId = srcMidVar8.ServiceTransactionID

destArgs1.operationCode = srcMidVar8.OperationCode

def srcMidVar14 = srcArgs0.ChangeSubOfferingRequestMsg.ChangeSubOfferingRequest.AdditionalProperty

mappingList(srcMidVar14,destArgs1.simplePropertyList,listMapping22)

def listMapping_AddiPropDeductL

listMapping_AddiPropDeductL = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping_TaxInfoDeductL

listMapping_TaxInfoDeductL = 
{
    src,dest  ->

	dest.taxCode = src.TaxCode
	
	dest.taxAmt = src.TaxAmount
	
}

def listMapping_deductInfoL

listMapping_deductInfoL = 
{
    src,dest  ->

	dest.chargeAmt = src.ChargeAmt
	
	dest.chargeCode = src.ChargeCode
	
	dest.currencyId = src.CurrencyID
	
	dest.discountAmt = src.DiscountAmt
	
	dest.invoiceTime = src.InvoiceTime
	
	dest.salesTime = src.SalesTime
	
	dest.waiveAmt = src.WaiveAmt
	
	dest.additionalInfo = src.AdditionalInfo
	
	mappingList(src.AdditionalProperty,dest.simplePropertyList,listMapping_AddiPropDeductL)
	
	mappingList(src.Tax,dest.taxInfoList,listMapping_TaxInfoDeductL)
	
}

def listMapping30

listMapping30 =
{
    src,dest  ->

	dest.salesChannelId = src.SalesChannelID
	
	dest.salesId = src.SalesID
	
}

def srcMidVar_FeeDeduction = srcArgs0.ChangeSubOfferingRequestMsg.ChangeSubOfferingRequest.DeductInfo

mappingList(srcMidVar_FeeDeduction,destArgs1.deductInfoList,listMapping_deductInfoL)

def srcMidVar_SalesInfo = srcArgs0.ChangeSubOfferingRequestMsg.ChangeSubOfferingRequest.SalesInfo
listMapping30.call(srcMidVar_SalesInfo,destArgs1.salesInfo)

def listMapping31

listMapping31 =
{
	src, dest ->

	def destOfferingKey = dest.changeOfferingPropertyInfo.offeringKey

	listMapping19.call(src,destOfferingKey)

	mappingList(src.OInstProperty,dest.changeOfferingPropertyInfo.addOfferingInstProperties,listMapping1)
}

listMapping31.call(srcMidVar5.OldPrimaryOffering,destArgs1.changeOldPrimaryOfferingPropInfo)
