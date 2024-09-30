import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("CustomerService","createCustomer")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.customer.createcustomer.io.CreateCustomerRequest"

def listMapping0

listMapping0 = 
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

	dest.channelType = src.ChannelType
	
	dest.noticeType = src.NoticeType
	
	dest.subNoticeType = src.SubNoticeType
	
}

def listMapping3

listMapping3 = 
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
	
	dest.orgWeb = src.OrgWebSite
	
	dest.subIndustry = src.SubIndustry
	
	dest.orgType = src.OrgType
	
	dest.sizeLevel = src.OrgSize
	
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

	dest.acctKey = src.AcctKey
	
	dest.payRelationKey = src.PayRelationKey
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.salesChannelId = src.SalesChannelID
	
	dest.salesId = src.SalesID
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	listMapping10.call(src.CustInfo,dest.customerInfo)
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping13

listMapping13 = 
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

def listMapping14

listMapping14 = 
{
    src,dest  ->

	dest.code = src.BMCode
	
	dest.type = src.BMType
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	def destMidVar2 = dest.accountInfo
	
	destMidVar2.acctName = src.AcctName
	
	destMidVar2.billLang = src.BillLang
	
	mappingList(src.AcctProperty,dest.properties,listMapping12)
	
	listMapping13.call(src.ContactInfo,dest.contactInfo)
	
	destMidVar2.dunningFlag = src.DunningFlag
	
	mappingList(src.FreeBillMedium,destMidVar2.bmInfos,listMapping14)
	
	destMidVar2.latePaymentFlag = src.LateFeeChargeable
	
	dest.redlistFlag = src.RedlistFlag
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	dest.bankAcctName = src.AcctName
	
	dest.bankAcctNo = src.AcctNo
	
	dest.bankAcctType = src.AcctType
	
	dest.bankBranchCode = src.BankBranchCode
	
	dest.bankCode = src.BankCode
	
	dest.creditCardType = src.CreditCardType
	
	dest.cvvNumber = src.CVVNumber
	
	dest.priority = src.Priority
	
	dest.bankAcctExpDate = src.ExpDate

	dest.effMode = src.EffectiveTime.Mode

	dest.effDate = parseDate(src.EffectiveTime.Time,Constant4Model.DATE_FORMAT)

	dest.expDate = parseDate(src.ExpireTime,Constant4Model.DATE_FORMAT)

	mappingList(src.AdditionalProperty,dest.paymentChannelProp,listMapping1)
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	dest.autoPayDate = src.AutoPayDate
	
	dest.autoPayMaxAmt = src.AutoPayMaxAmt
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.balanceThreshold = src.BalanceThreshold
	
	dest.controlPeriodType = src.ControlPeriodType
	
	dest.maxTimes = src.MaxTimes

	dest.balanceThresholdType = src.BalanceThresholdType
	
}

def listMapping20

listMapping20 = 
{
    src,dest  ->

	dest.autoRechargeAmt = src.AutoRechargeAmt
	
	dest.autoRechargeDate = src.AutoRechargeDate
	
	dest.periodType = src.PeriodType
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	dest.payType = src.AutoPayType
	
	listMapping18.call(src.BillCycleSchema,dest.billCycleSchema)
	
	listMapping19.call(src.LowBalanceSchema,dest.lowBalanceSchema)
	
	listMapping20.call(src.TimeSchema,dest.timeSchema)
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

	listMapping16.call(src.AutoPayChannelInfo,dest.paymentChannelInfo)
	
	def destMidVar5 = dest.paymentChannelInfo
	
	destMidVar5.paymentChannelKey = src.AutoPayChannelKey
	
	def srcMidVar12 = src.AutoPayChannelInfo
	
	mappingList(srcMidVar12.PaymentPlan,dest.paymentPlanInfos,listMapping17)
	
	dest.chargeCodes = srcMidVar12.ChargeCode
	
}

def listMapping21

listMapping21 = 
{
    src,dest  ->
  dest._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitExtInfo"
	dest.limitType = src.LimitType
	
	def destMidVar6 = dest.valueInfo
	
	destMidVar6.amount = src.LimitValue
	
	dest.limitPlanCode = src.LimitPlanCode
	
}

def listMapping22

listMapping22 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.CreateCustomerRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar.LoginSystemCode

destArgs0.password = srcMidVar.Password

destArgs0.remoteAddress = srcMidVar.RemoteIP

mappingList(srcArgs0.CreateCustomerRequestMsg.RequestHeader.AdditionalProperty,destArgs0.simpleProperty,listMapping22)

def srcMidVar1 = srcArgs0.CreateCustomerRequestMsg.RequestHeader

destArgs0.businessCode = srcMidVar1.BusinessCode

destArgs0.messageSeq = srcMidVar1.MessageSeq

destArgs0.msgLanguageCode = srcMidVar1.MsgLanguageCode

def srcMidVar2 = srcArgs0.CreateCustomerRequestMsg.RequestHeader.OperatorInfo

destArgs0.operatorId = srcMidVar2.OperatorID

destArgs0.channelId = srcMidVar2.ChannelID

def srcMidVar3 = srcArgs0.CreateCustomerRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar3.BEID

destArgs0.brId = srcMidVar3.BRID

def srcMidVar4 = srcArgs0.CreateCustomerRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar4.TimeType

destArgs0.timeZoneId = srcMidVar4.TimeZoneID

destArgs0.version = srcMidVar1.Version

def srcMidVar5 = srcArgs0.CreateCustomerRequestMsg.CreateCustomerRequest

mappingList(srcMidVar5.AddressInfo,destArgs1.addresses,listMapping0)

def destMidVar0 = destArgs1.createCustomerInfo.customerInfo

def srcMidVar6 = srcArgs0.CreateCustomerRequestMsg.CreateCustomerRequest.Customer.CustInfo.CustBasicInfo

destMidVar0.custLevel = srcMidVar6.CustLevel

destMidVar0.custLoyalty = srcMidVar6.CustLoyalty

def destMidVar1 = destArgs1.createCustomerInfo

mappingList(srcMidVar6.CustProperty,destMidVar1.custProperties,listMapping1)

destMidVar0.custSegment = srcMidVar6.CustSegment

destMidVar0.billCycleType = srcMidVar6.DFTBillCycleType

destMidVar0.currencyId = srcMidVar6.DFTCurrencyID

destMidVar0.custPLang = srcMidVar6.DFTIVRLang

destMidVar0.custPwd = srcMidVar6.DFTPwd

destMidVar0.custWLang = srcMidVar6.DFTWrittenLang

destMidVar0.dunningFlag = srcMidVar6.DunningFlag

def srcMidVar7 = srcArgs0.CreateCustomerRequestMsg.CreateCustomerRequest.Customer.CustInfo

destMidVar0.custClass = srcMidVar7.CustClass

destMidVar0.custCode = srcMidVar7.CustCode

destMidVar0.custNodeType = srcMidVar7.CustNodeType

destMidVar0.custType = srcMidVar7.CustType

mappingList(srcMidVar7.NoticeSuppress,destMidVar1.noticeSuppresses,listMapping2)

destMidVar0.parentCustKey = srcMidVar7.ParentCustKey

def srcMidVar8 = srcArgs0.CreateCustomerRequestMsg.CreateCustomerRequest.Customer

destMidVar0.tpCustKey = srcMidVar8.CustKey

listMapping3.call(srcMidVar8.IndividualInfo,destMidVar1.individualInfo)

def srcMidVar9 = srcArgs0.CreateCustomerRequestMsg.CreateCustomerRequest.Customer.IndividualInfo

mappingList(srcMidVar9.IndividualProperty,destMidVar1.indvProperties,listMapping4)

listMapping5.call(srcMidVar8.OrgInfo,destMidVar1.orgInfo)

def srcMidVar10 = srcArgs0.CreateCustomerRequestMsg.CreateCustomerRequest.Customer.OrgInfo

mappingList(srcMidVar10.OrgProperty,destMidVar1.orgProperties,listMapping6)

listMapping7.call(srcMidVar5.DFTAccount,destArgs1.dftAccount)

listMapping8.call(srcMidVar5.SalesInfo,destMidVar1.salesInfo)

listMapping9.call(srcMidVar5.Customer,destArgs1.createCustomerInfo)

def srcMidVar11 = srcArgs0.CreateCustomerRequestMsg.CreateCustomerRequest.DFTAccount.AcctInfo

listMapping11.call(srcMidVar11.AcctBasicInfo,destArgs1.createAccountInfo)

def destMidVar3 = destArgs1.createAccountInfo.accountInfo

destMidVar3.acctClass = srcMidVar11.AcctClass

destMidVar3.acctCode = srcMidVar11.AcctCode

destMidVar3.acctPaymentMethod = srcMidVar11.AcctPayMethod

destMidVar3.acctType = srcMidVar11.AcctType

def destMidVar4 = destArgs1.createAccountInfo

mappingList(srcMidVar11.AutoPayChannel,destMidVar4.paymentChannels,listMapping15)

destMidVar4.billCycleType = srcMidVar11.BillCycleType

mappingList(srcMidVar11.CreditLimit,destMidVar4.creditLimits,listMapping21)

destMidVar3.currencyId = srcMidVar11.CurrencyID

destMidVar4.initBalance = srcMidVar11.InitBalance

destMidVar3.parentAcctKey = srcMidVar11.ParentAcctKey

destMidVar3.paymentType = srcMidVar11.PaymentType

def srcMidVar13 = srcArgs0.CreateCustomerRequestMsg.CreateCustomerRequest.DFTAccount

destMidVar3.acctKey = srcMidVar13.AcctKey

destArgs1.registerCustKey = srcMidVar5.RegisterCustKey

destArgs0.interMode = srcMidVar1.AccessMode

destMidVar4.uCustKey = srcMidVar11.UserCustomerKey

destArgs1.effectiveTime = parseDate(srcMidVar5.EffectiveTime,Constant4Model.DATE_FORMAT)
