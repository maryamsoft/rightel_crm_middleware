import com.huawei.ngcbs.bm.common.common.Constant4Model

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.BalanceID = src.balanceId
	
	dest.BalanceType = src.balanceType
	
	dest.BalanceTypeName = src.balanceTypeName
	
	dest.CurrencyID = src.currencyId
	
	dest.NewBalanceAmt = src.newBalanceAmt
	
	dest.OldBalanceAmt = src.oldBalanceAmt
	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.AcctKey = src.acctKey
	
	mappingList(src.balanceChgInfoList,dest.BalanceChgInfo,listMapping1)
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.AccmBeginDate=formatDate(src.accmBeginDate,Constant4Model.DATE_FORMAT)
	
	dest.AccmEndDate=formatDate(src.accmEndDate,Constant4Model.DATE_FORMAT)
	
	dest.AcctKey = src.acctKey
	
	dest.CreditInstID = src.creditInstId
	
	dest.CreditLimitType = src.creditLimitType
	
	dest.CurrencyID = src.currencyId
	
	dest.CurrentAmt = src.currentAmt
	
	dest.OriginLimitAmt = src.originLimitAmt
	
	dest.PaidAmt = src.paidAmt
	
}

def listMapping4

listMapping4 = 
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

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.OwnerKey = src.ownerKey
	
	dest.OwnerType = src.ownerType
	
	mappingList(src.freeUnitChgInfoList,dest.FreeUnitChgInfo,listMapping4)
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def srcMidVar = srcReturn.feeDeductionResultInfo

def destMidVar = destReturn.FeeDeductionResultMsg.FeeDeductionResult

mappingList(srcMidVar.acctBalanceChangeInfoList,destMidVar.AcctBalanceChangeList,listMapping0)

mappingList(srcMidVar.creditLmtChangeList,destMidVar.CreditLimitChangeList,listMapping2)

destMidVar.DeductSerialNo = srcMidVar.deductSerialNo

mappingList(srcMidVar.freeUnitChangeList,destMidVar.FreeUnitChangeList,listMapping3)

def destMidVar0 = destReturn.FeeDeductionResultMsg.ResultHeader

def srcMidVar0 = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar0.msgLanguageCode

destMidVar0.ResultCode = srcMidVar0.resultCode

destMidVar0.ResultDesc = srcMidVar0.resultDesc

mappingList(srcMidVar0.simpleProperty,destMidVar0.AdditionalProperty,listMapping5)

destMidVar0.Version = srcMidVar0.version

destMidVar0.MessageSeq = srcMidVar0.messageSeq
