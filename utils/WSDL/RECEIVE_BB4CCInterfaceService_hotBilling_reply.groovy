def srcReturn = src.payload._return
def destReturn = dest.payload._return

def srcMidResultHeader = srcReturn.resultHeader
def destMidResultHeader = destReturn.HotBillingResultMsg.ResultHeader
def destMidHotBillingResult = destReturn.HotBillingResultMsg.HotBillingResult


def listDefinition

listDefinition =
        {
            src, dest ->

                dest.SubscriberID = src.subscriberId
                dest.AcctID = src.acctId
                dest.Msisdn = src.msisdn
                dest.BillCycleID = src.billCycleId
                dest.EntityType = src.entityType
                dest.ReturnCode = src.returnCode
        }

destMidResultHeader.Language = srcMidResultHeader.language
destMidResultHeader.Version = srcMidResultHeader.version
destMidResultHeader.ResultDesc = srcMidResultHeader.resultDesc
destMidResultHeader.ResultCode = srcMidResultHeader.resultCode
destMidResultHeader.SerialNo = srcMidResultHeader.serialNo
destMidResultHeader.TenantId = srcMidResultHeader.tenantId
destMidResultHeader.Remark = srcMidResultHeader.remark

mappingList(srcReturn.authTypeList.authTypeRecords, destMidHotBillingResult.AuthTypeList.AuthTypeRecord, listDefinition)
