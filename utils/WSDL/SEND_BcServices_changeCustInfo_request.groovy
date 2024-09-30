import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("CustomerService","changeCustInfo")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.customer.chgcustinfo.io.ChangeCustBasicInfoRequest"

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
	
	dest.messageSeq = src.MessageSeq
	
	dest.businessCode = src.BusinessCode
	
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
	
	dest.postCode = src.PostCode
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.customerCode = src.CustomerCode
	
	dest.customerKey = src.CustomerKey
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.custLevel = src.CustLevel
	
	dest.custLoyalty = src.CustLoyalty
	
	mappingList(src.CustProperty,dest.properties,listMapping7)
	
	dest.custSegment = src.CustSegment
	
	dest.billCycleType = src.DFTBillCycleType
	
	dest.currencyId = src.DFTCurrencyID
	
	dest.custPwd = src.DFTPwd
	
	dest.custWLang = src.DFTWrittenLang
	
	dest.custPLang = src.DFTIVRLang
	
	dest.dunningFlag = src.DunningFlag
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
	dest.idValidity = parseDate(src.IDValidity, Constant4Model.DATE_FORMAT)
	
	dest.industry = src.Industry
	
	dest.addrKey = src.OrgAddressKey
	
	dest.orgEmail = src.OrgEmail
	
	dest.orgLevel = src.OrgLevel
	
	dest.orgName = src.OrgName
	
	dest.orgPhone = src.OrgPhoneNumber
	
	dest.orgFax = src.OrgFaxNumber
	
	dest.orgSName = src.OrgShortName
	
	dest.orgType = src.OrgType
	
	dest.orgWeb = src.OrgWebSite
	
	dest.subIndustry = src.SubIndustry
	
	dest.sizeLevel = src.OrgSize
	
	mappingList(src.OrgProperty,dest.properties,listMapping9)
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.birthday = parseDate(src.Birthday, Constant4Model.DATE_FORMAT)
	
	dest.education = src.Education
	
	dest.email = src.Email
	
	dest.fax = src.Fax
	
	dest.firstName = src.FirstName
	
	dest.gender = src.Gender
	
	dest.addrKey = src.HomeAddressKey
	
	dest.homePhone = src.HomePhone
	
	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
	dest.idValidity = parseDate(src.IDValidity, Constant4Model.DATE_FORMAT)
	
	dest.lastName = src.LastName
	
	dest.marriedStatus = src.MaritalStatus
	
	dest.middleName = src.MiddleName
	
	dest.mobilePhone = src.MobilePhone
	
	dest.nationality = src.Nationality
	
	dest.nativePlace = src.NativePlace
	
	dest.occupation = src.Occupation
	
	dest.officePhone = src.OfficePhone
	
	mappingList(src.IndividualProperty,dest.properties,listMapping11)
	
	dest.race = src.Race
	
	dest.salary = src.Salary
	
	dest.title = src.Title
	
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

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	listMapping6.call(src.CustBasicInfo,dest.customerInfo)
	
	listMapping8.call(src.Organization,dest.orgInfo)
	
	listMapping10.call(src.Individual,dest.individualInfo)
	
	def srcMidVar4 = src.CustBasicInfo
	
	mappingList(srcMidVar4.CustProperty,dest.custProperties,listMapping12)
	
	def srcMidVar5 = src.Individual
	
	mappingList(srcMidVar5.IndividualProperty,dest.indvProperties,listMapping13)
	
	def srcMidVar6 = src.Organization
	
	mappingList(srcMidVar6.OrgProperty,dest.orgProperties,listMapping14)
	
}

def listMapping15
listMapping15 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	listMapping3.call(src.AddressInfo,dest.addressInfo)
	
	listMapping4.call(src.CustAccessCode,dest.custAccessCode)
	
	listMapping5.call(src.CustInfo,dest.changeCustBasicInfo)
	
	mappingList(src.AdditionalProperty,dest.simplePropertyList,listMapping15)
	
	dest.newCustomerKey = src.NewCustomerKey
	
}

def srcMidVar = srcArgs0.ChangeCustInfoRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.ChangeCustInfoRequest,destArgs1)
