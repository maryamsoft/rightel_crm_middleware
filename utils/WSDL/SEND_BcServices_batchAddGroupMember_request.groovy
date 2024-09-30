dest.setServiceOperation("BMGroupService","batchAddGroupMember")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.group.batch.addmember.io.BatchAddGroupMemberRequest"

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

		dest.effDate=parseDate(src.EffectiveTime,"yyyyMMddHHmmss")
	
		dest.expDate=parseDate(src.ExpirationTime,"yyyyMMddHHmmss")
	
	def destMidVar2 = dest.property
	
	destMidVar2.propCode = src.PropCode
	
	mappingList(src.SubPropInst,destMidVar2.subProps,listMapping3)
	
	destMidVar2.value = src.Value
	
	destMidVar2.complexFlag = src.PropType
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

		dest.effDate=parseDate(src.EffectiveTime,"yyyyMMddHHmmss")
	
		dest.expDate=parseDate(src.ExpirationTime,"yyyyMMddHHmmss")
	
	def destMidVar5 = dest.property
	
	destMidVar5.propCode = src.PropCode
	
	mappingList(src.SubPropInst,destMidVar5.subProps,listMapping6)
	
	destMidVar5.value = src.Value
	
	destMidVar5.complexFlag = src.PropType
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	def destMidVar4 = dest.productInst
	
	destMidVar4.networkType = src.NetworkType
	
	destMidVar4.packageFlag = src.PackageFlag
	
	destMidVar4.parentProdId = src.ParentProdID
	
	mappingList(src.PInstProperty,dest.properties,listMapping5)
	
	destMidVar4.primaryFlag = src.PrimaryFlag
	
	destMidVar4.prodId = src.ProductID
	
	destMidVar4.productType = src.ProductType
	
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

	def destMidVar0 = dest.offeringInst.offeringKey
	
	def srcMidVar5 = src.OfferingKey
	
	destMidVar0.oId = srcMidVar5.OfferingID
	
  destMidVar0.oCode = srcMidVar5.OfferingCode
	
	destMidVar0.pSeq = srcMidVar5.PurchaseSeq
	
	def destMidVar1 = dest.offeringInst
	
	destMidVar1.bundleFlag = src.BundledFlag
	
	destMidVar1.offeringClass = src.OfferingClass
	
	mappingList(src.OInstProperty,dest.properties,listMapping2)
	
	def destMidVar3 = dest.offeringInst.parentOfferingKey
	
	def srcMidVar6 = src.ParentOfferingKey
	
	destMidVar3.oId = srcMidVar6.OfferingID
	
	destMidVar3.oCode = srcMidVar6.OfferingCode
	
	destMidVar3.pSeq = srcMidVar6.PurchaseSeq
	
	mappingList(src.ProductInst,dest.productInsts,listMapping4)
	
		destMidVar1.trialEndTime=parseDate(src.TrialEndTime,"yyyyMMddHHmmss")
	
		destMidVar1.trialStartTime=parseDate(src.TrialStartTime,"yyyyMMddHHmmss")
	
	destMidVar1.status = src.Status
	
	def destMidVar6 = dest.offeringInst.relGOfferingKey
	
	def srcMidVar7 = src.RelGOfferingKey
	
	destMidVar6.oId = srcMidVar7.OfferingID
	
	destMidVar6.oCode = srcMidVar7.OfferingCode
	
	destMidVar6.pSeq = srcMidVar7.PurchaseSeq
	
}

def srcMidVar = srcArgs0.BatchAddGroupMemberRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar.LoginSystemCode

destArgs0.password = srcMidVar.Password

destArgs0.remoteAddress = srcMidVar.RemoteIP

def srcMidVar0 = srcArgs0.BatchAddGroupMemberRequestMsg.RequestHeader

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar0.BusinessCode

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

def srcMidVar1 = srcArgs0.BatchAddGroupMemberRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.BatchAddGroupMemberRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.BatchAddGroupMemberRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

def srcMidVar4 = srcArgs0.BatchAddGroupMemberRequestMsg.BatchAddGroupMemberRequest

destArgs1.requestFileName = srcMidVar4.FileName

destArgs1.transferPublicFreeUnit = srcMidVar4.TransferPublicFreeUnit

def destMidVar = destArgs1.subOfferingInfo

mappingList(srcMidVar4.GroupMemberOffering,destMidVar.addSuppOfferings,listMapping1)

def destMidVar7 = destArgs1.groupAccessCode

def srcMidVar8 = srcArgs0.BatchAddGroupMemberRequestMsg.BatchAddGroupMemberRequest.SubGroupAccessCode

destMidVar7.groupCode = srcMidVar8.SubGroupCode

destMidVar7.groupKey = srcMidVar8.SubGroupKey

def srcMidVar9 = srcArgs0.BatchAddGroupMemberRequestMsg.BatchAddGroupMemberRequest.EffectiveTime

destArgs1.effMode = srcMidVar9.Mode

def srcMidVar30 = srcArgs0.BatchAddGroupMemberRequestMsg.BatchAddGroupMemberRequest.SubGroupMemberInfo

destArgs1.memberTypeCode = srcMidVar30.MemberTypeCode

destArgs1.effDate=parseDate(srcMidVar9.Time,"yyyyMMddHHmmss")

destArgs0.interMode = srcMidVar0.AccessMode

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

def srcMidVar13 = srcArgs0.BatchAddGroupMemberRequestMsg.BatchAddGroupMemberRequest.PaymentRelation.AddPayRelation

mappingList(srcMidVar13.PaymentLimit,destArgs1.paymentLimitInfos,listMapping8)

mappingList(srcMidVar13.PayRelation,destArgs1.addPaymentRelationInfos,listMapping9)

def destMidVar11 = destArgs1.newDftAcct

def srcMidVar18 = srcArgs0.BatchAddGroupMemberRequestMsg.BatchAddGroupMemberRequest.PaymentRelation.NewDFTAcct

destMidVar11.acctKey = srcMidVar18.AcctKey

destMidVar11.payRelationKey = srcMidVar18.PayRelationKey

def destMidVar12 = destArgs1.newDftAcct.paymentLimitInfo

def srcMidVar19 = srcArgs0.BatchAddGroupMemberRequestMsg.BatchAddGroupMemberRequest.PaymentRelation.NewDFTAcct.PaymentLimit

destMidVar12.limitKey = srcMidVar19.PaymentLimitKey

def srcMidVar20 = srcArgs0.BatchAddGroupMemberRequestMsg.BatchAddGroupMemberRequest.PaymentRelation.NewDFTAcct.PaymentLimit.PaymentLimitInfo

destMidVar12.cBonusFlag = srcMidVar20.CBonusFlag

destMidVar12.currencyId = srcMidVar20.CurrencyID

def srcMidVar21 = srcArgs0.BatchAddGroupMemberRequestMsg.BatchAddGroupMemberRequest.PaymentRelation.NewDFTAcct.PaymentLimit.PaymentLimitInfo.Limit

destMidVar12.limitMeasureUnit = srcMidVar21.LimitMeasureUnit

destMidVar12.limitType = srcMidVar21.LimitType

destMidVar12.limitValue = srcMidVar21.LimitValue

destMidVar12.limitValueType = srcMidVar21.LimitValueType

destMidVar12.limitCycleType = srcMidVar20.LimitCycleType

destMidVar12.limitRule = srcMidVar20.LimitRule