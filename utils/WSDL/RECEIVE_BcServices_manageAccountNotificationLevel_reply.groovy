def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar0 = destReturn.ManageAccountNotificationLevelResultMsg.ResultHeader

destMidVar0.MsgLanguageCode = srcReturn.msgLanguageCode

mappingList(srcReturn.simpleProperty,destMidVar0.AdditionalProperty,listMapping0)

destMidVar0.ResultCode = srcReturn.resultCode

destMidVar0.ResultDesc = srcReturn.resultDesc

destMidVar0.Version = srcReturn.version

destMidVar0.MessageSeq = srcReturn.messageSeq
