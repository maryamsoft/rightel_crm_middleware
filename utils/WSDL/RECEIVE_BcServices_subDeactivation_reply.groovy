import com.huawei.ngcbs.bm.common.common.Constant4Model

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping2

listMapping2 = 
{
    src,dest  ->

	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	def destMidVar0 = dest.AdditionalProperty[0]
	
	def srcMidVar = src.simpleProperty[0]
	
	destMidVar0.Code = srcMidVar.code
	
	destMidVar0.Value = srcMidVar.value
	
	dest.MsgLanguageCode = src.msgLanguageCode
	
	dest.ResultCode = src.resultCode
	
	dest.ResultDesc = src.resultDesc
	
	dest.Version = src.version

	dest.MessageSeq = src.messageSeq
	
	mappingList(src.simpleProperty,dest.AdditionalProperty,listMapping2)
	
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.Amount = src.amount
	
	dest.CurrencyID = src.currencyId
	
	dest.BalanceType = src.balanceType
	
	dest.BalanceInstanceID = src.acctBalanceId
	
	dest.EffectiveTime = formatDate(src.effTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpireTime = formatDate(src.expTime, Constant4Model.DATE_FORMAT)
	
}

def destMidVar = destReturn.SubDeactivationResultMsg

listMapping0.call(srcReturn.resultHeader,destMidVar.ResultHeader)

def destMidVar1 = destReturn.SubDeactivationResultMsg.SubDeactivationResult.AcctBalance

def srcMidVar0 = srcReturn.acctBalance

destMidVar1.AcctKey = srcMidVar0.acctKey

mappingList(srcMidVar0.amountDataList,destMidVar1.AmountList,listMapping1)
