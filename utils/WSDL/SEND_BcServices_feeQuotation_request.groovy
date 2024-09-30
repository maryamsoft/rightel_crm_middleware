import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("BMQueryService","feeQuotation")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.query.feequotation.io.FeeQuotationRequest"

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.interMode = src.AccessMode
	
	def srcMidVar0 = src.AccessSecurity
	
	dest.loginSystem = srcMidVar0.LoginSystemCode
	
	dest.password = srcMidVar0.Password
	
	dest.remoteAddress = srcMidVar0.RemoteIP
	
	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	dest.businessCode = src.BusinessCode
	
	dest.messageSeq = src.MessageSeq
	
	dest.msgLanguageCode = src.MsgLanguageCode
	
	def srcMidVar1 = src.OperatorInfo
	
	dest.channelId = srcMidVar1.ChannelID
	
	dest.operatorId = srcMidVar1.OperatorID
	
	def srcMidVar2 = src.OwnershipInfo
	
	dest.beId = srcMidVar2.BEID
	
	dest.brId = srcMidVar2.BRID
	
	def srcMidVar3 = src.TimeFormat
	
	dest.timeType = srcMidVar3.TimeType
	
	dest.timeZoneId = srcMidVar3.TimeZoneID
	
	dest.version = src.Version
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.accoutCode = src.AccountCode
	
	dest.accoutKey = src.AccountKey
	
	dest.payType = src.PayType
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.customerCode = src.CustomerCode
	
	dest.customerKey = src.CustomerKey
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.groupCode = src.SubGroupCode
	
	dest.groupKey = src.SubGroupKey
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	listMapping4.call(src.AcctAccessCode,dest.acctAccessCode)
	
	listMapping5.call(src.CustAccessCode,dest.custAccessCode)
	
	listMapping6.call(src.SubAccessCode,dest.subAccessCode)
	
	listMapping7.call(src.SubGroupAccessCode,dest.groupAccessCode)
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.chargeCode = src.ChargeCode
	
	dest.chargeAmt = src.ChargeAmt
	
	dest.currencyId = src.CurrencyID
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.operationCode = src.OperationCode
	
	mappingList(src.OperationProperty,dest.operationProperty,listMapping11)
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	def srcMidVar6 = src.OfferingKey
	
	dest.oId = srcMidVar6.OfferingID
	
	dest.oCode = srcMidVar6.OfferingCode
	 
	dest.pSeq = srcMidVar6.PurchaseSeq
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->
	
	dest.pSeq = src.PurchaseSeq
  
  dest.oCode = src.OfferingCode
	
	dest.oId = src.OfferingID
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

	dest.effDate=parseDate(src.EffectiveTime, Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	def destMidVar4 = dest.property
	
	destMidVar4.propCode = src.PropCode
	
	destMidVar4.complexFlag = src.PropType
	
	destMidVar4.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar4.subProps,listMapping16)
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	dest.effDate=parseDate(src.EffectiveTime, Constant4Model.DATE_FORMAT)
	
	dest.expDate=parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)
	
	def destMidVar6 = dest.property
	
	destMidVar6.propCode = src.PropCode
	
	destMidVar6.complexFlag = src.PropType
	
	destMidVar6.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar6.subProps,listMapping19)
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	def destMidVar5 = dest.productInst
	
	destMidVar5.prodId = src.ProductID
	
	mappingList(src.PInstProperty,dest.properties,listMapping18)
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	def destMidVar2 = dest.offeringInst.offeringKey
	
	destMidVar2.oId = src.OfferingID

	destMidVar2.oCode = src.OfferingCode
	
	def destMidVar3 = dest.offeringInst
	
    listMapping14.call(src.ParentOfferingKey,destMidVar3.parentOfferingKey)
	
	destMidVar3.trialEndTime=parseDate(src.TrialEndTime, Constant4Model.DATE_FORMAT)
	
	destMidVar3.trialStartTime=parseDate(src.TrialStartTime, Constant4Model.DATE_FORMAT)
	
	mappingList(src.OInstProperty,dest.properties,listMapping15)
	
	mappingList(src.ProductInst,dest.productInsts,listMapping17)

	destMidVar2.pSeq = src.PurchaseSeq

	def srcPaidAcct = src.RentPaidAcct

	def rentPaidAcctObj = dest

	rentPaidAcctObj._class = "com.huawei.ngcbs.cm.customer.common.io.CustomizeAddOfferingInstInfo"

	rentPaidAcctObj.rentPaidAcct.primaryIdentity = srcPaidAcct.PrimaryIdentity

	rentPaidAcctObj.rentPaidAcct.accoutKey = srcPaidAcct.AccountKey

	rentPaidAcctObj.rentPaidAcct.accoutCode = srcPaidAcct.AccountCode
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	listMapping3.call(src.ChargeObj,dest.anyAccessCode)
	
	def srcMidVar4 = src.ChargeElement
	
	def destMidVar = dest.feeAmountList
	
	mappingList(srcMidVar4.FeeAmount,destMidVar.feeAmountList,listMapping8)
	
	listMapping10.call(srcMidVar4.OperationFee,dest.operationInfo)
	
	def srcMidVar5 = src.ChargeElement.OfferingFee
	
	def destMidVar0 = dest.delOfferingList
	
	mappingList(srcMidVar5.DelOffering,destMidVar0.delOfferings,listMapping12)
	
	def destMidVar1 = dest.addOfferingList
	
	mappingList(srcMidVar5.AddOffering,destMidVar1.addOfferings,listMapping13)
	
	def destFeeReservationSupport = dest.feeReservationSupport
	
	destFeeReservationSupport.abmOperationType = srcMidVar4.ABMOperationType
	
    destFeeReservationSupport.serviceTransactionId = srcMidVar4.ServiceTransactionID
	
	mappingList(srcMidVar4.AdditionalProperty,dest.simplePropertyList,listMapping11)
}

def srcMidVar = srcArgs0.FeeQuotationRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.FeeQuotationRequest,destArgs1)
