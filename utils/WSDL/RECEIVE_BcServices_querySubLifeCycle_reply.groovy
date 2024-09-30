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

def listMapping0

listMapping0 = 
{
    src,dest  ->

	mappingList(src.simpleProperty,dest.AdditionalProperty,listMapping1)
	
	dest.MsgLanguageCode = src.msgLanguageCode
	
	dest.ResultCode = src.resultCode
	
	dest.ResultDesc = src.resultDesc
	
	dest.Version = src.version

	dest.MessageSeq = src.messageSeq
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

		dest.StatusExpireTime=formatDate(src.statusExpireTime, Constant4Model.DATE_FORMAT)
	
	dest.StatusIndex = src.statusIndex
	
	dest.StatusName = src.statusName
	
}

def destMidVar = destReturn.QuerySubLifeCycleResultMsg

listMapping0.call(srcReturn.resultHeader,destMidVar.ResultHeader)

def destMidVar0 = destReturn.QuerySubLifeCycleResultMsg.QuerySubLifeCycleResult

def srcMidVar = srcReturn.querySubLifeCycleResultInfo

destMidVar0.CurrentStatusIndex = srcMidVar.currentStatusIndex

destMidVar0.FraudTimes = srcMidVar.fraudTimes

destMidVar0.RBlacklistStatus = srcMidVar.rBlacklistStatus

destMidVar0.StatusDetail = srcMidVar.statusDetail

mappingList(srcMidVar.lifeCycleStatusList,destMidVar0.LifeCycleStatus,listMapping2)
