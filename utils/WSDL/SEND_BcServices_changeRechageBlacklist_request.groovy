dest.setServiceOperation("SubscriberService","changeRechargeBlacklist")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.changerechargeblacklist.io.ChangeRechargeBlacklistRequest"

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
	
	def srcMidVar2 = src.OwnershipInfo
	
	dest.beId = srcMidVar2.BEID
	
	dest.brId = srcMidVar2.BRID
	
	def srcMidVar3 = src.TimeFormat
	
	dest.timeType = srcMidVar3.TimeType
	
	dest.timeZoneId = srcMidVar3.TimeZoneID
	
	dest.version = src.Version
	
	dest.interMode = src.AccessMode
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.opType = src.OpType
	
	dest.subIdentity = src.SubIdentity
	
}
def srcMidVar = srcArgs0.ChangeRechageBlacklistRequestMsg

destArgs1.subAccessCode.primaryIdentity = srcMidVar.ChangeRechageBlacklistRequest.SubIdentity

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.ChangeRechageBlacklistRequest,destArgs1.changeRechargeBlacklistInfo)
