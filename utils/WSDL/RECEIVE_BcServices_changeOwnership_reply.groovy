def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar = destReturn.ChangeOwnershipResultMsg.ResultHeader

def srcMidVar8 = srcReturn.resultHeader

destMidVar.MsgLanguageCode = srcMidVar8.msgLanguageCode

destMidVar.ResultCode = srcMidVar8.resultCode

destMidVar.ResultDesc = srcMidVar8.resultDesc

destMidVar.Version = srcMidVar8.version

destMidVar.MessageSeq = srcMidVar8.messageSeq

mappingList(srcMidVar8.simpleProperty,destMidVar.AdditionalProperty,listMapping0)

def destMidVar10 = destReturn.ChangeOwnershipResultMsg.ChangeOwnershipResult

destMidVar10.NewRegCustcode = srcReturn.newRegCustcode

destMidVar10.NewUserCustcode = srcReturn.newUserCustcode
