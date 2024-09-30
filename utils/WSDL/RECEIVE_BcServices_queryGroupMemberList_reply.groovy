import com.huawei.ngcbs.bm.common.common.Constant4Model;

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.PrimaryIdentity = src.primaryIdentity
	
	dest.MemberShortNo = src.shortNo
	
	mappingList(src.simpleProperty,dest.MemberProperty,listMapping2)
	
	dest.MemberTypeCode = src.typeCode

	dest.EffectiveTime = formatDate(src.effDate, Constant4Model.DATE_FORMAT)

	dest.ExpirationTime = formatDate(src.expDate, Constant4Model.DATE_FORMAT)

	dest.MemberStatus = src.status

	dest.MemberStatusDetail = src.statusDetail
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.BeginRowNum = src.beginRowNum
	
	dest.FetchRowNum = src.fetchRowNum
	
	mappingList(src.groupMemberList,dest.GroupMemberList,listMapping1)
	
	dest.TotalNumber = src.totalNumber
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar = destReturn.QueryGroupMemberListResultMsg

listMapping0.call(srcReturn.queryGroupMemberListResultInfo,destMidVar.QueryGroupMemberListResult)

def destMidVar0 = destReturn.QueryGroupMemberListResultMsg.ResultHeader

def srcMidVar = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar.msgLanguageCode

destMidVar0.ResultCode = srcMidVar.resultCode

destMidVar0.ResultDesc = srcMidVar.resultDesc

destMidVar0.MessageSeq = srcMidVar.messageSeq

mappingList(srcMidVar.simpleProperty,destMidVar0.AdditionalProperty,listMapping3)

destMidVar0.Version = srcMidVar.version
