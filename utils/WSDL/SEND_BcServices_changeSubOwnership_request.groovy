import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("SubscriberService","changeSubOwnershipWithResult")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.changeownership.io.ChangeSubOwnershipRequest"

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

	dest.postCode = src.PostCode
	
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
	
	dest.tpAddrKey = src.AddressKey
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.channelType = src.ChannelType
	
	dest.noticeType = src.NoticeType
	
	dest.subNoticeType = src.SubNoticeType
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.custClass = src.CustClass
	
	dest.custCode = src.CustCode
	
	def srcMidVar13 = src.CustBasicInfo
	
	dest.custLevel = srcMidVar13.CustLevel
	
	dest.custLoyalty = srcMidVar13.CustLoyalty
	
	dest.custNodeType = src.CustNodeType
	
	dest.custSegment = srcMidVar13.CustSegment
	
	dest.custType = src.CustType
	
	dest.dunningFlag = srcMidVar13.DunningFlag
	
	dest.parentCustKey = src.ParentCustKey
	
	dest.currencyId = srcMidVar13.DFTCurrencyID
	
	dest.billCycleType = srcMidVar13.DFTBillCycleType
	
	dest.custPLang = srcMidVar13.DFTIVRLang
	
	dest.custPwd = srcMidVar13.DFTPwd
	
	dest.custWLang = srcMidVar13.DFTWrittenLang
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.channelType = src.ChannelType
	
	dest.noticeType = src.NoticeType
	
	dest.subNoticeType = src.SubNoticeType
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.education = src.Education
	
	dest.email = src.Email
	
	dest.fax = src.Fax
	
	dest.firstName = src.FirstName
	
	dest.gender = src.Gender
	
	dest.homePhone = src.HomePhone
	
	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
	dest.lastName = src.LastName
	
	dest.middleName = src.MiddleName
	
	dest.mobilePhone = src.MobilePhone
	
	dest.nationality = src.Nationality
	
	dest.nativePlace = src.NativePlace
	
	dest.occupation = src.Occupation
	
	dest.officePhone = src.OfficePhone
	
	dest.race = src.Race
	
	dest.title = src.Title
	
			dest.birthday=parseDate(src.Birthday,Constant4Model.DATE_FORMAT)
	
	dest.addrKey = src.HomeAddressKey
	
	dest.idValidity=parseDate(src.IDValidity,Constant4Model.DATE_FORMAT)
	
	dest.marriedStatus = src.MaritalStatus
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
	dest.industry = src.Industry
	
	dest.orgEmail = src.OrgEmail
	
	dest.orgLevel = src.OrgLevel
	
	dest.orgName = src.OrgName
	
	dest.orgType = src.OrgType
	
	dest.subIndustry = src.SubIndustry
	
	dest.addrKey = src.OrgAddressKey
	
	dest.idValidity=parseDate(src.IDValidity,Constant4Model.DATE_FORMAT)
	
	dest.sizeLevel = src.OrgSize
	
	dest.orgWeb = src.OrgWebSite
	
	dest.orgSName = src.OrgShortName
	
	dest.orgPhone = src.OrgPhoneNumber
	
	dest.orgFax = src.OrgFaxNumber
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->

	def destMidVar8 = dest.newObjKey
    destMidVar8._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	def srcMidVar19 = src.NewOfferingKey
	
	destMidVar8.oId = srcMidVar19.OfferingID
    destMidVar8.oCode = srcMidVar19.OfferingCode
	destMidVar8.pSeq = srcMidVar19.PurchaseSeq
	
	def destMidVar9 = dest.oldObjKey
    destMidVar9._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	def srcMidVar20 = src.OldOfferingKey
	
	destMidVar9.oId = srcMidVar20.OfferingID
    destMidVar9.oCode = srcMidVar20.OfferingCode
	destMidVar9.pSeq = srcMidVar20.PurchaseSeq
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

    def oKeyExt = dest
    oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	def srcMidVar21 = src.OfferingKey
	
	oKeyExt.oId = srcMidVar21.OfferingID
    oKeyExt.oCode = srcMidVar21.OfferingCode
	oKeyExt.pSeq = srcMidVar21.PurchaseSeq
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar12 = dest.property
	
	destMidVar12.propCode = src.PropCode
	
	destMidVar12.complexFlag = src.PropType
	
	destMidVar12.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar12.subProps,listMapping18)
	
}

def listMapping21

listMapping21 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping20

listMapping20 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar16 = dest.property
	
	destMidVar16.propCode = src.PropCode
	
	destMidVar16.complexFlag = src.PropType
	
	destMidVar16.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar16.subProps,listMapping21)
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	def destMidVar15 = dest.productInst
	
	destMidVar15.networkType = src.NetworkType
	
	destMidVar15.packageFlag = src.PackageFlag
	
	destMidVar15.parentProdId = src.ParentProdID
	
	destMidVar15.primaryFlag = src.PrimaryFlag
	
	destMidVar15.prodId = src.ProductID
	
	destMidVar15.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping20)
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

			dest.offeringInst.activeTime=parseDate(src.ActivationTime.ActiveTime,Constant4Model.DATE_FORMAT)
	
			dest.offeringInst.activeTimeLimit=parseDate(src.ActivationTime.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	def destMidVar10 = dest.offeringInst
	
	def srcMidVar22 = src.ActivationTime
	
	destMidVar10.activeMode = srcMidVar22.Mode
	
	def srcMidVar23 = src.EffectiveTime
	
	dest.effMode = srcMidVar23.Mode
	
			dest.effDate=parseDate(srcMidVar23.Time,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	destMidVar10.offeringClass = src.OfferingClass
	
	def destMidVar11 = dest.offeringInst.offeringKey
    destMidVar11._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	def srcMidVar24 = src.OfferingKey
	
	destMidVar11.oId = srcMidVar24.OfferingID
    destMidVar11.oCode = srcMidVar24.OfferingCode
	destMidVar11.pSeq = srcMidVar24.PurchaseSeq
	
			destMidVar10.trialEndTime=parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
			destMidVar10.trialStartTime=parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
	
	destMidVar10.status = src.Status
	
	destMidVar10.bundleFlag = src.BundledFlag
	
	mappingList(src.OInstProperty,dest.properties,listMapping17)
	
	def destMidVar13 = dest.offeringInst.relGOfferingKey
    destMidVar13._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	def srcMidVar25 = src.RelGOfferingKey
	
	destMidVar13.pSeq = srcMidVar25.PurchaseSeq
    destMidVar13.oCode = srcMidVar25.OfferingCode
	destMidVar13.oId = srcMidVar25.OfferingID
	
	def destMidVar14 = dest.offeringInst.parentOfferingKey
    destMidVar14._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	def srcMidVar26 = src.ParentOfferingKey
	
	destMidVar14.oId = srcMidVar26.OfferingID
    destMidVar14.oCode = srcMidVar26.OfferingCode
	destMidVar14.pSeq = srcMidVar26.PurchaseSeq
	
	mappingList(src.ProductInst,dest.productInsts,listMapping19)
	
}

def listMapping23

listMapping23 = 
{
    src,dest  ->
  dest._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitExtInfo"
	dest.limitType = src.LimitType
	
	def destMidVar18 = dest.valueInfo
	
	destMidVar18.amount = src.LimitValue
	
	dest.limitPlanCode = src.LimitPlanCode
}

def listMapping24

listMapping24 = 
{
    src,dest  ->

	dest.email = src.Email
	
	dest.fax = src.Fax
	
	dest.firstName = src.FirstName
	
	dest.homePhone = src.HomePhone
	
	dest.lastName = src.LastName
	
	dest.middleName = src.MiddleName
	
	dest.mobilePhone = src.MobilePhone
	
	dest.officePhone = src.OfficePhone
	
	dest.title = src.Title
	
	dest.addrKey = src.AddressKey
	
}

def listMapping25

listMapping25 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping26

listMapping26 = 
{
    src,dest  ->

	dest.code = src.BMCode
	
	dest.type = src.BMType
	
}

def listMapping29

listMapping29 = 
{
    src,dest  ->

	dest.autoRechargeDate = src.AutoRechargeDate
	
	dest.periodType = src.PeriodType
	
	dest.autoRechargeAmt = src.AutoRechargeAmt
	
}

def listMapping30

listMapping30 = 
{
    src,dest  ->

	dest.autoPayDate = src.AutoPayDate
	
	dest.autoPayMaxAmt = src.AutoPayMaxAmt
	
}

def listMapping31

listMapping31 = 
{
    src,dest  ->

	dest.controlPeriodType = src.ControlPeriodType
	
	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.balanceThreshold = src.BalanceThreshold
	
	dest.maxTimes = src.MaxTimes

	dest.balanceThresholdType = src.BalanceThresholdType
	
}

def listMapping28

listMapping28 = 
{
    src,dest  ->

	dest.payType = src.AutoPayType
	
	listMapping29.call(src.TimeSchema,dest.timeSchema)
	
	listMapping30.call(src.BillCycleSchema,dest.billCycleSchema)
	
	listMapping31.call(src.LowBalanceSchema,dest.lowBalanceSchema)
	
}

def listMapping27

listMapping27 = 
{
    src,dest  ->

	def srcMidVar29 = src.AutoPayChannelInfo
	
	dest.chargeCodes = srcMidVar29.ChargeCode
	
	def destMidVar19 = dest.paymentChannelInfo
	
	destMidVar19.bankAcctName = srcMidVar29.AcctName
	
	destMidVar19.bankAcctNo = srcMidVar29.AcctNo
	
	destMidVar19.bankAcctType = srcMidVar29.AcctType
	
	destMidVar19.bankBranchCode = srcMidVar29.BankBranchCode
	
	destMidVar19.bankCode = srcMidVar29.BankCode
	
	destMidVar19.creditCardType = srcMidVar29.CreditCardType
	
	destMidVar19.cvvNumber = srcMidVar29.CVVNumber
	
	destMidVar19.bankAcctExpDate = srcMidVar29.ExpDate
	
	destMidVar19.priority = srcMidVar29.Priority
	
	destMidVar19.paymentChannelKey = src.AutoPayChannelKey
	
	mappingList(srcMidVar29.PaymentPlan,dest.paymentPlanInfos,listMapping28)

	destMidVar19.effMode = srcMidVar29.EffectiveTime.Mode

	destMidVar19.effDate = parseDate(srcMidVar29.EffectiveTime.Time,Constant4Model.DATE_FORMAT)

	destMidVar19.expDate = parseDate(srcMidVar29.ExpireTime,Constant4Model.DATE_FORMAT)

	mappingList(srcMidVar29.AdditionalProperty,destMidVar19.paymentChannelProp,listMapping1)
	
}

def listMapping22

listMapping22 = 
{
    src,dest  ->

	def destMidVar17 = dest.accountInfo
	
	destMidVar17.acctKey = src.AcctKey
	
	def srcMidVar27 = src.AcctInfo.AcctBasicInfo
	
	destMidVar17.acctName = srcMidVar27.AcctName
	
	destMidVar17.billLang = srcMidVar27.BillLang
	
	destMidVar17.dunningFlag = srcMidVar27.DunningFlag
	
	def srcMidVar28 = src.AcctInfo
	
	destMidVar17.acctClass = srcMidVar28.AcctClass
	
	destMidVar17.acctCode = srcMidVar28.AcctCode
	
	destMidVar17.acctPaymentMethod = srcMidVar28.AcctPayMethod
	
	destMidVar17.acctType = srcMidVar28.AcctType
	
	dest.billCycleType = srcMidVar28.BillCycleType
	
	destMidVar17.currencyId = srcMidVar28.CurrencyID
	
	dest.initBalance = srcMidVar28.InitBalance
	
	destMidVar17.parentAcctKey = srcMidVar28.ParentAcctKey
	
	destMidVar17.paymentType = srcMidVar28.PaymentType
	
	mappingList(srcMidVar28.CreditLimit,dest.creditLimits,listMapping23)
	
	listMapping24.call(srcMidVar27.ContactInfo,dest.contactInfo)
	
	mappingList(srcMidVar27.AcctProperty,dest.properties,listMapping25)
	
	destMidVar17.latePaymentFlag = srcMidVar27.LateFeeChargeable
	
	mappingList(srcMidVar27.FreeBillMedium,destMidVar17.bmInfos,listMapping26)
	
	mappingList(srcMidVar28.AutoPayChannel,dest.paymentChannels,listMapping27)
	
	dest.uCustKey = srcMidVar28.UserCustomerKey
	
	dest.redlistFlag = srcMidVar27.RedlistFlag
	
}

def listMapping32

listMapping32 = 
{
    src,dest  ->

	def srcMidVar31 = src.PaymentLimitInfo
	
	dest.limitCycleType = srcMidVar31.LimitCycleType
	
	dest.limitRule = srcMidVar31.LimitRule
	
	def srcMidVar32 = src.PaymentLimitInfo.Limit
	
	dest.limitType = srcMidVar32.LimitType
	
	dest.limitValueType = srcMidVar32.LimitValueType
	
	dest.limitKey = src.PaymentLimitKey
	
	dest.limitValue = srcMidVar32.LimitValue
	
	dest.limitMeasureUnit = srcMidVar32.LimitMeasureUnit
	
	dest.cBonusFlag = srcMidVar31.CBonusFlag
	
	dest.currencyId = srcMidVar31.CurrencyID
	
}

def listMapping33

listMapping33 = 
{
    src,dest  ->

	dest.acctKey = src.AcctKey
	
	dest.dftFlag = src.DEFAcctFlag
	
}

def listMapping34

listMapping34 = 
{
    src,dest  ->

	dest.acctKey = src.AcctKey
	
	def destMidVar20 = dest.paymentRelation
	
	def srcMidVar34 = src.PayRelExtRule
	
	destMidVar20.chargeCode = srcMidVar34.ChargeCode
	
	destMidVar20.paymentLimitKey = src.PaymentLimitKey
	
	destMidVar20.finalFlag = src.OnlyPayRelFlag
	
	destMidVar20.priority = src.Priority
	
	def destMidVar21 = dest.paymentRelation.offeringKey
    destMidVar21._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	def srcMidVar35 = src.PayRelExtRule.OfferingKey
	
	destMidVar21.oId = srcMidVar35.OfferingID
    destMidVar21.oCode = srcMidVar35.OfferingCode
	destMidVar21.pSeq = srcMidVar35.PurchaseSeq
	
	destMidVar20.paymentRelationKey = src.PayRelationKey
	
	destMidVar20.extRuleCode = srcMidVar34.ControlRule
	
}

def listMapping35

listMapping35 = 
{
    src,dest  ->

	dest.newObjKey = src.NewPayRelationKey
	
	dest.oldObjKey = src.OldPayRelationKey
	
}

def listMapping3_cust

listMapping3_cust =
{
	src, dest ->

	dest.code = src.Code

	dest.value = src.Value

}

def listMapping4_cust

listMapping4_cust =
{
	src, dest ->

	dest.addrKey = src.AddressKey

	dest.email = src.Email

	dest.fax = src.Fax

	dest.firstName = src.FirstName

	dest.homePhone = src.HomePhone

	dest.lastName = src.LastName

	dest.middleName = src.MiddleName

	dest.mobilePhone = src.MobilePhone

	dest.officePhone = src.OfficePhone

	dest.title = src.Title

}

def listMapping7_cust

listMapping7_cust =
{
	src, dest ->

	dest.autoRechargeAmt = src.AutoRechargeAmt

	dest.autoRechargeDate = src.AutoRechargeDate

	dest.periodType = src.PeriodType

}

def listMapping8_cust

listMapping8_cust =
{
	src, dest ->

	dest.autoPayDate = src.AutoPayDate

	dest.autoPayMaxAmt = src.AutoPayMaxAmt

}

def listMapping9_cust

listMapping9_cust =
{
	src, dest ->

	dest.autoRechargeAmt = src.AutoRechargeAmt

	dest.balanceThreshold = src.BalanceThreshold

	dest.controlPeriodType = src.ControlPeriodType

	dest.maxTimes = src.MaxTimes

	dest.balanceThresholdType = src.BalanceThresholdType

}

def listMapping6_cust

listMapping6_cust =
{
	src, dest ->

	dest.payType = src.AutoPayType

	listMapping7_cust.call(src.TimeSchema, dest.timeSchema)

	listMapping8_cust.call(src.BillCycleSchema, dest.billCycleSchema)

	listMapping9_cust.call(src.LowBalanceSchema, dest.lowBalanceSchema)

}

def listMapping5_cust

listMapping5_cust =
{
	src, dest ->

	def destMidVar0_cust = dest.basicInfo

	def srcMidVar7_cust = src.AutoPayChannelInfo

	destMidVar0_cust.bankAcctName = srcMidVar7_cust.AcctName

	destMidVar0_cust.bankAcctNo = srcMidVar7_cust.AcctNo

	destMidVar0_cust.bankAcctType = srcMidVar7_cust.AcctType

	destMidVar0_cust.bankBranchCode = srcMidVar7_cust.BankBranchCode

	destMidVar0_cust.bankCode = srcMidVar7_cust.BankCode

	dest.chargeCodes = srcMidVar7_cust.ChargeCode

	destMidVar0_cust.creditCardType = srcMidVar7_cust.CreditCardType

	destMidVar0_cust.cvvNumber = srcMidVar7_cust.CVVNumber

	destMidVar0_cust.paymentChannelKey = src.AutoPayChannelKey

	mappingList(srcMidVar7_cust.PaymentPlan, dest.paymentPlanInfos, listMapping6_cust)

	def destMidVar1_cust = dest.paymentChannelInfo

	destMidVar1_cust.bankAcctName = srcMidVar7_cust.AcctName

	destMidVar1_cust.bankAcctNo = srcMidVar7_cust.AcctNo

	destMidVar1_cust.bankAcctType = srcMidVar7_cust.AcctType

	destMidVar1_cust.bankBranchCode = srcMidVar7_cust.BankBranchCode

	destMidVar1_cust.bankCode = srcMidVar7_cust.BankCode

	destMidVar1_cust.creditCardType = srcMidVar7_cust.CreditCardType

	destMidVar1_cust.cvvNumber = srcMidVar7_cust.CVVNumber

	destMidVar1_cust.bankAcctExpDate = srcMidVar7_cust.ExpDate

	destMidVar1_cust.priority = srcMidVar7_cust.Priority

	destMidVar1_cust.paymentChannelKey = src.AutoPayChannelKey

	destMidVar1_cust.effMode = srcMidVar7_cust.EffectiveTime.Mode

	destMidVar1_cust.effDate = parseDate(srcMidVar7_cust.EffectiveTime.Time, Constant4Model.DATE_FORMAT)

	destMidVar1_cust.expDate = parseDate(srcMidVar7_cust.ExpireTime,Constant4Model.DATE_FORMAT)

	mappingList(srcMidVar7_cust.AdditionalProperty,destMidVar1_cust.paymentChannelProp,listMapping1)

}

def listMapping10_cust

listMapping10_cust =
{
	src, dest ->
	dest._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitExtInfo"
	dest.limitType = src.LimitType

	def destMidVar2_cust = dest.valueInfos[0]

	destMidVar2_cust.amount = src.LimitValue

	def destMidVar3_cust = dest.valueInfo

	destMidVar3_cust.amount = src.LimitValue

	dest.limitPlanCode = src.LimitPlanCode

}

def listMapping56_cust

listMapping56_cust =
{
	src, dest ->

	dest.code = src.BMCode

	dest.type = src.BMType

}

def listMapping_CustDFTAcct

listMapping_CustDFTAcct =
{
	src, dest ->

	def destMidVar_cust = dest.accountInfo

	def srcMidVar5_cust = src.AcctInfo.AcctBasicInfo

	destMidVar_cust.acctName = srcMidVar5_cust.AcctName

	mappingList(srcMidVar5_cust.AcctProperty, dest.properties, listMapping3_cust)

	destMidVar_cust.billLang = srcMidVar5_cust.BillLang

	listMapping4_cust.call(srcMidVar5_cust.ContactInfo, dest.contactInfo)

	destMidVar_cust.dunningFlag = srcMidVar5_cust.DunningFlag

	destMidVar_cust.latePaymentFlag = srcMidVar5_cust.LateFeeChargeable

	def srcMidVar6_cust = src.AcctInfo

	destMidVar_cust.acctClass = srcMidVar6_cust.AcctClass

	destMidVar_cust.acctCode = srcMidVar6_cust.AcctCode

	destMidVar_cust.acctPaymentMethod = srcMidVar6_cust.AcctPayMethod

	destMidVar_cust.acctType = srcMidVar6_cust.AcctType

	mappingList(srcMidVar6_cust.AutoPayChannel, dest.paymentChannels, listMapping5_cust)

	dest.billCycleType = srcMidVar6_cust.BillCycleType

	mappingList(srcMidVar6_cust.CreditLimit, dest.creditLimits, listMapping10_cust)

	dest.initBalance = srcMidVar6_cust.InitBalance

	destMidVar_cust.parentAcctKey = srcMidVar6_cust.ParentAcctKey

	destMidVar_cust.paymentType = srcMidVar6_cust.PaymentType

	destMidVar_cust.acctKey = src.AcctKey

	destMidVar_cust.currencyId = srcMidVar6_cust.CurrencyID

	mappingList(srcMidVar5_cust.FreeBillMedium, destMidVar_cust.bmInfos, listMapping56_cust)

	dest.uCustKey = srcMidVar6_cust.UserCustomerKey

	dest.redlistFlag = srcMidVar5_cust.RedlistFlag

}

def srcMidVar = srcArgs0.ChangeSubOwnershipRequestMsg.RequestHeader

mappingList(srcMidVar.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

def srcMidVar0 = srcArgs0.ChangeSubOwnershipRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar0.LoginSystemCode

destArgs0.password = srcMidVar0.Password

destArgs0.remoteAddress = srcMidVar0.RemoteIP

destArgs0.businessCode = srcMidVar.BusinessCode

destArgs0.messageSeq = srcMidVar.MessageSeq

destArgs0.msgLanguageCode = srcMidVar.MsgLanguageCode

def srcMidVar1 = srcArgs0.ChangeSubOwnershipRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.ChangeSubOwnershipRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.ChangeSubOwnershipRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar.Version

def destMidVar = destArgs1.subAccessCode

def srcMidVar4 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.OldOwnership

destMidVar.subscriberKey = srcMidVar4.SubscriberKey

destMidVar.primaryIdentity = srcMidVar4.PrimaryIdentity

def srcMidVar5 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.RegisterCustomer

destArgs1.opType = srcMidVar5.OpType

def srcMidVar6 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership

mappingList(srcMidVar6.ControlProperty,destArgs1.controlProperties,listMapping1)

mappingList(srcMidVar6.AddressInfo,destArgs1.addresses,listMapping2)

def destMidVar0 = destArgs1.changeSubOwnershipInfo.primaryOffering
destMidVar0._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

def srcMidVar7 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.PrimaryOffering.NewOfferingKey

destMidVar0.oId = srcMidVar7.OfferingID
destMidVar0.oCode = srcMidVar7.OfferingCode
destMidVar0.pSeq = srcMidVar7.PurchaseSeq

def destMidVar1 = destArgs1.userCustomerInfo.customerInfo

def srcMidVar8 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.UserCustomer

destMidVar1.tpCustKey = srcMidVar8.CustKey

def srcMidVar9 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.UserCustomer.CustInfo

destMidVar1.parentCustKey = srcMidVar9.ParentCustKey

def destMidVar2 = destArgs1.userCustomerInfo

mappingList(srcMidVar9.NoticeSuppress,destMidVar2.noticeSuppresses,listMapping3)

destMidVar1.custType = srcMidVar9.CustType

destMidVar1.custNodeType = srcMidVar9.CustNodeType

destMidVar1.custCode = srcMidVar9.CustCode

destMidVar1.custClass = srcMidVar9.CustClass

def srcMidVar10 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.UserCustomer.CustInfo.CustBasicInfo

mappingList(srcMidVar10.CustProperty,destMidVar2.custProperties,listMapping4)

destMidVar1.custLevel = srcMidVar10.CustLevel

destMidVar1.custLoyalty = srcMidVar10.CustLoyalty

destMidVar1.custSegment = srcMidVar10.CustSegment

destMidVar1.billCycleType = srcMidVar10.DFTBillCycleType

destMidVar1.currencyId = srcMidVar10.DFTCurrencyID

destMidVar1.dunningFlag = srcMidVar10.DunningFlag

destMidVar1.custPwd = srcMidVar10.DFTPwd

destMidVar1.custWLang = srcMidVar10.DFTWrittenLang

destMidVar1.custPLang = srcMidVar10.DFTIVRLang

def srcMidVar11 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.UserCustomer.IndividualInfo

mappingList(srcMidVar11.IndividualProperty,destMidVar2.indvProperties,listMapping5)

destMidVar2.individualInfo.birthday=parseDate(srcMidVar6.UserCustomer.IndividualInfo.Birthday,Constant4Model.DATE_FORMAT)

def destMidVar3 = destArgs1.userCustomerInfo.individualInfo

destMidVar3.education = srcMidVar11.Education

destMidVar3.email = srcMidVar11.Email

destMidVar3.fax = srcMidVar11.Fax

destMidVar3.firstName = srcMidVar11.FirstName

destMidVar3.gender = srcMidVar11.Gender

destMidVar3.addrKey = srcMidVar11.HomeAddressKey

destMidVar3.homePhone = srcMidVar11.HomePhone

destMidVar3.idNumber = srcMidVar11.IDNumber

destMidVar3.idType = srcMidVar11.IDType

destMidVar2.individualInfo.idValidity=parseDate(srcMidVar6.UserCustomer.IndividualInfo.IDValidity,Constant4Model.DATE_FORMAT)

destMidVar3.lastName = srcMidVar11.LastName

destMidVar3.marriedStatus = srcMidVar11.MaritalStatus

destMidVar3.middleName = srcMidVar11.MiddleName

destMidVar3.mobilePhone = srcMidVar11.MobilePhone

destMidVar3.nationality = srcMidVar11.Nationality

destMidVar3.nativePlace = srcMidVar11.NativePlace

destMidVar3.occupation = srcMidVar11.Occupation

destMidVar3.officePhone = srcMidVar11.OfficePhone

destMidVar3.race = srcMidVar11.Race

destMidVar3.salary = srcMidVar11.Salary

destMidVar3.title = srcMidVar11.Title

def srcMidVar12 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.UserCustomer.OrgInfo

mappingList(srcMidVar12.OrgProperty,destMidVar2.orgProperties,listMapping6)

def destMidVar4 = destArgs1.userCustomerInfo.orgInfo

destMidVar4.idNumber = srcMidVar12.IDNumber

destMidVar4.idType = srcMidVar12.IDType

destMidVar4.idValidity=parseDate(srcMidVar6.UserCustomer.OrgInfo.IDValidity,Constant4Model.DATE_FORMAT)

destMidVar4.industry = srcMidVar12.Industry

destMidVar4.addrKey = srcMidVar12.OrgAddressKey

destMidVar4.orgEmail = srcMidVar12.OrgEmail

destMidVar4.orgFax = srcMidVar12.OrgFaxNumber

destMidVar4.orgLevel = srcMidVar12.OrgLevel

destMidVar4.orgName = srcMidVar12.OrgName

destMidVar4.orgPhone = srcMidVar12.OrgPhoneNumber

destMidVar4.orgSName = srcMidVar12.OrgShortName

destMidVar4.orgType = srcMidVar12.OrgType

destMidVar4.subIndustry = srcMidVar12.SubIndustry

destMidVar4.orgWeb = srcMidVar12.OrgWebSite

destMidVar4.sizeLevel = srcMidVar12.OrgSize

def destMidVar5 = destArgs1.regCustomerInfo.customerInfo

destMidVar5.tpCustKey = srcMidVar5.CustKey

def destMidVar6 = destArgs1.regCustomerInfo

listMapping7.call(srcMidVar5.CustInfo,destMidVar6.customerInfo)

def srcMidVar14 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.RegisterCustomer.CustInfo.CustBasicInfo

mappingList(srcMidVar14.CustProperty,destMidVar6.custProperties,listMapping8)

def srcMidVar15 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.RegisterCustomer.CustInfo

mappingList(srcMidVar15.NoticeSuppress,destMidVar6.noticeSuppresses,listMapping9)

listMapping10.call(srcMidVar5.IndividualInfo,destMidVar6.individualInfo)

def srcMidVar16 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.RegisterCustomer.IndividualInfo

mappingList(srcMidVar16.IndividualProperty,destMidVar6.indvProperties,listMapping11)

listMapping12.call(srcMidVar5.OrgInfo,destMidVar6.orgInfo)

def srcMidVar17 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.RegisterCustomer.OrgInfo

mappingList(srcMidVar17.OrgProperty,destMidVar6.orgProperties,listMapping13)

def srcMidVar18 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.SupplementaryOffering

def destMidVar7 = destArgs1.changeSubOwnershipInfo

mappingList(srcMidVar18.ShiftOffering,destMidVar7.shiftSuppOfferings,listMapping14)

mappingList(srcMidVar18.DelOffering,destMidVar7.delSuppOfferings,listMapping15)

mappingList(srcMidVar18.AddOffering,destMidVar7.addSuppOfferings,listMapping16)

mappingList(srcMidVar6.Account,destArgs1.createAccountInfos,listMapping22)

def srcMidVar30 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.Subscriber.SubDFTAcct

mappingList(srcMidVar30.PaymentLimit,destArgs1.paymentLimits,listMapping32)

destArgs1.payRelationKey = srcMidVar30.PayRelationKey

destArgs1.acctKey = srcMidVar30.AcctKey

mappingList(srcMidVar30.AcctList,destArgs1.dftAccount,listMapping33)

def srcMidVar33 = srcArgs0.ChangeSubOwnershipRequestMsg.ChangeSubOwnershipRequest.NewOwnership.Subscriber

destMidVar7.newSubKey = srcMidVar33.SubscriberKey

destMidVar7.userCustKey = srcMidVar33.UserCustomerKey

mappingList(srcMidVar30.PayRelation,destArgs1.addPaymentRelations,listMapping34)

mappingList(srcMidVar33.ShiftPayRelation,destMidVar7.shiftPayRelations,listMapping35)

destArgs0.interMode = srcMidVar.AccessMode

def destMidVar22 = destArgs1.changeSubBasicInfo.subscriberInfo

destMidVar22.ivrLang = srcMidVar33.IVRLang

destMidVar22.subPassword = srcMidVar33.SubPassword

destMidVar22.writtenLang = srcMidVar33.WrittenLang

listMapping_CustDFTAcct.call(srcMidVar5.DFTAccount,destArgs1.regCustomerDTFAccountInfo)

destArgs1.payRelationKey4Cust = srcMidVar5.DFTAccount.PayRelationKey