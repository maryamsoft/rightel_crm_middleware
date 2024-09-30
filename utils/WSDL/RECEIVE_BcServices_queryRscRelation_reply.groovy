import com.huawei.ngcbs.bm.common.common.Constant4Model

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.Quota = src.quota
	
	dest.NotifyType = src.notifyType

	dest.StartTime = formatDate(src.effDate, Constant4Model.DATE_FORMAT)

	dest.EndTime = formatDate(src.expDate, Constant4Model.DATE_FORMAT)

	dest.ActionRule = src.actionRule
	
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.PayRelationKey = src.payRelationKey
	
	dest.PayObjType = src.payObjType
	
	dest.PayObjCode = src.payObjCode
	
	dest.RelationDestIdentify.PrimaryIdentity = src.relationDestIdentify.primaryIdentity

	dest.RelationDestCust.CustomerKey = src.relationDestCust.customerKey

	dest.RelationDestCust.CustomerCode = src.relationDestCust.customerCode
	
	dest.OfferingKey.OfferingID = src.offeringKey.oId
	
	dest.OfferingKey.OfferingCode = src.offeringKey.oCode
	
	dest.OfferingKey.PurchaseSeq = src.offeringKey.pSeq
	
	dest.ShareRule = src.shareRule
	
	dest.ShareLimit.LimitCycleType = src.shareLimit.limitCycleType
	
	dest.ShareLimit.LimitValue = src.shareLimit.limitValue
	
	dest.ShareLimit.MeasureUnit = src.shareLimit.measureUnit
	
	dest.Priority = src.priority
	
	dest.StartTime = formatDate(src.startTime, Constant4Model.DATE_FORMAT)
	
	dest.EndTime = formatDate(src.endTime, Constant4Model.DATE_FORMAT)
	
	dest.UsageAmount = src.usageAmount
	
	dest.UsageMeasureUnit = src.usageMeasureUnit
	
	mappingList(src.notifyRule,dest.NotifyRule,listMapping3)
	
	dest.FreeUnitType = src.freeUnitType
	
}

def destMidVar = destReturn.QueryRscRelationResultMsg.ResultHeader

def srcMidVar = srcReturn.resultHeader

destMidVar.MsgLanguageCode = srcMidVar.msgLanguageCode

destMidVar.Version = srcMidVar.version

destMidVar.ResultCode = srcMidVar.resultCode

destMidVar.ResultDesc = srcMidVar.resultDesc

destMidVar.MessageSeq = srcMidVar.messageSeq

mappingList(srcMidVar.simpleProperty,destMidVar.AdditionalProperty,listMapping0)

def srcMidVar0 = srcReturn.queryRscRelation

def destMidVar0 = destReturn.QueryRscRelationResultMsg.QueryRscRelationResult

mappingList(srcReturn.queryRscRelation,destMidVar0.RscRelation,listMapping1)

destMidVar0.TotalRowNum = srcReturn.totalRowNum
destMidVar0.BeginRowNum = srcReturn.beginRowNum
destMidVar0.FetchRowNum = srcReturn.fetchRowNum
