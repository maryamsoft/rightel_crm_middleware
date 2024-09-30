import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("AccountService","createAccountWithResult")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.account.createaccount.io.CreateAccountRequest"

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

	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	def srcMidVar0 = src.AccessSecurity
	
	dest.loginSystem = srcMidVar0.LoginSystemCode
	
	dest.password = srcMidVar0.Password
	
	dest.remoteAddress = srcMidVar0.RemoteIP
	
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

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.addr10 = src.Address10
	
	dest.addr11 = src.Address11
	
	dest.addr12 = src.Address12
	
	dest.postCode = src.PostCode
	
	dest.tpAddrKey = src.AddressKey
	
	dest.addr9 = src.Address9
	
	dest.addr8 = src.Address8
	
	dest.addr7 = src.Address7
	
	dest.addr6 = src.Address6
	
	dest.addr5 = src.Address5
	
	dest.addr4 = src.Address4
	
	dest.addr3 = src.Address3
	
	dest.addr2 = src.Address2
	
	dest.addr1 = src.Address1
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->
  dest._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitExtInfo"
	dest.limitType = src.LimitType
	
	def destMidVar1 = dest.valueInfo
	
	destMidVar1.amount = src.LimitValue
	
	dest.limitPlanCode = src.LimitPlanCode
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.email = src.Email
	
	dest.homePhone = src.HomePhone
	
	dest.middleName = src.MiddleName
	
	dest.mobilePhone = src.MobilePhone
	
	dest.officePhone = src.OfficePhone
	
	dest.title = src.Title
	
	dest.addrKey = src.AddressKey
	
	dest.fax = src.Fax
	
	dest.firstName = src.FirstName
	
	dest.lastName = src.LastName
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.code = src.BMCode
	
	dest.type = src.BMType
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	dest.autoPayDate = src.AutoPayDate
	
	dest.autoPayMaxAmt = src.AutoPayMaxAmt
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	dest.controlPeriodType = src.ControlPeriodType
	
	dest.maxTimes = src.MaxTimes
	
	dest.balanceThreshold = src.BalanceThreshold
	
	dest.autoRechargeAmt = src.AutoRechargeAmt

	dest.balanceThresholdType = src.BalanceThresholdType
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->

	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.autoRechargeDate = src.AutoRechargeDate
	
	dest.periodType = src.PeriodType
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.payType = src.AutoPayType
	
	listMapping12.call(src.BillCycleSchema,dest.billCycleSchema)
	
	listMapping13.call(src.LowBalanceSchema,dest.lowBalanceSchema)
	
	listMapping14.call(src.TimeSchema,dest.timeSchema)
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	def srcMidVar7 = src.AutoPayChannelInfo
	
	dest.chargeCodes = srcMidVar7.ChargeCode
	
	mappingList(srcMidVar7.PaymentPlan,dest.paymentPlanInfos,listMapping11)
	
	def destMidVar2 = dest.paymentChannelInfo
	
	destMidVar2.bankAcctName = srcMidVar7.AcctName
	
	destMidVar2.bankAcctNo = srcMidVar7.AcctNo
	
	destMidVar2.bankAcctType = srcMidVar7.AcctType
	
	destMidVar2.bankBranchCode = srcMidVar7.BankBranchCode
	
	destMidVar2.bankCode = srcMidVar7.BankCode
	
	destMidVar2.creditCardType = srcMidVar7.CreditCardType
	
	destMidVar2.cvvNumber = srcMidVar7.CVVNumber
	
	destMidVar2.bankAcctExpDate = srcMidVar7.ExpDate
	
	destMidVar2.priority = srcMidVar7.Priority
	
	destMidVar2.paymentChannelKey = src.AutoPayChannelKey

	destMidVar2.effMode = srcMidVar7.EffectiveTime.Mode

	destMidVar2.effDate = parseDate(srcMidVar7.EffectiveTime.Time,Constant4Model.DATE_FORMAT)

	destMidVar2.expDate = parseDate(srcMidVar7.ExpireTime,Constant4Model.DATE_FORMAT)

	mappingList(srcMidVar7.AdditionalProperty,destMidVar2.paymentChannelProp,listMapping1)
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping20

listMapping20 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	dest.effDate=parseDate(src.EffectiveTime, Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	def destMidVar5 = dest.property
	
	destMidVar5.propCode = src.PropCode
	
	mappingList(src.SubPropInst,destMidVar5.subProps,listMapping20)
	
	destMidVar5.value = src.Value
	
	destMidVar5.complexFlag = src.PropType
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	def destMidVar4 = dest.productInst
	
	destMidVar4.networkType = src.NetworkType
	
	destMidVar4.packageFlag = src.PackageFlag
	
	destMidVar4.parentProdId = src.ParentProdID
	
	destMidVar4.primaryFlag = src.PrimaryFlag
	
	destMidVar4.prodId = src.ProductID
	
	destMidVar4.productType = src.ProductType
	
	mappingList(src.PInstProperty,dest.properties,listMapping19)
	
}

def listMapping21

listMapping21 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping23

listMapping23 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping22

listMapping22 = 
{
    src,dest  ->

	dest.effDate=parseDate(src.EffectiveTime, Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	def destMidVar6 = dest.property
	
	destMidVar6.propCode = src.PropCode
	
	destMidVar6.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar6.subProps,listMapping23)
	
	destMidVar6.value = src.Value
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

	def destMidVar3 = dest.offeringInst
	
	destMidVar3.bundleFlag = src.BundledFlag
	
	dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	destMidVar3.offeringClass = src.OfferingClass
	
	def oKeyExt = destMidVar3.offeringKey
	
  oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	listMapping16.call(src.OfferingKey,oKeyExt)
	
	destMidVar3.status = src.Status
	
	destMidVar3.trialEndTime=parseDate(src.TrialEndTime, Constant4Model.DATE_FORMAT)
	
	destMidVar3.trialStartTime=parseDate(src.TrialStartTime, Constant4Model.DATE_FORMAT)
	
	def oKeyExt17 = destMidVar3.relGOfferingKey
	
  oKeyExt17._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	listMapping17.call(src.RelGOfferingKey,oKeyExt17)
	
	mappingList(src.ProductInst,dest.productInsts,listMapping18)
	
	destMidVar3.activeTime=parseDate(src.ActivationTime.ActiveTime, Constant4Model.DATE_FORMAT)
	
	def srcMidVar8 = src.ActivationTime
	
	destMidVar3.activeTimeLimit = parseDate(srcMidVar8.ActiveTimeLimit, Constant4Model.DATE_FORMAT)
	
	destMidVar3.activeMode = srcMidVar8.Mode
	
	def srcMidVar9 = src.EffectiveTime
	
	dest.effMode = srcMidVar9.Mode
	
	dest.effDate=parseDate(srcMidVar9.Time, Constant4Model.DATE_FORMAT)
	
	def oKeyExt21 = destMidVar3.parentOfferingKey
	
  oKeyExt21._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	listMapping21.call(src.ParentOfferingKey,oKeyExt21)
	
	mappingList(src.OInstProperty,dest.properties,listMapping22)
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	listMapping3.call(src.AddressInfo,dest.address)
	
	dest.registerCustKey = src.RegisterCustKey
	
	def destMidVar = dest.createAccountInfo.accountInfo
	
	def srcMidVar4 = src.Account
	
	destMidVar.acctKey = srcMidVar4.AcctKey
	
	def srcMidVar5 = src.Account.AcctInfo
	
	destMidVar.acctClass = srcMidVar5.AcctClass
	
	destMidVar.acctCode = srcMidVar5.AcctCode
	
	destMidVar.acctPaymentMethod = srcMidVar5.AcctPayMethod
	
	destMidVar.acctType = srcMidVar5.AcctType
	
	def destMidVar0 = dest.createAccountInfo
	
	destMidVar0.billCycleType = srcMidVar5.BillCycleType
	
	destMidVar.currencyId = srcMidVar5.CurrencyID
	
	destMidVar0.initBalance = srcMidVar5.InitBalance
	
	destMidVar.parentAcctKey = srcMidVar5.ParentAcctKey
	
	destMidVar.paymentType = srcMidVar5.PaymentType
	
	mappingList(srcMidVar5.CreditLimit,destMidVar0.creditLimits,listMapping4)
	
	def srcMidVar6 = src.Account.AcctInfo.AcctBasicInfo
	
	destMidVar.acctName = srcMidVar6.AcctName
	
	destMidVar.billLang = srcMidVar6.BillLang
	
	destMidVar.dunningFlag = srcMidVar6.DunningFlag
	
	destMidVar.latePaymentFlag = srcMidVar6.LateFeeChargeable
	
	listMapping7.call(srcMidVar6.ContactInfo,destMidVar0.contactInfo)
	
	mappingList(srcMidVar6.FreeBillMedium,destMidVar.bmInfos,listMapping8)
	
	mappingList(srcMidVar6.AcctProperty,destMidVar0.properties,listMapping9)
	
	mappingList(srcMidVar5.AutoPayChannel,destMidVar0.paymentChannels,listMapping10)
	
	destMidVar0.redlistFlag = srcMidVar6.RedlistFlag
	
	destMidVar0.uCustKey = srcMidVar5.UserCustomerKey
	
	mappingList(src.Offering,dest.offerings,listMapping15)
	
	dest.effectiveTime= parseDate(src.EffectiveTime, Constant4Model.DATE_FORMAT)
	
}

def srcMidVar = srcArgs0.CreateAccountRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.CreateAccountRequest,destArgs1)
