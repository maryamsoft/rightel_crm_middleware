def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.AccmType = src.accmTypeCode
	
	dest.AccmTypeName = src.accmTypeName
	
	dest.Amount = src.amount
	
	dest.BeginDate=formatDate(src.beginDate, "yyyyMMddHHmmss")
	
	dest.CurrencyID = src.currencyID
	
	dest.EndDate=formatDate(src.endDate, "yyyyMMddHHmmss")
	
	dest.MeasureID = src.measureID
	
	dest.UnitType = src.unitType
	
	dest.DimensionValue = src.dimensionValue
	
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar = destReturn.QueryAccumulationUsageResultMsg.QueryAccumulationUsageResult

mappingList(srcReturn.accmUsageList,destMidVar.AccmUsageList,listMapping0)

def destMidVar0 = destReturn.QueryAccumulationUsageResultMsg.ResultHeader

def srcMidVar = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar.msgLanguageCode

destMidVar0.ResultCode = srcMidVar.resultCode

destMidVar0.ResultDesc = srcMidVar.resultDesc

destMidVar0.Version = srcMidVar.version

destMidVar0.MessageSeq = srcMidVar.messageSeq

mappingList(srcMidVar.simpleProperty,destMidVar0.AdditionalProperty,listMapping1)
