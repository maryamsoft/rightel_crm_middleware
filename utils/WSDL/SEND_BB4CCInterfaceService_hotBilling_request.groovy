dest.setServiceOperation("bbf_BBFSoapServer", "ocs33hotBilling")

def srcArgs0 = src.payload._args[0]

def destRequestHeader = dest.payload._args[0]
def destHotBillingRequest = dest.payload._args[1]

destRequestHeader._class = "com.huawei.ngcbs.arm.bbf.webservice.domain.Ocs33RequestHeader"
destHotBillingRequest._class = "com.huawei.ngcbs.arm.bbf.webservice.domain.hotbilling.Ocs33HotBillingRequest"

def listMappingProperty

listMappingProperty =
        {
            src, dest ->

                dest.code = src.name

                dest.value = src.value

        }

def listMappingRecord

listMappingRecord =
        {
            src, dest ->

                dest.subscriberId = src.SubscriberID

                dest.acctId = src.AcctID

                dest.msisdn = src.Msisdn

                dest.billCycleId = src.BillCycleID

                dest.entityType = src.EntityType
        }

def srcMidRequestHeader = srcArgs0.HotBillingRequestMsg.RequestHeader

destRequestHeader.serialNo = srcMidRequestHeader.SerialNo
destRequestHeader.requestFrom = srcMidRequestHeader.RequestFrom
destRequestHeader.version = srcMidRequestHeader.Version
destRequestHeader.operatorId = srcMidRequestHeader.OperatorId
destRequestHeader.password = srcMidRequestHeader.Password
destRequestHeader.departmentId = srcMidRequestHeader.DepartmentId
destRequestHeader.language = srcMidRequestHeader.Language
mappingList(srcMidRequestHeader.Param, destRequestHeader.additionalPropertyList, listMappingProperty)
destRequestHeader.remark = srcMidRequestHeader.Remark
destRequestHeader.tenantId = srcMidRequestHeader.TenantId

def srcSessionEntitySecurity = srcMidRequestHeader.SessionEntity
def destReqHAccessSecurity = destRequestHeader.accessSecurity
destReqHAccessSecurity.loginSystemCode = srcSessionEntitySecurity.Name
destReqHAccessSecurity.sysword = srcSessionEntitySecurity.Password
destReqHAccessSecurity.remoteIp = srcSessionEntitySecurity.RemoteAddress

def srcMidHotBillingRequest = srcArgs0.HotBillingRequestMsg.HotBillingRequest
destHotBillingRequest.requestType = srcMidHotBillingRequest.RequestType
destHotBillingRequest.tradeType = srcMidHotBillingRequest.TradeType

mappingList(srcMidHotBillingRequest.BillTypeList.BillTypeRecord, destHotBillingRequest.billTypeList.billTypeRecords, listMappingRecord)