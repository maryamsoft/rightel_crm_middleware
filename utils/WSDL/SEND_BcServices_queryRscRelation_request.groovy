dest.setServiceOperation("BMQueryService","queryRscRelation")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.queryrscrelation.io.QueryRscRelationRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def destMidVar = destArgs1.subAccessCode

def srcMidVar = srcArgs0.QueryRscRelationRequestMsg.QueryRscRelationRequest.PayObj.SubAccessCode

destMidVar.primaryIdentity = srcMidVar.PrimaryIdentity

destMidVar.subscriberKey = srcMidVar.SubscriberKey

def srcMidVar0 = srcArgs0.QueryRscRelationRequestMsg.QueryRscRelationRequest.PayObj.SubGroupAccessCode

def destMidVar0 = destArgs1.groupAccessCode

destMidVar0.groupCode = srcMidVar0.SubGroupCode

destMidVar0.groupKey = srcMidVar0.SubGroupKey

def srcMidVar2 = srcArgs0.QueryRscRelationRequestMsg.QueryRscRelationRequest.PayObj.CustAccessCode

def destMidVar2 = destArgs1.custAccessCode

destMidVar2.primaryIdentity = srcMidVar2.PrimaryIdentity

destMidVar2.customerKey = srcMidVar2.CustomerKey

destMidVar2.customerCode = srcMidVar2.CustomerCode

def srcMidVar1 = srcArgs0.QueryRscRelationRequestMsg.QueryRscRelationRequest.RelationDestIdentity

def destMidVar1 = destArgs1.relationDestIdentity

destMidVar1.primaryIdentity = srcMidVar1.PrimaryIdentity

destMidVar1.subscriberKey = srcMidVar1.SubscriberKey

def srcMidVar8 = srcArgs0.QueryRscRelationRequestMsg.QueryRscRelationRequest.RelationDestCust

def destMidVar8 = destArgs1.relationDestCust

destMidVar8.primaryIdentity = srcMidVar8.PrimaryIdentity

destMidVar8.customerKey = srcMidVar8.CustomerKey

destMidVar8.customerCode = srcMidVar8.CustomerCode

def srcMidVar3 = srcArgs0.QueryRscRelationRequestMsg.RequestHeader

destArgs0.version = srcMidVar3.Version

def srcMidVar4 = srcArgs0.QueryRscRelationRequestMsg.RequestHeader.TimeFormat

destArgs0.timeZoneId = srcMidVar4.TimeZoneID

destArgs0.timeType = srcMidVar4.TimeType

def srcMidVar5 = srcArgs0.QueryRscRelationRequestMsg.RequestHeader.OwnershipInfo

destArgs0.brId = srcMidVar5.BRID

destArgs0.beId = srcMidVar5.BEID

def srcMidVar6 = srcArgs0.QueryRscRelationRequestMsg.RequestHeader.OperatorInfo

destArgs0.operatorId = srcMidVar6.OperatorID

destArgs0.channelId = srcMidVar6.ChannelID

destArgs0.msgLanguageCode = srcMidVar3.MsgLanguageCode

destArgs0.messageSeq = srcMidVar3.MessageSeq

destArgs0.businessCode = srcMidVar3.BusinessCode

def srcMidVar7 = srcArgs0.QueryRscRelationRequestMsg.RequestHeader.AccessSecurity

destArgs0.password = srcMidVar7.Password

destArgs0.loginSystem = srcMidVar7.LoginSystemCode

destArgs0.remoteAddress = srcMidVar7.RemoteIP

destArgs0.interMode = srcMidVar3.AccessMode

mappingList(srcMidVar3.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

def srcMidRequest = srcArgs0.QueryRscRelationRequestMsg.QueryRscRelationRequest
destArgs1.totalRowNum = srcMidRequest.TotalRowNum
destArgs1.beginRowNum = srcMidRequest.BeginRowNum
destArgs1.fetchRowNum = srcMidRequest.FetchRowNum
