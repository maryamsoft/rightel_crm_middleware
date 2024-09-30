import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("SubscriberService","changeUsagePayLimit")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.usagepaylimit.io.ChangeUsagePayLimitRequest"

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

	dest.businessCode = src.BusinessCode
	
	dest.messageSeq = src.MessageSeq
	
	dest.msgLanguageCode = src.MsgLanguageCode
	
	dest.version = src.Version
	
	def srcMidVar0 = src.AccessSecurity
	
	dest.loginSystem = srcMidVar0.LoginSystemCode
	
	dest.password = srcMidVar0.Password
	
	dest.remoteAddress = srcMidVar0.RemoteIP
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping0)
	
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

def srcMidVar = srcArgs0.ChangeUsagePayLimitRequestMsg
listMapping1.call(srcMidVar.RequestHeader,destArgs0)

def listMapping_chgSubAccessCode

listMapping_chgSubAccessCode = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping_subAccessCode

listMapping_subAccessCode = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping_custAccessCode

listMapping_custAccessCode = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.customerKey = src.CustomerKey
	
	dest.customerCode = src.CustomerCode
	
}

def listMapping_groupAccessCode

listMapping_groupAccessCode = 
{
    src,dest  ->
	
	dest.groupKey = src.SubGroupKey
	
	dest.groupCode = src.SubGroupCode
	
}

def srcMidChgSubAccessCode = srcArgs0.ChangeUsagePayLimitRequestMsg.ChangeUsagePayLimitRequest.ChgObj.SubAccessCode
def destChgSubAccessCode = destArgs1.subAccessCode

listMapping_chgSubAccessCode.call(srcMidChgSubAccessCode,destChgSubAccessCode) 

def listMapping_AddPayLimit

listMapping_AddPayLimit=
{
    src,dest  ->
		dest.usagePayLimitKey = src.UsagePayLimitKey
	  listMapping_custAccessCode.call(src.PaidObj.CustAccessCode,dest.paidObj.custAccessCode)
	  listMapping_subAccessCode.call(src.PaidObj.SubAccessCode,dest.paidObj.subAccessCode) 
	  listMapping_groupAccessCode.call(src.PaidObj.SubGroupAccessCode,dest.paidObj.groupAccessCode)
	  dest.eventType = src.EventType
	  dest.limitRule = src.LimitRule
	  dest.limitCycleType = src.LimitCycleType
	  dest.limitMeasureUnit = src.LimitMeasureUnit
	  dest.effDate = parseDate(src.EffDate,Constant4Model.DATE_FORMAT)
	  def srcMidVar4 = src.EffectiveTime
	  dest.effMode = srcMidVar4.Mode
	  dest.effTime = parseDate(srcMidVar4.Time,Constant4Model.DATE_FORMAT)
	  dest.expDate = parseDate(src.ExpDate,Constant4Model.DATE_FORMAT)
	  dest.limitValue = src.LimitValue
}

def srcMidAddPayLimitList = srcArgs0.ChangeUsagePayLimitRequestMsg.ChangeUsagePayLimitRequest.UsagePayLimit.AddPayLimit
def destAddPayLimitList = destArgs1.usagePayLimit.addPayLimitList

mappingList(srcMidAddPayLimitList,destAddPayLimitList,listMapping_AddPayLimit) 

def listMapping_DelPayLimit

listMapping_DelPayLimit = 
{
    src,dest  ->
    dest.usagePayLimitKey = src.UsagePayLimitKey
    dest.expDate = parseDate(src.ExpDate,Constant4Model.DATE_FORMAT)
	def srcMidVar5 = src.ExpiredTime
	dest.expMode = srcMidVar5.Mode
	dest.expTime = parseDate(srcMidVar5.Time,Constant4Model.DATE_FORMAT)
}

def srcMidDelPayLimitList = srcArgs0.ChangeUsagePayLimitRequestMsg.ChangeUsagePayLimitRequest.UsagePayLimit.DelPayLimit
def destDelPayLimitList = destArgs1.usagePayLimit.delPayLimitList

mappingList(srcMidDelPayLimitList,destDelPayLimitList,listMapping_DelPayLimit) 

def listMapping_AddTempLimit

listMapping_AddTempLimit =
{
	src,dest  ->
	dest.limitValue = src.LimitValue
	def srcMidVar7 = src.EffectiveTime
	dest.effMode = srcMidVar7.Mode
	dest.effTime = parseDate(srcMidVar7.Time,Constant4Model.DATE_FORMAT)
	dest.expDate = parseDate(src.ExpDate,Constant4Model.DATE_FORMAT)
}

def listMapping_ModifyPayLimit

listMapping_ModifyPayLimit = 
{
    src,dest  ->
    dest.usagePayLimitKey = src.UsagePayLimitKey
    dest.limitValue = src.LimitValue
	def srcMidVar6 = src.EffectiveTime
	dest.effMode = srcMidVar6.Mode
	dest.effTime = parseDate(srcMidVar6.Time,Constant4Model.DATE_FORMAT)
	mappingList(src.AddTempLimit,dest.addTempLimitList,listMapping_AddTempLimit) 
}

def srcMidModPayLimitList = srcArgs0.ChangeUsagePayLimitRequestMsg.ChangeUsagePayLimitRequest.UsagePayLimit.ModPayLimit
def destModPayLimitList = destArgs1.usagePayLimit.modPayLimitList

mappingList(srcMidModPayLimitList,destModPayLimitList,listMapping_ModifyPayLimit) 
