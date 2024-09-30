import com.huawei.ngcbs.bm.common.common.Constant4Model

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.OfferingID = src.oId
	
  dest.OfferingCode = src.oCode
	
	dest.PurchaseSeq = src.pSeq
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.AcctKey = src.acctKey
	
	dest.DefaultPayFlag = src.defaultPayFlag
	
	dest.PayObjCode = src.payObjCode
	
	dest.PayObjKey = src.payObjKey
	
	dest.PayObjType = src.payObjType
	
	def destMidVar0 = dest.PayRelExtRule
	
	def srcMidVar = src.paymentRelationInfo
	
	destMidVar0.ChargeCode = srcMidVar.chargeCode
	
	destMidVar0.ControlRule = srcMidVar.extRuleCode
	
	def oKeyExt =srcMidVar.offeringKey
    
  oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	listMapping3.call(oKeyExt,destMidVar0.OfferingKey)
	
	dest.PaymentLimitKey = srcMidVar.paymentLimitKey
	
	dest.PayRelationKey = srcMidVar.paymentRelationKey
	
	dest.Priority = srcMidVar.priority
	
	dest.OriginKey = srcMidVar.srcObjKey
	
	dest.OriginType = srcMidVar.srcObjType
	
	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	dest.OnlyPayRelFlag = srcMidVar.finalFlag

	dest.UsageAmount = src.usageAmount

	dest.LimitValueExprResult = src.limitValueExprResult
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	def destMidVar1 = dest.PaymentLimitInfo
	
	destMidVar1.CBonusFlag = src.cBonusFlag
	
	destMidVar1.CurrencyID = src.currencyId
	
	def destMidVar2 = dest.PaymentLimitInfo.Limit
	
	destMidVar2.LimitMeasureUnit = src.limitMeasureUnit
	
	destMidVar1.LimitCycleType = src.limitCycleType
	
	destMidVar1.LimitRule = src.limitRule
	
	destMidVar2.LimitType = src.limitType
	
	destMidVar2.LimitValue = src.limitValue
	
	destMidVar2.LimitValueExpr = src.extendExprCode
	
	destMidVar2.LimitValueType = src.limitValueType
	
	dest.PaymentLimitKey = src.limitKey
	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	mappingList(src.paymentRelationExtList,dest.PayRelation,listMapping2)
	
	mappingList(src.paymentLimitInfoList,dest.PaymentLimit,listMapping5)
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar = destReturn.QueryPaymentRelationResultMsg.QueryPaymentRelationResult

listMapping0.call(srcReturn.payRelationInfo,destMidVar.PaymentRelationList)

def srcMidVar0 = srcReturn.resultHeader

def destMidVar3 = destReturn.QueryPaymentRelationResultMsg.ResultHeader

mappingList(srcMidVar0.simpleProperty,destMidVar3.AdditionalProperty,listMapping4)

destMidVar3.ResultCode = srcMidVar0.resultCode

destMidVar3.MsgLanguageCode = srcMidVar0.msgLanguageCode

destMidVar3.ResultDesc = srcMidVar0.resultDesc

destMidVar3.Version = srcMidVar0.version

destMidVar3.MessageSeq = srcMidVar0.messageSeq

destMidVar.TotalRowNum = srcReturn.payRelationInfo.totalRowNum
destMidVar.BeginRowNum = srcReturn.payRelationInfo.beginRowNum
destMidVar.FetchRowNum = srcReturn.payRelationInfo.fetchRowNum
