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
   src,dest ->
 
  def destMidVar0 = dest.OldOfferingKey
	
	def srcMidVar0 = src.oldObjKey
	
  srcMidVar0._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar0.OfferingID = srcMidVar0.oId
	
	destMidVar0.OfferingCode = srcMidVar0.oCode
	
	destMidVar0.PurchaseSeq = srcMidVar0.pSeq
}


def listMapping3

listMapping3 = 
{
   src,dest ->
 
  def destMidVar1 = dest.NewOfferingKey
	
	def srcMidVar1 = src.newObjKey
	
  srcMidVar1._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar1.OfferingID = srcMidVar1.oId
	
	destMidVar1.OfferingCode = srcMidVar1.oCode
	
	destMidVar1.PurchaseSeq = srcMidVar1.pSeq
}



def listMapping4

listMapping4 =

{
  src,dest ->
  
  listMapping3.call(src.primaryOffering,dest.PrimaryOffering)
  
  listMapping1.call(src.primaryOffering,dest.PrimaryOffering)
  
}


def listMapping5

listMapping5 = 
{
   src,dest ->
 
  def destMidVar2 = dest.NewOfferingKey
	
	def srcMidVar2 = src.newObjKey
	
  srcMidVar2._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar2.OfferingID = srcMidVar2.oId
	
	destMidVar2.OfferingCode = srcMidVar2.oCode
	
	destMidVar2.PurchaseSeq = srcMidVar2.pSeq
	
  def destMidVar3 = dest.OldOfferingKey
	
	def srcMidVar3 = src.oldObjKey
	
  srcMidVar3._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar3.OfferingID = srcMidVar3.oId
	
	destMidVar3.OfferingCode = srcMidVar3.oCode
	
	destMidVar3.PurchaseSeq = srcMidVar3.pSeq
}

def listMapping8

listMapping8 = 
{
  src,dest  ->

  def destMidVar4 = dest.OfferingKey
    
	def srcMidVar4 = src
	
	srcMidVar4._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar4.OfferingID = srcMidVar4.oId
	
	destMidVar4.OfferingCode = srcMidVar4.oCode
	
	destMidVar4.PurchaseSeq = srcMidVar4.pSeq
	
}

def listMapping10

listMapping10 = 
{
  src,dest  ->

	src._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	dest.OfferingKey.OfferingID = src.oId
	
	dest.OfferingKey.OfferingCode = src.oCode
	
	dest.OfferingKey.PurchaseSeq = src.pSeq
	
}

def listMapping12

listMapping12 = 
{
  src,dest  ->

  def destMidVar6 = dest.OfferingKey
    
	def srcMidVar6 = src
	
	srcMidVar6._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar6.OfferingID = srcMidVar6.oId
	
	destMidVar6.OfferingCode = srcMidVar6.oCode
	
	destMidVar6.PurchaseSeq = srcMidVar6.pSeq
	
}

def destMidVar = destReturn.ChangeSubOwnershipResultMsg.ResultHeader

def srcMidVar8 = srcReturn.resultHeader

destMidVar.MsgLanguageCode = srcMidVar8.msgLanguageCode

destMidVar.ResultCode = srcMidVar8.resultCode

destMidVar.ResultDesc = srcMidVar8.resultDesc

destMidVar.Version = srcMidVar8.version

destMidVar.MessageSeq = srcMidVar8.messageSeq

mappingList(srcMidVar8.simpleProperty,destMidVar.AdditionalProperty,listMapping0)

def destMidVar7 = destReturn.ChangeSubOwnershipResultMsg

def srcReturn9 = srcReturn.changeSubOwnershipResultInfo.supplementaryOffering

def destMidVar9 = destMidVar7.ChangeSubOwnershipResult.SupplementaryOffering

mappingList(srcReturn9.shiftOfferingList,destMidVar9.ShiftOffering,listMapping5)

mappingList(srcReturn9.addOfferingList,destMidVar9.AddOffering,listMapping10)

mappingList(srcReturn9.delOfferingList,destMidVar9.DelOffering,listMapping10)

mappingList(srcReturn9.remainOfferingList,destMidVar9.RemainOffering,listMapping10)

listMapping3.call(srcReturn.changeSubOwnershipResultInfo.primaryOffering,destMidVar7.ChangeSubOwnershipResult.PrimaryOffering)
  
listMapping1.call(srcReturn.changeSubOwnershipResultInfo.primaryOffering,destMidVar7.ChangeSubOwnershipResult.PrimaryOffering)

def destMidVar10 = destReturn.ChangeSubOwnershipResultMsg.ChangeSubOwnershipResult.SiteInfo

def srcMidVar10 = srcReturn.changeSubOwnershipResultInfo.siteInfo

destMidVar10.PrimarySite = srcMidVar10.primarySite

destMidVar10.SecondarySite = srcMidVar10.secondarySite
