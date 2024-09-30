import com.huawei.ngcbs.bm.common.common.Constant4Model

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar = destReturn.SubActivationResultMsg.SubActivationResult

def srcMidVar = srcReturn.subActivationResultInfo

destMidVar.ActiveTime = formatDate(srcMidVar.activeTime,Constant4Model.DATE_FORMAT)

def destMidVar0 = destReturn.SubActivationResultMsg.ResultHeader

def srcMidVar0 = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar0.msgLanguageCode

mappingList(srcMidVar0.simpleProperty,destMidVar0.AdditionalProperty,listMapping1)

destMidVar0.ResultCode = srcMidVar0.resultCode

destMidVar0.ResultDesc = srcMidVar0.resultDesc

destMidVar0.Version = srcMidVar0.version

destMidVar0.MessageSeq = srcMidVar0.messageSeq
