dest.setServiceOperation("CustomerService", "changeFUPaymentLimitUsage")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.customer.changefupaymentlimitusage.ChangeFUPaymentLimitUsageRequest"

def listMapping0

listMapping0 =
        {
            src,dest  ->

                dest.code = src.Code

                dest.value = src.Value

        }

def listMapping1

listMapping1 =
        {
            src,dest  ->

                dest.primaryIdentity = src.PrimaryIdentity

                dest.subscriberKey = src.SubscriberKey

        }

def listMapping2

listMapping2 =
        {
            src,dest  ->

                dest.groupKey = src.SubGroupKey

                dest.groupCode = src.SubGroupCode

        }

def listMapping3

listMapping3 =
        {
            src,dest  ->

                dest.customerCode = src.CustomerCode

                dest.customerKey = src.CustomerKey

                dest.primaryIdentity = src.PrimaryIdentity

        }
def srcMidVar1 = srcArgs0.ChangeFUPaymentLimitUsageRequestMsg.ChangeFUPaymentLimitUsageRequest

listMapping1.call(srcMidVar1.SubAccessCode,destArgs1.subAccessCode)

listMapping2.call(srcMidVar1.SubGroupAccessCode,destArgs1.groupAccessCode)

listMapping3.call(srcMidVar1.CustAccessCode,destArgs1.custAccessCode)

destArgs1.rscRelationKey = srcMidVar1.RscRelationKey

destArgs1.resetValue = srcMidVar1.ResetValue

mappingList(srcMidVar1.AdditionalProperty,destArgs1.simplePropertyList,listMapping0)

def srcMidVar2 = srcArgs0.ChangeFUPaymentLimitUsageRequestMsg.RequestHeader

destArgs0.version = srcMidVar2.Version

def srcMidVar3 = srcArgs0.ChangeFUPaymentLimitUsageRequestMsg.RequestHeader.TimeFormat

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.timeType = srcMidVar3.TimeType

def srcMidVar4 = srcArgs0.ChangeFUPaymentLimitUsageRequestMsg.RequestHeader.OwnershipInfo

destArgs0.brId = srcMidVar4.BRID

destArgs0.beId = srcMidVar4.BEID

def srcMidVar5 = srcArgs0.ChangeFUPaymentLimitUsageRequestMsg.RequestHeader.OperatorInfo

destArgs0.operatorId = srcMidVar5.OperatorID

destArgs0.channelId = srcMidVar5.ChannelID

destArgs0.messageSeq = srcMidVar2.MessageSeq

destArgs0.businessCode = srcMidVar2.BusinessCode

mappingList(srcMidVar2.AdditionalProperty, destArgs0.simpleProperty, listMapping0)

def srcMidVar6 = srcArgs0.ChangeFUPaymentLimitUsageRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar6.LoginSystemCode

destArgs0.password = srcMidVar6.Password

destArgs0.remoteAddress = srcMidVar6.RemoteIP

destArgs0.interMode = srcMidVar2.AccessMode

destArgs0.msgLanguageCode = srcMidVar2.MsgLanguageCode