import com.huawei.ngcbs.bm.common.common.Constant4Model;

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

	dest.ChannelType = src.channelType
	
	dest.NoticeType = src.noticeType
		if(isNotNull(src))
		{
			if(isNull(src.noticeType))
			{
				dest.NoticeType  ='-1'
			}
		}
	
	dest.SubNoticeType = src.subNoticeType
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping5

listMapping5 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping4

listMapping4 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar6 = src.property
	
	mappingList(srcMidVar6.subProps,dest.SubPropInst,listMapping5)
	
	dest.Value = srcMidVar6.value
	
	dest.PropCode = srcMidVar6.propCode
	
	dest.PropType = srcMidVar6.complexFlag
	
}

def listMapping8

listMapping8 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping7

listMapping7 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar9 = src.property
	
	dest.PropCode = srcMidVar9.propCode
	
	dest.PropType = srcMidVar9.complexFlag
	
	mappingList(srcMidVar9.subProps,dest.SubPropInst,listMapping8)
	
	dest.Value = srcMidVar9.value
	
}

def listMapping6

listMapping6 = 
{
    src,dest  ->

	def srcMidVar8 = src.productInst
	
	dest.NetworkType = srcMidVar8.networkType
	
	dest.PackageFlag = srcMidVar8.packageFlag
	
	dest.ParentProdID = srcMidVar8.parentProdId
	
	mappingList(src.properties,dest.PInstProperty,listMapping7)
	
	dest.PrimaryFlag = srcMidVar8.primaryFlag
	
	dest.ProductID = srcMidVar8.prodId
	
	dest.ProductType = srcMidVar8.productType
	
}

def listMapping11

listMapping11 =
{
    src,dest  ->

    dest.OpenDay = formatDate(src.openDay, Constant4Model.DATE_FORMAT)

    dest.EndDay = formatDate(src.endDay, Constant4Model.DATE_FORMAT)

    dest.RentStatus = src.rentStatus

    dest.RentAmount = src.rentAmount

    dest.CurrencyID = src.currencyID

    dest.ProcessedCycleNum = src.processedCycleNum

    dest.SuccessCycleNum = src.successCycleNum

}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	def srcMidVar4 = src.offeringInst
	
	dest.ActivationMode = srcMidVar4.activeMode
	
	dest.ActivationTime=formatDate(srcMidVar4.activeTime, Constant4Model.DATE_FORMAT)
	
	dest.ActiveTimeLimit=formatDate(srcMidVar4.activeTimeLimit, Constant4Model.DATE_FORMAT)

	listMapping11.call(srcMidVar4.rentInfo,dest.RentInfo)

	dest.BundledFlag = srcMidVar4.bundleFlag
	
	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	dest.OfferingClass = srcMidVar4.offeringClass
	
	def destMidVar4 = dest.OfferingKey
	
	def srcMidVar5 = src.offeringInst.offeringKey
    srcMidVar5._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar4.OfferingID = srcMidVar5.oId
    destMidVar4.OfferingCode = srcMidVar5.oCode
	destMidVar4.PurchaseSeq = srcMidVar5.pSeq
	
	mappingList(src.properties,dest.OInstProperty,listMapping4)
	
	def destMidVar5 = dest.ParentOfferingKey
	
	def srcMidVar7 = src.offeringInst.parentOfferingKey
    srcMidVar7._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar5.OfferingID = srcMidVar7.oId
    destMidVar5.OfferingCode = srcMidVar7.oCode
	destMidVar5.PurchaseSeq = srcMidVar7.pSeq
	
	mappingList(src.productInsts,dest.ProductInst,listMapping6)
	
	def destMidVar6 = dest.RelGOfferingKey
	
	def srcMidVar10 = src.offeringInst.relGOfferingKey
    srcMidVar10._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar6.OfferingID = srcMidVar10.oId
    destMidVar6.OfferingCode = srcMidVar10.oCode
	destMidVar6.PurchaseSeq = srcMidVar10.pSeq
	
	dest.Status = srcMidVar4.status
	
	dest.TrialEndTime=formatDate(srcMidVar4.trialEndTime, Constant4Model.DATE_FORMAT)
	
	dest.TrialStartTime=formatDate(srcMidVar4.trialStartTime, Constant4Model.DATE_FORMAT)
	
}

def listMapping9

listMapping9 = 
{
    src,dest  ->

	dest.Value = src.value
	
	dest.Code = src.code
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping28

listMapping28 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping27

listMapping27 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar16 = src.property
	
	mappingList(srcMidVar16.subProps,dest.SubPropInst,listMapping28)
	
	dest.PropCode = srcMidVar16.propCode
	
	dest.PropType = srcMidVar16.complexFlag
	
	dest.Value = srcMidVar16.value
	
}

def listMapping31

listMapping31 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping30

listMapping30 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar20 = src.property
	
	dest.PropCode = srcMidVar20.propCode
	
	dest.PropType = srcMidVar20.complexFlag
	
	mappingList(srcMidVar20.subProps,dest.SubPropInst,listMapping31)
	
	dest.Value = srcMidVar20.value
	
}

def listMapping29

listMapping29 = 
{
    src,dest  ->

	def srcMidVar19 = src.productInst
	
	dest.NetworkType = srcMidVar19.networkType
	
	dest.PackageFlag = srcMidVar19.packageFlag
	
	dest.ParentProdID = srcMidVar19.parentProdId
	
	dest.PrimaryFlag = srcMidVar19.primaryFlag
	
	dest.ProductID = srcMidVar19.prodId
	
	dest.ProductType = srcMidVar19.productType
	
	mappingList(src.properties,dest.PInstProperty,listMapping30)
	
}

def listMapping32

listMapping32 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping33

listMapping33 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping34

listMapping34 = 
{
    src,dest  ->

	dest.ChannelType = src.channelType
	
	dest.NoticeType = src.noticeType
		if(isNotNull(src))
		{
			if(isNull(src.noticeType))
			{
				dest.NoticeType  ='-1'
			}
		}
	
	dest.SubNoticeType = src.subNoticeType
	
}

def listMapping35

listMapping35 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping36

listMapping36 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping60

listMapping60 = 
{
    src,dest  ->

	dest.OfferingID = src.oId
    dest.OfferingCode = src.oCode
	dest.PurchaseSeq = src.pSeq
	
}

def listMapping62

listMapping62 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping61

listMapping61 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar30 = src.property
	
	dest.PropCode = srcMidVar30.propCode
	
	dest.PropType = srcMidVar30.complexFlag
	
	mappingList(srcMidVar30.subProps,dest.SubPropInst,listMapping62)
	
	dest.Value = srcMidVar30.value
	
}

def listMapping63

listMapping63 = 
{
    src,dest  ->

	dest.OfferingID = src.oId
    dest.OfferingCode = src.oCode
	dest.PurchaseSeq = src.pSeq
	
}

def listMapping66

listMapping66 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping65

listMapping65 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar32 = src.property
	
	dest.PropCode = srcMidVar32.propCode
	
	dest.PropType = srcMidVar32.complexFlag
	
	mappingList(srcMidVar32.subProps,dest.SubPropInst,listMapping66)
	
	dest.Value = srcMidVar32.value
	
}

def listMapping64

listMapping64 = 
{
    src,dest  ->

	def srcMidVar31 = src.productInst
	
	dest.NetworkType = srcMidVar31.networkType
	
	dest.PackageFlag = srcMidVar31.packageFlag
	
	dest.ParentProdID = srcMidVar31.parentProdId
	
	mappingList(src.properties,dest.PInstProperty,listMapping65)
	
	dest.PrimaryFlag = srcMidVar31.primaryFlag
	
	dest.ProductID = srcMidVar31.prodId
	
	dest.ProductType = srcMidVar31.productType
	
}

def listMapping67

listMapping67 = 
{
    src,dest  ->

	dest.OfferingID = src.oId
    dest.OfferingCode = src.oCode
	dest.PurchaseSeq = src.pSeq
	
}

def listMapping39

listMapping39 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping38

listMapping38 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar36 = src.property
	
	dest.PropCode = srcMidVar36.propCode
	
	dest.PropType = srcMidVar36.complexFlag
	
	mappingList(srcMidVar36.subProps,dest.SubPropInst,listMapping39)
	
	dest.Value = srcMidVar36.value
	
}

def listMapping51

listMapping51 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping41

listMapping41 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar40 = src.property
	
	dest.PropCode = srcMidVar40.propCode
	
	dest.PropType = srcMidVar40.complexFlag
	
	mappingList(srcMidVar40.subProps,dest.SubPropInst,listMapping51)
	
	dest.Value = srcMidVar40.value
	
}

def listMapping40

listMapping40 = 
{
    src,dest  ->

	def srcMidVar39 = src.productInst
	
	dest.NetworkType = srcMidVar39.networkType
	
	dest.PackageFlag = srcMidVar39.packageFlag
	
	dest.ParentProdID = srcMidVar39.parentProdId
	
	mappingList(src.properties,dest.PInstProperty,listMapping41)
	
	dest.ProductID = srcMidVar39.prodId
	
	dest.ProductType = srcMidVar39.productType
	
	dest.PrimaryFlag = srcMidVar39.primaryFlag
	
}

def listMapping53

listMapping53 = 
{
    src,dest  ->

	dest.ParamCode = src.code
	
	dest.ParamValue = src.value
	
}

def listMapping52

listMapping52 = 
{
    src,dest  ->

	def srcMidVar44 = src.spendingLimitInfo.currencyLimit
	
	dest.CurrencyID = srcMidVar44.currencyId
	
	mappingList(src.spdlmtParamInfos,dest.LimitParam,listMapping53)
	
	def srcMidVar45 = src.spendingLimitInfo
	
	dest.LimitType = srcMidVar45.limitType
	
	def srcMidVar46 = src.spendingLimitInfo.usageLimit

	dest.MesureID = srcMidVar46.measureId
	
	dest.MesureType = srcMidVar46.measureType
	
	dest.UnitType = srcMidVar45.unitType

	if(!isNull(srcMidVar44.limitValue)){
		dest.LimitValue = srcMidVar44.limitValue
	}

	if(!isNull(srcMidVar46.limitValue)){
		dest.LimitValue = srcMidVar46.limitValue
	}
	
}

def listMapping54

listMapping54 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping55

listMapping55 = 
{
    src,dest  ->

	dest.PrimaryFlag = src.primaryFlag
	
	dest.SubIdentity = src.subIden
	
	dest.SubIdentityType = src.subIdenType
	
}

def listMapping56

listMapping56 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping57

listMapping57 = 
{
    src,dest  ->

	dest.ChannelType = src.channelType
	
	dest.NoticeType = src.noticeType
		if(isNotNull(src))
		{
			if(isNull(src.noticeType))
			{
				dest.NoticeType  ='-1'
			}
		}
	
	dest.SubNoticeType = src.subNoticeType
	
}

def listMapping58

listMapping58 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping59

listMapping59 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping70

listMapping70 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping69

listMapping69 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar54 = src.property
	
	dest.PropCode = srcMidVar54.propCode
	
	dest.PropType = srcMidVar54.complexFlag
	
	mappingList(srcMidVar54.subProps,dest.SubPropInst,listMapping70)
	
	dest.Value = srcMidVar54.value
	
}

def listMapping73

listMapping73 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping72

listMapping72 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar57 = src.property
	
	dest.PropCode = srcMidVar57.propCode
	
	dest.PropType = srcMidVar57.complexFlag
	
	mappingList(srcMidVar57.subProps,dest.SubPropInst,listMapping73)
	
	dest.Value = srcMidVar57.value
	
}

def listMapping71

listMapping71 = 
{
    src,dest  ->

	def srcMidVar56 = src.productInst
	
	dest.NetworkType = srcMidVar56.networkType
	
	dest.PackageFlag = srcMidVar56.packageFlag
	
	dest.ParentProdID = srcMidVar56.parentProdId
	
	mappingList(src.properties,dest.PInstProperty,listMapping72)
	
	dest.PrimaryFlag = srcMidVar56.primaryFlag
	
	dest.ProductID = srcMidVar56.prodId
	
	dest.ProductType = srcMidVar56.productType
	
}

def listMapping68

listMapping68 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar52 = src.offeringInst
	
	dest.ActivationMode = srcMidVar52.activeMode
	
	dest.ActivationTime=formatDate(srcMidVar52.activeTime, Constant4Model.DATE_FORMAT)
	
	dest.ActiveTimeLimit=formatDate(srcMidVar52.activeTimeLimit, Constant4Model.DATE_FORMAT)

	listMapping11.call(srcMidVar52.rentInfo,dest.RentInfo)

	dest.BundledFlag = srcMidVar52.bundleFlag
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	dest.OfferingClass = srcMidVar52.offeringClass
	
	def destMidVar34 = dest.OfferingKey
	
	def srcMidVar53 = src.offeringInst.offeringKey
    srcMidVar53._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar34.OfferingID = srcMidVar53.oId
    destMidVar34.OfferingCode = srcMidVar53.oCode
	destMidVar34.PurchaseSeq = srcMidVar53.pSeq
	
	mappingList(src.properties,dest.OInstProperty,listMapping69)
	
	def destMidVar35 = dest.ParentOfferingKey
	
	def srcMidVar55 = src.offeringInst.parentOfferingKey
    srcMidVar55._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar35.OfferingID = srcMidVar55.oId
    destMidVar35.OfferingCode = srcMidVar55.oCode
	destMidVar35.PurchaseSeq = srcMidVar55.pSeq
	
	mappingList(src.productInsts,dest.ProductInst,listMapping71)
	
	def destMidVar36 = dest.RelGOfferingKey
	
	def srcMidVar58 = src.offeringInst.relGOfferingKey
    srcMidVar58._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar36.OfferingID = srcMidVar58.oId
    destMidVar36.OfferingCode = srcMidVar58.oCode
	destMidVar36.PurchaseSeq = srcMidVar58.pSeq
	
	dest.Status = srcMidVar52.status
	
	dest.TrialEndTime=formatDate(srcMidVar52.trialEndTime, Constant4Model.DATE_FORMAT)
	
	dest.TrialStartTime=formatDate(srcMidVar52.trialStartTime, Constant4Model.DATE_FORMAT)
	
}

def listMapping108

listMapping108 =
		{
			src,dest  ->

				dest.LoanID = src.loanId

				dest.InitLoanAMT = src.initLoanAMT

				dest.initLoanDate = formatDate(src.initLoanDate, Constant4Model.DATE_FORMAT)

				dest.InitLoanPoundage = src.initLoanPoundage

				dest.RepaymentAMT = src.repaymentAMT

				dest.PaidAMT =  src.paidAMT

				dest.RemainingAMT = src.remainingAMT

				dest.GraceDate = formatDate(src.graceDate, Constant4Model.DATE_FORMAT)

				dest.PaidPoundage = src.paidPoundage

				dest.RemainingPoundage = src.remainingPoundage

				dest.RemainingTotal = src.remainingTotal

				dest.ForceGraceDate = formatDate(src.forceGraceDate, Constant4Model.DATE_FORMAT)

				dest.LoanGrade = src.loanGrade

				dest.SPID = src.spID

				dest.LoanTransID = src.loanTransId
		}

def listMapping49

listMapping49 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping50

listMapping50 = 
{
    src,dest  ->

	dest.BMCode = src.code
	
	dest.BMType = src.type
	
}

def listMapping74

listMapping74 = 
{
    src,dest  ->

	dest.Address1 = src.addr1
	
	dest.Address10 = src.addr10
	
	dest.Address11 = src.addr11
	
	dest.Address12 = src.addr12
	
	dest.Address2 = src.addr2
	
	dest.Address3 = src.addr3
	
	dest.Address4 = src.addr4
	
	dest.Address5 = src.addr5
	
	dest.Address6 = src.addr6
	
	dest.Address7 = src.addr7
	
	dest.Address8 = src.addr8
	
	dest.Address9 = src.addr9
	
	dest.PostCode = src.postCode
	
	dest.AddressKey = src.tpAddrKey
	
}

def listMapping75

listMapping75 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping76

listMapping76 = 
{
    src,dest  ->

	dest.ChannelType = src.channelType
	
	dest.NoticeType = src.noticeType
		if(isNotNull(src))
		{
			if(isNull(src.noticeType))
			{
				dest.NoticeType  ='-1'
			}
		}
	
	dest.SubNoticeType = src.subNoticeType
	
}

def listMapping77

listMapping77 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping78

listMapping78 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping81

listMapping81 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping80

listMapping80 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar68 = src.property
	
	dest.PropCode = srcMidVar68.propCode
	
	dest.PropType = srcMidVar68.complexFlag
	
	mappingList(srcMidVar68.subProps,dest.SubPropInst,listMapping81)
	
	dest.Value = srcMidVar68.value
	
}

def listMapping84

listMapping84 = 
{
    src,dest  ->

	dest.SubPropCode = src.code
	
	dest.Value = src.value
	
}

def listMapping83

listMapping83 = 
{
    src,dest  ->

	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	def srcMidVar71 = src.property
	
	dest.PropCode = srcMidVar71.propCode
	
	dest.PropType = srcMidVar71.complexFlag
	
	mappingList(srcMidVar71.subProps,dest.SubPropInst,listMapping84)
	
	dest.Value = srcMidVar71.value
	
}

def listMapping82

listMapping82 = 
{
    src,dest  ->

	def srcMidVar70 = src.productInst
	
	dest.NetworkType = srcMidVar70.networkType
	
	dest.PackageFlag = srcMidVar70.packageFlag
	
	dest.ParentProdID = srcMidVar70.parentProdId
	
	mappingList(src.properties,dest.PInstProperty,listMapping83)
	
	dest.PrimaryFlag = srcMidVar70.primaryFlag
	
	dest.ProductID = srcMidVar70.prodId
	
	dest.ProductType = srcMidVar70.productType
	
}

def listMapping79

listMapping79 = 
{
    src,dest  ->

	def srcMidVar66 = src.offeringInst
	
	dest.ActivationMode = srcMidVar66.activeMode
	
	dest.ActivationTime=formatDate(srcMidVar66.activeTime, Constant4Model.DATE_FORMAT)
	
	dest.ActiveTimeLimit=formatDate(srcMidVar66.activeTimeLimit, Constant4Model.DATE_FORMAT)
	
	dest.BundledFlag = srcMidVar66.bundleFlag
	
	dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
	
	dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
	
	dest.OfferingClass = srcMidVar66.offeringClass
	
	def destMidVar46 = dest.OfferingKey
	
	def srcMidVar67 = src.offeringInst.offeringKey
    srcMidVar67._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar46.OfferingID = srcMidVar67.oId
    destMidVar46.OfferingCode = srcMidVar67.oCode
	destMidVar46.PurchaseSeq = srcMidVar67.pSeq
	
	mappingList(src.properties,dest.OInstProperty,listMapping80)
	
	def destMidVar47 = dest.ParentOfferingKey
	
	def srcMidVar69 = src.offeringInst.parentOfferingKey
    srcMidVar69._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar47.OfferingID = srcMidVar69.oId
    destMidVar47.OfferingCode = srcMidVar69.oCode
	destMidVar47.PurchaseSeq = srcMidVar69.pSeq
	
	mappingList(src.productInsts,dest.ProductInst,listMapping82)
	
	def destMidVar48 = dest.RelGOfferingKey
	
	def srcMidVar72 = src.offeringInst.relGOfferingKey
    srcMidVar72._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	
	destMidVar48.OfferingID = srcMidVar72.oId
    destMidVar48.OfferingCode = srcMidVar72.oCode
	destMidVar48.PurchaseSeq = srcMidVar72.pSeq
	
	dest.Status = srcMidVar66.status
	
	dest.TrialEndTime=formatDate(srcMidVar66.trialEndTime, Constant4Model.DATE_FORMAT)
	
	dest.TrialStartTime=formatDate(srcMidVar66.trialStartTime, Constant4Model.DATE_FORMAT)
	
}

def listMapping86

listMapping86 = 
{
    src,dest  ->

	dest.BankBranchCode = src.bankBranchCode
	
	dest.BankCode = src.bankCode
	
	dest.CreditCardType = src.creditCardType
	
	dest.CVVNumber = src.cvvNumber
	
	dest.Priority = src.priority
	
	dest.AcctName = src.bankAcctName
	
	dest.AcctNo = src.bankAcctNo
	
	dest.AcctType = src.bankAcctType
	
	dest.ExpDate = src.bankAcctExpDate

	dest.EffectiveDate = formatDate(src.effDate, Constant4Model.DATE_FORMAT)

	dest.ExpireDate = formatDate(src.expDate, Constant4Model.DATE_FORMAT)

	mappingList(src.paymentChannelProp,dest.AdditionalProperty,listMapping0)
	
}

def listMapping88

listMapping88 = 
{
    src,dest  ->

	dest.AutoRechargeAmt = src.autoRechargeAmt
	
	dest.AutoRechargeDate = src.autoRechargeDate
	
	dest.PeriodType = src.periodType
	
}

def listMapping89

listMapping89 = 
{
    src,dest  ->

	dest.AutoPayDate = src.autoPayDate
	
	dest.AutoPayMaxAmt = src.autoPayMaxAmt
	
}

def listMapping90

listMapping90 = 
{
    src,dest  ->

	dest.AutoRechargeAmt = src.autoRechargeAmt
	
	dest.BalanceThreshold = src.balanceThreshold
	
	dest.ControlPeriodType = src.controlPeriodType
	
	dest.MaxTimes = src.maxTimes

	dest.BalanceThresholdType = src.balanceThresholdType
	
}

def listMapping87

listMapping87 = 
{
    src,dest  ->

	listMapping88.call(src.timeSchema,dest.TimeSchema)
	
	listMapping89.call(src.billCycleSchema,dest.BillCycleSchema)
	
	listMapping90.call(src.lowBalanceSchema,dest.LowBalanceSchema)
	
	dest.AutoPayType = src.payType
	
}

def listMapping85

listMapping85 = 
{
    src,dest  ->

	def destMidVar49 = dest.AutoPayChannelInfo
	
	destMidVar49.ChargeCode = src.chargeCodes
	
	listMapping86.call(src.paymentChannelInfo,dest.AutoPayChannelInfo)
	
	def srcMidVar73 = src.paymentChannelInfo
	
	dest.AutoPayChannelKey = srcMidVar73.paymentChannelKey
	
	mappingList(src.paymentPlanInfos,destMidVar49.PaymentPlan,listMapping87)
	
}

def listMapping48

listMapping48 = 
{
    src,dest  ->

	def destMidVar38 = dest.AcctInfo
	
	def srcMidVar59 = src.createAccountInfo.accountInfo
	
	destMidVar38.AcctClass = srcMidVar59.acctClass
	
	destMidVar38.AcctCode = srcMidVar59.acctCode
	
	def destMidVar39 = dest.AcctInfo.AcctBasicInfo

	destMidVar39.Status = srcMidVar59.status
	destMidVar39.StatusDetail = srcMidVar59.statusDetail
	
	destMidVar39.AcctName = srcMidVar59.acctName
	
	def srcMidVar60 = src.createAccountInfo
	
	mappingList(srcMidVar60.properties,destMidVar39.AcctProperty,listMapping49)
	
	destMidVar39.BillLang = srcMidVar59.billLang
	
	def destMidVar40 = dest.AcctInfo.AcctBasicInfo.ContactInfo
	
	def srcMidVar61 = src.createAccountInfo.contactInfo
	
	destMidVar40.AddressKey = srcMidVar61.addrKey
	
	destMidVar40.Email = srcMidVar61.email
	
	destMidVar40.Fax = srcMidVar61.fax
	
	destMidVar40.FirstName = srcMidVar61.firstName
	
	destMidVar40.HomePhone = srcMidVar61.homePhone
	
	destMidVar40.LastName = srcMidVar61.lastName
	
	destMidVar40.MiddleName = srcMidVar61.middleName
	
	destMidVar40.MobilePhone = srcMidVar61.mobilePhone
	
	destMidVar40.OfficePhone = srcMidVar61.officePhone
	
	destMidVar40.Title = srcMidVar61.title
	
	destMidVar39.DunningFlag = srcMidVar59.dunningFlag
	
	mappingList(srcMidVar59.bmInfos,destMidVar39.FreeBillMedium,listMapping50)
	
	destMidVar39.LateFeeChargeable = srcMidVar59.latePaymentFlag
	
	destMidVar39.RedlistFlag = srcMidVar60.redlistFlag
	
	destMidVar38.AcctPayMethod = srcMidVar59.acctPaymentMethod
	
	destMidVar38.AcctType = srcMidVar59.acctType
	
	mappingList(src.addressInfoList,destMidVar38.AddressInfo,listMapping74)
	
	destMidVar38.BillCycleEndDate=formatDate(src.billCycleEndDate, Constant4Model.DATE_FORMAT)
	
	destMidVar38.BillCycleOpenDate=formatDate(src.billCycleOpenDate, Constant4Model.DATE_FORMAT)
	
	destMidVar38.BillCycleType = srcMidVar60.billCycleType
	
	destMidVar38.CurrencyID = srcMidVar59.currencyId
	
	destMidVar38.ParentAcctKey = srcMidVar59.parentAcctKey
	
	destMidVar38.PaymentType = srcMidVar59.paymentType
	
	destMidVar38.RootAcctKey = src.rootAcctKey
	
	def destMidVar41 = dest.AcctInfo.UserCustomer.CustInfo.CustBasicInfo
	
	def srcMidVar62 = src.createCustomerInfo.customerInfo
	
	destMidVar41.CustLevel = srcMidVar62.custLevel
	
	destMidVar41.CustLoyalty = srcMidVar62.custLoyalty
	
	def srcMidVar63 = src.createCustomerInfo
	
	mappingList(srcMidVar63.custProperties,destMidVar41.CustProperty,listMapping75)
	
	destMidVar41.CustSegment = srcMidVar62.custSegment
	
	destMidVar41.DFTCurrencyID = srcMidVar62.currencyId
	
	destMidVar41.DFTIVRLang = srcMidVar62.custPLang
	
	destMidVar41.DFTPwd = srcMidVar62.custPwd
	
	destMidVar41.DFTWrittenLang = srcMidVar62.custWLang
	
	destMidVar41.DunningFlag = srcMidVar62.dunningFlag
	
	def destMidVar42 = dest.AcctInfo.UserCustomer.CustInfo
	
	destMidVar42.CustClass = srcMidVar62.custClass
	
	destMidVar42.CustCode = srcMidVar62.custCode
	
	destMidVar42.CustNodeType = srcMidVar62.custNodeType
	
	destMidVar42.CustType = srcMidVar62.custType
	
	mappingList(srcMidVar63.noticeSuppresses,destMidVar42.NoticeSuppress,listMapping76)
	
	destMidVar42.ParentCustKey = srcMidVar62.parentCustKey
	
	def destMidVar43 = dest.AcctInfo.UserCustomer
	
	destMidVar43.CustKey = srcMidVar62.tpCustKey
	
	destMidVar43.IndividualInfo.Birthday=formatDate(srcMidVar63.individualInfo.birthday, Constant4Model.DATE_FORMAT)
	
	def destMidVar44 = dest.AcctInfo.UserCustomer.IndividualInfo
	
	def srcMidVar64 = src.createCustomerInfo.individualInfo
	
	destMidVar44.Education = srcMidVar64.education
	
	destMidVar44.Email = srcMidVar64.email
	
	destMidVar44.Fax = srcMidVar64.fax
	
	destMidVar44.FirstName = srcMidVar64.firstName
	
	destMidVar44.Gender = srcMidVar64.gender
	
	destMidVar44.HomeAddressKey = srcMidVar64.addrKey
	
	destMidVar44.HomePhone = srcMidVar64.homePhone
	
	destMidVar44.IDNumber = srcMidVar64.idNumber
	
	destMidVar44.IDType = srcMidVar64.idType
	
	destMidVar43.IndividualInfo.IDValidity=formatDate(srcMidVar63.individualInfo.idValidity, Constant4Model.DATE_FORMAT)
	
	mappingList(srcMidVar63.indvProperties,destMidVar44.IndividualProperty,listMapping77)
	
	destMidVar44.LastName = srcMidVar64.lastName
	
	destMidVar44.MaritalStatus = srcMidVar64.marriedStatus
	
	destMidVar44.MiddleName = srcMidVar64.middleName
	
	destMidVar44.MobilePhone = srcMidVar64.mobilePhone
	
	destMidVar44.Nationality = srcMidVar64.nationality
	
	destMidVar44.NativePlace = srcMidVar64.nativePlace
	
	destMidVar44.Occupation = srcMidVar64.occupation
	
	destMidVar44.OfficePhone = srcMidVar64.officePhone
	
	destMidVar44.Race = srcMidVar64.race
	
	destMidVar44.Salary = srcMidVar64.salary
	
	destMidVar44.Title = srcMidVar64.title
	
	def destMidVar45 = dest.AcctInfo.UserCustomer.OrgInfo
	
	def srcMidVar65 = src.createCustomerInfo.orgInfo
	
	destMidVar45.OrgAddressKey = srcMidVar65.addrKey
	
	destMidVar45.IDNumber = srcMidVar65.idNumber
	
	destMidVar45.IDType = srcMidVar65.idType
	
	destMidVar43.OrgInfo.IDValidity=formatDate(srcMidVar63.orgInfo.idValidity, Constant4Model.DATE_FORMAT)
	
	destMidVar45.Industry = srcMidVar65.industry
	
	destMidVar45.OrgEmail = srcMidVar65.orgEmail
	
	destMidVar45.OrgFaxNumber = srcMidVar65.orgFax
	
	destMidVar45.OrgLevel = srcMidVar65.orgLevel
	
	destMidVar45.OrgName = srcMidVar65.orgName
	
	destMidVar45.OrgPhoneNumber = srcMidVar65.orgPhone
	
	mappingList(srcMidVar63.orgProperties,destMidVar45.OrgProperty,listMapping78)
	
	destMidVar45.OrgShortName = srcMidVar65.orgSName
	
	destMidVar45.OrgSize = srcMidVar65.sizeLevel
	
	destMidVar45.OrgType = srcMidVar65.orgType
	
	destMidVar45.OrgWebSite = srcMidVar65.orgWeb
	
	destMidVar45.SubIndustry = srcMidVar65.subIndustry
	
	destMidVar38.UserCustomerKey = srcMidVar60.uCustKey
	
	dest.AcctKey = srcMidVar59.acctKey
	
	mappingList(src.offeringList,dest.OfferingInst,listMapping79)
	
	destMidVar41.DFTBillCycleType = srcMidVar62.billCycleType
	
	mappingList(srcMidVar60.paymentChannels,destMidVar38.AutoPayChannel,listMapping85)
	
	def destMidVar50 = dest.AcctInfo.AcctBasicInfo.RedlistTimePeriod

	destMidVar50.EffectiveTime=formatDate(src.creditLimitEffectiveTime, Constant4Model.DATE_FORMAT)
	
	destMidVar50.ExpireTime=formatDate(src.creditLimitExpireTime, Constant4Model.DATE_FORMAT)

	dest.EffectiveTime=formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)
	dest.ExpireTime=formatDate(src.expireTime, Constant4Model.DATE_FORMAT)
}



def destMidVar = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.Customer.AddressInfo

def srcMidVar = srcReturn.customerDetail.addressInfo

destMidVar.Address1 = srcMidVar.addr1

destMidVar.Address10 = srcMidVar.addr10

destMidVar.Address11 = srcMidVar.addr11

destMidVar.Address12 = srcMidVar.addr12

destMidVar.Address2 = srcMidVar.addr2

destMidVar.Address3 = srcMidVar.addr3

destMidVar.Address4 = srcMidVar.addr4

destMidVar.Address5 = srcMidVar.addr5

destMidVar.Address6 = srcMidVar.addr6

destMidVar.Address7 = srcMidVar.addr7

destMidVar.Address8 = srcMidVar.addr8

destMidVar.Address9 = srcMidVar.addr9

destMidVar.PostCode = srcMidVar.postCode

destMidVar.AddressKey = srcMidVar.tpAddrKey

def destMidVar0 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.Customer.CustInfo.CustBasicInfo

def srcMidVar0 = srcReturn.customerDetail.createCustomerInfo.customerInfo

destMidVar0.CustLevel = srcMidVar0.custLevel

destMidVar0.CustLoyalty = srcMidVar0.custLoyalty

def srcMidVar1 = srcReturn.customerDetail.createCustomerInfo

mappingList(srcMidVar1.custProperties,destMidVar0.CustProperty,listMapping0)

destMidVar0.CustSegment = srcMidVar0.custSegment

destMidVar0.DFTBillCycleType = srcMidVar0.billCycleType

destMidVar0.DFTCurrencyID = srcMidVar0.currencyId

destMidVar0.DunningFlag = srcMidVar0.dunningFlag

destMidVar0.DFTWrittenLang = srcMidVar0.custWLang

destMidVar0.DFTPwd = srcMidVar0.custPwd

destMidVar0.DFTIVRLang = srcMidVar0.custPLang

def destMidVar1 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.Customer.CustInfo

destMidVar1.CustClass = srcMidVar0.custClass

destMidVar1.CustCode = srcMidVar0.custCode

destMidVar1.CustNodeType = srcMidVar0.custNodeType

destMidVar1.CustType = srcMidVar0.custType

mappingList(srcMidVar1.noticeSuppresses,destMidVar1.NoticeSuppress,listMapping1)

destMidVar1.ParentCustKey = srcMidVar0.parentCustKey

def destMidVar2 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.Customer

destMidVar2.CustKey = srcMidVar0.tpCustKey

destMidVar2.IndividualInfo.Birthday=formatDate(srcMidVar1.individualInfo.birthday, Constant4Model.DATE_FORMAT)

def destMidVar3 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.Customer.IndividualInfo

def srcMidVar2 = srcReturn.customerDetail.createCustomerInfo.individualInfo

destMidVar3.Education = srcMidVar2.education

destMidVar3.Fax = srcMidVar2.fax

destMidVar3.FirstName = srcMidVar2.firstName

destMidVar3.Gender = srcMidVar2.gender

destMidVar3.HomePhone = srcMidVar2.homePhone

destMidVar3.HomeAddressKey = srcMidVar2.addrKey

destMidVar3.IDNumber = srcMidVar2.idNumber

destMidVar3.IDType = srcMidVar2.idType

destMidVar3.IDValidity=formatDate(srcMidVar1.individualInfo.idValidity, Constant4Model.DATE_FORMAT)

mappingList(srcMidVar1.indvProperties,destMidVar3.IndividualProperty,listMapping2)

destMidVar3.LastName = srcMidVar2.lastName

destMidVar3.MaritalStatus = srcMidVar2.marriedStatus

destMidVar3.MiddleName = srcMidVar2.middleName

destMidVar3.MobilePhone = srcMidVar2.mobilePhone

destMidVar3.Nationality = srcMidVar2.nationality

destMidVar3.NativePlace = srcMidVar2.nativePlace

destMidVar3.Occupation = srcMidVar2.occupation

destMidVar3.OfficePhone = srcMidVar2.officePhone

destMidVar3.Race = srcMidVar2.race

destMidVar3.Salary = srcMidVar2.salary

destMidVar3.Title = srcMidVar2.title

def srcMidVar3 = srcReturn.customerDetail

mappingList(srcMidVar3.offeringList,destMidVar2.OfferingInst,listMapping3)

destMidVar2.EffectiveTime=formatDate(srcMidVar3.effectiveTime, Constant4Model.DATE_FORMAT)
destMidVar2.ExpireTime=formatDate(srcMidVar3.expireTime, Constant4Model.DATE_FORMAT)

def destMidVar7 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.Customer.OrgInfo

def srcMidVar11 = srcReturn.customerDetail.createCustomerInfo.orgInfo

destMidVar7.IDNumber = srcMidVar11.idNumber

destMidVar7.IDType = srcMidVar11.idType

destMidVar2.OrgInfo.IDValidity=formatDate(srcMidVar1.orgInfo.idValidity, Constant4Model.DATE_FORMAT)

destMidVar7.Industry = srcMidVar11.industry

destMidVar7.OrgAddressKey = srcMidVar11.addrKey

destMidVar7.OrgEmail = srcMidVar11.orgEmail

destMidVar7.OrgFaxNumber = srcMidVar11.orgFax

destMidVar7.OrgLevel = srcMidVar11.orgLevel

destMidVar7.OrgPhoneNumber = srcMidVar11.orgPhone

mappingList(srcMidVar1.orgProperties,destMidVar7.OrgProperty,listMapping9)

destMidVar7.OrgType = srcMidVar11.orgType

destMidVar7.OrgShortName = srcMidVar11.orgSName

destMidVar7.OrgSize = srcMidVar11.sizeLevel

destMidVar7.OrgWebSite = srcMidVar11.orgWeb

destMidVar7.SubIndustry = srcMidVar11.subIndustry

destMidVar3.Email = srcMidVar2.email

def destMidVar9 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.SubGroupInfo.AddressInfo

def srcMidVar13 = srcReturn.subGroupDetail.addressInfo

destMidVar9.Address1 = srcMidVar13.addr1

destMidVar9.Address10 = srcMidVar13.addr10

destMidVar9.Address11 = srcMidVar13.addr11

destMidVar9.Address12 = srcMidVar13.addr12

destMidVar9.Address2 = srcMidVar13.addr2

destMidVar9.Address3 = srcMidVar13.addr3

destMidVar9.Address4 = srcMidVar13.addr4

destMidVar9.Address5 = srcMidVar13.addr5

destMidVar9.Address6 = srcMidVar13.addr6

destMidVar9.Address7 = srcMidVar13.addr7

destMidVar9.Address8 = srcMidVar13.addr8

destMidVar9.PostCode = srcMidVar13.postCode

destMidVar9.Address9 = srcMidVar13.addr9

destMidVar9.AddressKey = srcMidVar13.tpAddrKey

def destMidVar10 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.PrimaryOffering

def srcMidVar14 = srcReturn.subGroupDetail.createGroupInfo.primaryOffering.offeringInst

destMidVar10.BundledFlag = srcMidVar14.bundleFlag

destMidVar10.OfferingClass = srcMidVar14.offeringClass

def srcMidVar15 = srcReturn.subGroupDetail.createGroupInfo.primaryOffering

mappingList(srcMidVar15.properties,destMidVar10.OfferingInstProperty,listMapping27)

def destMidVar11 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.PrimaryOffering.OfferingKey

def srcMidVar17 = srcReturn.subGroupDetail.createGroupInfo.primaryOffering.offeringInst.offeringKey
srcMidVar17._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

destMidVar11.OfferingID = srcMidVar17.oId
destMidVar11.OfferingCode = srcMidVar17.oCode
destMidVar11.PurchaseSeq = srcMidVar17.pSeq

def destMidVar12 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.PrimaryOffering.ParentOfferingKey

def srcMidVar18 = srcReturn.subGroupDetail.createGroupInfo.primaryOffering.offeringInst.parentOfferingKey
srcMidVar18._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

destMidVar12.OfferingID = srcMidVar18.oId
destMidVar12.OfferingCode = srcMidVar18.oCode
destMidVar12.PurchaseSeq = srcMidVar18.pSeq

mappingList(srcMidVar15.productInsts,destMidVar10.ProductInst,listMapping29)

destMidVar10.TrialEndTime=formatDate(srcMidVar14.trialEndTime, Constant4Model.DATE_FORMAT)

destMidVar10.TrialStartTime=formatDate(srcMidVar14.trialStartTime, Constant4Model.DATE_FORMAT)

def destMidVar13 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.SubGroupInfo

def srcMidVar21 = srcReturn.subGroupDetail.createGroupInfo.groupInfo

destMidVar13.GroupType = srcMidVar21.groupType

destMidVar13.Password = srcMidVar21.password

destMidVar13.PGroupKey = srcMidVar21.pGroupKey

def srcMidVar22 = srcReturn.subGroupDetail

destMidVar13.RGroupKey = srcMidVar22.rGroupKey

destMidVar13.EffectiveTime = formatDate(srcMidVar22.effectiveTime, Constant4Model.DATE_FORMAT)

destMidVar13.ExpirationTime = formatDate(srcMidVar22.expirationTime, Constant4Model.DATE_FORMAT)

destMidVar13.Status = srcMidVar22.status

destMidVar13.StatusDetail = srcMidVar22.statusDetail

def destMidVar14 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.SubGroupInfo.SubGroupBasicInfo

destMidVar14.SubGroupName = srcMidVar21.groupName

def srcMidVar23 = srcReturn.subGroupDetail.createGroupInfo

mappingList(srcMidVar23.properties,destMidVar14.SubGroupProperty,listMapping32)

destMidVar13.SubGroupClass = srcMidVar21.groupClass

destMidVar13.SubGroupCode = srcMidVar21.groupCode

def destMidVar15 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.SubGroupInfo.UserCustomer.CustInfo.CustBasicInfo

def srcMidVar24 = srcReturn.subGroupDetail.createCustomerInfo.customerInfo

destMidVar15.CustLevel = srcMidVar24.custLevel

destMidVar15.CustLoyalty = srcMidVar24.custLoyalty

def srcMidVar25 = srcReturn.subGroupDetail.createCustomerInfo

mappingList(srcMidVar25.custProperties,destMidVar15.CustProperty,listMapping33)

destMidVar15.CustSegment = srcMidVar24.custSegment

destMidVar15.DFTCurrencyID = srcMidVar24.currencyId

destMidVar15.DFTBillCycleType = srcMidVar24.billCycleType

destMidVar15.DFTWrittenLang = srcMidVar24.custWLang

destMidVar15.DFTIVRLang = srcMidVar24.custPLang

destMidVar15.DFTPwd = srcMidVar24.custPwd

destMidVar15.DunningFlag = srcMidVar24.dunningFlag

def destMidVar16 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.SubGroupInfo.UserCustomer.CustInfo

destMidVar16.CustClass = srcMidVar24.custClass

destMidVar16.CustCode = srcMidVar24.custCode

destMidVar16.CustNodeType = srcMidVar24.custNodeType

destMidVar16.CustType = srcMidVar24.custType

mappingList(srcMidVar25.noticeSuppresses,destMidVar16.NoticeSuppress,listMapping34)

destMidVar16.ParentCustKey = srcMidVar24.parentCustKey

def destMidVar17 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.SubGroupInfo.UserCustomer

destMidVar17.CustKey = srcMidVar24.tpCustKey

destMidVar13.UserCustomer.IndividualInfo.Birthday=formatDate(srcMidVar25.individualInfo.birthday, Constant4Model.DATE_FORMAT)

def destMidVar18 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.SubGroupInfo.UserCustomer.IndividualInfo

def srcMidVar26 = srcReturn.subGroupDetail.createCustomerInfo.individualInfo

destMidVar18.Education = srcMidVar26.education

destMidVar18.Email = srcMidVar26.email

destMidVar18.Fax = srcMidVar26.fax

destMidVar18.FirstName = srcMidVar26.firstName

destMidVar18.Gender = srcMidVar26.gender

destMidVar18.HomePhone = srcMidVar26.homePhone

destMidVar18.HomeAddressKey = srcMidVar26.addrKey

destMidVar18.IDNumber = srcMidVar26.idNumber

destMidVar18.IDType = srcMidVar26.idType

destMidVar13.UserCustomer.IndividualInfo.IDValidity=formatDate(srcMidVar25.individualInfo.idValidity, Constant4Model.DATE_FORMAT)

mappingList(srcMidVar25.indvProperties,destMidVar18.IndividualProperty,listMapping35)

destMidVar18.LastName = srcMidVar26.lastName

destMidVar18.MaritalStatus = srcMidVar26.marriedStatus

destMidVar18.MiddleName = srcMidVar26.middleName

destMidVar18.MobilePhone = srcMidVar26.mobilePhone

destMidVar18.Nationality = srcMidVar26.nationality

destMidVar18.NativePlace = srcMidVar26.nativePlace

destMidVar18.Occupation = srcMidVar26.occupation

destMidVar18.OfficePhone = srcMidVar26.officePhone

destMidVar18.Race = srcMidVar26.race

destMidVar18.Salary = srcMidVar26.salary

destMidVar18.Title = srcMidVar26.title

def destMidVar19 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup.SubGroupInfo.UserCustomer.OrgInfo

def srcMidVar27 = srcReturn.subGroupDetail.createCustomerInfo.orgInfo

destMidVar19.IDNumber = srcMidVar27.idNumber

destMidVar19.IDType = srcMidVar27.idType

destMidVar13.UserCustomer.OrgInfo.IDValidity=formatDate(srcMidVar25.orgInfo.idValidity, Constant4Model.DATE_FORMAT)

destMidVar19.Industry = srcMidVar27.industry

destMidVar19.OrgEmail = srcMidVar27.orgEmail

destMidVar19.OrgAddressKey = srcMidVar27.addrKey

destMidVar19.OrgFaxNumber = srcMidVar27.orgFax

destMidVar19.OrgLevel = srcMidVar27.orgLevel

destMidVar19.OrgName = srcMidVar27.orgName

destMidVar19.OrgPhoneNumber = srcMidVar27.orgPhone

mappingList(srcMidVar25.orgProperties,destMidVar19.OrgProperty,listMapping36)

destMidVar19.OrgShortName = srcMidVar27.orgSName

destMidVar19.OrgSize = srcMidVar27.sizeLevel

destMidVar19.OrgType = srcMidVar27.orgType

destMidVar19.OrgWebSite = srcMidVar27.orgWeb

destMidVar19.SubIndustry = srcMidVar27.subIndustry

destMidVar13.UserCustomerKey = srcMidVar22.uCustKey

def destMidVar20 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup

destMidVar20.SubGroupKey = srcMidVar21.groupKey

destMidVar7.OrgName = srcMidVar11.orgName

mappingList(srcMidVar23.supplementaryOfferings,destMidVar20.SupplementaryOffering,listMapping68)

destMidVar10.Status = srcMidVar14.status

def listMapping106

listMapping106 = 
{
    src,dest  ->

		dest.StatusExpireTime=formatDate(src.statusExpireTime, Constant4Model.DATE_FORMAT)
	
	  dest.StatusIndex = src.statusIndex
	
	  dest.StatusName = src.statusName
	
}

def listMapping107

listMapping107 = 
{
    src,dest  ->

	dest.AccmType = src.accmTypeCode
	
	dest.AccmTypeName = src.accmTypeName
	
	dest.Amount = src.amount
	
	dest.BeginDate=formatDate(src.beginDate, Constant4Model.DATE_FORMAT)
	
	dest.CurrencyID = src.currencyID
	
	dest.EndDate=formatDate(src.endDate, Constant4Model.DATE_FORMAT)
	
	dest.MeasureID = src.measureID
	
	dest.UnitType = src.unitType
	
	dest.CumulativePreAmt = src.cumulativePreAmt
	
}

def listMapping_creditAmountL

listMapping_creditAmountL = 
{
    src,dest  ->

	dest.Amount = src.amount
	
	dest.CreditInstID = src.creditInstId
	
	dest.EffectiveTime=formatDate(src.effectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.ExpireTime=formatDate(src.expireTime,Constant4Model.DATE_FORMAT)
	
	dest.LimitClass = src.limitClass
	
}

def listMapping_acctCreditL

listMapping_acctCreditL = 
{
    src,dest  ->

	mappingList(src.creditAmountInfoList,dest.CreditAmountInfo,listMapping_creditAmountL)
	
	dest.CreditLimitType = src.creditLimitType
	
	dest.CreditLimitTypeName = src.creditLimitTypeName
	
	dest.CurrencyID = src.currencyId
	
	dest.TotalCreditAmount = src.totalCreditAmount
	
	dest.TotalRemainAmount = src.totalRemainAmount
	
	dest.TotalUsageAmount = src.totalUsageAmount

    dest.NoLimitFlag = src.noLimitFlag
	
}

def listMapping_balDetailL

listMapping_balDetailL = 
{
    src,dest  ->

	dest.Amount = src.amount
	
	dest.BalanceInstanceID = src.balanceInstanceId
	
	dest.EffectiveTime=formatDate(src.effectiveTime,Constant4Model.DATE_FORMAT)
	
	dest.ExpireTime=formatDate(src.expireTime,Constant4Model.DATE_FORMAT)
	
	dest.InitialAmount = src.initialAmount

	def srcMidVar_acctBalOri = src.acctBalOriginal
	
	def destMidVar_acctBalOri = dest.AcctBalOriginal
	
	destMidVar_acctBalOri.OriginalType = srcMidVar_acctBalOri.originalType
	
	destMidVar_acctBalOri.OriginalID = srcMidVar_acctBalOri.originalID

	destMidVar_acctBalOri.PurchaseSeq = srcMidVar_acctBalOri.purchaseSeq
	
	dest.LastUpdateTime = src.lastUpdateTime
}

def listMapping_acctBalL

listMapping_acctBalL = 
{
    src,dest  ->

	mappingList(src.balanceDetailList,dest.BalanceDetail,listMapping_balDetailL)
	
	dest.BalanceType = src.balanceType
	
	dest.BalanceTypeName = src.balanceTypeName
	
	dest.CurrencyID = src.currencyId
	
	dest.DepositFlag = src.depositFlag
	
	dest.RefundFlag = src.refundFlag
	
	dest.TotalAmount = src.totalAmount
	
        dest.ReservedAmount = src.reservedAmount
	
}

def listMapping_oStDetailL

listMapping_oStDetailL = 
{
    src,dest  ->

	dest.CurrencyID = src.currencyId
	
	dest.OutStandingAmount = src.outStandingAmount
	
}

def listMapping_oStandingL

listMapping_oStandingL = 
{
    src,dest  ->

	dest.BillCycleBeginTime = formatDate(src.billCycleBeginTime,Constant4Model.DATE_FORMAT)
	
	dest.BillCycleEndTime = formatDate(src.billCycleEndTime,Constant4Model.DATE_FORMAT)
	
	dest.BillCycleID = src.billCycleId
	
	dest.DueDate = formatDate(src.dueDate,Constant4Model.DATE_FORMAT)
	
	mappingList(src.outStandingDetailList,dest.OutStandingDetail,listMapping_oStDetailL)
	
}

def listMapping_acctL

listMapping_acctL = 
{
    src,dest  ->

	mappingList(src.accountCreditList,dest.AccountCredit,listMapping_acctCreditL)
	
	mappingList(src.acctBalanceList,dest.BalanceResult,listMapping_acctBalL)
	
	dest.AcctKey = src.acctKey
	
	mappingList(src.outStandingList,dest.OutStandingList,listMapping_oStandingL)
	
}

def listMapping_Offer

listMapping_Offer = 
{
    src,dest  ->

	dest.PurchaseSeq = src.pSeq
	dest.OfferingName = src.offeringName
    dest.OfferingCode = src.oCode
	dest.OfferingID = src.oId
}

def listMapping_ShareUL

listMapping_ShareUL = 
{
    src,dest  ->

	dest.FreeUnitType = src.freeUnitType
	
	dest.MeasureUnit = src.measureUnit
	
    def oKeyExt = src.offeringKey
    oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	listMapping_Offer.call(oKeyExt,dest.OfferingKey)
	
	dest.SharedPrimaryIdentity = src.sharedPrimaryIdentity
	
	dest.UsedAmount = src.usedAmount
	
}

def listMapping_FUDetail

listMapping_FUDetail = 
{
    src,dest  ->

	dest.InitialAmount = src.initialAmount
	
	dest.LastRollOveredTime=formatDate(src.lastRollOveredTime, Constant4Model.DATE_FORMAT)
	
	dest.RollOverFlag = src.rollOverFlag

		dest.UsagePriority = src.usagePriority
	
	dest.CurrentAmount = src.currentAmount
	
	dest.EffectiveTime=formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpireTime=formatDate(src.expireTime, Constant4Model.DATE_FORMAT)
	
	dest.FreeUnitInstanceID = src.freeUnitInstanceId

	dest.AlreadyRollOverTimes = src.alreadyRollOverTimes

	dest.ReserveValidTime=formatDate(src.reserveValidTime, Constant4Model.DATE_FORMAT)
	
	def destMidVar_Offer = dest.FreeUnitOrigin.OfferingKey
	
    def oExtKey = src.offeringKey
    oExtKey._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar_Offer.OfferingID = oExtKey.oId
    destMidVar_Offer.OfferingCode = oExtKey.oCode
	destMidVar_Offer.OfferingName = oExtKey.offeringName
	destMidVar_Offer.PurchaseSeq = oExtKey.pSeq
	
	def destMidVar_FUOri = dest.FreeUnitOrigin
	
	destMidVar_FUOri.OriginType = src.originType
	
	destMidVar_FUOri.PlanID = src.planId

		destMidVar_FUOri.RenewFlag = src.renewFlag

		destMidVar_FUOri.AlreadyRenewTimes = src.alreadyRenewTimes

		destMidVar_FUOri.MaxRenewTimes = src.maxRenewTimes
}

def listMapping_MemUL

listMapping_MemUL = 
{
    src,dest  ->

	dest.PrimaryIdentity = src.primaryIdentity
	
	dest.SubscriberKey = src.subscriberKey
	
	dest.UsedAmount = src.usedAmount
	
}

def listMapping_FUPaymentPlan

listMapping_FUPaymentPlan =
		{
			src,dest  ->

				dest.FreeUnitInstanceID= src.freeUnitInstanceID

				dest.FreeUnitCycleType = src.freeUnitCycleType

				dest.FreeUnitUSRuleID = src.freeUnitUSRuleID

				dest.TimeSchemaID = src.timeSchemaID

				dest.MaxUsageAmt = src.maxUsageAmt

				dest.UsageAmt = src.usageAmt
		}


def listMapping_FUItem

listMapping_FUItem = 
{
    src,dest  ->

	dest.TotalUnusedAmount = src.totalUnusedAmount
	
	dest.TotalInitialAmount = src.totalInitialAmount
	
	dest.MeasureUnitName = src.measureUnitName
	
	dest.MeasureUnit = src.measureUnit
	
	dest.FreeUnitTypeName = src.freeUnitTypeName
	
	dest.FreeUnitType = src.freeUnitType
	
	mappingList(src.freeUnitItemDetailList,dest.FreeUnitItemDetail,listMapping_FUDetail)
	
	mappingList(src.memberFUUsageInfoWSList,dest.MemberUsageList,listMapping_MemUL)

	mappingList(src.fUPaymentPlanList.fUPaymentPlanList,dest.FUPaymentPlanList.FUPaymentPlanInfo,listMapping_FUPaymentPlan)
}

def listMappingLimitParam

listMappingLimitParam = 
{
    src,dest  ->

	dest.ParamCode = src.paramCode
	
	dest.ParamValue = src.paramValue
	
}

def listMappingLimitUsageList

listMappingLimitUsageList = 
{
    src,dest  ->

	dest.LimitType = src.limitType
	
	dest.LimitTypeName = src.limitTypeName
	
	dest.Amount = src.amount
	
	dest.EndDay = formatDate(src.endDay, Constant4Model.DATE_FORMAT)
	
	dest.BeginDate = formatDate(src.beginDate, Constant4Model.DATE_FORMAT)
	
	dest.MeasureType = src.measureType
	
	dest.MeasureID = src.measureId
	
	dest.CurrencyID = src.currencyId
	
	dest.LimitCtrlType = src.limitCtrlType
	
	dest.UsageAmount = src.usageAmount

	dest.EffectiveTime = formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)

	dest.ExpireTime = formatDate(src.expireTime, Constant4Model.DATE_FORMAT)

	if(isNotNull(src.limitCtrlAction))
	{
		dest.LimitCtrlAction = src.limitCtrlAction
	}

	addingList(src.limitParam,dest.LimitParam,listMappingLimitParam)
}

def listMapping109

listMapping109 =
        {
            src, dest ->

                dest.SubGroupKey = src.subGroupKey

                dest.SubGroupCode = src.subGroupCode

                dest.SubGroupType = src.subGroupType

                dest.MemberTypeCode = src.memberTypeCode

                dest.MemberShortNo = src.memberShortNo

                dest.MemberStatus = src.memberStatus

                dest.EffectiveTime = formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)

                dest.ExpirationTime = formatDate(src.expirationTime, Constant4Model.DATE_FORMAT)

                mappingList(src.memberPropertyList, dest.MemberProperty, listMapping10)
        }

def listMapping_OfferPayRel
listMapping_OfferPayRel =
		{
			src,dest  ->
				dest.OfferingID = src.oId
				dest.OfferingCode = src.oCode
				dest.PurchaseSeq = src.pSeq
		}
def listMapping_PayRelExt
listMapping_PayRelExt =
		{
			src,dest  ->
				dest.AcctKey = src.acctKey
				dest.DefaultPayFlag = src.defaultPayFlag
				dest.PayObjCode = src.payObjCode
				dest.PayObjKey = src.payObjKey
				dest.PayObjType = src.payObjType
				def destMidVar_PayRule = dest.PayRelExtRule
				def srcMidVar_Info = src.paymentRelationInfo
				destMidVar_PayRule.ChargeCode = srcMidVar_Info.chargeCode
				destMidVar_PayRule.ControlRule = srcMidVar_Info.extRuleCode
				def oKeyExt =srcMidVar_Info.offeringKey
				oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
				listMapping_OfferPayRel.call(oKeyExt,destMidVar_PayRule.OfferingKey)
				dest.PaymentLimitKey = srcMidVar_Info.paymentLimitKey
				dest.PayRelationKey = srcMidVar_Info.paymentRelationKey
				dest.Priority = srcMidVar_Info.priority
				dest.OriginKey = srcMidVar_Info.srcObjKey
				dest.OriginType = srcMidVar_Info.srcObjType
				dest.EffectiveTime=formatDate(src.effDate, Constant4Model.DATE_FORMAT)
				dest.ExpirationTime=formatDate(src.expDate, Constant4Model.DATE_FORMAT)
				dest.OnlyPayRelFlag = srcMidVar_Info.finalFlag
				dest.UsageAmount = src.usageAmount
				dest.LimitValueExprResult = src.limitValueExprResult
		}
def listMapping_PayLmt
listMapping_PayLmt =
		{
			src,dest  ->
				def destMidVar_LmtInfo = dest.PaymentLimitInfo
				destMidVar_LmtInfo.CBonusFlag = src.cBonusFlag
				destMidVar_LmtInfo.CurrencyID = src.currencyId
				def destMidVar_lmt = dest.PaymentLimitInfo.Limit
				destMidVar_lmt.LimitMeasureUnit = src.limitMeasureUnit
				destMidVar_LmtInfo.LimitCycleType = src.limitCycleType
				destMidVar_LmtInfo.LimitRule = src.limitRule
				destMidVar_lmt.LimitType = src.limitType
				destMidVar_lmt.LimitValue = src.limitValue
				destMidVar_lmt.LimitValueExpr = src.extendExprCode
				destMidVar_lmt.LimitValueType = src.limitValueType
				dest.PaymentLimitKey = src.limitKey
		}
def listMapping_PayRel
listMapping_PayRel =
		{
			src,dest  ->
				mappingList(src.paymentRelationExtList,dest.PayRelation,listMapping_PayRelExt)
				mappingList(src.paymentLimitInfoList,dest.PaymentLimit,listMapping_PayLmt)
		}
def listMapping105

listMapping105 = 
{
   src,dest ->
   
   def srcMidVar47 = src.createSubscriberInfo.subscriberInfo
   
   dest.SubscriberKey = srcMidVar47.subscriberKey
   
   dest.PaymentMode = src.paymentMode
   
   mappingList(src.supplementOfferingList,dest.SupplementaryOffering,listMapping68)

   mappingList(src.loanLogDetailList,dest.LoanLogDetail,listMapping108)

   def destMidVar23 = dest.PrimaryOffering
   
   def srcMidVar35 = src.createSubscriberInfo.primaryOffering
   
   mappingList(srcMidVar35.productInsts,destMidVar23.ProductInst,listMapping40)
   
   mappingList(srcMidVar35.properties,destMidVar23.OfferingInstProperty,listMapping38)
   
   def srcMidVar34 = srcMidVar35.offeringInst
   
   destMidVar23.TrialEndTime=formatDate(srcMidVar34.trialEndTime, Constant4Model.DATE_FORMAT)

   destMidVar23.TrialStartTime=formatDate(srcMidVar34.trialStartTime, Constant4Model.DATE_FORMAT)
   
   destMidVar23.BundledFlag = srcMidVar34.bundleFlag

   destMidVar23.OfferingClass = srcMidVar34.offeringClass
   
   destMidVar23.Status = srcMidVar34.status
   
   def srcMidVar37 = srcMidVar35.offeringInst.offeringKey
   srcMidVar37._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
   def destMidVar24 = destMidVar23.OfferingKey
   destMidVar24.OfferingID = srcMidVar37.oId
   destMidVar24.OfferingCode = srcMidVar37.oCode
   destMidVar24.PurchaseSeq = srcMidVar37.pSeq
   
   def srcMidVar38 = srcMidVar35.offeringInst.parentOfferingKey
   srcMidVar38._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
   def destMidVar25 = destMidVar23.ParentOfferingKey
   destMidVar25.OfferingID = srcMidVar38.oId
   destMidVar25.OfferingCode = srcMidVar38.oCode
   destMidVar25.PurchaseSeq = srcMidVar38.pSeq
   
   
   def destMidVar27 = dest.SubscriberInfo
   
   destMidVar27.ActiveTimeLimit=formatDate(src.createSubscriberInfo.subscriberInfo.activeTimeLimit, Constant4Model.DATE_FORMAT)
   
   destMidVar27.ActivationTime=formatDate(src.activeTime, Constant4Model.DATE_FORMAT)
   
   destMidVar27.StatusDetail = src.statusDetail
   
   def srcMidVar43 = src.createSubscriberInfo
   
   def srcMidVar42 = srcMidVar43.subBrandInfo
   
   destMidVar27.Brand = srcMidVar42.brand

	   mappingList(srcMidVar43.noticeSuppresses,dest.NoticeSuppress,listMapping76)

	   mappingList(srcMidVar43.noticeSuppresses,destMidVar27.NoticeSuppress,listMapping76)

   mappingList(srcMidVar43.consumptionLimits,destMidVar27.ConsumptionLimit,listMapping52)
   
   destMidVar27.NetworkType = srcMidVar47.networkType
   
   destMidVar27.Status = srcMidVar43.status
   
   destMidVar27.SubClass = srcMidVar47.subClass

   mappingList(srcMidVar43.subIdentities,destMidVar27.SubIdentity,listMapping55)

   destMidVar27.SubPassword = srcMidVar47.subPassword
   
   destMidVar27.UserCustomerKey = src.uCustKey
   
   
   def destMidVar28 = destMidVar27.SubBasicInfo

   destMidVar28.DunningFlag = srcMidVar47.dunningFlag

   destMidVar28.IVRLang = srcMidVar47.ivrLang

   destMidVar28.SubLevel = srcMidVar47.subLevel

   mappingList(srcMidVar43.subProperties,destMidVar28.SubProperty,listMapping54)

   destMidVar28.WrittenLang = srcMidVar47.writtenLang
   
   
   def destMidVar31 = destMidVar27.UserCustomer
   
   def srcMidVar49 = src.createCustomerInfo
   
   def srcMidVar48 = srcMidVar49.customerInfo

   destMidVar31.CustKey = srcMidVar48.tpCustKey
   
   def destMidVar30 = destMidVar31.CustInfo

   destMidVar30.CustClass = srcMidVar48.custClass

   destMidVar30.CustNodeType = srcMidVar48.custNodeType

   destMidVar30.CustCode = srcMidVar48.custCode

   destMidVar30.CustType = srcMidVar48.custType
   
   mappingList(srcMidVar49.noticeSuppresses,destMidVar30.NoticeSuppress,listMapping57)

   destMidVar30.ParentCustKey = srcMidVar48.parentCustKey
   
   
   def destMidVar29 = destMidVar30.CustBasicInfo
   
   destMidVar29.CustLevel = srcMidVar48.custLevel

   destMidVar29.CustLoyalty = srcMidVar48.custLoyalty

   destMidVar29.CustSegment = srcMidVar48.custSegment

   destMidVar29.DFTBillCycleType = srcMidVar48.billCycleType

   destMidVar29.DFTCurrencyID = srcMidVar48.currencyId

   destMidVar29.DFTIVRLang = srcMidVar48.custPLang

   destMidVar29.DFTPwd = srcMidVar48.custPwd

   destMidVar29.DunningFlag = srcMidVar48.dunningFlag

   destMidVar29.DFTWrittenLang = srcMidVar48.custWLang
   
   mappingList(srcMidVar49.custProperties,destMidVar29.CustProperty,listMapping56)
   

   def destMidVar32 = destMidVar31.IndividualInfo
   
   def srcMidVar50 = srcMidVar49.individualInfo
   
   destMidVar32.Birthday=formatDate(srcMidVar50.birthday, Constant4Model.DATE_FORMAT)

   destMidVar32.Education = srcMidVar50.education

   destMidVar32.Email = srcMidVar50.email

   destMidVar32.Fax = srcMidVar50.fax

   destMidVar32.FirstName = srcMidVar50.firstName

   destMidVar32.Gender = srcMidVar50.gender

   destMidVar32.HomePhone = srcMidVar50.homePhone

   destMidVar32.IDNumber = srcMidVar50.idNumber

   destMidVar32.IDType = srcMidVar50.idType

   destMidVar32.IDValidity=formatDate(srcMidVar50.idValidity, Constant4Model.DATE_FORMAT)

   destMidVar32.HomeAddressKey = srcMidVar50.addrKey

   mappingList(srcMidVar49.indvProperties,destMidVar32.IndividualProperty,listMapping58)

   destMidVar32.LastName = srcMidVar50.lastName

   destMidVar32.MaritalStatus = srcMidVar50.marriedStatus

   destMidVar32.MiddleName = srcMidVar50.middleName

   destMidVar32.MobilePhone = srcMidVar50.mobilePhone

   destMidVar32.Nationality = srcMidVar50.nationality

   destMidVar32.NativePlace = srcMidVar50.nativePlace

   destMidVar32.Occupation = srcMidVar50.occupation

   destMidVar32.OfficePhone = srcMidVar50.officePhone

   destMidVar32.Race = srcMidVar50.race

   destMidVar32.Salary = srcMidVar50.salary

   destMidVar32.Title = srcMidVar50.title
   

   def destMidVar33 = destMidVar31.OrgInfo
   
   destMidVar33.IDValidity=formatDate(src.createCustomerInfo.orgInfo.idValidity, Constant4Model.DATE_FORMAT)
   
   def srcMidVar51 = srcMidVar49.orgInfo

   destMidVar33.IDNumber = srcMidVar51.idNumber

   destMidVar33.IDType = srcMidVar51.idType

   destMidVar33.Industry = srcMidVar51.industry

   destMidVar33.OrgAddressKey = srcMidVar51.addrKey

   destMidVar33.OrgEmail = srcMidVar51.orgEmail

   destMidVar33.OrgFaxNumber = srcMidVar51.orgFax

   destMidVar33.OrgLevel = srcMidVar51.orgLevel

   destMidVar33.OrgName = srcMidVar51.orgName

   destMidVar33.OrgPhoneNumber = srcMidVar51.orgPhone

   mappingList(srcMidVar49.orgProperties,destMidVar33.OrgProperty,listMapping59)

   destMidVar33.OrgShortName = srcMidVar51.orgSName

   destMidVar33.OrgType = srcMidVar51.orgType

   destMidVar33.OrgSize = srcMidVar51.sizeLevel

   destMidVar33.OrgWebSite = srcMidVar51.orgWeb

   destMidVar33.SubIndustry = srcMidVar51.subIndustry
   
   
   def destMidVar26 = destMidVar27.AddressInfo
   
   def srcMidVar41 = src.addressInfo
   
   destMidVar26.Address1 = srcMidVar41.addr1

   destMidVar26.Address10 = srcMidVar41.addr10

   destMidVar26.Address11 = srcMidVar41.addr11

   destMidVar26.Address12 = srcMidVar41.addr12

   destMidVar26.Address2 = srcMidVar41.addr2

   destMidVar26.Address3 = srcMidVar41.addr3

   destMidVar26.Address4 = srcMidVar41.addr4

   destMidVar26.Address5 = srcMidVar41.addr5

   destMidVar26.Address6 = srcMidVar41.addr6

   destMidVar26.Address7 = srcMidVar41.addr7

   destMidVar26.Address8 = srcMidVar41.addr8

   destMidVar26.Address9 = srcMidVar41.addr9

   destMidVar26.PostCode = srcMidVar41.postCode

   destMidVar26.AddressKey = srcMidVar41.tpAddrKey
   
   
   def destMidVar80 = dest.LifeCycleDetail
   
   def srcMidVar80 = src.lifeCycleDetail
   
   destMidVar80.CurrentStatusIndex = srcMidVar80.currentStatusIndex

   destMidVar80.FraudTimes = srcMidVar80.fraudTimes

   destMidVar80.RBlacklistStatus = srcMidVar80.rBlacklistStatus

   destMidVar80.StatusDetail = srcMidVar80.statusDetail

   mappingList(srcMidVar80.lifeCycleStatusList,destMidVar80.LifeCycleStatus,listMapping106)
   
   mappingList(src.accmUsageList,dest.AccmUsageList,listMapping107)
   
   mappingList(src.acctList,dest.AcctList,listMapping_acctL)
   
   def srcMidVar_FUInfo = src.freeUnitInfo
   
   def destMidVar_FUInfo = dest.FreeUnitInfo
   
   def srcMidVar_FUItemL = srcMidVar_FUInfo.freeUnitItemList
   
   def srcMidVar_ShareUL = srcMidVar_FUInfo.shareUsageList
   
   mappingList(srcMidVar_FUItemL.freeUnitItemList,destMidVar_FUInfo.FreeUnitItem,listMapping_FUItem)
   
   mappingList(srcMidVar_ShareUL.shareFUUsageInfoWSList,destMidVar_FUInfo.ShareUsageList,listMapping_ShareUL)

   def srcMidVar_limitUsageList = src.limitUsageList
   
   def destMidVar_LimitUsageList = dest.LimitUsageList

   mappingList(srcMidVar_limitUsageList.limitUsageList,destMidVar_LimitUsageList,listMappingLimitUsageList)

   dest.EffectiveTime=formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)
   dest.ExpireTime=formatDate(src.expireTime, Constant4Model.DATE_FORMAT)

   mappingList(src.memberBasicInfoList, dest.MemberBasicInfo, listMapping109)
   listMapping_PayRel.call(src.payRelationInfo, dest.PaymentRelationList)
}

def listMapping_OfferG

listMapping_OfferG = 
{
    src,dest  ->

	dest.PurchaseSeq = src.pSeq
	dest.OfferingName = src.offeringName
    dest.OfferingCode = src.oCode
	dest.OfferingID = src.oId
}

def listMapping_ShareULG

listMapping_ShareULG = 
{
    src,dest  ->

	dest.FreeUnitType = src.freeUnitType
	
	dest.MeasureUnit = src.measureUnit
	
    def oKeyExtSG = src.offeringKey
    oKeyExtG._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	listMapping_OfferG.call(oKeyExtSG,dest.OfferingKey)
	
	dest.SharedPrimaryIdentity = src.sharedPrimaryIdentity
	
	dest.UsedAmount = src.usedAmount
	
}

def listMapping_FUDetailG

listMapping_FUDetailG = 
{
    src,dest  ->

	dest.InitialAmount = src.initialAmount
	
	dest.LastRollOveredTime=formatDate(src.lastRollOveredTime, Constant4Model.DATE_FORMAT)
	
	dest.RollOverFlag = src.rollOverFlag

		dest.UsagePriority = src.usagePriority
	
	dest.CurrentAmount = src.currentAmount
	
	dest.EffectiveTime=formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpireTime=formatDate(src.expireTime, Constant4Model.DATE_FORMAT)
	
	dest.FreeUnitInstanceID = src.freeUnitInstanceId

	dest.AlreadyRollOverTimes = src.alreadyRollOverTimes

	dest.ReserveValidTime=formatDate(src.reserveValidTime, Constant4Model.DATE_FORMAT)

	def destMidVar_OfferFG = dest.FreeUnitOrigin.OfferingKey
	
    def oExtKeyFG = src.offeringKey
    oExtKeyFG._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar_OfferFG.OfferingID = oExtKeyFG.oId
    destMidVar_OfferFG.OfferingCode = oExtKeyFG.oCode
	destMidVar_OfferFG.OfferingName = oExtKeyFG.offeringName
	destMidVar_OfferFG.PurchaseSeq = oExtKeyFG.pSeq
	
	def destMidVar_FUOriG = dest.FreeUnitOrigin
	
	destMidVar_FUOriG.OriginType = src.originType
	
	destMidVar_FUOriG.PlanID = src.planId

	destMidVar_FUOriG.RenewFlag = src.renewFlag

	destMidVar_FUOriG.AlreadyRenewTimes = src.alreadyRenewTimes

	destMidVar_FUOriG.MaxRenewTimes = src.maxRenewTimes
}

def listMapping_MemULG

listMapping_MemULG = 
{
    src,dest  ->

	dest.PrimaryIdentity = src.primaryIdentity
	
	dest.SubscriberKey = src.subscriberKey
	
	dest.UsedAmount = src.usedAmount
	
}

def listMapping_FUItemG

listMapping_FUItemG = 
{
    src,dest  ->

	dest.TotalUnusedAmount = src.totalUnusedAmount
	
	dest.TotalInitialAmount = src.totalInitialAmount
	
	dest.MeasureUnitName = src.measureUnitName
	
	dest.MeasureUnit = src.measureUnit
	
	dest.FreeUnitTypeName = src.freeUnitTypeName
	
	dest.FreeUnitType = src.freeUnitType
	
	mappingList(src.freeUnitItemDetailList,dest.FreeUnitItemDetail,listMapping_FUDetailG)
	
	mappingList(src.memberFUUsageInfoWSList,dest.MemberUsageList,listMapping_MemULG)

	mappingList(src.fUPaymentPlanList.fUPaymentPlanList,dest.FUPaymentPlanList.FUPaymentPlanInfo,listMapping_FUPaymentPlan)
}
def destMidVar_Group = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.SubGroup

def destMidVar_FUInfoG = destMidVar_Group.FreeUnitInfo

def srcMidVar_Group = srcReturn.subGroupDetail

def srcMidVar_FUInfoG = srcMidVar_Group.freeUnitInfo
   
def srcMidVar_FUItemLG = srcMidVar_FUInfoG.freeUnitItemList
   
def srcMidVar_ShareULG = srcMidVar_FUInfoG.shareUsageList
   
mappingList(srcMidVar_FUItemLG.freeUnitItemList,destMidVar_FUInfoG.FreeUnitItem,listMapping_FUItemG)
   
mappingList(srcMidVar_ShareULG.shareFUUsageInfoWSList,destMidVar_FUInfoG.ShareUsageList,listMapping_ShareULG)

def listMapping_FUDetailC

listMapping_FUDetailC = 
{
    src,dest  ->

	dest.InitialAmount = src.initialAmount
	
	dest.LastRollOveredTime=formatDate(src.lastRollOveredTime, Constant4Model.DATE_FORMAT)
	
	dest.RollOverFlag = src.rollOverFlag

		dest.UsagePriority = src.usagePriority
	
	dest.CurrentAmount = src.currentAmount
	
	dest.EffectiveTime=formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)
	
	dest.ExpireTime=formatDate(src.expireTime, Constant4Model.DATE_FORMAT)
	
	dest.FreeUnitInstanceID = src.freeUnitInstanceId

	dest.AlreadyRollOverTimes = src.alreadyRollOverTimes

	dest.ReserveValidTime=formatDate(src.reserveValidTime, Constant4Model.DATE_FORMAT)

	def destMidVar_OfferFG = dest.FreeUnitOrigin.OfferingKey
	
    def oExtKeyFG = src.offeringKey
    oExtKeyFG._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
    
	destMidVar_OfferFG.OfferingID = oExtKeyFG.oId
    destMidVar_OfferFG.OfferingCode = oExtKeyFG.oCode
	destMidVar_OfferFG.OfferingName = oExtKeyFG.offeringName
	destMidVar_OfferFG.PurchaseSeq = oExtKeyFG.pSeq
	
	def destMidVar_FUOriG = dest.FreeUnitOrigin
	
	destMidVar_FUOriG.OriginType = src.originType
	
	destMidVar_FUOriG.PlanID = src.planId

	destMidVar_FUOriG.RenewFlag = src.renewFlag

	destMidVar_FUOriG.AlreadyRenewTimes = src.alreadyRenewTimes

	destMidVar_FUOriG.MaxRenewTimes = src.maxRenewTimes
}

def listMapping_MemULC

listMapping_MemULC = 
{
    src,dest  ->

	dest.PrimaryIdentity = src.primaryIdentity
	
	dest.SubscriberKey = src.subscriberKey
	
	dest.UsedAmount = src.usedAmount
	
}

def listMapping_FUItemC

listMapping_FUItemC = 
{
    src,dest  ->

	dest.TotalUnusedAmount = src.totalUnusedAmount
	
	dest.TotalInitialAmount = src.totalInitialAmount
	
	dest.MeasureUnitName = src.measureUnitName
	
	dest.MeasureUnit = src.measureUnit
	
	dest.FreeUnitTypeName = src.freeUnitTypeName
	
	dest.FreeUnitType = src.freeUnitType
	
	mappingList(src.freeUnitItemDetailList,dest.FreeUnitItemDetail,listMapping_FUDetailC)
	
	mappingList(src.memberFUUsageInfoWSList,dest.MemberUsageList,listMapping_MemULC)

	mappingList(src.fUPaymentPlanList.fUPaymentPlanList,dest.FUPaymentPlanList.FUPaymentPlanInfo,listMapping_FUPaymentPlan)
}
def destMidVar_CUST = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.Customer

def destMidVar_FUInfoC = destMidVar_CUST.FreeUnitInfo

def srcMidVar_CUST = srcReturn.customerDetail

def srcMidVar_FUInfoC = srcMidVar_CUST.freeUnitInfo
   
def srcMidVar_FUItemLC = srcMidVar_FUInfoC.freeUnitItemList
   
mappingList(srcMidVar_FUItemLC.freeUnitItemList,destMidVar_FUInfoC.FreeUnitItem,listMapping_FUItemC)
   
def destMidVar37 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult

mappingList(srcReturn.accountDetailList,destMidVar37.Account,listMapping48)

mappingList(srcReturn.subscriberDetailList,destMidVar37.Subscriber,listMapping105)

def srcMidVar12 = srcReturn.resultHeader

def destMidVar8 = destReturn.QueryCustomerInfoResultMsg.ResultHeader

mappingList(srcMidVar12.simpleProperty,destMidVar8.AdditionalProperty,listMapping10)

destMidVar8.MsgLanguageCode = srcMidVar12.msgLanguageCode

destMidVar8.ResultCode = srcMidVar12.resultCode

destMidVar8.ResultDesc = srcMidVar12.resultDesc

destMidVar8.Version = srcMidVar12.version

destMidVar8.MessageSeq = srcMidVar12.messageSeq

def destMidVar21 = destReturn.QueryCustomerInfoResultMsg.QueryCustomerInfoResult.Customer.SiteInfo

def srcMidVar_SiteInfo = srcReturn.customerDetail.siteInfo

destMidVar21.PrimarySite = srcMidVar_SiteInfo.primarySite

destMidVar21.SecondarySite = srcMidVar_SiteInfo.secondarySite

