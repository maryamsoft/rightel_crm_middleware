import com.huawei.ngcbs.bm.common.common.Constant4Model

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.MsgLanguageCode = src.msgLanguageCode
	
	dest.ResultCode = src.resultCode
	
	dest.ResultDesc = src.resultDesc
	
	dest.Version = src.version

	dest.MessageSeq = src.messageSeq
	
	mappingList(src.simpleProperty,dest.AdditionalProperty,listMapping1)
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.CurrencyID = src.currencyId
	
	dest.NewBalanceAmt = src.newBalanceAmount
	
	dest.OldBalanceAmt = src.oldBalanceAmount
	
	dest.BalanceTypeName = src.balanceTypeName
	
	dest.BalanceID = src.acctBalanceId
	
	dest.BalanceType = src.balanceTypeCode
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.AcctKey = src.acctKey
	
	mappingList(src.acctBalanceChangeInfoList,dest.BalanceChgInfo,listMapping4)
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.FreeUnitInstanceID = src.freeUnitInstanceId
	
	dest.FreeUnitType = src.freeUnitType
	
	dest.FreeUnitTypeName = src.freeUnitTypeName
	
	dest.MeasureUnit = src.measureUnit
	
	dest.MeasureUnitName = src.measureUnitName
	
	dest.NewAmt = src.newAmt
	
	dest.OldAmt = src.oldAmt
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.OwnerType = src.ownerType
	
	dest.OwnerKey = src.ownerKey
	
	mappingList(src.freeUnitChgInfoList,dest.FreeUnitChgInfo,listMapping6)
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.TaxAmount = src.taxAmt
	
	dest.TaxCode = src.taxCode
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.ChargeAmt = src.chargeAmt
	
	dest.ChargeCode = src.chargeCode
	
	dest.CurrencyID = src.currencyId
	
	mappingList(src.taxList,dest.Tax,listMapping8)
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.AccmBeginDate=formatDate(src.accmBeginDate, Constant4Model.DATE_FORMAT)
	
	dest.AccmEndDate=formatDate(src.accmEndDate, Constant4Model.DATE_FORMAT)
	
	dest.AcctKey = src.acctKey
	
	dest.CreditInstID = src.creditInstId
	
	dest.CreditLimitType = src.creditLimitType
	
	dest.CurrencyID = src.currencyId
	
	dest.CurrentAmt = src.currentAmt
	
	dest.OriginLimitAmt = src.originLimitAmt
	
	dest.PaidAmt = src.paidAmt
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.AccmBeginDate=formatDate(src.accmBeginDate, Constant4Model.DATE_FORMAT)
	
	dest.AccmEndDate=formatDate(src.accmEndDate, Constant4Model.DATE_FORMAT)
	
	dest.CurrencyID = src.currencyId
	
	dest.CurrentAmt = src.currentAmt
	
	dest.LimitCategory = src.limitCategory
	
	dest.LimitInstID = src.limitInstId
	
	dest.LimitOwnerKey = src.limitOwnerKey
	
	dest.LimitOwnerType = src.limitOwnerType
	
	dest.LimitType = src.limitType
	
	dest.OriginLimitAmt = src.originLimitAmt
	
	dest.PaidAmt = src.paidAmt
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	def destMidVar1 = dest.OfferingKey

	def srcMidVar1 = src.offeringKey

	srcMidVar1._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

	destMidVar1.OfferingID = srcMidVar1.oId

	destMidVar1.OfferingCode = srcMidVar1.oCode

	destMidVar1.PurchaseSeq = srcMidVar1.pSeq

	dest.TotalRentAmt = src.totalRentAmt
	
	dest.CurrencyID = src.currencyID
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.BalanceSufficientFlag = src.balanceSufficientFlag
	
	mappingList(src.acctBalanceChangeList,dest.AcctBalanceChangeList,listMapping3)
	
	mappingList(src.freeUnitChangeList,dest.FreeUnitChangeList,listMapping5)
	
	mappingList(src.chargeAmountInfos,dest.ChargeAmountList,listMapping7)
	
	def srcMidVar = src.creditLimitChangeList[0]
	
	mappingList(srcMidVar.creditLimitChanges,dest.CreditLimitChangeList,listMapping9)
	
	mappingList(src.creditLimitChangeList,dest.CreditLimitChangeList,listMapping10)
	
	mappingList(src.spendingLimitChangeList,dest.ConsumptionLimitChangeList,listMapping11)
	
	mappingList(src.addOfferingRentList,dest.AddOfferingRentList,listMapping12)

	mappingList(src.delOfferingRentList,dest.DelOfferingRentList,listMapping12)
}

def destMidVar = destReturn.FeeQuotationResultMsg

listMapping0.call(srcReturn.resultHeader,destMidVar.ResultHeader)

listMapping2.call(srcReturn.feeQuotationResultInfo,destMidVar.FeeQuotationResult)
