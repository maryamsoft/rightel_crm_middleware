import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("BMQueryService","queryInteractLog")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.queryinteractlog.io.QueryInteractLogRequest"

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.customerCode = src.CustomerCode
	
	dest.customerKey = src.CustomerKey
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.groupCode = src.SubGroupCode
	
	dest.groupKey = src.SubGroupKey
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

listMapping6 = 
{
    src,dest  ->

	dest.accoutCode = src.AccountCode
	
	dest.accoutKey = src.AccountKey
	
	dest.payType = src.PayType
	
	dest.primaryIdentity = src.PrimaryIdentity	
}


def listMapping0

listMapping0 = 
{
    src,dest  ->
	
	listMapping1.call(src.CustAccessCode,dest.custAccessCode)
	
	listMapping2.call(src.SubGroupAccessCode,dest.groupAccessCode)
	
	listMapping3.call(src.SubAccessCode,dest.subAccessCode)	
	
	listMapping6.call(src.AcctAccessCode,dest.acctAccessCode)
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
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping4)
	
	def srcMidVar4 = src.OwnershipInfo
	
	dest.beId = srcMidVar4.BEID
	
	dest.brId = srcMidVar4.BRID
	
	dest.interMode = src.AccessMode
	
}


def srcMidVar = srcArgs0.QueryInteractLogRequestMsg.QueryInteractLogRequest

listMapping0.call(srcMidVar.QueryObj,destArgs1.anyAccessCode)

destArgs1.operationCode = srcMidVar.OperationCode

destArgs1.startTime = parseDate(srcMidVar.TimePeriod.StartTime, Constant4Model.DATE_FORMAT)

destArgs1.endTime = parseDate(srcMidVar.TimePeriod.EndTime, Constant4Model.DATE_FORMAT)

def srcMidVar5 = srcArgs0.QueryInteractLogRequestMsg.RequestHeader

listMapping5.call(srcMidVar5,destArgs0)





