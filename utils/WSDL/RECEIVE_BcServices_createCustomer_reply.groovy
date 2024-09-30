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

def destMidVar = destReturn.CreateCustomerResultMsg.ResultHeader

def srcMidVar = srcReturn.resultHeader

destMidVar.MsgLanguageCode = srcMidVar.msgLanguageCode

destMidVar.ResultCode = srcMidVar.resultCode

destMidVar.ResultDesc = srcMidVar.resultDesc

destMidVar.Version = srcMidVar.version

destMidVar.MessageSeq = srcMidVar.messageSeq

mappingList(srcMidVar.simpleProperty,destMidVar.AdditionalProperty,listMapping0)

def destMidVar0 = destReturn.CreateCustomerResultMsg.CreateCustomerResult

mappingList(srcReturn.acctProperties,destMidVar0.Property,listMapping1)

def destMidVar1 = destReturn.CreateCustomerResultMsg.CreateCustomerResult.SiteInfo

def srcMidVar1 = srcReturn.createCustomerResultInfo.siteInfo

destMidVar1.PrimarySite = srcMidVar1.primarySite

destMidVar1.SecondarySite = srcMidVar1.secondarySite


