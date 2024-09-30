import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("SubscriberService","batchCreateSubscriber")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.batch.createsubscriber.io.BatchCreateSubscriberRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

				dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
				dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar6 = dest.property
	
	destMidVar6.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar6.subProps,listMapping6)
	
	destMidVar6.propCode = src.PropCode
	
	destMidVar6.complexFlag = src.PropType
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

				dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
				dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar7 = dest.property
	
	destMidVar7.propCode = src.PropCode
	
	destMidVar7.complexFlag = src.PropType
	
	destMidVar7.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar7.subProps,listMapping9)
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	mappingList(src.PInstProperty,dest.properties,listMapping8)
	
	def destMidVar8 = dest.productInst
	
	destMidVar8.networkType = src.NetworkType
	
	destMidVar8.packageFlag = src.PackageFlag
	
	destMidVar8.parentProdId = src.ParentProdID
	
	destMidVar8.primaryFlag = src.PrimaryFlag
	
	destMidVar8.prodId = src.ProductID
	
	destMidVar8.productType = src.ProductType
	
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

				dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
				dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar17 = dest.property
	
	destMidVar17.complexFlag = src.PropType
	
	destMidVar17.propCode = src.PropCode
	
	destMidVar17.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar17.subProps,listMapping12)
	
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

				dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
				dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar19 = dest.property
	
	destMidVar19.propCode = src.PropCode
	
	destMidVar19.complexFlag = src.PropType
	
	destMidVar19.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar19.subProps,listMapping15)
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	def destMidVar18 = dest.productInst
	
	destMidVar18.networkType = src.NetworkType
	
	destMidVar18.packageFlag = src.PackageFlag
	
	destMidVar18.parentProdId = src.ParentProdID
	
	destMidVar18.primaryFlag = src.PrimaryFlag
	
	destMidVar18.prodId = src.ProductID
	
	destMidVar18.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping14)
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

				dest.addOfferingInstInfo.offeringInst.activeTime=parseDate(src.ActivationTime.ActiveTime,Constant4Model.DATE_FORMAT)
	
				dest.addOfferingInstInfo.offeringInst.activeTimeLimit=parseDate(src.ActivationTime.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	def destMidVar11 = dest.addOfferingInstInfo.offeringInst
	
	def srcMidVar11 = src.ActivationTime
	
	destMidVar11.activeMode = srcMidVar11.Mode
	
	destMidVar11.bundleFlag = src.BundledFlag
	
	dest.acctPayMode = src.AcctPaymentMode
	
	def destMidVar12 = dest.addOfferingInstInfo
	
	def srcMidVar12 = src.EffectiveTime
	
	destMidVar12.effMode = srcMidVar12.Mode
	
				destMidVar12.effDate=parseDate(srcMidVar12.Time,Constant4Model.DATE_FORMAT)
	
				destMidVar12.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	destMidVar11.offeringClass = src.OfferingClass
	
	def destMidVar13 = dest.addOfferingInstInfo.offeringInst.offeringKey
	
	destMidVar13._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	def srcMidVar13 = src.OfferingKey
	
	destMidVar13.oId = srcMidVar13.OfferingID
	
	destMidVar13.oCode = srcMidVar13.OfferingCode
	
	destMidVar13.pSeq = srcMidVar13.PurchaseSeq
	
	def destMidVar14 = dest.addOfferingInstInfo.offeringInst.parentOfferingKey
	
	destMidVar14._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	def srcMidVar14 = src.ParentOfferingKey
	
	destMidVar14.oId = srcMidVar14.OfferingID
	
	destMidVar14.oCode = srcMidVar14.OfferingCode
	
	destMidVar14.pSeq = srcMidVar14.PurchaseSeq
	
				destMidVar11.trialEndTime=parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
				destMidVar11.trialStartTime=parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
	
	destMidVar11.status = src.Status
	
	def destMidVar15 = dest.addOfferingInstInfo.offeringInst.relGOfferingKey
	
	destMidVar15._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	def srcMidVar15 = src.RelGOfferingKey
	
	destMidVar15.oId = srcMidVar15.OfferingID
	
	destMidVar15.oCode = srcMidVar15.OfferingCode
	
	destMidVar15.pSeq = srcMidVar15.PurchaseSeq
	
	def destMidVar16 = dest.opObjInfo
	
	destMidVar16.opObjType = src.OwnerType
	
	mappingList(src.OInstProperty,destMidVar12.properties,listMapping11)
	
	mappingList(src.ProductInst,destMidVar12.productInsts,listMapping13)
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->
  dest._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitExtInfo"
	dest.limitType = src.LimitType
	
	def destMidVar25 = dest.valueInfo
	
	destMidVar25.amount = src.LimitValue
	
	dest.limitPlanCode = src.LimitPlanCode
}

def listMapping20

listMapping20 = 
{
    src,dest  ->

	dest.code = src.BMCode
	
	dest.type = src.BMType
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	mappingList(src.AcctProperty,dest.properties,listMapping18)
	
	dest.billCycleType = src.BillCycleType
	
	def destMidVar24 = dest.accountInfo
	
	destMidVar24.billLang = src.BillLang
	
	mappingList(src.CreditLimit,dest.creditLimits,listMapping19)
	
	destMidVar24.currencyId = src.CurrencyID
	
	destMidVar24.dunningFlag = src.DunningFlag
	
	mappingList(src.FreeBillMedium,destMidVar24.bmInfos,listMapping20)
	
	dest.initBalance = src.InitBalance
	
	destMidVar24.paymentType = src.PaymentType
	
	destMidVar24.latePaymentFlag = src.LateFeeChargeable
	
}

def listMapping22

listMapping22 = 
{
    src,dest  ->

	dest.code = src.ParamCode
	
	dest.value = src.ParamValue
	
}


def listMapping21

listMapping21 = 
{
    src,dest  ->

	def destMidVar26 = dest.spendingLimitInfo.currencyLimit
	
	destMidVar26.currencyId = src.CurrencyID
	
	def destMidVar27 = dest.spendingLimitInfo
	
	destMidVar27.limitType = src.LimitType
	
	destMidVar27.unitType = src.UnitType
	
	def destMidVar28 = dest.spendingLimitInfo.usageLimit
	
	destMidVar28.limitValue = src.LimitValue
	
	destMidVar28.measureId = src.MesureID
	
	destMidVar28.measureType = src.MesureType
	
	destMidVar26.limitValue = src.LimitValue
	
	mappingList(src.LimitParam,dest.spdlmtParamInfos,listMapping22)
	
}

def srcMidVar = srcArgs0.BatchCreateSubscriberRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar.BEID

destArgs0.brId = srcMidVar.BRID

def srcMidVar0 = srcArgs0.BatchCreateSubscriberRequestMsg.RequestHeader

destArgs0.businessCode = srcMidVar0.BusinessCode

def srcMidVar1 = srcArgs0.BatchCreateSubscriberRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.BatchCreateSubscriberRequestMsg.RequestHeader.AccessSecurity

destArgs0.password = srcMidVar2.Password

def destMidVar = destArgs0.simpleProperty[0]

def srcMidVar3 = srcArgs0.BatchCreateSubscriberRequestMsg.RequestHeader.AdditionalProperty[0]

destMidVar.code = srcMidVar3.Code

destMidVar.value = srcMidVar3.Value

def srcMidVar4 = srcArgs0.BatchCreateSubscriberRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar4.TimeType

destArgs0.timeZoneId = srcMidVar4.TimeZoneID

destArgs0.version = srcMidVar0.Version

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

destArgs0.remoteAddress = srcMidVar2.RemoteIP

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

def srcMidVar5 = srcArgs0.BatchCreateSubscriberRequestMsg.BatchCreateSubscriberRequest

destArgs1.requestFileName = srcMidVar5.FileName

def destMidVar0 = destArgs1.registrationInfo.regCustomerInfo.customerInfo

def srcMidVar6 = srcArgs0.BatchCreateSubscriberRequestMsg.BatchCreateSubscriberRequest.Customer

destMidVar0.custLevel = srcMidVar6.CustLevel

destMidVar0.custLoyalty = srcMidVar6.CustLoyalty

def destMidVar1 = destArgs1.registrationInfo.regCustomerInfo

mappingList(srcMidVar6.CustProperty,destMidVar1.custProperties,listMapping4)

destMidVar0.custSegment = srcMidVar6.CustSegment

destMidVar0.custType = srcMidVar6.CustType

destMidVar0.billCycleType = srcMidVar6.DFTBillCycleType

destMidVar0.currencyId = srcMidVar6.DFTCurrencyID

destMidVar0.custPLang = srcMidVar6.DFTIVRLang

destMidVar0.custPwd = srcMidVar6.DFTPwd

destMidVar0.custWLang = srcMidVar6.DFTWrittenLang

destMidVar0.dunningFlag = srcMidVar6.DunningFlag

def destMidVar2 = destArgs1.registrationInfo.createSubscriberInfo.primaryOffering.offeringInst

def srcMidVar7 = srcArgs0.BatchCreateSubscriberRequestMsg.BatchCreateSubscriberRequest.PrimaryOffering

destMidVar2.bundleFlag = srcMidVar7.BundledFlag

destMidVar2.offeringClass = srcMidVar7.OfferingClass

def destMidVar3 = destArgs1.registrationInfo.createSubscriberInfo.primaryOffering.offeringInst.offeringKey

destMidVar3._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

def srcMidVar8 = srcArgs0.BatchCreateSubscriberRequestMsg.BatchCreateSubscriberRequest.PrimaryOffering.OfferingKey

destMidVar3.oId = srcMidVar8.OfferingID

destMidVar3.oCode = srcMidVar8.OfferingCode

destMidVar3.pSeq = srcMidVar8.PurchaseSeq

def destMidVar4 = destArgs1.registrationInfo.createSubscriberInfo.primaryOffering.offeringInst.parentOfferingKey

destMidVar4._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

def srcMidVar9 = srcArgs0.BatchCreateSubscriberRequestMsg.BatchCreateSubscriberRequest.PrimaryOffering.ParentOfferingKey

destMidVar4.oId = srcMidVar9.OfferingID

destMidVar4.oCode = srcMidVar9.OfferingCode

destMidVar4.pSeq = srcMidVar9.PurchaseSeq

destMidVar2.status = srcMidVar7.Status

destMidVar2.trialEndTime=parseDate(srcMidVar5.PrimaryOffering.TrialEndTime,Constant4Model.DATE_FORMAT)

destMidVar2.trialStartTime=parseDate(srcMidVar5.PrimaryOffering.TrialStartTime,Constant4Model.DATE_FORMAT)

def destMidVar5 = destArgs1.registrationInfo.createSubscriberInfo.primaryOffering

mappingList(srcMidVar7.OfferingInstProperty,destMidVar5.properties,listMapping5)

mappingList(srcMidVar7.ProductInst,destMidVar5.productInsts,listMapping7)

def destMidVar9 = destArgs1.registrationInfo.salesInfo

def srcMidVar10 = srcArgs0.BatchCreateSubscriberRequestMsg.BatchCreateSubscriberRequest.SalesInfo

destMidVar9.salesChannelId = srcMidVar10.SalesChannelID

destMidVar9.salesId = srcMidVar10.SalesID

def destMidVar10 = destArgs1.registrationInfo

mappingList(srcMidVar5.SupplementaryOffering,destMidVar10.supplementaryOfferings,listMapping10)

destMidVar10.createSubscriberInfo.subscriberInfo.activeTimeLimit=parseDate(srcMidVar5.Subscriber.ActiveTimeLimit,Constant4Model.DATE_FORMAT)

def destMidVar20 = destArgs1.registrationInfo.createSubscriberInfo.subBrandInfo

def srcMidVar16 = srcArgs0.BatchCreateSubscriberRequestMsg.BatchCreateSubscriberRequest.Subscriber

destMidVar20.brand = srcMidVar16.Brand

def destMidVar21 = destArgs1.registrationInfo.createSubscriberInfo.subscriberInfo

destMidVar21.networkType = srcMidVar16.NetworkType

destMidVar21.subClass = srcMidVar16.SubClass

def destMidVar22 = destArgs1.registrationInfo.subPaymentMode

destMidVar22.paymentMode = srcMidVar16.PaymentMode

destMidVar21.subPassword = srcMidVar16.SubPassword

destMidVar21.priIdenType = srcMidVar16.PrimaryIdentityType

def srcMidVar17 = srcArgs0.BatchCreateSubscriberRequestMsg.BatchCreateSubscriberRequest.Subscriber.SubBasicInfo

destMidVar21.dunningFlag = srcMidVar17.DunningFlag

destMidVar21.ivrLang = srcMidVar17.IVRLang

destMidVar21.subLevel = srcMidVar17.SubLevel

destMidVar21.writtenLang = srcMidVar17.WrittenLang


def destMidVar23 = destArgs1.registrationInfo.createSubscriberInfo

mappingList(srcMidVar17.SubProperty,destMidVar23.subProperties,listMapping16)

destArgs0.interMode = srcMidVar0.AccessMode

mappingList(srcMidVar5.Account,destMidVar10.createAccountInfos,listMapping17)

mappingList(srcMidVar16.CreditLimit,destMidVar10.creditLimits,listMapping19)

destMidVar23.status = srcMidVar16.Status

mappingList(srcMidVar16.ConsumptionLimit,destMidVar23.consumptionLimits,listMapping21)

mappingList(srcMidVar5.AdditionalProperty,destMidVar10.simplePropertyList,listMapping4)

def srcMidVar18 = srcArgs0.BatchCreateSubscriberRequestMsg.BatchCreateSubscriberRequest.UserCustomer

def destMidVar24 = destArgs1.registrationInfo.userCustomerInfo.customerInfo

destMidVar24.custType = srcMidVar18.CustType

destMidVar24.custSegment = srcMidVar18.CustSegment

destMidVar24.custPwd = srcMidVar18.DFTPwd

destMidVar24.custWLang = srcMidVar18.DFTWrittenLang

destMidVar24.custPLang = srcMidVar18.DFTIVRLang

destMidVar24.billCycleType = srcMidVar18.DFTBillCycleType

destMidVar24.currencyId = srcMidVar18.DFTCurrencyID

destMidVar24.custLevel = srcMidVar18.CustLevel

destMidVar24.custLoyalty = srcMidVar18.CustLoyalty

destMidVar24.dunningFlag = srcMidVar18.DunningFlag

def destMidVar25 = destArgs1.registrationInfo.userCustomerInfo

mappingList(srcMidVar18.CustProperty,destMidVar25.custProperties,listMapping4)