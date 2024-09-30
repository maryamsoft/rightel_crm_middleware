import com.huawei.ngcbs.bm.common.common.Constant4Model

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.RecordID = src.recordID

    dest.RequestSeq = src.requestSeq

    dest.RequestSysCode = src.requestSysCode

    dest.RequestSysIP = src.requestsysip

    dest.InteractMode = src.interactmode

    dest.CustID = src.custid

    dest.OperationCode = src.operationcode

    dest.OperationObjectType = src.operationobjecttype

    dest.OperationObjectCode = src.operationobjectcode

    dest.PrimaryIdentity = src.primaryidentity

    dest.BeginTime = formatDate(src.begintime, Constant4Model.DATE_FORMAT)

    dest.EndTime = formatDate(src.endtime, Constant4Model.DATE_FORMAT)

    dest.Status = src.status

    dest.ResultCode = src.resultcode

    dest.ResultDescription = src.resultdescription

    dest.OperatorID = src.operatorid

    dest.DepartmentID = src.departmentid

    mappingList(src.simpleProperty,dest.AdditionalProperty,listMapping0)
}



def srcMidVar0 = srcReturn.resultHeader

def destMidVar0 = destReturn.QueryInteractLogResultMsg.ResultHeader

mappingList(srcMidVar0.simpleProperty,destMidVar0.AdditionalProperty,listMapping0)

destMidVar0.ResultDesc = srcMidVar0.resultDesc

destMidVar0.ResultCode = srcMidVar0.resultCode

destMidVar0.MsgLanguageCode = srcMidVar0.msgLanguageCode

destMidVar0.Version = srcMidVar0.version

destMidVar0.MessageSeq = srcMidVar0.messageSeq

def destMidVar1 = destReturn.QueryInteractLogResultMsg.QueryInteractLogResult

mappingList(srcReturn.queryInteractLogInfo,destMidVar1.InteractLog,listMapping1)








