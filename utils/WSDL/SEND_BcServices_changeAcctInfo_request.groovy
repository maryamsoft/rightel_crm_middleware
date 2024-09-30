import com.huawei.ngcbs.bm.common.common.Constant4Model
dest.setServiceOperation("AccountService","changeAcctInfoWithResult")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.account.changeaccountbasicinfo.io.ChangeAccountBasicInfoRequest"

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
	
	def destMidVar = dest.simpleProperty[0]
	
	def srcMidVar2 = src.AdditionalProperty[0]
	
	destMidVar.value = srcMidVar2.Value
	
	def srcMidVar3 = src.TimeFormat
	
	dest.timeType = srcMidVar3.TimeType
	
	dest.timeZoneId = srcMidVar3.TimeZoneID
	
	dest.version = src.Version
	
	dest.remoteAddress = srcMidVar1.RemoteIP
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	def srcMidVar4 = src.OwnershipInfo
	
	dest.beId = srcMidVar4.BEID
	
	dest.brId = srcMidVar4.BRID
	
	dest.interMode = src.AccessMode
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.accoutCode = src.AccountCode
	
	dest.accoutKey = src.AccountKey
	
	dest.payType = src.PayType
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.addr10 = src.Address10
	
	dest.addr11 = src.Address11
	
	dest.addr12 = src.Address12
	
	dest.postCode = src.PostCode
	
	dest.tpAddrKey = src.AddressKey
	
	dest.addr1 = src.Address1
	
	dest.addr2 = src.Address2
	
	dest.addr3 = src.Address3
	
	dest.addr4 = src.Address4
	
	dest.addr5 = src.Address5
	
	dest.addr6 = src.Address6
	
	dest.addr7 = src.Address7
	
	dest.addr8 = src.Address8
	
	dest.addr9 = src.Address9
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping8

listMapping8 = 
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

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.code = src.BMCode
	
	dest.type = src.BMType
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	def destMidVar0 = dest.accountInfo
	
	destMidVar0.acctName = src.AcctName
	
	mappingList(src.AcctProperty,dest.propertyInfos,listMapping7)
	
	destMidVar0.billLang = src.BillLang
	
	destMidVar0.dunningFlag = src.DunningFlag
	
	listMapping8.call(src.ContactInfo,dest.contactInfo)
	
	destMidVar0.latePaymentFlag = src.LateFeeChargeable
	
	mappingList(src.FreeBillMedium,destMidVar0.bmInfos,listMapping9)
	
	dest.redlistFlag = src.RedlistFlag
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.paymentChannelKey = src.AutoPayChannelKey

	dest.expirationTime = parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	dest.autoPayDate = src.AutoPayDate
	
	dest.autoPayMaxAmt = src.AutoPayMaxAmt
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->

	dest.controlPeriodType = src.ControlPeriodType
	
	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.balanceThreshold = src.BalanceThreshold
	
	dest.maxTimes = src.MaxTimes

	dest.balanceThresholdType = src.BalanceThresholdType
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

	dest.autoRechargeDate = src.AutoRechargeDate
	
	dest.periodType = src.PeriodType
	
	dest.autoRechargeAmt = src.AutoRechargeAmt
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	dest.payType = src.AutoPayType
	
	listMapping13.call(src.BillCycleSchema,dest.billCycleSchema)
	
	listMapping14.call(src.LowBalanceSchema,dest.lowBalanceSchema)
	
	listMapping15.call(src.TimeSchema,dest.timeSchema)
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	def srcMidVar5 = src.AutoPayChannelInfo
	
	dest.chargeCodes = srcMidVar5.ChargeCode
	
	def destMidVar1 = dest.paymentChannelInfo
	
	destMidVar1.bankBranchCode = srcMidVar5.BankBranchCode
	
	destMidVar1.bankAcctName = srcMidVar5.AcctName
	
	destMidVar1.bankAcctNo = srcMidVar5.AcctNo
	
	destMidVar1.bankAcctType = srcMidVar5.AcctType
	
	destMidVar1.bankCode = srcMidVar5.BankCode
	
	destMidVar1.creditCardType = srcMidVar5.CreditCardType
	
	destMidVar1.cvvNumber = srcMidVar5.CVVNumber
	
	destMidVar1.bankAcctExpDate = srcMidVar5.ExpDate
	
	destMidVar1.priority = srcMidVar5.Priority
	
	destMidVar1.paymentChannelKey = src.AutoPayChannelKey
	
	mappingList(srcMidVar5.PaymentPlan,dest.paymentPlanInfos,listMapping12)

	destMidVar1.effMode = srcMidVar5.EffectiveTime.Mode

	destMidVar1.effDate = parseDate(srcMidVar5.EffectiveTime.Time,Constant4Model.DATE_FORMAT)

	destMidVar1.expDate = parseDate(srcMidVar5.ExpireTime,Constant4Model.DATE_FORMAT)

	mappingList(srcMidVar5.AdditionalProperty,destMidVar1.paymentChannelProp,listMapping1)
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.newPaymentMethod = src.NewPayMethod
	
	dest.oldPaymentMethod = src.OldPayMethod
	
	mappingList(src.DelAutoPayChannel,dest.delAutoPayChannelKeys,listMapping10)
	
	mappingList(src.AddAutoPayChannel,dest.addAutoPayChannels,listMapping11)
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	listMapping3.call(src.AcctAccessCode,dest.acctAccessCode)
	
	listMapping4.call(src.AddressInfo,dest.addressInfo)
	
	listMapping5.call(src.AcctBasicInfo,dest.changeAcctBasicInfoInfo)
	
	listMapping6.call(src.AcctPayMethod,dest.changePaymentChannelInfo)
	
	dest.acctClass = src.AcctClass

	mappingList(src.AdditionalProperty,dest.simplePropertyList,listMapping16)
	
	dest.newAccountKey = src.NewAccountKey
	
}

def srcMidVar = srcArgs0.ChangeAcctInfoRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.ChangeAcctInfoRequest,destArgs1)
