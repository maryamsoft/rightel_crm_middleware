import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("SubscriberService","changeSubPaymentMode")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.changesubpaymode.io.ChangeSubPaymentModeRequest"

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

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.code = src.BMCode
	
	dest.type = src.BMType
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.autoRechargeDate = src.AutoRechargeDate
	
	dest.periodType = src.PeriodType
	
	dest.autoRechargeAmt = src.AutoRechargeAmt
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.controlPeriodType = src.ControlPeriodType
	
	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.balanceThreshold = src.BalanceThreshold

	dest.maxTimes = src.MaxTimes

	dest.balanceThresholdType = src.BalanceThresholdType
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.autoPayDate = src.AutoPayDate
	
	dest.autoPayMaxAmt = src.AutoPayMaxAmt
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	listMapping7.call(src.TimeSchema,dest.timeSchema)
	
	dest.payType = src.AutoPayType
	
	listMapping8.call(src.LowBalanceSchema,dest.lowBalanceSchema)
	
	listMapping9.call(src.BillCycleSchema,dest.billCycleSchema)
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	def destMidVar3 = dest.paymentChannelInfo
	
	def srcMidVar9 = src.AutoPayChannelInfo
	
	destMidVar3.bankBranchCode = srcMidVar9.BankBranchCode
	
	destMidVar3.bankCode = srcMidVar9.BankCode
	
	destMidVar3.creditCardType = srcMidVar9.CreditCardType
	
	destMidVar3.cvvNumber = srcMidVar9.CVVNumber
	
	destMidVar3.paymentChannelKey = src.AutoPayChannelKey
	
	destMidVar3.priority = srcMidVar9.Priority
	
	mappingList(srcMidVar9.PaymentPlan,dest.paymentPlanInfos,listMapping6)
	
	dest.chargeCodes = srcMidVar9.ChargeCode
	
	destMidVar3.bankAcctName = srcMidVar9.AcctName
	
	destMidVar3.bankAcctNo = srcMidVar9.AcctNo
	
	destMidVar3.bankAcctType = srcMidVar9.AcctType
	
	destMidVar3.bankAcctExpDate = srcMidVar9.ExpDate

	destMidVar3.effMode = srcMidVar9.EffectiveTime.Mode

	destMidVar3.effDate = parseDate(srcMidVar9.EffectiveTime.Time,Constant4Model.DATE_FORMAT)

	destMidVar3.expDate = parseDate(srcMidVar9.ExpireTime,Constant4Model.DATE_FORMAT)

	mappingList(srcMidVar9.AdditionalProperty,destMidVar3.paymentChannelProp,listMapping1)
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	def srcMidVar11 = src.PaymentLimitInfo
	
	dest.limitCycleType = srcMidVar11.LimitCycleType
	
	dest.limitRule = srcMidVar11.LimitRule
	
	def srcMidVar12 = src.PaymentLimitInfo.Limit
	
	dest.limitType = srcMidVar12.LimitType
	
	dest.limitValueType = srcMidVar12.LimitValueType
	
	dest.limitMeasureUnit = srcMidVar12.LimitMeasureUnit
	
	dest.limitValue = srcMidVar12.LimitValue
	
	dest.limitKey = src.PaymentLimitKey
	
	dest.cBonusFlag = srcMidVar11.CBonusFlag
	
	dest.currencyId = srcMidVar11.CurrencyID
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.acctKey = src.AcctKey
	
	def destMidVar4 = dest.paymentRelation
	
	def srcMidVar13 = src.PayRelExtRule
	
	destMidVar4.chargeCode = srcMidVar13.ChargeCode
	
	destMidVar4.paymentLimitKey = src.PaymentLimitKey
	
	destMidVar4.priority = src.Priority
	
	def destMidVar5 = dest.paymentRelation.offeringKey
	
	def srcMidVar14 = src.PayRelExtRule.OfferingKey
	
	destMidVar5.oId = srcMidVar14.OfferingID
	
	destMidVar5.oCode = srcMidVar14.OfferingCode
	
	destMidVar5.pSeq = srcMidVar14.PurchaseSeq
	
	destMidVar4.paymentRelationKey = src.PayRelationKey
	
	destMidVar4.finalFlag = src.OnlyPayRelFlag
	
	destMidVar4.extRuleCode = srcMidVar13.ControlRule
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	dest.paymentRelationKey = src.PayRelationKey
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	dest.dftAcctKey = src.DFTAcctKey
	
	dest.postpaidAcctKey = src.PostPaidAcctKey
	
	dest.prepaidAcctKey = src.PrePaidAcctKey
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->

	dest.dftAcctKey = src.DFTAcctKey
	
	dest.postpaidAcctKey = src.PostPaidAcctKey
	
	dest.prepaidAcctKey = src.PrePaidAcctKey
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

	def destMidVar6 = dest.owner
	
	def srcMidVar17 = src.OfferingOwner
	
	destMidVar6.ownerKey = srcMidVar17.OwnerKey
	
	destMidVar6.ownerType = srcMidVar17.OwnerType
	
	def destMidVar7 = dest.offeringKeyInfo
	
	def srcMidVar18 = src.OfferingKey
	
	destMidVar7.oId = srcMidVar18.OfferingID
	
	destMidVar7.oCode = srcMidVar18.OfferingCode
	
	destMidVar7.pSeq = srcMidVar18.PurchaseSeq
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	def destMidVar8 = dest.owner
	
	def srcMidVar19 = src.OfferingOwner
	
	destMidVar8.ownerKey = srcMidVar19.OwnerKey
	
	destMidVar8.ownerType = srcMidVar19.OwnerType
	
	def destMidVar9 = dest.modifyOfferingInstInfo
	
	def srcMidVar20 = src.NewExpirationTime
	
	destMidVar9.expMode = srcMidVar20.Mode
	
			destMidVar9.expDate=parseDate(srcMidVar20.Time,Constant4Model.DATE_FORMAT)
	
			destMidVar9.effDate=parseDate(src.NewEffectiveTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar10 = dest.modifyOfferingInstInfo.offeringKey
	
	def srcMidVar21 = src.OfferingKey
	
	destMidVar10.oId = srcMidVar21.OfferingID
	
	destMidVar10.oCode = srcMidVar21.OfferingCode
	
	destMidVar10.pSeq = srcMidVar21.PurchaseSeq
	
}

def listMapping27

listMapping27 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar17 = dest.property
	
	destMidVar17.propCode = src.PropCode
	
	destMidVar17.complexFlag = src.PropType
	
	destMidVar17.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar17.subProps,listMapping27)
	
}

def listMapping28

listMapping28 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping20

listMapping20 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar19 = dest.property
	
	destMidVar19.propCode = src.PropCode
	
	destMidVar19.complexFlag = src.PropType
	
	destMidVar19.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar19.subProps,listMapping28)
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	def destMidVar18 = dest.productInst
	
	destMidVar18.networkType = src.NetworkType
	
	destMidVar18.packageFlag = src.PackageFlag
	
	destMidVar18.productType = src.ProductType
	
	destMidVar18.parentProdId = src.ParentProdID
	
	destMidVar18.primaryFlag = src.PrimaryFlag
	
	destMidVar18.prodId = src.ProductID
	
	mappingList(src.PInstProperty,dest.properties,listMapping20)
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	def destMidVar11 = dest.addOfferingInstInfo.offeringInst
	
	destMidVar11.offeringClass = src.OfferingClass
	
	destMidVar11.status = src.Status
	
	def destMidVar12 = dest.owner
	
	def srcMidVar22 = src.OfferingOwner
	
	destMidVar12.ownerKey = srcMidVar22.OwnerKey
	
	destMidVar12.ownerType = srcMidVar22.OwnerType
	
			destMidVar11.activeTime=parseDate(src.ActivationTime.ActiveTime,Constant4Model.DATE_FORMAT)
	
			destMidVar11.activeTimeLimit=parseDate(src.ActivationTime.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	def srcMidVar23 = src.ActivationTime
	
	destMidVar11.activeMode = srcMidVar23.Mode
	
	destMidVar11.bundleFlag = src.BundledFlag
	
	def destMidVar13 = dest.addOfferingInstInfo
	
	def srcMidVar24 = src.EffectiveTime
	
	destMidVar13.effMode = srcMidVar24.Mode
	
			destMidVar13.effDate=parseDate(srcMidVar24.Time,Constant4Model.DATE_FORMAT)
	
			destMidVar13.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar14 = dest.addOfferingInstInfo.offeringInst.offeringKey
	
	def srcMidVar25 = src.OfferingKey
	
	destMidVar14.oId = srcMidVar25.OfferingID
	
	destMidVar14.oCode = srcMidVar25.OfferingCode
	
	destMidVar14.pSeq = srcMidVar25.PurchaseSeq
	
	def destMidVar15 = dest.addOfferingInstInfo.offeringInst.parentOfferingKey
	
	def srcMidVar26 = src.ParentOfferingKey
	
	destMidVar15.oId = srcMidVar26.OfferingID
	
	destMidVar15.oCode = srcMidVar26.OfferingCode
	
	destMidVar15.pSeq = srcMidVar26.PurchaseSeq
	
			destMidVar11.trialEndTime=parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
			destMidVar11.trialStartTime=parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar16 = dest.addOfferingInstInfo.offeringInst.relGOfferingKey
	
	def srcMidVar27 = src.RelGOfferingKey
	
	destMidVar16.oId = srcMidVar27.OfferingID
	
	destMidVar16.oCode = srcMidVar27.OfferingCode
	
	destMidVar16.pSeq = srcMidVar27.PurchaseSeq
	
	mappingList(src.OInstProperty,destMidVar13.properties,listMapping18)
	
	mappingList(src.ProductInst,destMidVar13.productInsts,listMapping19)
	
}

def listMapping23

listMapping23 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping22

listMapping22 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar26 = dest.property
	
	destMidVar26.propCode = src.PropCode
	
	destMidVar26.complexFlag = src.PropType
	
	destMidVar26.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar26.subProps,listMapping23)
	
}

def listMapping26

listMapping26 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping25

listMapping25 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar28 = dest.property
	
	destMidVar28.propCode = src.PropCode
	
	destMidVar28.complexFlag = src.PropType
	
	destMidVar28.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar28.subProps,listMapping26)
	
}

def listMapping24

listMapping24 = 
{
    src,dest  ->

	def destMidVar27 = dest.productInst
	
	destMidVar27.networkType = src.NetworkType
	
	destMidVar27.packageFlag = src.PackageFlag
	
	destMidVar27.parentProdId = src.ParentProdID
	
	destMidVar27.primaryFlag = src.PrimaryFlag
	
	destMidVar27.prodId = src.ProductID
	
	destMidVar27.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping25)
	
}

def listMapping29

listMapping29 = 
{
    src,dest  ->

	dest.addr1 = src.Address1
	
	dest.addr10 = src.Address10
	
	dest.addr11 = src.Address11
	
	dest.addr12 = src.Address12
	
	dest.addr2 = src.Address2
	
	dest.addr3 = src.Address3
	
	dest.addr4 = src.Address4
	
	dest.addr5 = src.Address5
	
	dest.addr6 = src.Address6
	
	dest.addr7 = src.Address7
	
	dest.addr8 = src.Address8
	
	dest.addr9 = src.Address9
	
	dest.postCode = src.PostCode
	
	dest.tpAddrKey = src.AddressKey
	
}

def listMapping30

listMapping30 = 
{
    src,dest  ->
  dest._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitExtInfo"
	dest.limitType = src.LimitType
	
	def destMidVar29 = dest.valueInfo
	
	destMidVar29.amount = src.LimitValue
	
	dest.limitPlanCode = src.LimitPlanCode
}

def listMapping31

listMapping31 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.ChangeSubPaymentModeRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar.LoginSystemCode

destArgs0.password = srcMidVar.Password

destArgs0.remoteAddress = srcMidVar.RemoteIP

def srcMidVar0 = srcArgs0.ChangeSubPaymentModeRequestMsg.RequestHeader

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar0.BusinessCode

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

def srcMidVar1 = srcArgs0.ChangeSubPaymentModeRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.ChangeSubPaymentModeRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.ChangeSubPaymentModeRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZone = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

def srcMidVar4 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest

mappingList(srcMidVar4.ControlProperty,destArgs1.controlProperties,listMapping1)

def destMidVar = destArgs1.changeSubPaymentModeInfo

destMidVar.opType = srcMidVar4.OpType

listMapping2.call(srcMidVar4.SubAccessCode,destArgs1.subAccessCode)

def destMidVar0 = destArgs1.accountInfo.accountInfo

def srcMidVar5 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.Account

destMidVar0.acctKey = srcMidVar5.AcctKey

def srcMidVar6 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.Account.AccountInfo.AcctBasicInfo

destMidVar0.acctName = srcMidVar6.AcctName

def destMidVar1 = destArgs1.accountInfo

mappingList(srcMidVar6.AcctProperty,destMidVar1.properties,listMapping3)

destMidVar0.billLang = srcMidVar6.BillLang

def destMidVar2 = destArgs1.accountInfo.contactInfo

def srcMidVar7 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.Account.AccountInfo.AcctBasicInfo.ContactInfo

destMidVar2.addrKey = srcMidVar7.AddressKey

destMidVar2.email = srcMidVar7.Email

destMidVar2.fax = srcMidVar7.Fax

destMidVar2.firstName = srcMidVar7.FirstName

destMidVar2.homePhone = srcMidVar7.HomePhone

destMidVar2.lastName = srcMidVar7.LastName

destMidVar2.middleName = srcMidVar7.MiddleName

destMidVar2.mobilePhone = srcMidVar7.MobilePhone

destMidVar2.officePhone = srcMidVar7.OfficePhone

destMidVar2.title = srcMidVar7.Title

destMidVar0.dunningFlag = srcMidVar6.DunningFlag

mappingList(srcMidVar6.FreeBillMedium,destMidVar0.bmInfos,listMapping4)

destMidVar0.latePaymentFlag = srcMidVar6.LateFeeChargeable

def srcMidVar8 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.Account.AccountInfo

destMidVar0.acctClass = srcMidVar8.AcctClass

destMidVar0.acctCode = srcMidVar8.AcctCode

destMidVar0.acctPaymentMethod = srcMidVar8.AcctPayMethod

destMidVar0.acctType = srcMidVar8.AcctType

destMidVar1.billCycleType = srcMidVar8.BillCycleType

mappingList(srcMidVar8.AutoPayChannel,destMidVar1.paymentChannels,listMapping5)

destMidVar1.initBalance = srcMidVar8.InitBalance

destMidVar0.paymentType = srcMidVar8.PaymentType

destMidVar0.parentAcctKey = srcMidVar8.ParentAcctKey

destMidVar0.currencyId = srcMidVar8.CurrencyID

def srcMidVar10 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.DFTPayRelation

mappingList(srcMidVar10.PaymentLimit,destArgs1.paymentLimits,listMapping10)

mappingList(srcMidVar10.AddPayRelation,destArgs1.addPaymentRelations,listMapping11)

mappingList(srcMidVar10.DelPayRelation,destArgs1.delPaymentRelations,listMapping12)

def srcMidVar15 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.SubDFTAccount

listMapping13.call(srcMidVar15.NewDFTAcct,destMidVar.newSubDftAcct)

listMapping14.call(srcMidVar15.OldDFTAcct,destMidVar.oldSubDftAcct)

def srcMidVar16 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.SupplementaryOffering

mappingList(srcMidVar16.DelOffering,destMidVar.delSupplementOfferings,listMapping15)

mappingList(srcMidVar16.ModifyOffering,destMidVar.modifySupplementOfferings,listMapping16)

mappingList(srcMidVar16.AddOffering,destMidVar.newSupplementOfferings,listMapping17)

def destMidVar20 = destArgs1.changeSubPaymentModeInfo.oldPrimaryOffering

def srcMidVar28 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.PrimaryOffering.OldPrimaryOffering

destMidVar20.oId = srcMidVar28.OfferingID

destMidVar20.oCode = srcMidVar28.OfferingCode

destMidVar20.pSeq = srcMidVar28.PurchaseSeq

def destMidVar21 = destArgs1.changeSubPaymentModeInfo.newBrand

def srcMidVar29 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.PrimaryOffering

destMidVar21.brand = srcMidVar29.NewBrand

def destMidVar22 = destArgs1.changeSubPaymentModeInfo.newPrimaryOffering

def srcMidVar30 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.EffectiveTime

destMidVar22.effMode = srcMidVar30.Mode

destMidVar22.effDate=parseDate(srcMidVar30.Time,Constant4Model.DATE_FORMAT)

def destMidVar23 = destArgs1.changeSubPaymentModeInfo.newPrimaryOffering.offeringInst

def srcMidVar31 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.PrimaryOffering.NewPrimaryOffering

destMidVar23.status = srcMidVar31.Status

destMidVar.newPrimaryOffering.offeringInst.trialEndTime=parseDate(srcMidVar29.NewPrimaryOffering.TrialEndTime,Constant4Model.DATE_FORMAT)

destMidVar.newPrimaryOffering.offeringInst.trialStartTime=parseDate(srcMidVar29.NewPrimaryOffering.TrialStartTime,Constant4Model.DATE_FORMAT)

def destMidVar24 = destArgs1.changeSubPaymentModeInfo.newPrimaryOffering.offeringInst.parentOfferingKey

def srcMidVar32 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.PrimaryOffering.NewPrimaryOffering.ParentOfferingKey

destMidVar24.oId = srcMidVar32.OfferingID

destMidVar24.oCode = srcMidVar32.OfferingCode

destMidVar24.pSeq = srcMidVar32.PurchaseSeq

def destMidVar25 = destArgs1.changeSubPaymentModeInfo.newPrimaryOffering.offeringInst.offeringKey

def srcMidVar33 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange.PrimaryOffering.NewPrimaryOffering.OfferingKey

destMidVar25.oId = srcMidVar33.OfferingID

destMidVar25.oCode = srcMidVar33.OfferingCode

destMidVar25.pSeq = srcMidVar33.PurchaseSeq

destMidVar23.bundleFlag = srcMidVar31.BundledFlag

destMidVar23.offeringClass = srcMidVar31.OfferingClass

mappingList(srcMidVar31.OfferingInstProperty,destMidVar22.properties,listMapping22)

mappingList(srcMidVar31.ProductInst,destMidVar22.productInsts,listMapping24)

destArgs0.interMode = srcMidVar0.AccessMode

destMidVar1.uCustKey = srcMidVar8.UserCustomerKey

destMidVar1.redlistFlag = srcMidVar6.RedlistFlag

def srcMidVar34 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.PaymentModeChange

listMapping29.call(srcMidVar34.AddressInfo,destArgs1.address)

mappingList(srcMidVar8.CreditLimit,destMidVar1.creditLimits,listMapping30)

def srcMidVar35 = srcArgs0.ChangeSubPaymentModeRequestMsg.ChangeSubPaymentModeRequest.AdditionalProperty

mappingList(srcMidVar35,destArgs1.simplePropertyList,listMapping31)

