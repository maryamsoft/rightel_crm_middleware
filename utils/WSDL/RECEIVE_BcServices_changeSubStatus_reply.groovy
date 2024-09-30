def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar = destReturn.ChangeSubStatusResultMsg.ChangeSubStatusResult

def srcMidVar = srcReturn.changeSubStatusResultInfo

destMidVar.NewStatus = srcMidVar.newStatus

destMidVar.OldStatus = srcMidVar.oldStatus

def destMidVar0 = destReturn.ChangeSubStatusResultMsg.ResultHeader

def srcMidVar0 = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar0.msgLanguageCode

mappingList(srcMidVar0.simpleProperty,destMidVar0.AdditionalProperty,listMapping0)

destMidVar0.ResultCode = srcMidVar0.resultCode

destMidVar0.ResultDesc = srcMidVar0.resultDesc

destMidVar0.Version = srcMidVar0.version

destMidVar0.MessageSeq = srcMidVar0.messageSeq