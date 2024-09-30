import com.huawei.ngcbs.bm.common.common.Constant4Model

dest.setServiceOperation("AccountService", "changeAcctCreditLimit")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.account.changeacctcreditLimit.io.ChangeAcctCreditLimitRequest"

def listMapping0

listMapping0 =
        {
            src, dest ->

                dest.code = src.Code

                dest.value = src.Value

        }

def listMapping2

listMapping2 =
        {
            src, dest ->

                dest.accoutCode = src.AccountCode

                dest.accoutKey = src.AccountKey

                dest.payType = src.PayType

                dest.primaryIdentity = src.PrimaryIdentity

        }

def listMapping6

listMapping6 =
        {
            src, dest ->

                dest.customerCode = src.CustomerCode

                dest.customerKey = src.CustomerKey

                dest.primaryIdentity = src.PrimaryIdentity

        }

def listMapping3

listMapping3 =
        {
            src, dest ->
                dest._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreateCreditLimitExtInfo"
                dest.creditLimitType = src.CreditLimitType

                dest.limitPlanCode = src.LimitPlanCode

                def srcMidVar5 = src.EffectiveTime

                dest.effMode = srcMidVar5.Mode

                dest.limitAmount = src.LimitAmount

                dest.effDate = parseDate(srcMidVar5.Time, Constant4Model.DATE_FORMAT)

        }

def listMapping4

listMapping4 =
        {
            src, dest ->

                dest.creditLimitType = src.CreditLimitType

				dest.creditInstId = src.CreditInstID
	
                dest.expDate = parseDate(src.ExpirationTime, Constant4Model.DATE_FORMAT)

        }

def listMapping5

listMapping5 =
        {
            src, dest ->

                def destMidVar = dest.commonCreditLimitInfo

                def srcMidVar6 = src.CommonCreditLimit.EffectiveTime

                destMidVar.effMode = srcMidVar6.Mode

                destMidVar.effDate = parseDate(srcMidVar6.Time, Constant4Model.DATE_FORMAT)
                def destMidVar4 = destMidVar.creditLimitInfo
                destMidVar4._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitExtInfo"
                def destMidVar0 = destMidVar4.valueInfo

                def srcMidVar7 = src.CommonCreditLimit

                destMidVar0.amount = srcMidVar7.NewLimitAmount

                destMidVar4.limitPlanCode = srcMidVar7.NewLimitPlanCode

                def destMidVar1 = dest.tmpCreditLimitInfo

                def srcMidVar8 = src.TmpCreditLimit

                destMidVar1.creditValueInstId = srcMidVar8.CreditInstID

                def srcMidVar9 = src.TmpCreditLimit.EffectiveTime

                destMidVar1.effMode = srcMidVar9.Mode

                destMidVar1.effDate = parseDate(srcMidVar9.Time, Constant4Model.DATE_FORMAT)

                destMidVar1.expDate = parseDate(srcMidVar8.ExpirationTime, Constant4Model.DATE_FORMAT)

                destMidVar1.opType = srcMidVar8.OpType

                def destMidVar2 = dest.tmpCreditLimitInfo.creditLimitInfo.valueInfo
                if (!isNull(srcMidVar8)) {
                    destMidVar2._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitValueExtInfo"
                    destMidVar2.amount = srcMidVar8.NewTmpLimitAmount
                    destMidVar2.limitAmountType = srcMidVar8.NewTmpLimitAmountType
                }
                
                def destMidVar11 = dest.highPriorityTmpCreditLimit

                def srcMidVar10 = src.HighPriorityTmpCreditLimit

                def srcMidVar12 = src.HighPriorityTmpCreditLimit.EffectiveTime

                destMidVar11.effMode = srcMidVar12.Mode

                destMidVar11.effDate = parseDate(srcMidVar12.Time, Constant4Model.DATE_FORMAT)

                destMidVar11.expDate = parseDate(srcMidVar10.ExpirationTime, Constant4Model.DATE_FORMAT)

                destMidVar11.opType = srcMidVar10.OpType
				
				destMidVar11.creditValueInstId = srcMidVar10.CreditInstID

                def destMidVar13 = dest.highPriorityTmpCreditLimit.creditLimitInfo.valueInfo
                if (!isNull(srcMidVar10)) {
                    destMidVar13._class = "com.huawei.ngcbs.cm.common.common.io.creditlimit.CreditLimitValueExtInfo"
                    destMidVar13.amount = srcMidVar10.NewTmpLimitAmount
                    destMidVar13.limitAmountType = srcMidVar10.NewTmpLimitAmountType
                }
				
                dest.creditLimitType = src.CreditLimitType
        }

def listMapping1

listMapping1 =
        {
            src, dest ->

                def destMidVar3 = dest.subAccessCode

                def destMidVar5 = dest.additionalProperty

                def srcMidVar10 = src.SubAccessCode

                destMidVar3.primaryIdentity = srcMidVar10.PrimaryIdentity

                destMidVar3.subscriberKey = srcMidVar10.SubscriberKey
                listMapping2.call(src.AcctAccessCode, dest.acctAccessCode)

                listMapping6.call(src.CustAccessCode, dest.custAccessCode)

		mappingList(src.AddAccountCredit,dest.createCreditLimitInfoList,listMapping3)

		mappingList(src.DelAccountCredit,dest.delCreditLimitInfoList,listMapping4)

                mappingList(src.AccountCredit, dest.changeAcctCreditLimitInfoList, listMapping5)

                mappingList(src.AdditionalProperty, destMidVar5, listMapping0)

        }

def srcMidVar = srcArgs0.ChangeAcctCreditLimitRequestMsg.RequestHeader

destArgs0.interMode = srcMidVar.AccessMode

def srcMidVar0 = srcArgs0.ChangeAcctCreditLimitRequestMsg.RequestHeader.AccessSecurity

destArgs0.loginSystem = srcMidVar0.LoginSystemCode

destArgs0.password = srcMidVar0.Password

destArgs0.remoteAddress = srcMidVar0.RemoteIP

mappingList(srcMidVar.AdditionalProperty, destArgs0.simpleProperty, listMapping0)

destArgs0.businessCode = srcMidVar.BusinessCode

destArgs0.messageSeq = srcMidVar.MessageSeq

destArgs0.msgLanguageCode = srcMidVar.MsgLanguageCode

def srcMidVar1 = srcArgs0.ChangeAcctCreditLimitRequestMsg.RequestHeader.OperatorInfo

destArgs0.channelId = srcMidVar1.ChannelID

destArgs0.operatorId = srcMidVar1.OperatorID

def srcMidVar2 = srcArgs0.ChangeAcctCreditLimitRequestMsg.RequestHeader.OwnershipInfo

destArgs0.beId = srcMidVar2.BEID

destArgs0.brId = srcMidVar2.BRID

def srcMidVar3 = srcArgs0.ChangeAcctCreditLimitRequestMsg.RequestHeader.TimeFormat

destArgs0.timeType = srcMidVar3.TimeType

destArgs0.timeZoneId = srcMidVar3.TimeZoneID

destArgs0.version = srcMidVar.Version

def srcMidVar4 = srcArgs0.ChangeAcctCreditLimitRequestMsg

listMapping1.call(srcMidVar4.ChangeAcctCreditLimitRequest, destArgs1)
