def srcReturn = src.payload._return

def destReturn = dest.payload._return

def destMidVar0 = destReturn.BatchChangeRscRelationResultMsg.ResultHeader

def srcMidVar0 = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar0.msgLanguageCode

destMidVar0.ResultCode = srcMidVar0.resultCode

destMidVar0.ResultDesc = srcMidVar0.resultDesc

destMidVar0.Version = srcMidVar0.version

destMidVar0.MessageSeq = srcMidVar0.messageSeq
