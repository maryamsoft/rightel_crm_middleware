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

	def destMidVar0 = dest.AdditionalProperty[0]
	
	def srcMidVar = src.simpleProperty[0]
	
	destMidVar0.Code = srcMidVar.code
	
	destMidVar0.Value = srcMidVar.value
	
	dest.MsgLanguageCode = src.msgLanguageCode
	
	dest.ResultCode = src.resultCode
	
	dest.ResultDesc = src.resultDesc
	
	dest.Version = src.version

	dest.MessageSeq = src.messageSeq
	
	mappingList(src.simpleProperty,dest.AdditionalProperty,listMapping1)
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	def destMidVar2 = dest.OfferingOwner
	
	def srcMidVar0 = src.owner
	
	destMidVar2.OwnerKey = srcMidVar0.ownerKey
	
	destMidVar2.OwnerType = srcMidVar0.ownerType
	
	dest.NewEffectiveTime=formatDate(src.modifyOfferingInstInfo.effDate,Constant4Model.DATE_FORMAT)
	
	dest.NewExpirationTime=formatDate(src.modifyOfferingInstInfo.expDate,Constant4Model.DATE_FORMAT)
	
	def destMidVar3 = dest.OfferingKey
	
	def srcMidVar1 = src.modifyOfferingInstInfo.offeringKey
	
	srcMidVar1._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar3.OfferingID = srcMidVar1.oId
	
	destMidVar3.OfferingCode = srcMidVar1.oCode
	
	destMidVar3.PurchaseSeq = srcMidVar1.pSeq
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	def destMidVar4 = dest.OfferingOwner
	
	def srcMidVar5 = src.owner
	
	destMidVar4.OwnerKey = srcMidVar5.ownerKey
	
	destMidVar4.OwnerType = srcMidVar5.ownerType
	
	dest.NewEffectiveTime=formatDate(src.modifyOfferingInstInfo.effDate,Constant4Model.DATE_FORMAT)
	
	dest.NewExpirationTime=formatDate(src.modifyOfferingInstInfo.expDate,Constant4Model.DATE_FORMAT)
	
	def destMidVar6 = dest.OfferingKey
	
	def srcMidVar7 = src.modifyOfferingInstInfo.offeringKey
	
	srcMidVar7._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar6.OfferingID = srcMidVar7.oId
	
	destMidVar6.OfferingCode = srcMidVar7.oCode
	
	destMidVar6.PurchaseSeq = srcMidVar7.pSeq
	
}

def listMapping4

listMapping4 = 
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
	
	mappingList(srcMidVar8.subProps,dest.SubPropInst,listMapping4)
	
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

def destMidVar = destReturn.ChangeSubPaymentModeResultMsg

listMapping0.call(srcReturn.resultHeader,destMidVar.ResultHeader)

def destMidVar1 = destReturn.ChangeSubPaymentModeResultMsg.ChangeSubPaymentModeResult

mappingList(srcReturn.modifyOfferings,destMidVar1.ModifyOffering,listMapping2)

mappingList(srcReturn.addOffering,destMidVar1.AddOffering,listMapping3)

listMapping6.call(srcReturn.newPrimaryOffering,destMidVar1.NewPrimaryOffering)
