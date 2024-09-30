import com.huawei.ngcbs.bm.common.common.Constant4Model;

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expTime, Constant4Model.DATE_FORMAT)
	
	def srcMidVar4 = src.instPropertyInfo
	
	mappingList(srcMidVar4.subProps,dest.SubPropInst,listMapping3)
	
	dest.Value = srcMidVar4.value
	
	dest.PropCode = srcMidVar4.propCode
	
	dest.PropType = srcMidVar4.complexFlag
	
}


def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.trialStartTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.trialEndTime, Constant4Model.DATE_FORMAT)
	
	mappingList(src.offerInstPropList,dest.OfferingInstProperty,listMapping4)
	
	def destMidVar5 = dest.OfferingKey
	
	def srcMidVar5 = src.offeringKeyInfo
    srcMidVar5._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar5.OfferingID = srcMidVar5.oId
  destMidVar5.OfferingCode = srcMidVar5.oCode
	destMidVar5.PurchaseSeq = srcMidVar5.pSeq
	
}

def destMidVar = destReturn.CreateGroupResultMsg.CreateGroupResult

def srcMidVar = srcReturn.createGroupResultInfo

destMidVar.EffectiveTime = formatDate(srcMidVar.effectiveTime,Constant4Model.DATE_FORMAT)

mappingList(srcMidVar.offeringInstBasicInfoList,destMidVar.OfferingInst,listMapping5)

def destMidVar0 = destReturn.CreateGroupResultMsg.ResultHeader

def srcMidVar0 = srcReturn.resultHeader

destMidVar0.MsgLanguageCode = srcMidVar0.msgLanguageCode

mappingList(srcMidVar0.simpleProperty,destMidVar0.AdditionalProperty,listMapping1)

destMidVar0.ResultCode = srcMidVar0.resultCode

destMidVar0.ResultDesc = srcMidVar0.resultDesc

destMidVar0.Version = srcMidVar0.version

destMidVar0.MessageSeq = srcMidVar0.messageSeq
