import com.huawei.ngcbs.bm.common.common.Constant4Model

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.OfferingID = src.offerId

    dest.OfferingName = src.offeringName
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.FreeVolume = src.freeVolume
	
	def destMidVar0 = dest.Offering
	
	def srcMidVar0 = src.offeringKey
	
	destMidVar0.PurchaseSeq = srcMidVar0.purchaseSeq

	listMapping11.call(src.offeringKey,dest.Offering)

	dest.MeasureUnit = src.measureUnit
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.Amount = src.amount
	
	dest.FreeUnitType = src.freeUnitType

	dest.MeasureUnit = src.measureUnit
}

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.ActualVolume = src.actualVolume
	
	dest.FreeVolume = src.freeVolume
	
	mappingList(src.freeVolumeList,dest.FreeVolumeList,listMapping2)
	
	dest.MeasureUnit = src.measureUnit
	
	dest.RatingVolume = src.ratingVolume
	
	mappingList(src.freeUnits,dest.FreeUnitList,listMapping10)
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.CalledHomeAreaNumber = src.calledHomeAreaNumber
	
	dest.CalledHomeCountryCode = src.calledHomeCountryCode
	
	dest.CalledHomeOperatorNumber = src.calledHomeOperatorNumber
	
	dest.CalledRoamAreaNumber = src.calledRoamAreaNumber
	
	dest.CalledRoamCountryCode = src.calledRoamCountryCode
	
	dest.CalledRoamOperatorNumber = src.calledRoamOperatorNumber
	
	dest.CallingHomeAreaNumber = src.callingHomeAreaNumber
	
	dest.CallingHomeCountryCode = src.callingHomeCountryCode
	
	dest.CallingHomeOperatorNumber = src.callingHomeOperatorNumber
	
	dest.CallingRoamAreaNumber = src.callingRoamAreaNumber
	
	dest.CallingRoamCountryCode = src.callingRoamCountryCode
	
	dest.CallingRoamOperatorNumber = src.callingRoamOperatorNumber
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	dest.TaxAmt = src.taxAmt
	
	dest.TaxCode = src.taxCode
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.ChargeAmount = src.chargeAmount
	
	dest.ChargeCodeName = src.chargeCodeName
	
	dest.CurrencyID = src.currencyId
	
	dest.OfferingID = src.offeringId

    dest.OfferingName = src.offeringName
	
	dest.PayAcctKey = src.payAcctKey
	
	dest.PayObjClass = src.payObjClass
	
	dest.PayObjID = src.payObjId
	
	dest.PayObjType = src.payObjType
	
	dest.PlanID = src.planId
	
	mappingList(src.tax,dest.Tax,listMapping6)
	
	dest.ChargeCode = src.chargeCodeId
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.TaxAmt = src.taxAmt
	
	dest.TaxCode = src.taxCode
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.TaxAmt = src.taxAmt
	
	dest.TaxCode = src.taxCode
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.ActualChargeAmt = src.actualChargeAmt
	
	dest.CurrencyID = src.currencyId
	
	dest.FreeChargeAmt = src.freeChargeAmt
	
	mappingList(src.actualTaxList,dest.ActualTax,listMapping8)
	
	mappingList(src.freeTaxList,dest.FreeTax,listMapping9)
	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.BillCycleID = src.billCycleId
	
	dest.CalledCellID = src.calledCellId
	
	dest.CallingCellID = src.callingCellId
	
	dest.CategoryID = src.categoryId
	
	dest.CdrSeq = src.cdrSeq
	
	dest.ChargingPartyNumber = src.chargingPartyNumber
	
	dest.ContentID = src.contentId
	
	dest.EndTime=formatDate(src.endTime, Constant4Model.DATE_FORMAT)
	
	dest.FlowType = src.flowType
	
	dest.OriginalCalledParty = src.originalCalledParty
	
	dest.OtherNumber = src.otherNumber
	
	dest.RefundIndicator = src.refundIndicator
	
	dest.RoamFlag = src.roamFlag
	
	dest.SeriveType = src.seriveType
	
	dest.ServiceCategory = src.serviceCategory
	
	dest.ServiceID = src.serviceId
	
	dest.ServiceTypeName = src.serviceTypeName
	
	dest.SpCpID = src.spCpId
	
	dest.SpecialNumberIndicator = src.specialNumberIndicator
	
	dest.StartTime=formatDate(src.startTime, Constant4Model.DATE_FORMAT)
	
	dest.SubKey = src.subKey
	
	dest.URL = src.url
	
	listMapping1.call(src.volumeInfo,dest.VolumeInfo)
	
	dest.AccountKey = src.acctKey
	
	mappingList(src.additionalProperty,dest.AdditionalProperty,listMapping3)
	
	listMapping4.call(src.areaInfo,dest.AreaInfo)
	
	mappingList(src.chargeDetailList,dest.ChargeDetail,listMapping5)
	
	listMapping7.call(src.totalChargeInfo,dest.TotalChargeInfo)
	
	dest.PrimaryIdentity = src.subIdentity
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping15

listMapping15 = 
{
    src,dest  ->

	dest.TaxAmt = src.taxAmt
	
	dest.TaxCode = src.taxCode
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	dest.TaxAmt = src.taxAmt
	
	dest.TaxCode = src.taxCode
	
}

def listMapping14

listMapping14 = 
{
    src,dest  ->

	dest.ActualChargeAmt = src.actualChargeAmt
	
	dest.CurrencyID = src.currencyId
	
	dest.FreeChargeAmt = src.freeChargeAmt
	
	mappingList(src.actualTaxList,dest.ActualTax,listMapping15)
	
	mappingList(src.freeTaxList,dest.FreeTax,listMapping16)
	
}

def listMapping18

listMapping18 = 
{
    src,dest  ->

	dest.Amount = src.amount
	
	dest.FreeUnitType = src.freeUnitType

	dest.MeasureUnit = src.measureUnit
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	dest.ActualVolume = src.actualVolume
	
	dest.FreeVolume = src.freeVolume
	
	dest.MeasureUnit = src.measureUnit
	
	dest.RatingVolume = src.ratingVolume
	
	mappingList(src.freeUnits,dest.FreeUnitList,listMapping18)
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	dest.BillCycleID = src.cdrSummaryQueryInfo.billCycleId
	
	dest.FlowType = src.cdrSummaryQueryInfo.flowType
	
	dest.RoamFlag = src.cdrSummaryQueryInfo.roamFlag
	
	dest.SeriveType = src.cdrSummaryQueryInfo.seriveType
	
	dest.ServiceCategory = src.cdrSummaryQueryInfo.serviceCategory
	
	dest.ServiceTypeName = src.cdrSummaryQueryInfo.serviceTypeName
	
	mappingList(src.cdrSummaryDataInfo.additionalProperty,dest.AdditionalProperty,listMapping13)
	
	mappingList(src.cdrSummaryDataInfo.totalChargeInfos,dest.TotalChargeInfo,listMapping14)
	
	mappingList(src.cdrSummaryDataInfo.volumeInfos,dest.VolumeInfo,listMapping17)
	
}

def listMapping19

listMapping19 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def destMidVar = destReturn.QueryCDRResultMsg.QueryCDRResult

def srcMidVar = srcReturn.queryCDRResultInfo

destMidVar.BeginRowNum = srcMidVar.beginRowNum

mappingList(srcMidVar.CDRInfoList,destMidVar.CDRInfo,listMapping0)

mappingList(srcMidVar.summaryCDRInfos,destMidVar.CDRSummary,listMapping12)

destMidVar.TotalCDRNum = srcMidVar.totalCDRNum

destMidVar.FetchRowNum = srcMidVar.fetchRowNum

def srcMidVar1 = srcReturn.resultHeader

def destMidVar1 = destReturn.QueryCDRResultMsg.ResultHeader

mappingList(srcMidVar1.simpleProperty,destMidVar1.AdditionalProperty,listMapping19)

destMidVar1.MsgLanguageCode = srcMidVar1.msgLanguageCode

destMidVar1.ResultCode = srcMidVar1.resultCode

destMidVar1.ResultDesc = srcMidVar1.resultDesc

destMidVar1.Version = srcMidVar1.version

destMidVar1.MessageSeq = srcMidVar1.messageSeq