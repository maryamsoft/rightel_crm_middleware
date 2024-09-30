import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("SubscriberService","createSubscriber")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.createsubscriber.io.CreateSubscriberRequest"

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
	
	def srcMidVar2 = src.TimeFormat
	
	dest.timeType = srcMidVar2.TimeType
	
	dest.timeZoneId = srcMidVar2.TimeZoneID
	
	dest.version = src.Version
	
	def srcMidVar3 = src.OwnershipInfo
	
	dest.beId = srcMidVar3.BEID
	
	dest.brId = srcMidVar3.BRID
	
	dest.interMode = src.AccessMode
	
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

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.autoRechargeDate = src.AutoRechargeDate
	
	dest.periodType = src.PeriodType
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.autoPayDate = src.AutoPayDate
	
	dest.autoPayMaxAmt = src.AutoPayMaxAmt
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.balanceThreshold = src.BalanceThreshold
	
	dest.controlPeriodType = src.ControlPeriodType
	
	dest.maxTimes = src.MaxTimes

	dest.balanceThresholdType = src.BalanceThresholdType
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.payType = src.AutoPayType
	
	listMapping7.call(src.TimeSchema,dest.timeSchema)
	
	listMapping8.call(src.BillCycleSchema,dest.billCycleSchema)
	
	listMapping9.call(src.LowBalanceSchema,dest.lowBalanceSchema)
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	def destMidVar0 = dest.basicInfo
	
	def srcMidVar7 = src.AutoPayChannelInfo
	
	destMidVar0.bankAcctName = srcMidVar7.AcctName
	
	destMidVar0.bankAcctNo = srcMidVar7.AcctNo
	
	destMidVar0.bankAcctType = srcMidVar7.AcctType
	
	destMidVar0.bankBranchCode = srcMidVar7.BankBranchCode
	
	destMidVar0.bankCode = srcMidVar7.BankCode
	
	dest.chargeCodes = srcMidVar7.ChargeCode
	
	destMidVar0.creditCardType = srcMidVar7.CreditCardType
	
	destMidVar0.cvvNumber = srcMidVar7.CVVNumber
	
	destMidVar0.paymentChannelKey = src.AutoPayChannelKey
	
	mappingList(srcMidVar7.PaymentPlan,dest.paymentPlanInfos,listMapping6)
	
	def destMidVar1 = dest.paymentChannelInfo
	
	destMidVar1.bankAcctName = srcMidVar7.AcctName
	
	destMidVar1.bankAcctNo = srcMidVar7.AcctNo
	
	destMidVar1.bankAcctType = srcMidVar7.AcctType
	
	destMidVar1.bankBranchCode = srcMidVar7.BankBranchCode
	
	destMidVar1.bankCode = srcMidVar7.BankCode
	
	destMidVar1.creditCardType = srcMidVar7.CreditCardType
	
	destMidVar1.cvvNumber = srcMidVar7.CVVNumber
	
	destMidVar1.bankAcctExpDate = srcMidVar7.ExpDate
	
	destMidVar1.priority = srcMidVar7.Priority
	
	destMidVar1.paymentChannelKey = src.AutoPayChannelKey

	destMidVar1.effMode = srcMidVar7.EffectiveTime.Mode

	destMidVar1.effDate = parseDate(srcMidVar7.EffectiveTime.Time,Constant4Model.DATE_FORMAT)

	destMidVar1.expDate = parseDate(srcMidVar7.ExpireTime,Constant4Model.DATE_FORMAT)

	mappingList(srcMidVar7.AdditionalProperty,destMidVar1.paymentChannelProp,listMapping1)
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->
  dest._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitExtInfo"
	dest.limitType = src.LimitType
	
	def destMidVar2 = dest.valueInfos[0]
	
	destMidVar2.amount = src.LimitValue
	
	def destMidVar3 = dest.valueInfo
	
	destMidVar3.amount = src.LimitValue
	
	dest.limitPlanCode = src.LimitPlanCode
	
}

def listMapping56

listMapping56 = 
{
    src,dest  ->

	dest.code = src.BMCode
	
	dest.type = src.BMType
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	def destMidVar = dest.accountInfo
	
	def srcMidVar5 = src.AcctInfo.AcctBasicInfo
	
	destMidVar.acctName = srcMidVar5.AcctName
	
	mappingList(srcMidVar5.AcctProperty,dest.properties,listMapping3)
	
	destMidVar.billLang = srcMidVar5.BillLang
	
	listMapping4.call(srcMidVar5.ContactInfo,dest.contactInfo)
	
	destMidVar.dunningFlag = srcMidVar5.DunningFlag
	
	destMidVar.latePaymentFlag = srcMidVar5.LateFeeChargeable
	
	def srcMidVar6 = src.AcctInfo
	
	destMidVar.acctClass = srcMidVar6.AcctClass
	
	destMidVar.acctCode = srcMidVar6.AcctCode
	
	destMidVar.acctPaymentMethod = srcMidVar6.AcctPayMethod
	
	destMidVar.acctType = srcMidVar6.AcctType
	
	mappingList(srcMidVar6.AutoPayChannel,dest.paymentChannels,listMapping5)
	
	dest.billCycleType = srcMidVar6.BillCycleType
	
	mappingList(srcMidVar6.CreditLimit,dest.creditLimits,listMapping10)
	
	dest.initBalance = srcMidVar6.InitBalance
	
	destMidVar.parentAcctKey = srcMidVar6.ParentAcctKey
	
	destMidVar.paymentType = srcMidVar6.PaymentType
	
	destMidVar.acctKey = src.AcctKey
	
	destMidVar.currencyId = srcMidVar6.CurrencyID
	
	mappingList(srcMidVar5.FreeBillMedium,destMidVar.bmInfos,listMapping56)
	
	dest.uCustKey = srcMidVar6.UserCustomerKey
	
	dest.redlistFlag = srcMidVar5.RedlistFlag
	
}

def listMapping11

listMapping11 = 
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

def listMapping13

listMapping13 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
    
    dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping72

listMapping72 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping71

listMapping71 = 
{
    src,dest  ->

		dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
		dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar7 = dest.property
	
	destMidVar7.propCode = src.PropCode
	
	destMidVar7.complexFlag = src.PropType
	
	destMidVar7.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar7.subProps,listMapping72)
	
}

def listMapping70

listMapping70 = 
{
    src,dest  ->

	def destMidVar6 = dest.productInst
	
	destMidVar6.networkType = src.NetworkType
	
	destMidVar6.packageFlag = src.PackageFlag
	
	destMidVar6.parentProdId = src.ParentProdID
	
	destMidVar6.primaryFlag = src.PrimaryFlag
	
	destMidVar6.prodId = src.ProductID
	
	destMidVar6.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping71)
	
}

def listMapping74

listMapping74 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping73

listMapping73 = 
{
    src,dest  ->

	def destMidVar8 = dest.property
	
	destMidVar8.propCode = src.PropCode
	
	destMidVar8.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar8.subProps,listMapping74)
	
	destMidVar8.value = src.Value
	
	dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	mappingList(src.ProductInst,dest.productInsts,listMapping70)
	
	dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	mappingList(src.OfferingInstProperty,dest.properties,listMapping73)
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	def destMidVar5 = dest.offeringInst
	
	destMidVar5.bundleFlag = src.BundledFlag
	
	destMidVar5.offeringClass = src.OfferingClass
	
    def offeringKeyExt = destMidVar5.offeringKey
    offeringKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping13.call(src.OfferingKey,offeringKeyExt)
	
    def parentOfferingKeyExt = destMidVar5.parentOfferingKey
    parentOfferingKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping13.call(src.ParentOfferingKey,parentOfferingKeyExt)
	
	destMidVar5.trialEndTime=parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
	destMidVar5.trialStartTime=parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
	
	destMidVar5.status = src.Status

	destMidVar5.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)

	listMapping18.call(src,dest)
	
}

def listMapping20

listMapping20 = 
{
    src,dest  ->

	def srcMidVar8 = src.CustBasicInfo
	
	dest.custLevel = srcMidVar8.CustLevel
	
	dest.custLoyalty = srcMidVar8.CustLoyalty
	
	dest.custSegment = srcMidVar8.CustSegment
	
	dest.billCycleType = srcMidVar8.DFTBillCycleType
	
	dest.currencyId = srcMidVar8.DFTCurrencyID
	
	dest.custPLang = srcMidVar8.DFTIVRLang
	
	dest.custPwd = srcMidVar8.DFTPwd
	
	dest.custWLang = srcMidVar8.DFTWrittenLang
	
	dest.custClass = src.CustClass
	
	dest.custCode = src.CustCode
	
	dest.custNodeType = src.CustNodeType
	
	dest.custType = src.CustType
	
	dest.parentCustKey = src.ParentCustKey
	
	dest.dunningFlag = srcMidVar8.DunningFlag
	
}

def listMapping21

listMapping21 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping22

listMapping22 = 
{
    src,dest  ->

	dest.channelType = src.ChannelType
	
	dest.noticeType = src.NoticeType
	
	dest.subNoticeType = src.SubNoticeType
	
}

def listMapping23

listMapping23 = 
{
    src,dest  ->

			dest.birthday=parseDate(src.Birthday,Constant4Model.DATE_FORMAT)
	
	dest.education = src.Education
	
	dest.email = src.Email
	
	dest.fax = src.Fax
	
	dest.firstName = src.FirstName
	
	dest.gender = src.Gender
	
	dest.homePhone = src.HomePhone
	
	dest.addrKey = src.HomeAddressKey
	
	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
			dest.idValidity=parseDate(src.IDValidity,Constant4Model.DATE_FORMAT)
	
	dest.lastName = src.LastName
	
	dest.marriedStatus = src.MaritalStatus
	
	dest.middleName = src.MiddleName
	
	dest.mobilePhone = src.MobilePhone
	
	dest.nationality = src.Nationality
	
	dest.nativePlace = src.NativePlace
	
	dest.occupation = src.Occupation
	
	dest.officePhone = src.OfficePhone
	
	dest.race = src.Race
	
	dest.salary = src.Salary
	
	dest.title = src.Title
	
}

def listMapping24

listMapping24 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping25

listMapping25 = 
{
    src,dest  ->

	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
			dest.idValidity=parseDate(src.IDValidity,Constant4Model.DATE_FORMAT)
	
	dest.industry = src.Industry
	
	dest.orgEmail = src.OrgEmail
	
	dest.orgFax = src.OrgFaxNumber
	
	dest.orgLevel = src.OrgLevel
	
	dest.orgName = src.OrgName
	
	dest.orgPhone = src.OrgPhoneNumber
	
	dest.orgSName = src.OrgShortName
	
	dest.sizeLevel = src.OrgSize
	
	dest.orgType = src.OrgType
	
	dest.orgWeb = src.OrgWebSite
	
	dest.subIndustry = src.SubIndustry
	
	dest.addrKey = src.OrgAddressKey
	
}

def listMapping26

listMapping26 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	listMapping20.call(src.CustInfo,dest.customerInfo)
	
	def srcMidVar9 = src.CustInfo.CustBasicInfo
	
	mappingList(srcMidVar9.CustProperty,dest.custProperties,listMapping21)
	
	def srcMidVar10 = src.CustInfo
	
	mappingList(srcMidVar10.NoticeSuppress,dest.noticeSuppresses,listMapping22)
	
	def destMidVar9 = dest.customerInfo
	
	destMidVar9.tpCustKey = src.CustKey
	
	listMapping23.call(src.IndividualInfo,dest.individualInfo)
	
	def srcMidVar11 = src.IndividualInfo
	
	mappingList(srcMidVar11.IndividualProperty,dest.indvProperties,listMapping24)
	
	listMapping25.call(src.OrgInfo,dest.orgInfo)
	
	def srcMidVar12 = src.OrgInfo
	
	mappingList(srcMidVar12.OrgProperty,dest.orgProperties,listMapping26)
	
}

def listMapping33

listMapping33 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping35

listMapping35 = 
{
    src,dest  ->

	dest.code = src.ParamCode
	
	dest.value = src.ParamValue
	
}

def listMapping34

listMapping34 = 
{
    src,dest  ->

	def destMidVar11 = dest.spendingLimitInfo.currencyLimit
	
	destMidVar11.currencyId = src.CurrencyID
	
	def destMidVar12 = dest.spendingLimitInfo
	
	destMidVar12.limitType = src.LimitType
	
	destMidVar12.unitType = src.UnitType
	
	def destMidVar13 = dest.spendingLimitInfo.usageLimit
	
	destMidVar13.limitValue = src.LimitValue
	
	destMidVar13.measureId = src.MesureID
	
	destMidVar13.measureType = src.MesureType
	
	destMidVar11.limitValue = src.LimitValue
	
	mappingList(src.LimitParam,dest.spdlmtParamInfos,listMapping35)
	
}

def listMapping36

listMapping36 = 
{
    src,dest  ->

	
}

def listMapping37

listMapping37 = 
{
    src,dest  ->
	dest._class="com.huawei.ngcbs.cm.subscriber.createsubscriber.io.SubIdenInfoExt"
	dest.primaryFlag = src.PrimaryFlag
	
	dest.subIden = src.SubIdentity
	
	dest.subIdenType = src.SubIdentityType
	
	dest.relatedSubIdentity = src.RelatedSubIdentity
}


def listMapping30

listMapping30 = 
{
    src,dest  ->

	def destMidVar10 = dest.subscriberInfo
	
	destMidVar10.subscriberKey = src.SubscriberKey
	
			destMidVar10.activeTimeLimit=parseDate(src.SubscriberInfo.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	def srcMidVar14 = src.SubscriberInfo
	
	destMidVar10.subClass = srcMidVar14.SubClass
	
	destMidVar10.subPassword = srcMidVar14.SubPassword
	
	def srcMidVar15 = src.SubscriberInfo.SubBasicInfo
	
	destMidVar10.dunningFlag = srcMidVar15.DunningFlag
	
	destMidVar10.ivrLang = srcMidVar15.IVRLang
	
	destMidVar10.subLevel = srcMidVar15.SubLevel
	
	destMidVar10.writtenLang = srcMidVar15.WrittenLang
	
	destMidVar10.networkType = srcMidVar14.NetworkType
	
	destMidVar10.status = srcMidVar14.Status
	
	mappingList(srcMidVar15.SubProperty,dest.subProperties,listMapping33)
	
	mappingList(srcMidVar14.ConsumptionLimit,dest.consumptionLimits,listMapping34)
	
	listMapping36.call(srcMidVar14.SubBasicInfo,dest.subscriberInfo)
	
	mappingList(srcMidVar14.SubIdentity,dest.subIdentities,listMapping37)
	
	def destMidVar14 = dest.subBrandInfo
	
	destMidVar14.brand = srcMidVar14.Brand
	
	dest.status = srcMidVar14.Status
	
}

def listMapping32

listMapping32 = 
{
    src,dest  ->

	dest.key = src.AcctKey
	
	dest.dftAcctFlag = src.DEFAcctFlag
	
}

def listMapping57

listMapping57 = 
{
    src,dest  ->

	def destMidVar17 = dest.paymentRelation
	
	destMidVar17.priority = src.Priority
	
	destMidVar17.paymentLimitKey = src.PaymentLimitKey
	
	destMidVar17.paymentRelationKey = src.PayRelationKey
	
	def srcMidVar17 = src.PayRelExtRule
	
	destMidVar17.chargeCode = srcMidVar17.ChargeCode
	
	destMidVar17.extRuleCode = srcMidVar17.ControlRule
	
	destMidVar17.finalFlag = src.OnlyPayRelFlag
	
	dest.tpAcctKey = src.AcctKey
	
	def destMidVar18 = dest.addPaymentRelationInfo.paymentRelation
	
	destMidVar18.chargeCode = srcMidVar17.ChargeCode
	
	destMidVar18.extRuleCode = srcMidVar17.ControlRule
	
	destMidVar18.priority = src.Priority
	
	destMidVar18.finalFlag = src.OnlyPayRelFlag
	
	destMidVar18.paymentLimitKey = src.PaymentLimitKey
	
	destMidVar18.paymentRelationKey = src.PayRelationKey
	
    def prOfferingKeyExt = destMidVar18.offeringKey
    prOfferingKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping13.call(srcMidVar17.OfferingKey,prOfferingKeyExt)
	
}

def listMapping59

listMapping59 = 
{
    src,dest  ->

	dest.limitKey = src.PaymentLimitKey
	
	def srcMidVar18 = src.PaymentLimitInfo
	
	dest.limitCycleType = srcMidVar18.LimitCycleType
	
	dest.limitRule = srcMidVar18.LimitRule
	
	def srcMidVar19 = src.PaymentLimitInfo.Limit
	
	dest.limitMeasureUnit = srcMidVar19.LimitMeasureUnit
	
	dest.limitType = srcMidVar19.LimitType
	
	dest.limitValue = srcMidVar19.LimitValue
	
	dest.limitValueType = srcMidVar19.LimitValueType
	
	dest.cBonusFlag = srcMidVar18.CBonusFlag
	
	dest.currencyId = srcMidVar18.CurrencyID
	
}

def listMapping31

listMapping31 = 
{
    src,dest  ->

	def destMidVar15 = dest.existAcct
	
	destMidVar15.acctKey = src.AcctKey
	
	destMidVar15.paymentRelationKey = src.PayRelationKey
	
	def destMidVar16 = dest.newAcct
	
	mappingList(src.AcctList,destMidVar16.dftAccts,listMapping32)
	
	dest.paymentMode = src.PaymentMode
	
	mappingList(src.PayRelation,dest.addPaymentRelationInfos,listMapping57)
	
	mappingList(src.PaymentLimit,dest.paymentLimitInfos,listMapping59)
	
}

def listMapping42

listMapping42 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping40

listMapping40 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar20 = dest.property
	
	destMidVar20.value = src.Value
	
	destMidVar20.propCode = src.PropCode
	
	destMidVar20.propType = src.PropType
	
	mappingList(src.SubPropInst,destMidVar20.subProps,listMapping42)
	
	destMidVar20.complexFlag = src.PropType
	
}

def listMapping44

listMapping44 = 
{
    src,dest  ->

	def destMidVar21 = dest.productInst
	
	destMidVar21.network = src.NetworkType
	
	destMidVar21.packageFlag = src.PackageFlag
	
	destMidVar21.parentProdId = src.ParentProdID
	
	destMidVar21.primaryFlag = src.PrimaryFlag
	
	destMidVar21.productId = src.ProductID
	
	destMidVar21.productType = src.ProductType
	
	destMidVar21.prodId = src.ProductID
	
	destMidVar21.networkType = src.NetworkType
	
}

def listMapping38

listMapping38 = 
{
    src,dest  ->

	def srcMidVar20 = src.ActivationTime
	
	dest.activeMode = srcMidVar20.Mode
	
	dest.activeTimeLimit=parseDate(srcMidVar20.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	dest.activeTime=parseDate(srcMidVar20.ActiveTime,Constant4Model.DATE_FORMAT)
	
	def srcMidVar21 = src.EffectiveTime
	
	dest.effMode = srcMidVar21.Mode
	
	dest.effDate=parseDate(srcMidVar21.Time,Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar19 = dest.offeringInst
	
	destMidVar19.offeringClass = src.OfferingClass
	
	destMidVar19.status = src.Status
	
	destMidVar19.trialEndTime=parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
	destMidVar19.trialStartTime=parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
    
    def relGOfferingKeyExt = destMidVar19.relGOfferingKey
    relGOfferingKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping13.call(src.RelGOfferingKey,relGOfferingKeyExt)
	
    def supOfferingKeyExt = destMidVar19.offeringKey
    supOfferingKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping13.call(src.OfferingKey,supOfferingKeyExt)
	
	destMidVar19.bundleFlag = src.BundledFlag
	
	mappingList(src.OInstProperty,dest.properties,listMapping40)
	
    def prOfferingKeyExt = destMidVar19.parentOfferingKey
    prOfferingKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping13.call(src.ParentOfferingKey,prOfferingKeyExt)
	
	mappingList(src.ProductInst,dest.productInsts,listMapping44)
	
	destMidVar19.activeTime=parseDate(srcMidVar20.ActiveTime,Constant4Model.DATE_FORMAT)
	
	destMidVar19.activeTimeLimit=parseDate(srcMidVar20.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	destMidVar19.activeMode = srcMidVar20.Mode
	
}

def listMapping48

listMapping48 = 
{
    src,dest  ->

	dest.custClass = src.CustClass
	
	dest.custCode = src.CustCode
	
	dest.custNodeType = src.CustNodeType
	
	dest.custType = src.CustType
	
	def srcMidVar22 = src.CustBasicInfo
	
	dest.custLevel = srcMidVar22.CustLevel
	
	dest.custLoyalty = srcMidVar22.CustLoyalty
	
	dest.custSegment = srcMidVar22.CustSegment
	
	dest.billCycleType = srcMidVar22.DFTBillCycleType
	
	dest.currencyId = srcMidVar22.DFTCurrencyID
	
	dest.custPLang = srcMidVar22.DFTIVRLang
	
	dest.custPwd = srcMidVar22.DFTPwd
	
	dest.custWLang = srcMidVar22.DFTWrittenLang
	
	dest.dunningFlag = srcMidVar22.DunningFlag
	
	dest.parentCustKey = src.ParentCustKey
	
}

def listMapping49

listMapping49 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping50

listMapping50 = 
{
    src,dest  ->

	dest.channelType = src.ChannelType
	
	dest.noticeType = src.NoticeType
	
	dest.subNoticeType = src.SubNoticeType
	
}

def listMapping51

listMapping51 = 
{
    src,dest  ->

			dest.birthday=parseDate(src.Birthday,Constant4Model.DATE_FORMAT)
	
	dest.education = src.Education
	
	dest.email = src.Email
	
	dest.fax = src.Fax
	
	dest.firstName = src.FirstName
	
	dest.gender = src.Gender
	
	dest.addrKey = src.HomeAddressKey
	
	dest.homePhone = src.HomePhone
	
	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
			dest.idValidity=parseDate(src.IDValidity,Constant4Model.DATE_FORMAT)
	
	dest.lastName = src.LastName
	
	dest.marriedStatus = src.MaritalStatus
	
	dest.middleName = src.MiddleName
	
	dest.mobilePhone = src.MobilePhone
	
	dest.nationality = src.Nationality
	
	dest.nativePlace = src.NativePlace
	
	dest.occupation = src.Occupation
	
	dest.officePhone = src.OfficePhone
	
	dest.race = src.Race
	
	dest.salary = src.Salary
	
	dest.title = src.Title
	
}

def listMapping52

listMapping52 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping53

listMapping53 = 
{
    src,dest  ->

	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
			dest.idValidity=parseDate(src.IDValidity,Constant4Model.DATE_FORMAT)
	
	dest.industry = src.Industry
	
	dest.addrKey = src.OrgAddressKey
	
	dest.orgEmail = src.OrgEmail
	
	dest.orgFax = src.OrgFaxNumber
	
	dest.orgLevel = src.OrgLevel
	
	dest.orgName = src.OrgName
	
	dest.orgPhone = src.OrgPhoneNumber
	
	dest.orgSName = src.OrgShortName
	
	dest.sizeLevel = src.OrgSize
	
	dest.orgType = src.OrgType
	
	dest.orgWeb = src.OrgWebSite
	
	dest.subIndustry = src.SubIndustry
	
}

def listMapping54

listMapping54 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping47

listMapping47 = 
{
    src,dest  ->

	listMapping48.call(src.CustInfo,dest.customerInfo)
	
	def srcMidVar23 = src.CustInfo.CustBasicInfo
	
	mappingList(srcMidVar23.CustProperty,dest.custProperties,listMapping49)
	
	def srcMidVar24 = src.CustInfo
	
	mappingList(srcMidVar24.NoticeSuppress,dest.noticeSuppresses,listMapping50)
	
	def destMidVar22 = dest.customerInfo
	
	destMidVar22.tpCustKey = src.CustKey
	
	listMapping51.call(src.IndividualInfo,dest.individualInfo)
	
	def srcMidVar25 = src.IndividualInfo
	
	mappingList(srcMidVar25.IndividualProperty,dest.indvProperties,listMapping52)
	
	listMapping53.call(src.OrgInfo,dest.orgInfo)
	
	def srcMidVar26 = src.OrgInfo
	
	mappingList(srcMidVar26.OrgProperty,dest.orgProperties,listMapping54)
	
}

def listMapping55

listMapping55 = 
{
    src,dest  ->

	dest.salesChannelId = src.SalesChannelID
	
	dest.salesId = src.SalesID
	
}

def listMapping61

listMapping61 = 
{
    src,dest  ->

	dest.opObjCode = src.OwnerKey
	
	dest.opObjType = src.OwnerType
	
}

def listMapping66

listMapping66 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping65

listMapping65 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar25 = dest.property
	
	destMidVar25.value = src.Value
	
	destMidVar25.complexFlag = src.PropType
	
	destMidVar25.propCode = src.PropCode
	
	mappingList(src.SubPropInst,destMidVar25.subProps,listMapping66)
	
}

def listMapping69

listMapping69 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping68

listMapping68 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar27 = dest.property
	
	destMidVar27.propCode = src.PropCode
	
	destMidVar27.complexFlag = src.PropType
	
	destMidVar27.value = src.Value
	
	def destMidVar28 = dest.property.subProps[0]
	
	def srcMidVar29 = src.SubPropInst[0]
	
	destMidVar28.code = srcMidVar29.SubPropCode
	
	mappingList(src.SubPropInst,destMidVar27.subProps,listMapping69)
	
}

def listMapping67

listMapping67 = 
{
    src,dest  ->

	def destMidVar26 = dest.productInst
	
	destMidVar26.networkType = src.NetworkType
	
	destMidVar26.packageFlag = src.PackageFlag
	
	destMidVar26.parentProdId = src.ParentProdID
	
	destMidVar26.primaryFlag = src.PrimaryFlag
	
	destMidVar26.prodId = src.ProductID
	
	destMidVar26.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping68)
	
}

def listMapping58

listMapping58 = 
{
    src,dest  ->

	listMapping61.call(src.OfferingOwner,dest.opObjInfo)
	
	def destMidVar23 = dest.addOfferingInstInfo.offeringInst
    
    def offeringKeyExt = destMidVar23.offeringKey
    offeringKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping13.call(src.OfferingKey,offeringKeyExt)
	
    def prOfferingKeyExt = destMidVar23.parentOfferingKey
    prOfferingKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping13.call(src.ParentOfferingKey,prOfferingKeyExt)
	
	def destMidVar24 = dest.addOfferingInstInfo
	
	def srcMidVar27 = src.EffectiveTime
	
	destMidVar24.effMode = srcMidVar27.Mode
	
	destMidVar24.effDate=parseDate(srcMidVar27.Time,Constant4Model.DATE_FORMAT)
	
	destMidVar24.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	destMidVar23.offeringClass = src.OfferingClass
	
    def relGOfferingKeyExt = destMidVar23.relGOfferingKey
    relGOfferingKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping13.call(src.RelGOfferingKey,relGOfferingKeyExt)
	
	destMidVar23.status = src.Status
	
	destMidVar23.trialEndTime=parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
	destMidVar23.trialStartTime=parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
	
	destMidVar23.bundleFlag = src.BundledFlag
	
	destMidVar23.activeTime=parseDate(src.ActivationTime.ActiveTime,Constant4Model.DATE_FORMAT)
	
	destMidVar23.activeTimeLimit=parseDate(src.ActivationTime.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	def srcMidVar28 = src.ActivationTime
	
	destMidVar23.activeMode = srcMidVar28.Mode
	
	mappingList(src.OInstProperty,destMidVar24.properties,listMapping65)
	
	mappingList(src.ProductInst,destMidVar24.productInsts,listMapping67)
	
}

def listMapping75

listMapping75 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping3_cust

listMapping3_cust = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping4_cust

listMapping4_cust = 
{
    src,dest  ->

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
    src,dest  ->

	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.autoRechargeDate = src.AutoRechargeDate
	
	dest.periodType = src.PeriodType
	
}

def listMapping8_cust

listMapping8_cust = 
{
    src,dest  ->

	dest.autoPayDate = src.AutoPayDate
	
	dest.autoPayMaxAmt = src.AutoPayMaxAmt
	
}

def listMapping9_cust

listMapping9_cust = 
{
    src,dest  ->

	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.balanceThreshold = src.BalanceThreshold
	
	dest.controlPeriodType = src.ControlPeriodType
	
	dest.maxTimes = src.MaxTimes

	dest.balanceThresholdType = src.BalanceThresholdType
	
}

def listMapping6_cust

listMapping6_cust = 
{
    src,dest  ->

	dest.payType = src.AutoPayType
	
	listMapping7_cust.call(src.TimeSchema,dest.timeSchema)
	
	listMapping8_cust.call(src.BillCycleSchema,dest.billCycleSchema)
	
	listMapping9_cust.call(src.LowBalanceSchema,dest.lowBalanceSchema)
	
}

def listMapping5_cust

listMapping5_cust = 
{
    src,dest  ->

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
	
	mappingList(srcMidVar7_cust.PaymentPlan,dest.paymentPlanInfos,listMapping6_cust)
	
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

	destMidVar1_cust.effDate = parseDate(srcMidVar7_cust.EffectiveTime.Time,Constant4Model.DATE_FORMAT)

	destMidVar1_cust.expDate = parseDate(srcMidVar7_cust.ExpireTime,Constant4Model.DATE_FORMAT)

	mappingList(srcMidVar7_cust.AdditionalProperty,destMidVar1_cust.paymentChannelProp,listMapping1)
	
}

def listMapping10_cust

listMapping10_cust = 
{
    src,dest  ->
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
    src,dest  ->

	dest.code = src.BMCode
	
	dest.type = src.BMType
	
}

def listMapping_CustDFTAcct

listMapping_CustDFTAcct = 
{
    src,dest  ->

	def destMidVar_cust = dest.accountInfo
	
	def srcMidVar5_cust = src.AcctInfo.AcctBasicInfo
	
	destMidVar_cust.acctName = srcMidVar5_cust.AcctName
	
	mappingList(srcMidVar5_cust.AcctProperty,dest.properties,listMapping3_cust)
	
	destMidVar_cust.billLang = srcMidVar5_cust.BillLang
	
	listMapping4_cust.call(srcMidVar5_cust.ContactInfo,dest.contactInfo)
	
	destMidVar_cust.dunningFlag = srcMidVar5_cust.DunningFlag
	
	destMidVar_cust.latePaymentFlag = srcMidVar5_cust.LateFeeChargeable
	
	def srcMidVar6_cust = src.AcctInfo
	
	destMidVar_cust.acctClass = srcMidVar6_cust.AcctClass
	
	destMidVar_cust.acctCode = srcMidVar6_cust.AcctCode
	
	destMidVar_cust.acctPaymentMethod = srcMidVar6_cust.AcctPayMethod
	
	destMidVar_cust.acctType = srcMidVar6_cust.AcctType
	
	mappingList(srcMidVar6_cust.AutoPayChannel,dest.paymentChannels,listMapping5_cust)
	
	dest.billCycleType = srcMidVar6_cust.BillCycleType
	
	mappingList(srcMidVar6_cust.CreditLimit,dest.creditLimits,listMapping10_cust)
	
	dest.initBalance = srcMidVar6_cust.InitBalance
	
	destMidVar_cust.parentAcctKey = srcMidVar6_cust.ParentAcctKey
	
	destMidVar_cust.paymentType = srcMidVar6_cust.PaymentType
	
	destMidVar_cust.acctKey = src.AcctKey
	
	destMidVar_cust.currencyId = srcMidVar6_cust.CurrencyID
	
	mappingList(srcMidVar5_cust.FreeBillMedium,destMidVar_cust.bmInfos,listMapping56_cust)
	
	dest.uCustKey = srcMidVar6_cust.UserCustomerKey
	
	dest.redlistFlag = srcMidVar5_cust.RedlistFlag
	
}

def srcMidVar = srcArgs0.CreateSubscriberRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

def srcMidVar4 = srcArgs0.CreateSubscriberRequestMsg.CreateSubscriberRequest

mappingList(srcMidVar4.Account,destArgs1.createAccountInfos,listMapping2)

mappingList(srcMidVar4.AddressInfo,destArgs1.addresses,listMapping11)

def destMidVar4 = destArgs1.createSubscriberInfo

listMapping12.call(srcMidVar4.PrimaryOffering,destMidVar4.primaryOffering)

listMapping19.call(srcMidVar4.RegisterCustomer,destArgs1.regCustomerInfo)

def srcMidVar13 = srcArgs0.CreateSubscriberRequestMsg.CreateSubscriberRequest.RegisterCustomer

destArgs1.opType = srcMidVar13.OpType

listMapping30.call(srcMidVar4.Subscriber,destArgs1.createSubscriberInfo)

mappingList(srcMidVar4.Subscriber.SubscriberInfo.CreditLimit,destArgs1.creditLimits,listMapping10)

def srcMidVar16 = srcArgs0.CreateSubscriberRequestMsg.CreateSubscriberRequest.Subscriber

listMapping31.call(srcMidVar16.SubPaymentMode,destArgs1.subPaymentMode)

mappingList(srcMidVar4.SupplementaryOffering,destMidVar4.supplementaryOfferings,listMapping38)

listMapping47.call(srcMidVar4.UserCustomer,destArgs1.userCustomerInfo)

listMapping55.call(srcMidVar4.SalesInfo,destArgs1.salesInfo)

mappingList(srcMidVar4.SupplementaryOffering,destArgs1.supplementaryOfferings,listMapping58)

destArgs1.handlingChargeFlag = srcMidVar4.HandlingChargeFlag

def srcMidVar30 = srcArgs0.CreateSubscriberRequestMsg.CreateSubscriberRequest.Subscriber.SubscriberInfo

destArgs1.subUCustKey = srcMidVar30.UserCustomerKey

def srcMidVar31 = srcArgs0.CreateSubscriberRequestMsg.CreateSubscriberRequest.AdditionalProperty

mappingList(srcMidVar31,destArgs1.simplePropertyList,listMapping75)

listMapping_CustDFTAcct.call(srcMidVar13.DFTAccount,destArgs1.regCustomerDTFAccountInfo)

destArgs1.payRelationKey4Cust = srcMidVar13.DFTAccount.PayRelationKey
