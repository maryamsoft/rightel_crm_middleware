import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("SubscriberService","changeSubStatus")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.changesubstatus.io.ChangeSubStatusRequest"

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
	
	dest.messageSeq = src.MessageSeq
	
	dest.msgLanguageCode = src.MsgLanguageCode
	
	dest.version = src.Version
	
	def srcMidVar0 = src.AccessSecurity
	
	dest.loginSystem = srcMidVar0.LoginSystemCode
	
	dest.password = srcMidVar0.Password
	
	dest.remoteAddress = srcMidVar0.RemoteIP
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	def srcMidVar1 = src.OperatorInfo
	
	dest.channelId = srcMidVar1.ChannelID
	
	dest.operatorId = srcMidVar1.OperatorID
	
	def srcMidVar2 = src.OwnershipInfo
	
	dest.beId = srcMidVar2.BEID
	
	dest.brId = srcMidVar2.BRID
	
	def srcMidVar3 = src.TimeFormat
	
	dest.timeType = srcMidVar3.TimeType
	
	dest.timeZoneId = srcMidVar3.TimeZoneID
	
	dest.interMode = src.AccessMode
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
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

	dest.accoutCode = src.AccountCode
	
	dest.payModeFlag = src.PayModeFlag
	
	dest.accoutKey = src.AccountKey
	
	dest.primaryIdentity = src.PrimaryIdentity
}

def listMapping2

listMapping2 = 
{
    src,dest  ->
    dest.activeDate = parseDate(src.ActiveDate,Constant4Model.DAY_FORMAT)

    listMapping3.call(src.SubAccessCode,dest.subAccessCode)
	
	listMapping5.call(src.AcctAccessCode,dest.acctAccessCode)
	
	def destMidVar = dest.changeSubStatusInfo
	
	mappingList(src.AdditionalProperty,destMidVar.additionalProperties,listMapping4)
	
	destMidVar.holdingDays = src.HoldingDays
	
	destMidVar.newStatus = src.NewStatus
	
	destMidVar.oldStatus = src.OldStatus
	
	destMidVar.opType = src.OpType

	dest.handlingChargeFlag = src.HandlingChargeFlag
}

def srcMidVar = srcArgs0.ChangeSubStatusRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.ChangeSubStatusRequest,destArgs1)
