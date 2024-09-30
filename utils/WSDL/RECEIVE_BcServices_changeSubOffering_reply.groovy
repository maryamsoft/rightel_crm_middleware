import com.huawei.ngcbs.bm.common.common.Constant4Model

def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping2

listMapping2 =
        {
            src, dest ->

                dest.Code = src.code

                dest.Value = src.value

        }

def listMapping_FreeUnitChange_Modify

listMapping_FreeUnitChange_Modify =
        {
            src,dest  ->

                dest.FreeUnitInstanceID = src.freeUnitInstanceId

                dest.FreeUnitType = src.freeUnitType

                dest.FreeUnitTypeName = src.freeUnitTypeName

                dest.MeasureUnit = src.measureUnit

                dest.MeasureUnitName = src.measureUnitName

                dest.NewAmt = src.newAmt

                dest.OldAmt = src.oldAmt
                
                dest.EffectiveTime = formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)
                
                dest.ExpireTime = formatDate(src.expireTime, Constant4Model.DATE_FORMAT)

        }

def listMapping_FreeUnitChangeList_Modify

listMapping_FreeUnitChangeList_Modify =
        {
            src,dest  ->

                dest.OwnerKey = src.ownerKey

                dest.OwnerType = src.ownerType

                mappingList(src.freeUnitChgInfoList, dest.FreeUnitChgInfo, listMapping_FreeUnitChange_Modify)

        }

def listMapping_balance_Modify

listMapping_balance_Modify = 
{
    src,dest  ->

	dest.BalanceID = src.balanceId
	
	dest.BalanceType = src.balanceType
	
	dest.BalanceTypeName = src.balanceTypeName
	
	dest.CurrencyID = src.currencyId
	
	dest.NewBalanceAmt = src.newBalanceAmt
	
	dest.OldBalanceAmt = src.oldBalanceAmt
	
  dest.EffectiveTime = formatDate(src.effectiveTime, Constant4Model.DATE_FORMAT)
                
  dest.ExpireTime = formatDate(src.expireTime, Constant4Model.DATE_FORMAT)
	
}

def listMapping_BanlanceInfo_Modify

listMapping_BanlanceInfo_Modify = 
{
    src,dest  ->

	dest.AcctKey = src.acctKey
	
	mappingList(src.balanceChgInfoList, dest.BalanceChgInfo, listMapping_balance_Modify)
	
}

def listMapping1

listMapping1 =
        {
            src, dest ->

                dest.NewEffectiveTime = formatDate(src.effDate, Constant4Model.DATE_FORMAT)

                dest.NewExpirationTime = formatDate(src.expDate, Constant4Model.DATE_FORMAT)

                def srcMidVar0 = src.offeringKey

                srcMidVar0._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

                def destMidVar1 = dest.OfferingKey

                destMidVar1.OfferingCode = srcMidVar0.oCode

                destMidVar1.OfferingID = srcMidVar0.oId

                destMidVar1.PurchaseSeq = srcMidVar0.pSeq
                
                mappingList(src.acctBalanceChangeInfoList,dest.AcctBalanceChangeList,listMapping_BanlanceInfo_Modify)

                mappingList(src.freeUnitChangeInfoList,dest.FreeUnitChangeList,listMapping_FreeUnitChangeList_Modify)
        }

def listMapping3

listMapping3 =
        {
            src, dest ->

                dest.EffectiveTime = formatDate(src.effDate, Constant4Model.DATE_FORMAT)

                dest.ExpirationTime = formatDate(src.expDate, Constant4Model.DATE_FORMAT)

                dest.RentDeductionStatus = src.deductionStatus

                def srcMidVar0 = src.offeringKey

                srcMidVar0._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

                def destMidVar1 = dest.OfferingKey

                destMidVar1.OfferingCode = srcMidVar0.oCode

                destMidVar1.OfferingID = srcMidVar0.oId

                destMidVar1.PurchaseSeq = srcMidVar0.pSeq

        }


def listMapping_balance

listMapping_balance = 
{
    src,dest  ->

	dest.BalanceID = src.balanceId
	
	dest.BalanceType = src.balanceType
	
	dest.BalanceTypeName = src.balanceTypeName
	
	dest.CurrencyID = src.currencyId
	
	dest.NewBalanceAmt = src.newBalanceAmt
	
	dest.OldBalanceAmt = src.oldBalanceAmt
	
}

def listMapping_BanlanceInfo

listMapping_BanlanceInfo = 
{
    src,dest  ->

	dest.AcctKey = src.acctKey
	
	mappingList(src.balanceChgInfoList,dest.BalanceChgInfo,listMapping_balance)
	
}


def listMapping_CreditLimitInfo

listMapping_CreditLimitInfo = 
{
    src,dest ->

	dest.AcctKey = src.acctKey
	
	dest.CreditInstID = src.creditInstId
	
	dest.CreditLimitType = src.creditLimitType
	
	dest.CurrencyID = src.currencyId
	
	dest.CurrentAmt = src.currentAmt
	
	dest.OriginLimitAmt = src.originLimitAmt
	
	dest.PaidAmt = src.paidAmt
	
	dest.AccmBeginDate=formatDate(src.accmBeginDate,Constant4Model.DATE_FORMAT)
	
	dest.AccmEndDate=formatDate(src.accmEndDate,Constant4Model.DATE_FORMAT)
	
}

def listMapping_FreeUnitChange

listMapping_FreeUnitChange =
        {
            src,dest  ->

                dest.FreeUnitInstanceID = src.freeUnitInstanceId

                dest.FreeUnitType = src.freeUnitType

                dest.FreeUnitTypeName = src.freeUnitTypeName

                dest.MeasureUnit = src.measureUnit

                dest.MeasureUnitName = src.measureUnitName

                dest.NewAmt = src.newAmt

                dest.OldAmt = src.oldAmt

        }



def listMapping_FreeUnitChangeList

listMapping_FreeUnitChangeList =
        {
            src,dest  ->

                dest.OwnerKey = src.ownerKey

                dest.OwnerType = src.ownerType

                mappingList(src.freeUnitChgInfoList,dest.FreeUnitChgInfo,listMapping_FreeUnitChange)

        }

def listMapping_FreeUnitChange_Rent

listMapping_FreeUnitChange_Rent =
        {
            src,dest  ->

                dest.FreeUnitInstanceID = src.freeUnitInstanceId

                dest.FreeUnitType = src.freeUnitType

                dest.FreeUnitTypeName = src.freeUnitTypeName

                dest.MeasureUnit = src.measureUnit

                dest.MeasureUnitName = src.measureUnitName

                dest.NewAmt = src.newAmt

                dest.OldAmt = src.oldAmt

                def srcMidVar0 = src.offeringKey

                srcMidVar0._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"

                def destMidVar1 = dest.OfferingKey

                destMidVar1.OfferingCode = srcMidVar0.oCode

                destMidVar1.OfferingID = srcMidVar0.oId

                destMidVar1.PurchaseSeq = srcMidVar0.pSeq
        }

def listMapping_FreeUnitChangeList_Rent

listMapping_FreeUnitChangeList_Rent =
        {
            src,dest  ->

                dest.OwnerKey = src.ownerKey

                dest.OwnerType = src.ownerType

                mappingList(src.freeUnitChgInfoList,dest.FreeUnitChgInfo,listMapping_FreeUnitChange_Rent)

        }
        
def destMidVar = destReturn.ChangeSubOfferingResultMsg.ResultHeader

def srcMidVar = srcReturn.resultHeader

destMidVar.Version = srcMidVar.version

destMidVar.MsgLanguageCode = srcMidVar.msgLanguageCode

destMidVar.ResultCode = srcMidVar.resultCode

destMidVar.ResultDesc = srcMidVar.resultDesc

destMidVar.MessageSeq = srcMidVar.messageSeq

//convert simpleProperty
mappingList(srcMidVar.simpleProperty, destMidVar.AdditionalProperty, listMapping2)


def destMidVar0 = destReturn.ChangeSubOfferingResultMsg.ChangeSubOfferingResult

mappingList(srcReturn.changeSubOfferingResultInfo.addOfferings, destMidVar0.AddOffering, listMapping3)


//convert rent Deduction info--begin
def srcMidVar_result = srcReturn.changeSubOfferingResultInfo

mappingList(srcReturn.changeSubOfferingResultInfo.modifiedOfferingInstInfoCMList, destMidVar0.ModifyOffering, listMapping1)

def srcMidVar_rent = srcMidVar_result.rentDeductionResultInfo

def destMidVar_Rent = destMidVar0.RentDeductionResult

mappingList(srcMidVar_rent.acctBalanceChangeInfoList,destMidVar_Rent.AcctBalanceChangeList,listMapping_BanlanceInfo)
mappingList(srcMidVar_rent.creditLmtChangeList,destMidVar_Rent.CreditLimitChangeList,listMapping_CreditLimitInfo)

mappingList(srcMidVar_rent.freeUnitChangeList,destMidVar_Rent.FreeUnitChangeList,listMapping_FreeUnitChangeList_Rent)


def srcMidVar_fee = srcMidVar_result.feeDeductionResultInfo

def destMidVar_Fee = destMidVar0.FeeDeductionResult

mappingList(srcMidVar_fee.acctBalanceChangeInfoList,destMidVar_Fee.AcctBalanceChangeList,listMapping_BanlanceInfo)
mappingList(srcMidVar_fee.creditLmtChangeList,destMidVar_Fee.CreditLimitChangeList,listMapping_CreditLimitInfo)

mappingList(srcMidVar_fee.freeUnitChangeList,destMidVar_Fee.FreeUnitChangeList,listMapping_FreeUnitChangeList)

//convert rent Deduction info--end