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

	dest.MsgLanguageCode = src.msgLanguageCode
	
	dest.ResultCode = src.resultCode
	
	dest.ResultDesc = src.resultDesc
	
	dest.Version = src.version

	dest.MessageSeq = src.messageSeq
	
	mappingList(src.simpleProperty,dest.AdditionalProperty,listMapping1)
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.OfferingID = src.oId
	
	dest.OfferingCode = src.oCode
	
	dest.PurchaseSeq = src.pSeq
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->
 
  def oKeyExt = src.offeringKey
  
  oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

	listMapping4.call(oKeyExt,dest.OfferingKey)
	
	dest.NewEffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.NewExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	mappingList(src.modifyOfferingInfos,dest.ModifyOffering,listMapping3)
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expTime, Constant4Model.DATE_FORMAT)
	
	def srcMidVar4 = src.instPropertyInfo
	
	mappingList(srcMidVar4.subProps,dest.SubPropInst,listMapping5)
	
	dest.Value = srcMidVar4.value
	
	dest.PropCode = srcMidVar4.propCode
	
	dest.PropType = srcMidVar4.complexFlag
	
}

def listMapping7
listMapping7 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.trialStartTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.trialEndTime, Constant4Model.DATE_FORMAT)
	
	mappingList(src.offerInstPropList,dest.OfferingInstProperty,listMapping6)
	
	def destMidVar5 = dest.OfferingKey
	
	def srcMidVar5 = src.offeringKeyInfo
  srcMidVar5._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar5.OfferingID = srcMidVar5.oId
	
  destMidVar5.OfferingCode = srcMidVar5.oCode
  
	destMidVar5.PurchaseSeq = srcMidVar5.pSeq
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	mappingList(src.addOfferingList,dest.AddOffering,listMapping7)
	
}

def destMidVar = destReturn.ChangeGroupMemberOfferingResultMsg

listMapping0.call(srcReturn.resultHeader,destMidVar.ResultHeader)

listMapping2.call(srcReturn.resultBody,destMidVar.ChangeGroupMemberOfferingResult)

listMapping8.call(srcReturn.resultBody,destMidVar.ChangeGroupMemberOfferingResult)
