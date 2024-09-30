dest.setServiceOperation("BalanceNotifyService","manageAccountNotificationLevel")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.manageaccountnotificationlevel.io.ManageAccountNotificationLevelRequest"

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

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.groupKey = src.SubGroupKey
	
	dest.groupCode = src.SubGroupCode
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->
  
  dest.levelLeft = src.LevelLeft
  
  dest.levelRight = src.LevelRight
  
  dest.sequenceNo = src.SequenceNo
  
  dest.actionRuleId = src.ActionRuleID
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.objectType = src.ObjectType
	
	dest.accountObject = src.AccountObject
	
	dest.notifyMode = src.NotifyMode
	
	dest.notifyGateProcessMode = src.NotifyGateProcessMode
	
	mappingList(src.LevelList,dest.levelList,listMapping5)
}


def listMapping2

listMapping2 = 
{
    src,dest  ->

	listMapping3.call(src.SubAccessCode,dest.subAccessCode)
	
	listMapping6.call(src.SubGroupAccessCode,dest.groupAccessCode)
	
	dest.opType = src.OpType
	
	mappingList(src.AccountLevelInfo,dest.accountLevelInfoList,listMapping4)
	
}

def srcMidVar = srcArgs0.ManageAccountNotificationLevelRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.ManageAccountNotificationLevelRequest,destArgs1)
