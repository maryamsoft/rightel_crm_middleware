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

	dest.EffectiveTime=formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expirationTime, Constant4Model.DATE_FORMAT)
	
	mappingList(src.memberProperty,dest.MemberProperty,listMapping2)
	
	dest.MemberShortNo = src.memberShortNo
	
	dest.MemberTypeCode = src.memberTypeCode
	
	dest.SubGroupCode = src.subGroupCode
	
	dest.SubGroupKey = src.subGroupKey
	
	dest.SubGroupType = src.subGroupType

	dest.SubGroupName = src.subGroupName

	dest.Status = src.status

	dest.StatusDetail = src.statusDetail
}

def srcMidVar = srcReturn.resultHeader

def destMidVar = destReturn.QueryGroupListBySubscriberResultMsg.ResultHeader

mappingList(srcMidVar.simpleProperty,destMidVar.AdditionalProperty,listMapping0)

destMidVar.MsgLanguageCode = srcMidVar.msgLanguageCode

destMidVar.ResultCode = srcMidVar.resultCode

destMidVar.ResultDesc = srcMidVar.resultDesc

destMidVar.Version = srcMidVar.version

destMidVar.MessageSeq = srcMidVar.messageSeq

def destMidVar0 = destReturn.QueryGroupListBySubscriberResultMsg.QueryGroupListBySubscriberResult

mappingList(srcReturn.groupList,destMidVar0.GroupList,listMapping1)
