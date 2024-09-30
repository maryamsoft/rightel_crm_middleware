import com.huawei.ngcbs.bm.common.common.Constant4Model;

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping1

listMapping1= 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.TopGroupCode = src.topGroupCode
	
	dest.ParentGroupCode = src.parentGroupCode
	
	dest.SubGroupKey = src.subGroupKey
	
	dest.SubGroupCode = src.subGroupCode
	
	dest.SubGroupType = src.subGroupType
	
	dest.PrimaryIdentity = src.primaryIdentity
	
	dest.MemberTypeCode = src.memberTypeCode
	
	dest.MemberShortNo = src.memberShortNo
	
	dest.MemberStatus = src.memberStatus
	
	dest.SubscriberStatus = src.subscriberStatus
	
	mappingList(src.memberPropertyList,dest.MemberProperty,listMapping1)
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar0 = destReturn.QueryGroupMemberBasicInfoResultMsg.ResultHeader

def srcMidVar = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar.msgLanguageCode

destMidVar0.ResultCode = srcMidVar.resultCode

destMidVar0.ResultDesc = srcMidVar.resultDesc

mappingList(srcMidVar.simpleProperty,destMidVar0.AdditionalProperty,listMapping2)

destMidVar0.Version = srcMidVar.version

destMidVar0.MessageSeq = srcMidVar.messageSeq

def destMidVar1 = destReturn.QueryGroupMemberBasicInfoResultMsg.QueryGroupMemberBasicInfoResult
def srcMidVar1 = srcReturn.queryGroupMemberListResultInfo

destMidVar1.EffectiveTime = formatDate(srcMidVar1.effectiveTime,Constant4Model.DATE_FORMAT)

destMidVar1.ExpirationTime = formatDate(srcMidVar1.expirationTime,Constant4Model.DATE_FORMAT)

listMapping0.call(srcMidVar1,destMidVar1)
