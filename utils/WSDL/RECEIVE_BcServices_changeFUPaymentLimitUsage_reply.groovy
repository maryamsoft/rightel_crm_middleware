def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping1

listMapping1 =
		{
			src,dest  ->

				dest.Code = src.code

				dest.Value = src.value

		}

def srcMidVar = srcReturn.resultInfo

def destMidVar = destReturn.ChangeFUPaymentLimitUsageResultMsg.ChangeFUPaymentLimitUsageResult

destMidVar.FUPayLimitID = srcMidVar.fuPayLimitID

destMidVar.CycleBeginDate = srcMidVar.cycleBeginDate

destMidVar.CycleEndDate = srcMidVar.cycleEndDate

destMidVar.CurrAmount = srcMidVar.currAmount

destMidVar.OldAmount = srcMidVar.oldAmount

def destMidVar0 = destReturn.ChangeFUPaymentLimitUsageResultMsg.ResultHeader

def srcMidVar0 = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar0.msgLanguageCode

destMidVar0.ResultCode = srcMidVar0.resultCode

destMidVar0.ResultDesc = srcMidVar0.resultDesc

destMidVar0.Version = srcMidVar0.version

destMidVar0.MessageSeq = srcMidVar0.messageSeq

mappingList(srcMidVar0.simpleProperty,destMidVar0.AdditionalProperty,listMapping1)
