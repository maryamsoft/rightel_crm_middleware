dest.setServiceOperation("AccountService","batchChangePayRelation")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.account.batch.changepayrelation.io.BatchChangePayRelationRequest"

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
    
  def destMidVar = dest.paymentRelation

	destMidVar.chargeCode = src.ChargeCode
	
	destMidVar.extRuleCode = src.ControlRule
	
	destMidVar.priority = src.Priority
	
	destMidVar.finalFlag = src.OnlyPayRelFlag
	
	if(!src.BalCLType.isNull()){
	
	destMidVar._class = "com.huawei.ngcbs.cm.domain.entity.common.io.PaymentRelationInfoExtInfo"
	destMidVar.balanceType = src.BalCLType.BalanceType
	destMidVar.creditLimitType = src.BalCLType.CreditLimitType
	
	}
	
	dest.paymentLimitInfo.currencyId = src.PayLimit.CurrencyID
	
	dest.paymentLimitInfo.limitCycleType = src.PayLimit.LimitCycleType
	
	dest.paymentLimitInfo.limitMeasureUnit = src.PayLimit.Limit.LimitMeasureUnit
	
	dest.paymentLimitInfo.limitType = src.PayLimit.Limit.LimitType
	
	dest.paymentLimitInfo.limitValue = src.PayLimit.Limit.LimitValue
	
	dest.paymentLimitInfo.extendExprCode = src.PayLimit.Limit.LimitValueExpr
	
	dest.paymentLimitInfo.limitValueType = src.PayLimit.Limit.LimitValueType
	
}

def listMapping2

listMapping2 =
{
	src,dest  ->
	
	def destMidVar2 = dest.modPaymentRelation
	
	destMidVar2.chargeCode = src.ChargeCode
	
	destMidVar2.extRuleCode = src.ControlRule
	
	destMidVar2.finalFlag = src.OnlyPayRelFlag
	
	dest.limitValue = src.LimitValue
	
	dest.extendExprCode = src.LimitValueExpr
	
	if(!src.BalCLType.isNull()){
	
	destMidVar2._class = "com.huawei.ngcbs.cm.domain.entity.common.io.PaymentRelationInfoExtInfo"
	
	destMidVar2.balanceType = src.BalCLType.BalanceType
	destMidVar2.creditLimitType = src.BalCLType.CreditLimitType
	
	}
	
	destMidVar2.priority = src.Priority
	
}

def srcModRel = srcArgs0.BatchChangePayRelationRequestMsg.BatchChangePayRelationRequest.PayRelation.ModPayRelation

def destModRel = destArgs1.batchChangePaymentRelation.modPaymentRelations.modPayRelation

mappingList(srcModRel,destModRel,listMapping2)

def srcMidVar = srcArgs0.BatchChangePayRelationRequestMsg.BatchChangePayRelationRequest

destArgs1.requestFileName = srcMidVar.FileName

destArgs1.paymentAcctKey = srcMidVar.PaymentAcctKey

def destMidVar = destArgs1.batchChangePaymentRelation.batchAddPaymentRelationInfo

def srcMidVar1 = srcArgs0.BatchChangePayRelationRequestMsg.BatchChangePayRelationRequest.PayRelation.AddPayRelation

mappingList(srcMidVar1,destMidVar,listMapping1)

def srcMidVar3 = srcArgs0.BatchChangePayRelationRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar3.AccessMode

def srcMidVar4 = srcArgs0.BatchChangePayRelationRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar4.LoginSystemCode

destArgs0.password = srcMidVar4.Password

destArgs0.remoteAddress = srcMidVar4.RemoteIP

mappingList(srcMidVar3.AdditionalProperty,destArgs0.simpleProperty,listMapping0)

destArgs0.businessCode = srcMidVar3.BusinessCode

destArgs0.messageSeq = srcMidVar3.MessageSeq

destArgs0.msgLanguageCode = srcMidVar3.MsgLanguageCode

def srcMidVar5 = srcArgs0.BatchChangePayRelationRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar5.ChannelID

destArgs0.operatorId = srcMidVar5.OperatorID

def srcMidVar6 = srcArgs0.BatchChangePayRelationRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar6.BEID

destArgs0.brId = srcMidVar6.BRID

def srcMidVar7 = srcArgs0.BatchChangePayRelationRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar7.TimeType

destArgs0.timeZoneId = srcMidVar7.TimeZoneID

destArgs0.version = srcMidVar3.Version
