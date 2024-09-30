import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("BMGroupService","addGroupMemberWithResult")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.addmember.io.AddMemberRequest"

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

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar4 = dest.property
	
	destMidVar4.propCode = src.PropCode
	
	destMidVar4.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar4.subProps,listMapping4)
	
	destMidVar4.value = src.Value
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.effDate=parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar7 = dest.property
	
	destMidVar7.propCode = src.PropCode
	
	destMidVar7.complexFlag = src.PropType
	
	mappingList(src.SubPropInst,destMidVar7.subProps,listMapping7)
	
	destMidVar7.value = src.Value
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	def destMidVar6 = dest.productInst
	
	destMidVar6.networkType = src.NetworkType
	
	destMidVar6.packageFlag = src.PackageFlag
	
	destMidVar6.parentProdId = src.ParentProdID
	
	mappingList(src.PInstProperty,dest.properties,listMapping6)
	
	destMidVar6.primaryFlag = src.PrimaryFlag
	
	destMidVar6.prodId = src.ProductID
	
	destMidVar6.productType = src.ProductType
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.offeringInst.activeTime=parseDate(src.ActivationTime.ActiveTime,Constant4Model.DATE_FORMAT)
	
	dest.offeringInst.activeTimeLimit=parseDate(src.ActivationTime.ActiveTimeLimit,Constant4Model.DATE_FORMAT)
	
	def destMidVar2 = dest.offeringInst
	
	def srcMidVar9 = src.ActivationTime
	
	destMidVar2.activeMode = srcMidVar9.Mode
	
	destMidVar2.bundleFlag = src.BundledFlag
	
	destMidVar2.offeringClass = src.OfferingClass
	
	def destMidVar3 = dest.offeringInst.offeringKey
	
	def srcMidVar10 = src.OfferingKey
	
	destMidVar3.oId = srcMidVar10.OfferingID
	
	destMidVar3.oCode = srcMidVar10.OfferingCode
	
	destMidVar3.pSeq = srcMidVar10.PurchaseSeq
	
	mappingList(src.OInstProperty,dest.properties,listMapping3)
	
	def destMidVar5 = dest.offeringInst.parentOfferingKey
	
	def srcMidVar11 = src.ParentOfferingKey
	
	destMidVar5.oId = srcMidVar11.OfferingID
	
	destMidVar5.oCode = srcMidVar11.OfferingCode
	
	destMidVar5.pSeq = srcMidVar11.PurchaseSeq
	
	mappingList(src.ProductInst,dest.productInsts,listMapping5)
	
	def destMidVar8 = dest.offeringInst.relGOfferingKey
	
	def srcMidVar12 = src.RelGOfferingKey
	
	destMidVar8.oId = srcMidVar12.OfferingID
	
	destMidVar8.oCode = srcMidVar12.OfferingCode
	
	destMidVar8.pSeq = srcMidVar12.PurchaseSeq
	
	destMidVar2.status = src.Status
	
	destMidVar2.trialEndTime=parseDate(src.TrialEndTime,Constant4Model.DATE_FORMAT)
	
	destMidVar2.trialStartTime=parseDate(src.TrialStartTime,Constant4Model.DATE_FORMAT)
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	def srcMidVar14 = src.PaymentLimitInfo
	
	dest.cBonusFlag = srcMidVar14.CBonusFlag
	
	dest.currencyId = srcMidVar14.CurrencyID
	
	def srcMidVar15 = src.PaymentLimitInfo.Limit
	
	dest.limitMeasureUnit = srcMidVar15.LimitMeasureUnit
	
	dest.limitType = srcMidVar15.LimitType
	
	dest.limitValue = srcMidVar15.LimitValue

	dest.extendExprCode = srcMidVar15.LimitValueExpr
	
	dest.limitValueType = srcMidVar15.LimitValueType
	
	dest.limitCycleType = srcMidVar14.LimitCycleType
	
	dest.limitRule = srcMidVar14.LimitRule
	
	dest.limitKey = src.PaymentLimitKey
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.acctKey = src.AcctKey
	
	def destMidVar9 = dest.paymentRelation
	
	destMidVar9.finalFlag = src.OnlyPayRelFlag
	
	destMidVar9.paymentLimitKey = src.PaymentLimitKey
	
	destMidVar9.paymentRelationKey = src.PayRelationKey
	
	def srcMidVar16 = src.PayRelExtRule
	
	destMidVar9.chargeCode = srcMidVar16.ChargeCode
	
	destMidVar9.extRuleCode = srcMidVar16.ControlRule
	
	def destMidVar10 = dest.paymentRelation.offeringKey
	
	def srcMidVar17 = src.PayRelExtRule.OfferingKey
	
	destMidVar10.oId = srcMidVar17.OfferingID
	
	destMidVar10.oCode = srcMidVar17.OfferingCode
	
	destMidVar10.pSeq = srcMidVar17.PurchaseSeq
	
	destMidVar9.priority = src.Priority

	destMidVar9.srcObjKey = src.OriginKey

	destMidVar9.srcObjType = src.OriginType
	
}
def listMapping10

listMapping10 =
		{
			src,dest  ->

				dest.quota = src.Quota

				dest.notifyType = src.NotifyType

				dest.actionRule = src.ActionRule

				dest.effDate = parseDate(src.StartTime, Constant4Model.DATE_FORMAT)

				dest.expDate = parseDate(src.EndTime, Constant4Model.DATE_FORMAT)

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
	  def srcMidVar26 = src.EffectiveTime
	  dest.effMode = srcMidVar26.Mode
	  dest.effTime = parseDate(srcMidVar26.Time,Constant4Model.DATE_FORMAT)
	  dest.expDate = parseDate(src.ExpDate,Constant4Model.DATE_FORMAT)
	  dest.limitValue = src.LimitValue
}

def listMapping11

listMapping11 =
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

def srcMidAddPayLimitList = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.UsagePayLimit.AddPayLimit
def destAddPayLimitList = destArgs1.addPayLimitList

mappingList(srcMidAddPayLimitList,destAddPayLimitList,listMapping_AddPayLimit) 

def srcMidVar = srcArgs0.AddGroupMemberRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar.LoginSystemCode

destArgs0.password = srcMidVar.Password

destArgs0.remoteAddress = srcMidVar.RemoteIP

def srcMidVar0 = srcArgs0.AddGroupMemberRequestMsg.RequestHeader

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar0.BusinessCode

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

destArgs0.interMode = srcMidVar0.AccessMode

def srcMidVar1 = srcArgs0.AddGroupMemberRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.AddGroupMemberRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.AddGroupMemberRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

def destMidVar = destArgs1.addMemberInfo

def srcMidVar4 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.EffectiveTime

destMidVar.effMode = srcMidVar4.Mode

destArgs0.version = srcMidVar0.Version

destMidVar.effDate=parseDate(srcMidVar4.Time,Constant4Model.DATE_FORMAT)

def destMidVar0 = destArgs1.subAccessCode

def srcMidVar5 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.GroupMember.SubAccessCode

destMidVar0.primaryIdentity = srcMidVar5.PrimaryIdentity

destMidVar0.subscriberKey = srcMidVar5.SubscriberKey

def srcMidVar6 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.GroupMember.SubGrpMember

destMidVar.shortNumber = srcMidVar6.MemberShortNo

def srcMidVar7 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.GroupMember.SubGrpMember.SubGrpMemberInfo

mappingList(srcMidVar7.MemberProperty,destMidVar.memberProperties,listMapping1)

destMidVar.memberTypeCode = srcMidVar7.MemberTypeCode

def srcMidVar8 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest

destArgs1.transferPublicFreeUnit = srcMidVar8.TransferPublicFreeUnit

def destMidVar1 = destArgs1.subOfferingInfo

mappingList(srcMidVar8.GroupMemberOffering,destMidVar1.addSuppOfferings,listMapping2)

def srcMidVar13 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.PaymentRelation.AddPayRelation

mappingList(srcMidVar13.PaymentLimit,destArgs1.paymentLimitInfos,listMapping8)

mappingList(srcMidVar13.PayRelation,destArgs1.addPaymentRelationInfos,listMapping9)

def destMidVar11 = destArgs1.newDftAcct

def srcMidVar18 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.PaymentRelation.NewDFTAcct

destMidVar11.acctKey = srcMidVar18.AcctKey

destMidVar11.payRelationKey = srcMidVar18.PayRelationKey

def destMidVar12 = destArgs1.newDftAcct.paymentLimitInfo

def srcMidVar19 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.PaymentRelation.NewDFTAcct.PaymentLimit

destMidVar12.limitKey = srcMidVar19.PaymentLimitKey

def srcMidVar20 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.PaymentRelation.NewDFTAcct.PaymentLimit.PaymentLimitInfo

destMidVar12.cBonusFlag = srcMidVar20.CBonusFlag

destMidVar12.currencyId = srcMidVar20.CurrencyID

def srcMidVar21 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.PaymentRelation.NewDFTAcct.PaymentLimit.PaymentLimitInfo.Limit

destMidVar12.limitMeasureUnit = srcMidVar21.LimitMeasureUnit

destMidVar12.limitType = srcMidVar21.LimitType

destMidVar12.limitValue = srcMidVar21.LimitValue

destMidVar12.limitValueType = srcMidVar21.LimitValueType

destMidVar12.limitCycleType = srcMidVar20.LimitCycleType

destMidVar12.limitRule = srcMidVar20.LimitRule

def destMidVar13 = destArgs1.groupAccessCode

def srcMidVar22 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.SubGroupAccessCode

destMidVar13.groupCode = srcMidVar22.SubGroupCode

destMidVar13.groupKey = srcMidVar22.SubGroupKey

def srcMidVar23 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.GroupMember

destArgs1.subClass = srcMidVar23.SubClass

def destMidVar14 = destArgs1.outerSubInfo

def srcMidVar24 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.GroupMember.SubInfo

destMidVar14.displayNumber = srcMidVar24.DisplayNumber

destMidVar14.ivrLang = srcMidVar24.IVRLang

destMidVar14.networkType = srcMidVar24.NetworkType

destMidVar14.writtenLang = srcMidVar24.WrittenLang

destMidVar14.numberType = srcMidVar24.NumberType

def destMidVar15 = destArgs1.rscRelation

def srcMidVar25 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest.RscRelation
destMidVar15.effDate=parseDate(srcMidVar25.StartTime, Constant4Model.DATE_FORMAT)

destMidVar15.rscRelationInfo.offeringKey.oId = srcMidVar25.OfferingKey.OfferingID
destMidVar15.rscRelationInfo.offeringKey.oCode = srcMidVar25.OfferingKey.OfferingCode
destMidVar15.rscRelationInfo.offeringKey.pSeq = srcMidVar25.OfferingKey.PurchaseSeq

destMidVar15.relationDestIdentify.subAccessCode.primaryIdentity = srcMidVar25.RelationDestIdentify.SubIdentify.PrimaryIdentity
destMidVar15.relationDestIdentify.subAccessCode.subscriberKey = srcMidVar25.RelationDestIdentify.SubIdentify.SubscriberKey

destMidVar15.relationObjType = srcMidVar25.RelationObjType
mappingList(srcMidVar25.ShareLimit,destMidVar15.shareLimitInfos,listMapping11)

destMidVar15.rscRelationInfo.shareRule = srcMidVar25.ShareRule
destMidVar15.expDate=parseDate(srcMidVar25.EndTime, Constant4Model.DATE_FORMAT)

destMidVar15.rscRelationInfo.freeUnitLimitTypeCode = srcMidVar25.FreeUnitLimitType

destMidVar15.rscRelationInfo.freeUnitType = srcMidVar25.FreeUnitType

mappingList(srcMidVar25.NotifyRule, destMidVar15.notifyRules, listMapping10)

destMidVar15.priority = srcMidVar25.Priority

destMidVar15.paymentRelKey = srcMidVar25.RscRelationKey

destMidVar15.allocatedFlag = srcMidVar25.AllocatedFlag

def listMapping12

listMapping12 =
		{
			src, dest ->
				dest.freeUnitTypeGroup = src.FreeUnitTypeGroup

                dest.effMode = src.EffectiveTime.Mode

                dest.effDate = parseDate(src.EffectiveTime.Time, Constant4Model.DATE_FORMAT)
		}

def srcMidVar26 = srcArgs0.AddGroupMemberRequestMsg.AddGroupMemberRequest

mappingList(srcMidVar26.TransferFreeUnitTypeGroup, destArgs1.transferFreeUnitTypeGroupList, listMapping12)