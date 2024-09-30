import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("CustomerService","changeRscRelation")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.customer.changerscrelation.io.ChangeRscRelationRequest"

def listMapping0

listMapping0 =
{
    src,dest  ->

	dest.code = src.Code

	dest.value = src.Value

}

def listMapping2

listMapping2 =
{
    src,dest  ->

	dest.oId = src.OfferingID

	dest.pSeq = src.PurchaseSeq

}

def listMapping4

listMapping4 =
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity

	dest.subscriberKey = src.SubscriberKey

}

def listMapping22

listMapping22 =
{
	src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity

	dest.customerKey = src.CustomerKey

	dest.customerCode = src.CustomerCode
}

def listMapping3

listMapping3 =
{
    src,dest  ->

	listMapping4.call(src.SubIdentify,dest.subAccessCode)

	listMapping22.call(src.CustAccessCode, dest.custAccessCode)

}

def listMapping5

listMapping5 =
{
    src,dest  ->

	dest.freeUnitLimitTypeCode = src.FreeUnitLimitType

	dest.limitCycleType = src.LimitCycleType

	dest.limitValue = src.LimitValue

	dest.measureUnit = src.MeasureUnit
	
	dest.rscRelationLimitKey = src.RscRelationLimitKey
	
	dest.limitValueExpr = src.LimitValueExpr

	dest.limitPermillage = src.LimitPermillage

}

def listMapping20

listMapping20 =
{
	src,dest  ->

	dest.quota = src.Quota

	dest.notifyType = src.NotifyType

	dest.actionRule = src.ActionRule

	dest.effDate = parseDate(src.StartTime, Constant4Model.DATE_FORMAT)

	dest.expDate = parseDate(src.EndTime, Constant4Model.DATE_FORMAT)

    dest.measureUnit = src.MeasureUnit

}

def listMapping1

listMapping1 =
{
    src,dest  ->

	dest.effDate=parseDate(src.StartTime, Constant4Model.DATE_FORMAT)

	def destMidVar = dest.rscRelationInfo

	listMapping2.call(src.OfferingKey,destMidVar.offeringKey)
	
	if(!src.OfferingKey.isNull()){
	
	destMidVar.offeringKey._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar.offeringKey.oCode = src.OfferingKey.OfferingCode
	
	}

	listMapping3.call(src.RelationDestIdentify,dest.relationDestIdentify)

	dest.relationObjType = src.RelationObjType

	mappingList(src.ShareLimit,dest.shareLimitInfos,listMapping5)

	destMidVar.shareRule = src.ShareRule

    destMidVar.freeUnitType = src.FreeUnitType

	dest.expDate=parseDate(src.EndTime, Constant4Model.DATE_FORMAT)

	destMidVar.freeUnitLimitTypeCode = src.FreeUnitLimitType

    mappingList(src.NotifyRule,dest.notifyRules,listMapping20)

    dest.priority = src.Priority
    
    dest.paymentRelKey = src.RscRelationKey
    
    dest.allocatedFlag = src.AllocatedFlag
}

def listMapping7

listMapping7 =
{
    src,dest  ->

	dest.oId = src.OfferingID

	dest.pSeq = src.PurchaseSeq

}

def listMapping9

listMapping9 =
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity

	dest.subscriberKey = src.SubscriberKey

}

def listMapping8

listMapping8 =
{
    src,dest  ->

	listMapping9.call(src.SubIdentify,dest.subAccessCode)

	listMapping22.call(src.CustAccessCode, dest.custAccessCode)

}

def listMapping6

listMapping6 =
{
    src,dest  ->

	dest.expDate=parseDate(src.EndTime, Constant4Model.DATE_FORMAT)

	dest.effDate=parseDate(src.StartTime, Constant4Model.DATE_FORMAT)

	def destMidVar0 = dest.rscRelationInfo

	listMapping7.call(src.OfferingKey,destMidVar0.offeringKey)
	
	if(!src.OfferingKey.isNull()){
	
		destMidVar0.offeringKey._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
		destMidVar0.offeringKey.oCode = src.OfferingKey.OfferingCode
	
	}

	listMapping8.call(src.RelationDestIdentify,dest.relationDestIdentify)

  dest.paymentRelKey = src.RscRelationKey

	dest.relationObjType = src.RelationObjType

	destMidVar0.shareRule = src.ShareRule

    destMidVar0.freeUnitType = src.FreeUnitType

	destMidVar0.freeUnitLimitTypeCode = src.FreeUnitLimitType
}

def listMapping11

listMapping11 =
{
    src,dest  ->

	dest.oId = src.OfferingID

	dest.pSeq = src.PurchaseSeq

}

def listMapping12

listMapping12 =
{
    src,dest  ->

	dest.oId = src.OfferingID

	dest.pSeq = src.PurchaseSeq

}

def listMapping13

listMapping13 =
{
    src,dest  ->

	dest.freeUnitLimitTypeCode = src.FreeUnitLimitType

	dest.limitCycleType = src.LimitCycleType

	dest.limitValue = src.LimitValue

	dest.measureUnit = src.MeasureUnit
	
	dest.rscRelationLimitKey = src.RscRelationLimitKey
	
	dest.limitValueExpr = src.LimitValueExpr

	dest.limitPermillage = src.LimitPermillage

}

def listMapping15

listMapping15 =
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity

	dest.subscriberKey = src.SubscriberKey

}

def listMapping14

listMapping14 =
{
    src,dest  ->

	listMapping15.call(src.SubIdentify,dest.subAccessCode)

	listMapping22.call(src.CustAccessCode, dest.custAccessCode)

}

def listMapping18

listMapping18 =
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity

	dest.subscriberKey = src.SubscriberKey

}

def listMapping17

listMapping17 =
{
    src,dest  ->

	listMapping18.call(src.SubIdentify,dest.subAccessCode)

	listMapping22.call(src.CustAccessCode, dest.custAccessCode)

}

def listMapping10

listMapping10 =
{
    src,dest  ->

	def srcMidVar2 = src.NewRelation

	def destMidVar1 = dest.newRscRelationInfo

	listMapping11.call(srcMidVar2.OfferingKey,destMidVar1.offeringKey)
	
		if(!srcMidVar2.OfferingKey.isNull()){
		destMidVar1.offeringKey._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
		destMidVar1.offeringKey.oCode = srcMidVar2.OfferingKey.OfferingCode
	}

	destMidVar1.shareRule = srcMidVar2.ShareRule

    destMidVar1.freeUnitType = srcMidVar2.FreeUnitType

	destMidVar1.freeUnitLimitTypeCode = srcMidVar2.FreeUnitLimitType

	def srcMidVar3 = src.OldRelation

	def destMidVar2 = dest.oldRscRelationInfo

	listMapping12.call(srcMidVar3.OfferingKey,destMidVar2.offeringKey)
	
		if(!srcMidVar3.OfferingKey.isNull()){	
		destMidVar2.offeringKey._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
		destMidVar2.offeringKey.oCode = srcMidVar3.OfferingKey.OfferingCode
	}

	destMidVar2.shareRule = srcMidVar3.ShareRule

	destMidVar2.freeUnitType = srcMidVar3.FreeUnitType

	destMidVar2.freeUnitLimitTypeCode = srcMidVar3.FreeUnitLimitType

	mappingList(srcMidVar2.ShareLimit,dest.newShareLimitInfos,listMapping13)

	listMapping14.call(src.RelationDestIdentify,dest.relationDestIdentify)

	dest.relationObjType = src.RelationObjType

	listMapping17.call(src.NewDestIdentify,dest.newDestIdentify)

	dest.effTime=parseDate(src.EffTime, Constant4Model.DATE_FORMAT)

	dest.priority = srcMidVar2.Priority
	
	dest.paymentRelKey = srcMidVar3.RscRelationKey

	mappingList(src.NotifyRule,dest.newNotifyRules,listMapping20)

}

def listMapping16

listMapping16 =
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity

	dest.subscriberKey = src.SubscriberKey

}

def listMapping19

listMapping19 =
{
    src,dest  ->

    dest.groupKey = src.SubGroupKey

    dest.groupCode = src.SubGroupCode

}

def listMapping21

listMapping21 =
{
	src,dest  ->

		dest.customerCode = src.CustomerCode

		dest.customerKey = src.CustomerKey

		dest.primaryIdentity = src.PrimaryIdentity

}

def srcMidVar = srcArgs0.ChangeRscRelationRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar.AccessMode

def srcMidVar0 = srcArgs0.ChangeRscRelationRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar0.LoginSystemCode

destArgs0.password = srcMidVar0.Password

destArgs0.remoteAddress = srcMidVar0.RemoteIP

mappingList(srcMidVar.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar.BusinessCode

destArgs0.messageSeq = srcMidVar.MessageSeq

destArgs0.msgLanguageCode = srcMidVar.MsgLanguageCode

def srcMidVar1 = srcArgs0.ChangeRscRelationRequestMsg.ChangeRscRelationRequest.RscRelation

mappingList(srcMidVar1.DelRelation,destArgs1.delRelations,listMapping6)

mappingList(srcMidVar1.AddRelation,destArgs1.addRelations,listMapping1)

mappingList(srcMidVar1.ModRelation,destArgs1.modifyRelations,listMapping10)

def srcMidVar4 = srcArgs0.ChangeRscRelationRequestMsg.ChangeRscRelationRequest

def destMidVar3 = destArgs1.anyAccessCode

def destMidVar4 = destArgs1.anyAccessCode

def destMidVar5 = destArgs1.anyAccessCode

listMapping16.call(srcMidVar4.SubAccessCode,destMidVar3.subAccessCode)

listMapping19.call(srcMidVar4.SubGroupAccessCode,destMidVar4.groupAccessCode)

listMapping21.call(srcMidVar4.CustAccessCode,destMidVar5.custAccessCode)

def srcMidVar5 = srcArgs0.ChangeRscRelationRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar5.ChannelID

destArgs0.operatorId = srcMidVar5.OperatorID

def srcMidVar6 = srcArgs0.ChangeRscRelationRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar6.BEID

destArgs0.brId = srcMidVar6.BRID

def srcMidVar7 = srcArgs0.ChangeRscRelationRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar7.TimeType

destArgs0.timeZoneId = srcMidVar7.TimeZoneID

destArgs0.version = srcMidVar.Version
