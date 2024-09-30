import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("SubscriberService","changeSubInfo")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.changesubinfo.io.ChangeSubBasicInfoRequest"

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

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
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

	dest.channelType = src.ChannelType
	
	dest.noticeType = src.NoticeType
	
	dest.subNoticeType = src.SubNoticeType
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

		dest.birthday=parseDate(src.Birthday,Constant4Model.DATE_FORMAT)
	
	dest.education = src.Education
	
	dest.email = src.Email
	
	dest.fax = src.Fax
	
	dest.firstName = src.FirstName
	
	dest.gender = src.Gender
	
	dest.homePhone = src.HomePhone
	
	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
		dest.idValidity=parseDate(src.IDValidity,Constant4Model.DATE_FORMAT)
	
	dest.lastName = src.LastName
	
	dest.middleName = src.MiddleName
	
	dest.mobilePhone = src.MobilePhone
	
	dest.nationality = src.Nationality
	
	dest.nativePlace = src.NativePlace
	
	dest.occupation = src.Occupation
	
	dest.officePhone = src.OfficePhone
	
	dest.race = src.Race
	
	dest.salary = src.Salary
	
	dest.title = src.Title
	
	dest.addrKey = src.HomeAddressKey
	
	dest.marriedStatus = src.MaritalStatus
	
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

	dest.idNumber = src.IDNumber
	
	dest.idType = src.IDType
	
		dest.idValidity=parseDate(src.IDValidity,Constant4Model.DATE_FORMAT)
	
	dest.industry = src.Industry
	
	dest.orgEmail = src.OrgEmail
	
	dest.orgLevel = src.OrgLevel
	
	dest.orgName = src.OrgName
	
	dest.orgType = src.OrgType
	
	dest.subIndustry = src.SubIndustry
	
	dest.addrKey = src.OrgAddressKey
	
	dest.orgFax = src.OrgFaxNumber
	
	dest.orgWeb = src.OrgWebSite
	
	dest.orgSName = src.OrgShortName
	
	dest.sizeLevel = src.OrgSize
	
	dest.orgPhone = src.OrgPhoneNumber
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.ChangeSubInfoRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar.BEID

destArgs0.brId = srcMidVar.BRID

def srcMidVar0 = srcArgs0.ChangeSubInfoRequestMsg.RequestHeader

destArgs0.businessCode = srcMidVar0.BusinessCode

def srcMidVar1 = srcArgs0.ChangeSubInfoRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.ChangeSubInfoRequestMsg.RequestHeader.AccessSecurity

destArgs0.password = srcMidVar2.Password

def srcMidVar3 = srcArgs0.ChangeSubInfoRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

destArgs0.remoteAddress = srcMidVar2.RemoteIP

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

def srcMidVar4 = srcArgs0.ChangeSubInfoRequestMsg.ChangeSubInfoRequest

listMapping1.call(srcMidVar4.SubAccessCode,destArgs1.subAccessCode)

def destMidVar = destArgs1.addressInfo

def srcMidVar5 = srcArgs0.ChangeSubInfoRequestMsg.ChangeSubInfoRequest.AddressInfo

destMidVar.addr1 = srcMidVar5.Address1

destMidVar.addr10 = srcMidVar5.Address10

destMidVar.addr11 = srcMidVar5.Address11

destMidVar.addr12 = srcMidVar5.Address12

destMidVar.addr2 = srcMidVar5.Address2

destMidVar.addr3 = srcMidVar5.Address3

destMidVar.addr4 = srcMidVar5.Address4

destMidVar.addr5 = srcMidVar5.Address5

destMidVar.addr6 = srcMidVar5.Address6

destMidVar.addr7 = srcMidVar5.Address7

destMidVar.addr8 = srcMidVar5.Address8

destMidVar.addr9 = srcMidVar5.Address9

destMidVar.tpAddrKey = srcMidVar5.AddressKey

destMidVar.postCode = srcMidVar5.PostCode

def srcMidVar6 = srcArgs0.ChangeSubInfoRequestMsg.ChangeSubInfoRequest.SubBasicInfo

def destMidVar0 = destArgs1.changeSubBasicInfo

mappingList(srcMidVar6.SubProperty,destMidVar0.subProperties,listMapping2)

def destMidVar1 = destArgs1.changeSubBasicInfo.subscriberInfo

destMidVar1.writtenLang = srcMidVar6.WrittenLang

destMidVar1.ivrLang = srcMidVar6.IVRLang

destMidVar1.subLevel = srcMidVar6.SubLevel

destMidVar1.dunningFlag = srcMidVar6.DunningFlag

def destMidVar2 = destArgs1.userCustomerInfo.customerInfo

def srcMidVar7 = srcArgs0.ChangeSubInfoRequestMsg.ChangeSubInfoRequest.UserCustomer.CustInfo.CustBasicInfo

destMidVar2.custLevel = srcMidVar7.CustLevel

destMidVar2.custLoyalty = srcMidVar7.CustLoyalty

destMidVar2.custSegment = srcMidVar7.CustSegment

destMidVar2.dunningFlag = srcMidVar7.DunningFlag

def destMidVar3 = destArgs1.userCustomerInfo

mappingList(srcMidVar7.CustProperty,destMidVar3.custProperties,listMapping3)

destMidVar2.billCycleType = srcMidVar7.DFTBillCycleType

destMidVar2.currencyId = srcMidVar7.DFTCurrencyID

destMidVar2.custPLang = srcMidVar7.DFTIVRLang

destMidVar2.custPwd = srcMidVar7.DFTPwd

destMidVar2.custWLang = srcMidVar7.DFTWrittenLang

def srcMidVar8 = srcArgs0.ChangeSubInfoRequestMsg.ChangeSubInfoRequest.UserCustomer.CustInfo

destMidVar2.custClass = srcMidVar8.CustClass

destMidVar2.custCode = srcMidVar8.CustCode

destMidVar2.custNodeType = srcMidVar8.CustNodeType

destMidVar2.custType = srcMidVar8.CustType

mappingList(srcMidVar8.NoticeSuppress,destMidVar3.noticeSuppresses,listMapping4)

destMidVar2.parentCustKey = srcMidVar8.ParentCustKey

def srcMidVar9 = srcArgs0.ChangeSubInfoRequestMsg.ChangeSubInfoRequest.UserCustomer

listMapping5.call(srcMidVar9.IndividualInfo,destMidVar3.individualInfo)

def srcMidVar10 = srcArgs0.ChangeSubInfoRequestMsg.ChangeSubInfoRequest.UserCustomer.IndividualInfo

mappingList(srcMidVar10.IndividualProperty,destMidVar3.indvProperties,listMapping6)

listMapping7.call(srcMidVar9.OrgInfo,destMidVar3.orgInfo)

def srcMidVar11 = srcArgs0.ChangeSubInfoRequestMsg.ChangeSubInfoRequest.UserCustomer.OrgInfo

mappingList(srcMidVar11.OrgProperty,destMidVar3.orgProperties,listMapping8)

destMidVar2.tpCustKey = srcMidVar9.CustKey

destArgs0.interMode = srcMidVar0.AccessMode

destArgs1.code=srcMidVar6.NewSubscriberKey

def listMapping9
listMapping9 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

mappingList(srcMidVar4.AdditionalProperty,destArgs1.simplePropertyList,listMapping9)