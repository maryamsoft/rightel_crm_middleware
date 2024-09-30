dest.setServiceOperation("BMOfferingService","changeOfferingProperty")

def srcArgs0 = src.payload._args[0]

def destArgs0 = dest.payload._args[0]

destArgs0._class = "com.huawei.ngcbs.bm.common.common.MessageHeader"

def destArgs1 = dest.payload._args[1]

destArgs1._class = "com.huawei.ngcbs.cm.offering.changeofferingproperty.io.ChangeOfferingPropertyRequest"

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

	mappingList(src.AdditionalProperty,dest.simpleProperty,listMapping1)
	
	def srcMidVar0 = src.AccessSecurity
	
	dest.loginSystem = srcMidVar0.LoginSystemCode
	
	dest.password = srcMidVar0.Password
	
	dest.remoteAddress = srcMidVar0.RemoteIP
	
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
	
	dest.interMode = src.AccessMode
	
}

def listMapping11

listMapping11 = 
{
    src,dest  ->

	dest.value = src.Value
	
	dest.code = src.SubPropCode
	
}

def listMapping10

listMapping10 = 
{
    src,dest  ->

	def srcMidVar4 = src.EffectiveTime
	
	dest.effMode = srcMidVar4.Mode
	
		dest.effDate=parseDate(srcMidVar4.Time, "yyyyMMddHHmmss")
	
		dest.expDate=parseDate(src.ExpirationTime, "yyyyMMddHHmmss")
	
	def destMidVar = dest.property
	
	destMidVar.propCode = src.PropCode
	
	destMidVar.complexFlag = src.PropType
	
	destMidVar.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar.subProps,listMapping11)
	
}

def listMapping13

listMapping13 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping12

listMapping12 = 
{
    src,dest  ->

	def srcMidVar5 = src.ExpirationTime
	
	dest.expMode = srcMidVar5.Mode
	
		dest.expDate=parseDate(srcMidVar5.Time, "yyyyMMddHHmmss")
	
	def destMidVar0 = dest.instProperty
	
	destMidVar0.propCode = src.PropCode
	
	destMidVar0.complexFlag = src.PropType
	
	destMidVar0.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar0.subProps,listMapping13)
	
}

def listMapping27

listMapping27 =
        {
            src, dest ->
                def destMidVar5 = dest.instProperty

                destMidVar5.propCode = src.PropCode

                destMidVar5.complexFlag = src.PropType

                destMidVar5.value = src.Value

                mappingList(src.SubPropInst, destMidVar5.subProps, listMapping13)

                dest.effDate = parseDate(src.EffectiveTime, "yyyyMMddHHmmss")

                dest.expDate = parseDate(src.ExpirationTime, "yyyyMMddHHmmss")
        }

def listMapping9

listMapping9 = 
{
    src,dest  ->

	mappingList(src.AddProperty,dest.addOfferingInstProperties,listMapping10)
	
	mappingList(src.DelProperty,dest.delOfferingInstProperties,listMapping12)

    mappingList(src.ModProperty, dest.modOfferingInstProperties, listMapping27)
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

	def srcMidVar6 = src.EffectiveTime
	
	dest.effMode = srcMidVar6.Mode
	
		dest.effDate=parseDate(srcMidVar6.Time, "yyyyMMddHHmmss")
	
		dest.expDate=parseDate(src.ExpirationTime, "yyyyMMddHHmmss")
	
	def destMidVar2 = dest.property
	
	destMidVar2.propCode = src.PropCode
	
	destMidVar2.complexFlag = src.PropType
	
	destMidVar2.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar2.subProps,listMapping19)
	
}

def listMapping21

listMapping21 = 
{
    src,dest  ->

	dest.code = src.SubPropCode
	
	dest.value = src.Value
	
}

def listMapping20

listMapping20 = 
{
    src,dest  ->

	def srcMidVar7 = src.ExpirationTime
	
	dest.expMode = srcMidVar7.Mode
	
		dest.expDate=parseDate(srcMidVar7.Time, "yyyyMMddHHmmss")
	
	def destMidVar3 = dest.instProperty
	
	destMidVar3.propCode = src.PropCode
	
	destMidVar3.complexFlag = src.PropType
	
	destMidVar3.value = src.Value
	
	mappingList(src.SubPropInst,destMidVar3.subProps,listMapping21)
	
}

def listMapping17

listMapping17 = 
{
    src,dest  ->

	mappingList(src.AddProperty,dest.addProperties,listMapping18)
	
	mappingList(src.DelProperty,dest.delProperties,listMapping20)
	
	dest.productId = src.ProductID
	
}

def listMapping22

listMapping22 = 
{
    src,dest  ->

	dest.oId = src.OfferingID
    dest.oCode = src.OfferingCode
	dest.pSeq = src.PurchaseSeq
	
}

def listMapping23

listMapping23 = 
{
    src,dest  ->

	dest.accoutCode = src.AccountCode
	
	dest.accoutKey = src.AccountKey
	
	dest.payType = src.PayType
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping24

listMapping24 = 
{
    src,dest  ->

	dest.customerCode = src.CustomerCode
	
	dest.customerKey = src.CustomerKey
	
	dest.primaryIdentity = src.PrimaryIdentity
	
}

def listMapping25

listMapping25 = 
{
    src,dest  ->

	dest.primaryIdentity = src.PrimaryIdentity
	
	dest.subscriberKey = src.SubscriberKey
	
}

def listMapping26

listMapping26 = 
{
    src,dest  ->

	dest.groupCode = src.SubGroupCode
	
	dest.groupKey = src.SubGroupKey
	
}

def listMapping16

listMapping16 = 
{
    src,dest  ->

	listMapping23.call(src.AcctAccessCode,dest.acctAccessCode)
	
	listMapping24.call(src.CustAccessCode,dest.custAccessCode)
	
	listMapping25.call(src.SubAccessCode,dest.subAccessCode)
	
	listMapping26.call(src.SubGroupAccessCode,dest.groupAccessCode)
	
}

def listMapping3

listMapping3 = 
{
    src,dest  ->

	listMapping9.call(src.OfferingInstProperty,dest.changeOfferingPropertyInfo)
	
	def destMidVar1 = dest.changeOfferingPropertyInfo
    
	def oKeyExt = destMidVar1.offeringKey
    oKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping22.call(src.OfferingKey,oKeyExt)
	
	mappingList(src.ProductInst,dest.changeProductPropertyInfoList,listMapping17)
	
	def destMidVar4 = dest.changeProductPropertyInfoList[0]
	
    def pOKeyExt = destMidVar4.offeringKey
    pOKeyExt._class = "com.huawei.ngcbs.cm.common.common.io.offering.OfferingKeyExtInfo"
	listMapping22.call(src.OfferingKey,pOKeyExt)
	
	listMapping16.call(src.OfferingOwner,dest.anyAccessCode)
	
}

def listMapping2

listMapping2 = 
{
    src,dest  ->

	mappingList(src.OfferingInst,dest.changeOfferingPropertyInfoList,listMapping3)
	
}


def srcMidVar = srcArgs0.ChangeOfferingPropertyRequestMsg

listMapping0.call(srcMidVar.RequestHeader,destArgs0)

listMapping2.call(srcMidVar.ChangeOfferingPropertyRequest,destArgs1)

def listMapping34
listMapping34 = 
{
    src,dest  ->

	dest.code = src.Code
	
	dest.value = src.Value
	
}

mappingList(srcMidVar.ChangeOfferingPropertyRequest.AdditionalProperty,destArgs1.simplePropertyList,listMapping34)

destArgs1.handlingChargeFlag = srcMidVar.ChangeOfferingPropertyRequest.HandlingChargeFlag
