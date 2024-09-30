import com.huawei.ngcbs.bm.common.common.Constant4Model


dest.setServiceOperation("SubscriberService","subActivation")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.subscriber.subscriberactivation.io.SubActivationRequest"

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
	
	def srcMidVar2 = src.TimeFormat
	
	dest.timeType = srcMidVar2.TimeType
	
	dest.timeZoneId = srcMidVar2.TimeZoneID
	
	dest.version = src.Version
	
	dest.remoteAddress = srcMidVar1.RemoteIP
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	def srcMidVar3 = src.OwnershipInfo
	
	dest.beId = srcMidVar3.BEID
	
	dest.brId = srcMidVar3.BRID
	
	dest.interMode = src.AccessMode
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
	
	dest.oCode = src.OfferingCode
	
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->
    
  def oKeyExt = dest.offeringKey
  
  oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

	listMapping4.call(src.OfferingKey,oKeyExt)
	
		dest.expirationTime=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
		dest.trialEndTime=parseDate(src.TrialEndTime, Constant4Model.DATE_FORMAT)
	
		dest.trialStartTime=parseDate(src.TrialStartTime, Constant4Model.DATE_FORMAT)
	
	def srcMidVar4 = src.OfferingKey.OfferingOwner
	
	dest.ownerKey = srcMidVar4.OwnerKey
	
	dest.ownerType = srcMidVar4.OwnerType
	
	dest.activeTime=parseDate(src.ActiveTime, Constant4Model.DATE_FORMAT)
	
	dest.activeTimeLimit=parseDate(src.ActiveTimeLimit, Constant4Model.DATE_FORMAT)
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
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

	def destMidVar = dest.subscriberInfo
	
	destMidVar.ivrLang = src.IVRLang
	
	destMidVar.subPassword = src.SubPassword
	
	destMidVar.writtenLang = src.WrittenLang
	
	mappingList(src.SubProperty,dest.properties,listMapping7)
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	mappingList(src.OfferingInst,dest.activeOfferingInstInfos,listMapping3)

	mappingList(src.AdditionalProperty,dest.simplePropertyList,listMapping7)

	listMapping5.call(src.SubAccessCode,dest.subAccessCode)
	
	listMapping6.call(src.SubBasicInfo,dest.subActivationInfo)
	
}

def srcMidVar = srcArgs0.SubActivationRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.SubActivationRequest,destArgs1)
