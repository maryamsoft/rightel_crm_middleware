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

	dest.ResultCode = src.resultCode
	
	dest.MsgLanguageCode = src.msgLanguageCode
	
	dest.ResultDesc = src.resultDesc
	
	dest.Version = src.version

	dest.MessageSeq = src.messageSeq
	
	mappingList(src.simpleProperty,dest.AdditionalProperty,listMapping1)
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.CreditInstID = src.creditValueInstId
	
	def srcMidVar = src.creditLimitInfo.valueInfo
	
	dest.Amount = srcMidVar.amount
	
	dest.LimitClass = srcMidVar.category
	
	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpireTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
}

def destMidVar = destReturn.ChangeAcctCreditLimitResultMsg

listMapping0.call(srcReturn.resultHeader,destMidVar.ResultHeader)

def destMidVar0 = destReturn.ChangeAcctCreditLimitResultMsg.ChangeAcctCreditLimitResult

mappingList(srcReturn.changeCreditLimitInfoList,destMidVar0.CreditLimit,listMapping2)
