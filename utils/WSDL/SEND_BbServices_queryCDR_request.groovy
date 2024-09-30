import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("BMQueryService","queryCDR")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.querycdr.io.QueryCDRInfoRequest"

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

	dest.customerCode = src.CustomerCode
	
	dest.customerKey = src.CustomerKey
	
	dest.primaryIdentity = src.PrimaryIdentity
	
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

	dest.groupKey = src.SubGroupKey
	
	dest.groupCode = src.SubGroupCode

}

def listMapping5

listMapping5 =
        {
            src,dest  ->

                dest.accoutCode = src.AccountCode

                dest.accoutKey = src.AccountKey

                dest.primaryIdentity = src.PrimaryIdentity

        }

def srcMidVar = srcArgs0.QueryCDRRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar.LoginSystemCode

destArgs0.password = srcMidVar.Password

destArgs0.remoteAddress = srcMidVar.RemoteIP

def srcMidVar0 = srcArgs0.QueryCDRRequestMsg.RequestHeader

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar0.BusinessCode

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

def srcMidVar1 = srcArgs0.QueryCDRRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.interMode = srcMidVar0.AccessMode

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.QueryCDRRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.QueryCDRRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

def srcMidVar4 = srcArgs0.QueryCDRRequestMsg.QueryCDRRequest

destArgs1.beginRowNum = srcMidVar4.BeginRowNum

destArgs1.billCycleId = srcMidVar4.BillCycleID

listMapping1.call(srcMidVar4.CustAccessCode,destArgs1.custAccessCode)

destArgs1.fetchRowNum = srcMidVar4.FetchRowNum

destArgs1.flowType = srcMidVar4.FlowType

destArgs1.serviceCategory = srcMidVar4.ServiceCategory

listMapping3.call(srcMidVar4.SubAccessCode,destArgs1.subAccessCode)

listMapping4.call(srcMidVar4.SubGroupAccessCode,destArgs1.groupAccessCode)

listMapping5.call(srcMidVar4.AcctAccessCode,destArgs1.acctAccessCode)

listMapping1.call(srcMidVar4.CustomerAccessCode,destArgs1.customerAccessCode)

destArgs1.endTime=parseDate(srcMidVar4.TimePeriod.EndTime, Constant4Model.DATE_FORMAT)

destArgs1.startTime=parseDate(srcMidVar4.TimePeriod.StartTime, Constant4Model.DATE_FORMAT)

destArgs1.totalCDRNum = srcMidVar4.TotalCDRNum

destArgs1.otherNumber = srcMidVar4.OtherNumber

def listMapping2

listMapping2 = 
{
    src,dest  ->

 dest.serviceType = src
 
}

mappingList(srcMidVar4.ServiceType,destArgs1.serviceTypeList,listMapping2)


