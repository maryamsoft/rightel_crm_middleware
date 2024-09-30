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

	mappingList(src.onlyModifyOfferingInfos,dest.ModifyOffering,listMapping3)
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expTime, Constant4Model.DATE_FORMAT)
	
	def srcMidVar8 = src.instPropertyInfo
	
	mappingList(srcMidVar8.subProps,dest.SubPropInst,listMapping7)
	
	dest.Value = srcMidVar8.value
	
	dest.PropCode = srcMidVar8.propCode
	
	dest.PropType = srcMidVar8.complexFlag
	
}

def listMapping6
listMapping6 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.trialStartTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.trialEndTime, Constant4Model.DATE_FORMAT)
	
	mappingList(src.offerInstPropList,dest.OfferingInstProperty,listMapping5)
	
	def destMidVar9 = dest.OfferingKey
	
	def srcMidVar9 = src.offeringKeyInfo
  srcMidVar9._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar9.OfferingID = srcMidVar9.oId
	
  destMidVar9.OfferingCode = srcMidVar9.oCode
  
	destMidVar9.PurchaseSeq = srcMidVar9.pSeq
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	mappingList(src.addOfferingList,dest.AddOffering,listMapping6)
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expTime, Constant4Model.DATE_FORMAT)
	
	def srcMidVar10 = src.instPropertyInfo
	
	mappingList(srcMidVar10.subProps,dest.SubPropInst,listMapping10)
	
	dest.Value = srcMidVar10.value
	
	dest.PropCode = srcMidVar10.propCode
	
	dest.PropType = srcMidVar10.complexFlag
	
}

def listMapping12
listMapping12 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.trialStartTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.trialEndTime, Constant4Model.DATE_FORMAT)
	
	mappingList(src.offerInstPropList,dest.OfferingInstProperty,listMapping11)
	
	def destMidVar11 = dest.OfferingKey
	
	def srcMidVar11 = src.offeringKeyInfo
  srcMidVar11._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar11.OfferingID = srcMidVar11.oId
	
  destMidVar11.OfferingCode = srcMidVar11.oCode
  
	destMidVar11.PurchaseSeq = srcMidVar11.pSeq
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

    listMapping12.call(src.newPrimaryOffering,dest.NewPrimaryOffering)
	
}

def destMidVar = destReturn.ChangeGroupOfferingResultMsg

listMapping0.call(srcReturn.resultHeader,destMidVar.ResultHeader)

listMapping2.call(srcReturn.resultBody,destMidVar.ChangeGroupOfferingResult)

listMapping8.call(srcReturn.resultBody,destMidVar.ChangeGroupOfferingResult)

listMapping9.call(srcReturn.resultBody,destMidVar.ChangeGroupOfferingResult)
