def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	
}

def destMidVar = destReturn.ChangeSubInfoResultMsg.ResultHeader.AdditionalProperty[0]

def srcMidVar = srcReturn.simpleProperty[0]

destMidVar.Code = srcMidVar.code

destMidVar.Value = srcMidVar.value

def destMidVar0 = destReturn.ChangeSubInfoResultMsg.ResultHeader

destMidVar0.MsgLanguageCode = srcReturn.msgLanguageCode

destMidVar0.ResultCode = srcReturn.resultCode

destMidVar0.ResultDesc = srcReturn.resultDesc

destMidVar0.Version = srcReturn.version

destMidVar0.MessageSeq = srcReturn.messageSeq

mappingList(srcReturn.simpleProperty,destMidVar0.AdditionalProperty,listMapping0)
