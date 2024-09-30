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

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expTime, Constant4Model.DATE_FORMAT)
	
	def srcMidVar4 = src.instPropertyInfo
	
	mappingList(srcMidVar4.subProps,dest.SubPropInst,listMapping1)
	
	dest.Value = srcMidVar4.value
	
	dest.PropCode = srcMidVar4.propCode
	
	dest.PropType = srcMidVar4.complexFlag
	
}

def listMapping3
listMapping3 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.trialStartTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.trialEndTime, Constant4Model.DATE_FORMAT)
	
	mappingList(src.offerInstPropList,dest.OfferingInstProperty,listMapping2)
	
	def destMidVar5 = dest.OfferingKey
	
	def srcMidVar5 = src.offeringKeyInfo
  srcMidVar5._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar5.OfferingID = srcMidVar5.oId
  destMidVar5.OfferingCode = srcMidVar5.oCode
	destMidVar5.PurchaseSeq = srcMidVar5.pSeq
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	mappingList(src.offeringInst,dest.OfferingInst,listMapping3)
	
}

def destMidVar = destReturn.CreateAccountResultMsg.ResultHeader

def srcMidVar0 = srcReturn.resultHeader

mappingList(srcMidVar0.simpleProperty,destMidVar.AdditionalProperty,listMapping0)

destMidVar.Version = srcMidVar0.version

destMidVar.MsgLanguageCode = srcMidVar0.msgLanguageCode

destMidVar.ResultCode = srcMidVar0.resultCode

destMidVar.ResultDesc = srcMidVar0.resultDesc

destMidVar.MessageSeq = srcMidVar0.messageSeq

def destMidVar6 = destReturn.CreateAccountResultMsg

listMapping4.call(srcReturn.createAccountResultInfo,destMidVar6.CreateAccountResult)
