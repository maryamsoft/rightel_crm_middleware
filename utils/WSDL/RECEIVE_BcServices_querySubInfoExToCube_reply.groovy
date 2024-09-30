def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def srcMidVar = srcReturn.querySubInfoExToCubeResultInfo.additionalProperty

def destMidVar = destReturn.QuerySubInfoExToCubeResultMsg.QuerySubInfoExToCubeResult.Subscriber

mappingList(srcMidVar.simplePropertyList,destMidVar.AdditionalProperty,listMapping0)

def srcMidVar0 = srcReturn.querySubInfoExToCubeResultInfo

destMidVar.BalanceAmount = srcMidVar0.balanceAmount

destMidVar.BlacklistStatus = srcMidVar0.blacklistStatus

destMidVar.ManagementSatus = srcMidVar0.managementSatus

destMidVar.LifeCycleStatus = srcMidVar0.lifeCycleStatus

destMidVar.PaymentType = srcMidVar0.paymentType

destMidVar.PrimaryOfferKey = srcMidVar0.primaryOfferKey

destMidVar.PrimaryOfferName = srcMidVar0.primaryOfferName

destMidVar.ServiceNum = srcMidVar0.serviceNum

def destMidVar1 = destMidVar.PaymentLimitUsage

def srcMidVar2 = srcMidVar0.paymentLimitUsage

destMidVar1.Amount = srcMidVar2.amount

destMidVar1.LimitType = srcMidVar2.limitType

destMidVar1.UsedAmount = srcMidVar2.usageAmount

def destMidVar0 = destReturn.QuerySubInfoExToCubeResultMsg.ResultHeader

def srcMidVar1 = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar1.msgLanguageCode

destMidVar0.ResultCode = srcMidVar1.resultCode

destMidVar0.ResultDesc = srcMidVar1.resultDesc

mappingList(srcMidVar1.simpleProperty,destMidVar0.AdditionalProperty,listMapping1)

destMidVar0.Version = srcMidVar1.version

destMidVar0.MessageSeq = srcMidVar1.messageSeq


