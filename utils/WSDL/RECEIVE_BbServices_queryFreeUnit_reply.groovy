import com.huawei.ngcbs.bm.common.common.Constant4Model;

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.PurchaseSeq = src.pSeq
	dest.OfferingName = src.offeringName
    dest.OfferingCode = src.oCode
	dest.OfferingID = src.oId
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}
def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.FreeUnitType = src.freeUnitType
	
	dest.MeasureUnit = src.measureUnit
	
    def oKeyExt = src.offeringKey
    oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	listMapping1.call(oKeyExt,dest.OfferingKey)
	
	dest.SharedPrimaryIdentity = src.sharedPrimaryIdentity
	
	dest.UsedAmount = src.usedAmount
	
	mappingList(src.simpleProperty,dest.OfferingKey.AdditionalProperty,listMapping5)
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.InitialAmount = src.initialAmount
	
	dest.LastRollOveredTime=formatDate(src.lastRollOveredTime, Constant4Model.DATE_FORMAT)

	dest.UsagePriority = src.usagePriority

	dest.RollOverFlag = src.rollOverFlag
	
	dest.CurrentAmount = src.currentAmount
	
	dest.EffectiveTime=formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpireTime=formatDate(src.expireTime, Constant4Model.DATE_FORMAT)
	
	dest.FreeUnitInstanceID = src.freeUnitInstanceId

        dest.AlreadyRollOverTimes = src.alreadyRollOverTimes

	dest.CreateDate = formatDate(src.createTime, Constant4Model.DATE_FORMAT)

	dest.LastUpdateDate = formatDate(src.lastUpdateTime, Constant4Model.DATE_FORMAT)
		
	def destMidVar1 = dest.FreeUnitOrigin.OfferingKey
	
    def oExtKey = src.offeringKey
    oExtKey._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar1.OfferingID = oExtKey.oId
    destMidVar1.OfferingCode = oExtKey.oCode
	destMidVar1.OfferingName = oExtKey.offeringName
	destMidVar1.PurchaseSeq = oExtKey.pSeq
	
  mappingList(src.simpleProperty,destMidVar1.AdditionalProperty,listMapping5)
  
	def destMidVar2 = dest.FreeUnitOrigin
	
	destMidVar2.OriginType = src.originType
	
	destMidVar2.PlanID = src.planId

	destMidVar2.RenewFlag = src.renewFlag

	destMidVar2.AlreadyRenewTimes = src.alreadyRenewTimes

	destMidVar2.MaxRenewTimes = src.maxRenewTimes

	dest.ReserveValidTime=formatDate(src.reserveValidTime, Constant4Model.DATE_FORMAT)
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.PrimaryIdentity = src.primaryIdentity
	
	dest.SubscriberKey = src.subscriberKey
	
	dest.UsedAmount = src.usedAmount
	
}

def listMapping8

listMapping8 =
{
    src,dest  ->
	
	dest.FreeUnitInstanceID= src.freeUnitInstanceID

	dest.FreeUnitCycleType = src.freeUnitCycleType
	
	dest.FreeUnitUSRuleID = src.freeUnitUSRuleID
	
	dest.TimeSchemaID = src.timeSchemaID
	
	dest.MaxUsageAmt = src.maxUsageAmt
	
	dest.UsageAmt = src.usageAmt
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.TotalUnusedAmount = src.totalUnusedAmount
	
	dest.TotalInitialAmount = src.totalInitialAmount
	
	dest.MeasureUnitName = src.measureUnitName
	
	dest.MeasureUnit = src.measureUnit
	
	dest.FreeUnitTypeName = src.freeUnitTypeName
	
	dest.FreeUnitType = src.freeUnitType
	
	mappingList(src.freeUnitItemDetailList,dest.FreeUnitItemDetail,listMapping4)
	
	mappingList(src.memberFUUsageInfoWSList,dest.MemberUsageList,listMapping6)
	
	mappingList(src.fUPaymentPlanList.fUPaymentPlanList,dest.FUPaymentPlanList.FUPaymentPlanInfo,listMapping8)
	
}



def listMapping9

listMapping9 =
{
	src,dest  ->

	dest.RscRelationLimitKey = src.rscRelationLimitKey

	dest.LimitCycleType = src.limitCycleType

	dest.LimitValue = src.limitValue

	dest.MeasureUnit = src.measureUnit

}

def listMapping10

listMapping10 =
{
	src,dest  ->

	dest.FreeUnitType = src.freeUnitType

	dest.UsedAmount = src.usedAmount

	dest.MeasureUnit = src.measureUnit

}

def listMapping12

listMapping12 =
{
	src,dest  ->

	dest.RscRelationLimitKey = src.rscRelationLimitKey

	dest.LimitCycleType = src.limitCycleType

	dest.LimitValue = src.limitValue
	
	dest.MeasureUnit = src.measureUnit
	
	dest.UsageAmount = src.usageAmount

}

def listMapping7

listMapping7 =
{
	src,dest  ->

		dest.PayRelationKey = src.payRelationKey

		dest.PrimaryIdentity = src.primaryIdentity

		dest.SubscriberKey = src.subscriberKey

		dest.FreeUnitType = src.freeUnitType
		
		dest.ShareRule = src.shareRule
		
		dest.Priority = src.priority
		
		dest.StartTime = formatDate(src.startTime, Constant4Model.DATE_FORMAT)
		
		dest.EndTime = formatDate(src.endTime, Constant4Model.DATE_FORMAT)

		def oKeyExt = src.offeringKey
		oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

		listMapping1.call(oKeyExt,dest.OfferingKey)

		listMapping9.call(src.shareLimitInfo,dest.ShareLimit)

		mappingList(src.usageDetailList,dest.UsageDetail,listMapping10)
		
		mappingList(src.multipleShareLimits,dest.MultipleShareLimits,listMapping12)
}

def listMapping11

listMapping11 =
{
	src,dest  ->

	dest.PayRelationKey = src.payRelationKey

	dest.SharedObjType = src.sharedObjType

	dest.SharedObjID = src.sharedObjId

	dest.FreeUnitType = src.freeUnitType
	
	dest.ShareRule = src.shareRule
		
	dest.Priority = src.priority

	dest.StartTime = formatDate(src.startTime, Constant4Model.DATE_FORMAT)

	dest.EndTime = formatDate(src.endTime, Constant4Model.DATE_FORMAT)

	def oKeyExt = src.offeringKey
	oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

	listMapping1.call(oKeyExt,dest.OfferingKey)

	listMapping9.call(src.shareLimitInfo,dest.ShareLimit)

	mappingList(src.usageDetailList,dest.UsageDetail,listMapping10)
	
	mappingList(src.multipleShareLimits,dest.MultipleShareLimits,listMapping12)
}

def srcMidVar = srcReturn.shareUsageListWS

def destMidVar = destReturn.QueryFreeUnitResultMsg.QueryFreeUnitResult

mappingList(srcMidVar.shareFUUsageInfoWSList,destMidVar.ShareUsageList,listMapping0)

def srcMidVar0 = srcReturn.resultHeader

def destMidVar0 = destReturn.QueryFreeUnitResultMsg.ResultHeader

mappingList(srcMidVar0.simpleProperty,destMidVar0.AdditionalProperty,listMapping5)

destMidVar0.Version = srcMidVar0.version

destMidVar0.ResultDesc = srcMidVar0.resultDesc

destMidVar0.ResultCode = srcMidVar0.resultCode

destMidVar0.MsgLanguageCode = srcMidVar0.msgLanguageCode

destMidVar0.MessageSeq = srcMidVar0.messageSeq

def srcMidVar1 = srcReturn.freeUnitItemList

mappingList(srcMidVar1.freeUnitItemList,destMidVar.FreeUnitItem,listMapping3)

def srcMidVar2 = srcReturn.rscRelation

def destMidVar2 = destMidVar.RscRelation

mappingList(srcMidVar2.shareToRelationList,destMidVar2.ShareToRelation,listMapping7)

mappingList(srcMidVar2.shareFromRelationList,destMidVar2.ShareFromRelation,listMapping11)

