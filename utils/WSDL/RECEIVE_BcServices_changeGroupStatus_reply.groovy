def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar = destReturn.ChangeGroupStatusResultMsg.ResultHeader

mappingList(srcReturn.simpleProperty,destMidVar.AdditionalProperty,listMapping0)

destMidVar.MsgLanguageCode = srcReturn.msgLanguageCode

destMidVar.ResultCode = srcReturn.resultCode

destMidVar.ResultDesc = srcReturn.resultDesc

destMidVar.Version = srcReturn.version

destMidVar.MessageSeq = srcReturn.messageSeq
