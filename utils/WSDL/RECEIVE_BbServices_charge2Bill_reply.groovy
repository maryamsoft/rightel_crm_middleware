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

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.Charge2BillSerialNo = src.charge2BillSerialNo
	
}

def destMidVar = destReturn.Charge2BillResultMsg

listMapping0.call(srcReturn.resultHeader,destMidVar.ResultHeader)

listMapping2.call(srcReturn.charge2BillResultInfo,destMidVar.Charge2BillResult)
