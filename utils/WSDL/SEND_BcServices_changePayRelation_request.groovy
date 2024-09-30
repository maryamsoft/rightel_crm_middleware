import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("AccountService","changeAdvPayRelation")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.account.changeadvpayrelation.io.ChangeAdvPayRelationRequest"

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

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.groupCode = src.SubGroupCode
	
	dest.groupKey = src.SubGroupKey
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	def srcMidVar6 = src.PaymentLimitInfo
	
	dest.cBonusFlag = srcMidVar6.CBonusFlag
	
	dest.currencyId = srcMidVar6.CurrencyID
	
	def srcMidVar7 = src.PaymentLimitInfo.Limit
	
	dest.limitMeasureUnit = srcMidVar7.LimitMeasureUnit
	
	dest.limitType = srcMidVar7.LimitType
	
	dest.limitValue = srcMidVar7.LimitValue

	dest.extendExprCode = srcMidVar7.LimitValueExpr
	
	dest.limitValueType = srcMidVar7.LimitValueType
	
	dest.limitCycleType = srcMidVar6.LimitCycleType
	
	dest.limitRule = srcMidVar6.LimitRule
	
	dest.limitKey = src.PaymentLimitKey
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.acctKey = src.AcctKey
	
	def srcMidVar8 = src.EffectiveTime
	
	dest.effMode = srcMidVar8.Mode
	
	dest.effDate=parseDate(srcMidVar8.Time,Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime,Constant4Model.DATE_FORMAT)
	
	def destMidVar0 = dest.paymentRelation
	
	destMidVar0.finalFlag = src.OnlyPayRelFlag
	
	destMidVar0.srcObjKey = src.OriginKey
	
	destMidVar0.srcObjType = src.OriginType
	
	if(!src.BalCLType.isNull()){
	
	  destMidVar0._class = "com.huawei.ngcbs.cm.domain.entity.common.io.PaymentRelationInfoExtInfo"
	 
		destMidVar0.balanceType = src.BalCLType.BalanceType
		
	  destMidVar0.creditLimitType = src.BalCLType.CreditLimitType
	 
	}
	
	
	destMidVar0.paymentLimitKey = src.PaymentLimitKey
	
	destMidVar0.paymentRelationKey = src.PayRelationKey
	
	def srcMidVar9 = src.PayRelExtRule
	
	destMidVar0.chargeCode = srcMidVar9.ChargeCode
	
	destMidVar0.extRuleCode = srcMidVar9.ControlRule
	
	def destMidVar1 = dest.paymentRelation.offeringKey
	
	destMidVar1._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	def srcMidVar10 = src.PayRelExtRule.OfferingKey
	
	destMidVar1.oId = srcMidVar10.OfferingID
	
	destMidVar1.oCode = srcMidVar10.OfferingCode
	
	destMidVar1.pSeq = srcMidVar10.PurchaseSeq
	
	destMidVar0.priority = src.Priority
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	def srcMidVar12 = src.ExpirationTime
	
	dest.expMode = srcMidVar12.Mode
	
	dest.expDate=parseDate(srcMidVar12.Time,Constant4Model.DATE_FORMAT)
	
	dest.paymentRelationKey = src.PayRelationKey
	
	dest.filterEffDate = parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	def srcMidVar13 = src.PaymentLimitInfo
	
	dest.cBonusFlag = srcMidVar13.CBonusFlag
	
	dest.currencyId = srcMidVar13.CurrencyID
	
	def srcMidVar14 = src.PaymentLimitInfo.Limit
	
	dest.limitMeasureUnit = srcMidVar14.LimitMeasureUnit
	
	dest.limitType = srcMidVar14.LimitType
	
	dest.limitValue = srcMidVar14.LimitValue

	dest.extendExprCode = srcMidVar14.LimitValueExpr
	
	dest.limitValueType = srcMidVar14.LimitValueType
	
	dest.limitCycleType = srcMidVar13.LimitCycleType
	
	dest.limitRule = srcMidVar13.LimitRule
	
	dest.limitKey = src.PaymentLimitKey
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	def destMidVar2 = dest.modPaymentRelation
	
	destMidVar2.finalFlag = src.OnlyPayRelFlag
	
	if(!src.BalCLType.isNull()){
	
	destMidVar2._class = "com.huawei.ngcbs.cm.domain.entity.common.io.PaymentRelationInfoExtInfo"
	
	destMidVar2.balanceType = src.BalCLType.BalanceType
	destMidVar2.creditLimitType = src.BalCLType.CreditLimitType
	
	}
	
	dest.filterEffDate = parseDate(src.EffectiveTime,Constant4Model.DATE_FORMAT)
	
	def srcMidVar15 = src.PaymentLimit
	
	dest.limitValue = srcMidVar15.LimitValue

	dest.extendExprCode = srcMidVar15.LimitValueExpr
	
	dest.opType = srcMidVar15.OpType
	
	destMidVar2.paymentLimitKey = srcMidVar15.PaymentLimitKey
	
	destMidVar2.paymentRelationKey = src.PayRelationKey
	
	def srcMidVar16 = src.PayRelExtRule
	
	destMidVar2.chargeCode = srcMidVar16.ChargeCode
	
	destMidVar2.extRuleCode = srcMidVar16.ControlRule
	
	def destMidVar3 = dest.modPaymentRelation.offeringKey
	
	destMidVar3._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	def srcMidVar17 = src.PayRelExtRule.OfferingKey
	
	destMidVar3.oId = srcMidVar17.OfferingID
	
	destMidVar3.oCode = srcMidVar17.OfferingCode
	
	destMidVar3.pSeq = srcMidVar17.PurchaseSeq
	
	destMidVar2.priority = src.Priority
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	mappingList(src.PaymentLimit,dest.modPaymentLimitInfoList,listMapping8)
	
	mappingList(src.PayRelation,dest.modPayRelation,listMapping9)
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def srcMidVar = srcArgs0.ChangePayRelationRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar.BEID

destArgs0.brId = srcMidVar.BRID

def srcMidVar0 = srcArgs0.ChangePayRelationRequestMsg.RequestHeader

destArgs0.businessCode = srcMidVar0.BusinessCode

def srcMidVar1 = srcArgs0.ChangePayRelationRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.interMode = srcMidVar0.AccessMode

def srcMidVar2 = srcArgs0.ChangePayRelationRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar2.LoginSystemCode

destArgs0.messageSeq = srcMidVar0.MessageSeq

destArgs0.msgLanguageCode = srcMidVar0.MsgLanguageCode

destArgs0.operatorId = srcMidVar1.OperatorID

destArgs0.password = srcMidVar2.Password

destArgs0.remoteAddress = srcMidVar2.RemoteIP

mappingList(srcMidVar0.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

def srcMidVar3 = srcArgs0.ChangePayRelationRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar0.Version

def srcMidVar4 = srcArgs0.ChangePayRelationRequestMsg.ChangePayRelationRequest.PaymentObj

listMapping1.call(srcMidVar4.CustAccessCode,destArgs1.custAccessCode)

listMapping2.call(srcMidVar4.SubAccessCode,destArgs1.subAccessCode)

listMapping3.call(srcMidVar4.SubGroupAccessCode,destArgs1.groupAccessCode)

def srcMidVar5 = srcArgs0.ChangePayRelationRequestMsg.ChangePayRelationRequest.PaymentRelation.AddPayRelation

mappingList(srcMidVar5.PaymentLimit,destArgs1.paymentLimitInfoList,listMapping4)

def destMidVar = destArgs1.changePaymentRelationInfo

mappingList(srcMidVar5.PayRelation,destMidVar.addPaymentRelations,listMapping5)

def srcMidVar11 = srcArgs0.ChangePayRelationRequestMsg.ChangePayRelationRequest.PaymentRelation

mappingList(srcMidVar11.DelPayRelation,destMidVar.delPaymentRelations,listMapping6)

listMapping7.call(srcMidVar11.ModPayRelation,destMidVar.modPaymentRelations)


def srcMidVar23 = srcArgs0.ChangePayRelationRequestMsg.ChangePayRelationRequest.AdditionalProperty

mappingList(srcMidVar23,destArgs1.simplePropertyList,listMapping10)

