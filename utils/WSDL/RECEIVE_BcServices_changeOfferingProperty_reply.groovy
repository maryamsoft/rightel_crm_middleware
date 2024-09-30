def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar = destReturn.ChangeOfferingPropertyResultMsg.ResultHeader

mappingList(srcReturn.simpleProperty,destMidVar.AdditionalProperty,listMapping0)

destMidVar.Version = srcReturn.version

destMidVar.ResultDesc = srcReturn.resultDesc

destMidVar.ResultCode = srcReturn.resultCode

destMidVar.MsgLanguageCode = srcReturn.msgLanguageCode

destMidVar.MessageSeq = srcReturn.messageSeq
