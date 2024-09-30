import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("BMGroupService","createGroupWithResult")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.creategroup.io.CreateGroupRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	
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

	dest.code = src.Code
	
	dest.value = src.Value
	
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

	dest.channelType = src.ChannelType
	
	dest.noticeType = src.NoticeType
	
	dest.subNoticeType = src.SubNoticeType
	
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

def listMapping16

listMapping16 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar12 = dest.property
	
	destMidVar12.propCode = src.PropCode
	
	destMidVar12.complexFlag = src.PropType
	
	destMidVar12.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar12.subProps,listMapping16)
	
}

def listMapping19

listMapping19 = 
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
	
	def destMidVar15 = dest.property
	
	destMidVar15.propCode = src.PropCode
	
	destMidVar15.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar15.subProps,listMapping19)
	
	destMidVar15.value = src.Value
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	mappingList(src.PInstProperty,dest.properties,listMapping18)
	
	def destMidVar16 = dest.productInst
	
	destMidVar16.networkType = src.NetworkType
	
	destMidVar16.packageFlag = src.PackageFlag
	
	destMidVar16.parentProdId = src.ParentProdID
	
	destMidVar16.primaryFlag = src.PrimaryFlag
	
	destMidVar16.prodId = src.ProductID
	
	destMidVar16.productType = src.ProductType
	
}

def listMapping20

listMapping20 = 
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
  dest._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitExtInfo"
	dest.limitType = src.LimitType
	
	def destMidVar20 = dest.valueInfo
	
	destMidVar20.amount = src.LimitValue
	
	destMidVar20.category = Constant4Model.CREDIT_LIMIT_TYPE_INIT
	
	dest.limitPlanCode = src.LimitPlanCode
	
}

def listMapping23

listMapping23 = 
{
    src,dest  ->

	dest.code = src.BMCode
	
	dest.type = src.BMType
	
}

def listMapping25

listMapping25 = 
{
    src,dest  ->

	def destMidVar23 = dest.billCycleSchema
	
	def srcMidVar26 = src.BillCycleSchema
	
	destMidVar23.autoPayDate = srcMidVar26.AutoPayDate
	
	def destMidVar24 = dest.lowBalanceSchema
	
	def srcMidVar27 = src.LowBalanceSchema
	
	destMidVar24.controlPeriodType = srcMidVar27.ControlPeriodType
	
	def destMidVar25 = dest.timeSchema
	
	def srcMidVar28 = src.TimeSchema
	
	destMidVar25.autoRechargeDate = srcMidVar28.AutoRechargeDate
	
	destMidVar25.periodType = srcMidVar28.PeriodType
	
	destMidVar25.autoRechargeAmt = srcMidVar28.AutoRechargeAmt
	
	destMidVar24.maxTimes = srcMidVar27.MaxTimes
	
	destMidVar24.balanceThreshold = srcMidVar27.BalanceThreshold

	destMidVar24.balanceThresholdType = srcMidVar27.BalanceThresholdType
	
	destMidVar24.autoRechargeAmt = srcMidVar27.AutoRechargeAmt
	
	destMidVar23.autoPayMaxAmt = srcMidVar26.AutoPayMaxAmt
	
	dest.payType = src.AutoPayType
	
}

def listMapping24

listMapping24 = 
{
    src,dest  ->

	def destMidVar22 = dest.paymentChannelInfo
	
	destMidVar22.paymentChannelKey = src.AutoPayChannelKey
	
	def srcMidVar25 = src.AutoPayChannelInfo
	
	destMidVar22.bankAcctName = srcMidVar25.AcctName
	
	destMidVar22.bankAcctNo = srcMidVar25.AcctNo
	
	destMidVar22.bankAcctType = srcMidVar25.AcctType
	
	destMidVar22.bankBranchCode = srcMidVar25.BankBranchCode
	
	destMidVar22.bankCode = srcMidVar25.BankCode
	
	destMidVar22.creditCardType = srcMidVar25.CreditCardType
	
	destMidVar22.cvvNumber = srcMidVar25.CVVNumber
	
	destMidVar22.priority = srcMidVar25.Priority
	
	mappingList(srcMidVar25.PaymentPlan,dest.paymentPlanInfos,listMapping25)
	
	destMidVar22.bankAcctExpDate = srcMidVar25.ExpDate
	
	dest.chargeCodes = srcMidVar25.ChargeCode

	destMidVar22.effMode = srcMidVar25.EffectiveTime.Mode

	destMidVar22.effDate = parseDate(srcMidVar25.EffectiveTime.Time,Constant4Model.DATE_FORMAT)

	destMidVar22.expDate = parseDate(srcMidVar25.ExpireTime,Constant4Model.DATE_FORMAT)

	mappingList(srcMidVar25.AdditionalProperty,destMidVar22.paymentChannelProp,listMapping1)
	
}

def listMapping29

listMapping29 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping27

listMapping27 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar28 = dest.property
	
	destMidVar28.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar28.subProps,listMapping29)
	
	destMidVar28.value = src.Value
	
	destMidVar28.propCode = src.PropCode
	
}

def listMapping31

listMapping31 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping30

listMapping30 = 
{
    src,dest  ->

			dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar31 = dest.property
	
	destMidVar31.propCode = src.PropCode
	
	destMidVar31.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar31.subProps,listMapping31)
	
	destMidVar31.value = src.Value
	
}

def listMapping28

listMapping28 = 
{
    src,dest  ->

	def destMidVar30 = dest.productInst
	
	destMidVar30.parentProdId = src.ParentProdID
	
	mappingList(src.PInstProperty,dest.properties,listMapping30)
	
	destMidVar30.prodId = src.ProductID
	
	destMidVar30.primaryFlag = src.PrimaryFlag
	
	destMidVar30.networkType = src.NetworkType
	
	destMidVar30.packageFlag = src.PackageFlag
	
	destMidVar30.productType = src.ProductType
	
}

def listMapping26

listMapping26 = 
{
    src,dest  ->

	def destMidVar26 = dest.offeringInst
	
	destMidVar26.offeringClass = src.OfferingClass
	
	destMidVar26.status = src.Status
	
	def srcMidVar29 = src.OfferingOwner
	
	dest.ownerKey = srcMidVar29.OwnerKey
	
	dest.ownerType = srcMidVar29.OwnerType
	
			destMidVar26.activeTime=parseDate(src.ActivationTime.ActiveTime,Constant4Model.DATE_FORMAT)
	
			destMidVar26.activeTimeLimit=parseDate(src.ActivationTime.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	def srcMidVar30 = src.ActivationTime
	
	destMidVar26.activeMode = srcMidVar30.Mode
	
	destMidVar26.bundleFlag = src.BundledFlag
	
	def srcMidVar31 = src.EffectiveTime
	
	dest.effMode = srcMidVar31.Mode
	
			dest.effDate=parseDate(srcMidVar31.Time,Constant4Model.DATE_FORMAT)
	
			dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar27 = dest.offeringInst.offeringKey
	
	destMidVar27._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	def srcMidVar32 = src.OfferingKey
	
	destMidVar27.oId = srcMidVar32.OfferingID
	
	destMidVar27.oCode = srcMidVar32.OfferingCode
	
	destMidVar27.pSeq = srcMidVar32.PurchaseSeq
	
	mappingList(src.OInstProperty,dest.properties,listMapping27)
	
	def destMidVar29 = dest.offeringInst.parentOfferingKey
	
	destMidVar29._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	def srcMidVar33 = src.ParentOfferingKey
	
	destMidVar29.oId = srcMidVar33.OfferingID
	
	destMidVar29.oCode = srcMidVar33.OfferingCode
	
	destMidVar29.pSeq = srcMidVar33.PurchaseSeq
	
	mappingList(src.ProductInst,dest.productInsts,listMapping28)
	
	def destMidVar32 = dest.offeringInst.relGOfferingKey
	
	destMidVar32._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	def srcMidVar34 = src.RelGOfferingKey
	
	destMidVar32.oId = srcMidVar34.OfferingID
	
	destMidVar32.oCode = srcMidVar34.OfferingCode
	
	destMidVar32.pSeq = srcMidVar34.PurchaseSeq
	
			destMidVar26.trialEndTime=parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
			destMidVar26.trialStartTime=parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
	
}

def listMapping32

listMapping32 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping33

listMapping33 =
		{
			src,dest  ->
				def srcMidVar35 = src.DestGroupAccessCode
				dest.groupKey = srcMidVar35.SubGroupKey
				dest.groupCode = srcMidVar35.SubGroupCode
		}
def listMapping34

listMapping34 =
		{
			src,dest  ->
				def srcMidVar36 = src.SrcGroupAccessCode
				dest.groupKey = srcMidVar36.SubGroupKey
				dest.groupCode = srcMidVar36.SubGroupCode
		}

def srcMidVar = srcArgs0.CreateGroupRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar.BEID

destArgs0.brId = srcMidVar.BRID

def srcMidVar0 = srcArgs0.CreateGroupRequestMsg.RequestHeader

destArgs0.businessCode = srcMidVar0.BusinessCode

def srcMidVar1 = srcArgs0.CreateGroupRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.CreateGroupRequestMsg.RequestHeader.AccessSecurity

destArgs0.password = srcMidVar2.Password

def destMidVar = destArgs0.simpleProperty[0]

mappingList(srcArgs0.CreateGroupRequestMsg.RequestHeader.AdditionalProperty,destArgs0.simpleProperty,listMapping32)

def srcMidVar4 = srcArgs0.CreateGroupRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar4.TimeType

destArgs0.timeZoneId = srcMidVar4.TimeZoneID

destArgs0.version = srcMidVar0.Version

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

destArgs0.remoteAddress = srcMidVar2.RemoteIP

def destMidVar0 = destArgs1.userCustomerInfo.customerInfo

def srcMidVar5 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.UserCustomer.CustInfo.CustBasicInfo

destMidVar0.custLevel = srcMidVar5.CustLevel

destMidVar0.custLoyalty = srcMidVar5.CustLoyalty

def destMidVar1 = destArgs1.userCustomerInfo

mappingList(srcMidVar5.CustProperty,destMidVar1.custProperties,listMapping1)

destMidVar0.custSegment = srcMidVar5.CustSegment

destMidVar0.billCycleType = srcMidVar5.DFTBillCycleType

destMidVar0.currencyId = srcMidVar5.DFTCurrencyID

destMidVar0.custPLang = srcMidVar5.DFTIVRLang

destMidVar0.custPwd = srcMidVar5.DFTPwd

destMidVar0.custWLang = srcMidVar5.DFTWrittenLang

destMidVar0.dunningFlag = srcMidVar5.DunningFlag

def srcMidVar6 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.UserCustomer.CustInfo

destMidVar0.custClass = srcMidVar6.CustClass

destMidVar0.custCode = srcMidVar6.CustCode

destMidVar0.custNodeType = srcMidVar6.CustNodeType

destMidVar0.custType = srcMidVar6.CustType

destMidVar0.parentCustKey = srcMidVar6.ParentCustKey

mappingList(srcMidVar6.NoticeSuppress,destMidVar1.noticeSuppresses,listMapping2)

def srcMidVar7 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.UserCustomer

destMidVar0.tpCustKey = srcMidVar7.CustKey

def destMidVar2 = destArgs1.userCustomerInfo.individualInfo

def srcMidVar8 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.UserCustomer.IndividualInfo

destMidVar2.education = srcMidVar8.Education

destMidVar2.email = srcMidVar8.Email

destMidVar2.fax = srcMidVar8.Fax

destMidVar2.firstName = srcMidVar8.FirstName

destMidVar2.gender = srcMidVar8.Gender

destMidVar2.homePhone = srcMidVar8.HomePhone

destMidVar2.idNumber = srcMidVar8.IDNumber

destMidVar2.idType = srcMidVar8.IDType

destMidVar2.lastName = srcMidVar8.LastName

destMidVar2.middleName = srcMidVar8.MiddleName

destMidVar2.mobilePhone = srcMidVar8.MobilePhone

destMidVar2.nationality = srcMidVar8.Nationality

destMidVar2.nativePlace = srcMidVar8.NativePlace

destMidVar2.occupation = srcMidVar8.Occupation

destMidVar2.officePhone = srcMidVar8.OfficePhone

destMidVar2.race = srcMidVar8.Race

destMidVar2.title = srcMidVar8.Title

destMidVar1.individualInfo.birthday=parseDate(srcMidVar7.IndividualInfo.Birthday,Constant4Model.DATE_FORMAT)

destMidVar2.addrKey = srcMidVar8.HomeAddressKey

destMidVar1.individualInfo.idValidity=parseDate(srcMidVar7.IndividualInfo.IDValidity,Constant4Model.DATE_FORMAT)

mappingList(srcMidVar8.IndividualProperty,destMidVar1.indvProperties,listMapping3)

destMidVar2.salary = srcMidVar8.Salary

def destMidVar3 = destArgs1.userCustomerInfo.orgInfo

def srcMidVar9 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.UserCustomer.OrgInfo

destMidVar3.idNumber = srcMidVar9.IDNumber

destMidVar3.idType = srcMidVar9.IDType

destMidVar3.industry = srcMidVar9.Industry

destMidVar3.orgEmail = srcMidVar9.OrgEmail

destMidVar3.orgLevel = srcMidVar9.OrgLevel

destMidVar3.orgName = srcMidVar9.OrgName

destMidVar3.orgType = srcMidVar9.OrgType

destMidVar3.subIndustry = srcMidVar9.SubIndustry

destMidVar3.idValidity=parseDate(srcMidVar7.OrgInfo.IDValidity,Constant4Model.DATE_FORMAT)

destMidVar3.addrKey = srcMidVar9.OrgAddressKey

destMidVar3.orgFax = srcMidVar9.OrgFaxNumber

destMidVar3.orgPhone = srcMidVar9.OrgPhoneNumber

destMidVar3.orgSName = srcMidVar9.OrgShortName

destMidVar3.sizeLevel = srcMidVar9.OrgSize

destMidVar3.orgWeb = srcMidVar9.OrgWebSite

mappingList(srcMidVar9.OrgProperty,destMidVar1.orgProperties,listMapping4)

def destMidVar4 = destArgs1.regCustomerInfo.customerInfo

def srcMidVar10 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.RegisterCustomer.CustInfo.CustBasicInfo

destMidVar4.custLevel = srcMidVar10.CustLevel

destMidVar4.custLoyalty = srcMidVar10.CustLoyalty

destMidVar4.custSegment = srcMidVar10.CustSegment

destMidVar4.billCycleType = srcMidVar10.DFTBillCycleType

destMidVar4.currencyId = srcMidVar10.DFTCurrencyID

destMidVar4.custPLang = srcMidVar10.DFTIVRLang

destMidVar4.custPwd = srcMidVar10.DFTPwd

destMidVar4.custWLang = srcMidVar10.DFTWrittenLang

destMidVar4.dunningFlag = srcMidVar10.DunningFlag

def srcMidVar11 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.RegisterCustomer.CustInfo

destMidVar4.custClass = srcMidVar11.CustClass

destMidVar4.custCode = srcMidVar11.CustCode

destMidVar4.custNodeType = srcMidVar11.CustNodeType

destMidVar4.custType = srcMidVar11.CustType

def srcMidVar12 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.RegisterCustomer

destMidVar4.tpCustKey = srcMidVar12.CustKey

def destMidVar5 = destArgs1.regCustomerInfo

mappingList(srcMidVar10.CustProperty,destMidVar5.custProperties,listMapping5)

mappingList(srcMidVar11.NoticeSuppress,destMidVar5.noticeSuppresses,listMapping6)

def destMidVar6 = destArgs1.regCustomerInfo.individualInfo

def srcMidVar13 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.RegisterCustomer.IndividualInfo

destMidVar6.education = srcMidVar13.Education

destMidVar6.email = srcMidVar13.Email

destMidVar6.fax = srcMidVar13.Fax

destMidVar6.firstName = srcMidVar13.FirstName

destMidVar6.gender = srcMidVar13.Gender

destMidVar6.homePhone = srcMidVar13.HomePhone

destMidVar6.idNumber = srcMidVar13.IDNumber

destMidVar6.idType = srcMidVar13.IDType

destMidVar6.lastName = srcMidVar13.LastName

destMidVar6.middleName = srcMidVar13.MiddleName

destMidVar6.mobilePhone = srcMidVar13.MobilePhone

destMidVar6.nationality = srcMidVar13.Nationality

destMidVar6.nativePlace = srcMidVar13.NativePlace

destMidVar6.occupation = srcMidVar13.Occupation

destMidVar6.officePhone = srcMidVar13.OfficePhone

destMidVar6.race = srcMidVar13.Race

destMidVar6.title = srcMidVar13.Title

destMidVar6.birthday=parseDate(srcMidVar13.Birthday,Constant4Model.DATE_FORMAT)

destMidVar6.addrKey = srcMidVar13.HomeAddressKey

destMidVar6.idValidity=parseDate(srcMidVar13.IDValidity,Constant4Model.DATE_FORMAT)

destMidVar6.salary = srcMidVar13.Salary

mappingList(srcMidVar13.IndividualProperty,destMidVar5.indvProperties,listMapping7)

def destMidVar7 = destArgs1.regCustomerInfo.orgInfo

def srcMidVar14 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.RegisterCustomer.OrgInfo

destMidVar7.idNumber = srcMidVar14.IDNumber

destMidVar7.idType = srcMidVar14.IDType

destMidVar7.industry = srcMidVar14.Industry

destMidVar7.orgEmail = srcMidVar14.OrgEmail

destMidVar7.orgLevel = srcMidVar14.OrgLevel

destMidVar7.orgName = srcMidVar14.OrgName

destMidVar7.orgType = srcMidVar14.OrgType

destMidVar7.subIndustry = srcMidVar14.SubIndustry

destMidVar7.idValidity=parseDate(srcMidVar14.IDValidity,Constant4Model.DATE_FORMAT)

destMidVar7.addrKey = srcMidVar14.OrgAddressKey

destMidVar7.orgFax = srcMidVar14.OrgFaxNumber

mappingList(srcMidVar14.OrgProperty,destMidVar5.orgProperties,listMapping8)

destMidVar7.orgPhone = srcMidVar14.OrgPhoneNumber

destMidVar7.orgSName = srcMidVar14.OrgShortName

destMidVar7.orgWeb = srcMidVar14.OrgWebSite

destMidVar7.sizeLevel = srcMidVar14.OrgSize

destMidVar4.parentCustKey = srcMidVar11.ParentCustKey

destArgs1.opType = srcMidVar12.OpType

def destMidVar8 = destArgs1.createGroupInfo.groupInfo

def srcMidVar15 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.Group.SubGroupInfo

destMidVar8.password = srcMidVar15.Password

def srcMidVar16 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.Group.SubGroupInfo.SubGroupBasicInfo

destMidVar8.groupName = srcMidVar16.SubGroupName

def destMidVar9 = destArgs1.createGroupInfo

mappingList(srcMidVar16.SubGroupProperty,destMidVar9.properties,listMapping14)

destMidVar8.groupClass = srcMidVar15.SubGroupClass

destArgs1.groupUserCustomerKey = srcMidVar15.UserCustomerKey

def srcMidVar37= srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.Group.AddProhibitGroup
def destMidVar34 = destArgs1.addProhibitGroupInfo
mappingList(srcMidVar37.DestGroupList,destMidVar34.destGroupList,listMapping33)
mappingList(srcMidVar37.SrcGroupList,destMidVar34.srcGroupList,listMapping34)

def destMidVar10 = destArgs1.createGroupInfo.primaryOffering.offeringInst

def srcMidVar17 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.PrimaryOffering

destMidVar10.bundleFlag = srcMidVar17.BundledFlag

destMidVar10.offeringClass = srcMidVar17.OfferingClass

def destMidVar11 = destArgs1.createGroupInfo.primaryOffering

destMidVar11.effDate =parseDate(srcMidVar17.EffectiveTime,Constant4Model.DATE_FORMAT)

mappingList(srcMidVar17.OfferingInstProperty,destMidVar11.properties,listMapping15)

def destMidVar13 = destArgs1.createGroupInfo.primaryOffering.offeringInst.offeringKey

destMidVar13._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

def srcMidVar18 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.PrimaryOffering.OfferingKey

destMidVar13.oId = srcMidVar18.OfferingID

destMidVar13.oCode = srcMidVar18.OfferingCode

destMidVar13.pSeq = srcMidVar18.PurchaseSeq

def destMidVar14 = destArgs1.createGroupInfo.primaryOffering.offeringInst.parentOfferingKey

destMidVar14._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

def srcMidVar19 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.PrimaryOffering.ParentOfferingKey

destMidVar14.oId = srcMidVar19.OfferingID

destMidVar14.oCode = srcMidVar19.OfferingCode

destMidVar14.pSeq = srcMidVar19.PurchaseSeq

destMidVar10.status = srcMidVar17.Status

destMidVar9.primaryOffering.offeringInst.trialEndTime=parseDate(srcMidVar17.TrialEndTime,Constant4Model.DATE_FORMAT)

destMidVar9.primaryOffering.offeringInst.trialStartTime=parseDate(srcMidVar17.TrialStartTime,Constant4Model.DATE_FORMAT)

mappingList(srcMidVar17.ProductInst,destMidVar11.productInsts,listMapping17)

def srcMidVar20 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest

mappingList(srcMidVar20.AddressInfo,destArgs1.addresses,listMapping20)

def destMidVar17 = destArgs1.createAccountInfos[0].accountInfo

def srcMidVar21 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.Account.AcctInfo.AcctBasicInfo

destMidVar17.acctName = srcMidVar21.AcctName

def destMidVar18 = destArgs1.createAccountInfos[0]

mappingList(srcMidVar21.AcctProperty,destMidVar18.properties,listMapping21)

destMidVar17.billLang = srcMidVar21.BillLang

def destMidVar19 = destArgs1.createAccountInfos[0].contactInfo

def srcMidVar22 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.Account.AcctInfo.AcctBasicInfo.ContactInfo

destMidVar19.email = srcMidVar22.Email

destMidVar19.fax = srcMidVar22.Fax

destMidVar19.firstName = srcMidVar22.FirstName

destMidVar19.homePhone = srcMidVar22.HomePhone

destMidVar19.lastName = srcMidVar22.LastName

destMidVar19.middleName = srcMidVar22.MiddleName

destMidVar19.mobilePhone = srcMidVar22.MobilePhone

destMidVar19.officePhone = srcMidVar22.OfficePhone

destMidVar19.title = srcMidVar22.Title

destMidVar17.dunningFlag = srcMidVar21.DunningFlag

destMidVar17.latePaymentFlag = srcMidVar21.LateFeeChargeable

def srcMidVar23 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.Account.AcctInfo

destMidVar17.acctClass = srcMidVar23.AcctClass

destMidVar17.acctCode = srcMidVar23.AcctCode

destMidVar17.acctPaymentMethod = srcMidVar23.AcctPayMethod

destMidVar17.acctType = srcMidVar23.AcctType

destMidVar18.billCycleType = srcMidVar23.BillCycleType

mappingList(srcMidVar23.CreditLimit,destMidVar18.creditLimits,listMapping22)

destMidVar17.currencyId = srcMidVar23.CurrencyID

destMidVar18.initBalance = srcMidVar23.InitBalance

destMidVar17.parentAcctKey = srcMidVar23.ParentAcctKey

destMidVar17.paymentType = srcMidVar23.PaymentType

def srcMidVar24 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.Account

destMidVar17.acctKey = srcMidVar24.AcctKey

def destMidVar21 = destArgs1.addPaymentRelationInfo.paymentRelation

destMidVar21.paymentRelationKey = srcMidVar24.PayRelationKey

mappingList(srcMidVar21.FreeBillMedium,destMidVar17.bmInfos,listMapping23)

mappingList(srcMidVar23.AutoPayChannel,destMidVar18.paymentChannels,listMapping24)

destMidVar19.addrKey = srcMidVar22.AddressKey

mappingList(srcMidVar20.SupplementaryOffering,destArgs1.addGroupOfferingInstInfoList,listMapping26)

def destMidVar33 = destArgs1.salesInfo

destArgs1.handlingChargeFlag = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.HandlingChargeFlag

def srcMidVar35 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.SalesInfo

destMidVar33.salesChannelId = srcMidVar35.SalesChannelID

destMidVar33.salesId = srcMidVar35.SalesID

destMidVar2.marriedStatus = srcMidVar8.MaritalStatus

destMidVar6.marriedStatus = srcMidVar13.MaritalStatus

def srcMidVar36 = srcArgs0.CreateGroupRequestMsg.CreateGroupRequest.Group

destMidVar8.groupKey = srcMidVar36.SubGroupKey

destMidVar8.groupCode = srcMidVar15.SubGroupCode

destMidVar8.pGroupKey = srcMidVar15.PGroupKey

destArgs0.interMode = srcMidVar0.AccessMode

destMidVar18.redlistFlag = srcMidVar21.RedlistFlag

destMidVar18.uCustKey = srcMidVar23.UserCustomerKey
