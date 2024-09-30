dest.setServiceOperation("BMQueryService","queryCustomerInfo")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.querycustomerinfo.io.QueryCustomerInfoRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def destMidVar = destArgs1.acctAccessCode

def srcMidVar = srcArgs0.QueryCustomerInfoRequestMsg.QueryCustomerInfoRequest.QueryObj.AcctAccessCode

destMidVar.accoutCode = srcMidVar.AccountCode

destMidVar.accoutKey = srcMidVar.AccountKey

destMidVar.payType = srcMidVar.PayType

destMidVar.primaryIdentity = srcMidVar.PrimaryIdentity

def destMidVar0 = destArgs1.custAccessCode

def srcMidVar0 = srcArgs0.QueryCustomerInfoRequestMsg.QueryCustomerInfoRequest.QueryObj.CustAccessCode

destMidVar0.customerCode = srcMidVar0.CustomerCode

destMidVar0.customerKey = srcMidVar0.CustomerKey

destMidVar0.primaryIdentity = srcMidVar0.PrimaryIdentity

def destMidVar1 = destArgs1.subAccessCode

def srcMidVar1 = srcArgs0.QueryCustomerInfoRequestMsg.QueryCustomerInfoRequest.QueryObj.SubAccessCode

destMidVar1.primaryIdentity = srcMidVar1.PrimaryIdentity

destMidVar1.subscriberKey = srcMidVar1.SubscriberKey

def destMidVar2 = destArgs1.groupAccessCode

def srcMidVar2 = srcArgs0.QueryCustomerInfoRequestMsg.QueryCustomerInfoRequest.QueryObj.SubGroupAccessCode

destMidVar2.groupCode = srcMidVar2.SubGroupCode

destMidVar2.groupKey = srcMidVar2.SubGroupKey

def srcMidVar8 = srcArgs0.QueryCustomerInfoRequestMsg.QueryCustomerInfoRequest

destArgs1.outQueryType = srcMidVar8.QueryMode

destArgs1.customerMask = srcMidVar8.CustomerMask

destArgs1.accountMask = srcMidVar8.AccountMask

destArgs1.subscriberMask = srcMidVar8.SubscriberMask

destArgs1.groupMask = srcMidVar8.GroupMask

mappingList(srcMidVar8.AdditionalProperty,destArgs1.simplePropertyList,listMapping0)

def srcMidVar3 = srcArgs0.QueryCustomerInfoRequestMsg.RequestHeader

destArgs0.version = srcMidVar3.Version

def srcMidVar4 = srcArgs0.QueryCustomerInfoRequestMsg.RequestHeader.TimeFormat

destArgs0.timeZoneId = srcMidVar4.TimeZoneID

destArgs0.timeType = srcMidVar4.TimeType

def srcMidVar5 = srcArgs0.QueryCustomerInfoRequestMsg.RequestHeader.OwnershipInfo

destArgs0.brId = srcMidVar5.BRID

destArgs0.beId = srcMidVar5.BEID

def srcMidVar6 = srcArgs0.QueryCustomerInfoRequestMsg.RequestHeader.OperatorInfo

destArgs0.operatorId = srcMidVar6.OperatorID

destArgs0.channelId = srcMidVar6.ChannelID

destArgs0.msgLanguageCode = srcMidVar3.MsgLanguageCode

destArgs0.messageSeq = srcMidVar3.MessageSeq

destArgs0.businessCode = srcMidVar3.BusinessCode

def srcMidVar7 = srcArgs0.QueryCustomerInfoRequestMsg.RequestHeader.AccessSecurity

destArgs0.password = srcMidVar7.Password

destArgs0.loginSystem = srcMidVar7.LoginSystemCode

destArgs0.remoteAddress = srcMidVar7.RemoteIP

destArgs0.interMode = srcMidVar3.AccessMode

mappingList(srcMidVar3.AdditionalProperty,destArgs0.simpleProperty,listMapping0)
