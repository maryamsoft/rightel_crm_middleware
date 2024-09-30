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

	def destMidVar = dest.ResultHeader
	
	destMidVar.MsgLanguageCode = src.msgLanguageCode
	
	destMidVar.ResultCode = src.resultCode
	
	destMidVar.ResultDesc = src.resultDesc
	
	destMidVar.Version = src.version

	destMidVar.MessageSeq = src.messageSeq
	
	mappingList(src.simpleProperty,destMidVar.AdditionalProperty,listMapping1)
	
}

listMapping0.call(srcReturn,destReturn.ChangeCustInfoResultMsg)
