def srcReturn = src.payload._return

def destReturn = dest.payload._return

def listMapping1

listMapping1 = 
{
    src,dest  ->

	dest.Code = src.code
	
	dest.Value = src.value
	
}

def listMapping0

listMapping0 = 
{
    src,dest  ->

	dest.MsgLanguageCode = src.msgLanguageCode
	
	dest.ResultCode = src.resultCode
	
	dest.ResultDesc = src.resultDesc
	
	dest.Version = src.version

	dest.MessageSeq = src.messageSeq
	
	mappingList(src.simpleProperty,dest.AdditionalProperty,listMapping1)
	
}

def listMapping3

listMapping3 = 
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

def listMapping2

listMapping2 = 
{
    src,dest  ->

	dest.OwnerType = src.ownerType
	
	dest.OwnerKey = src.ownerKey
	
	mappingList(src.freeUnitChgInfoList,dest.FreeUnitChgInfo,listMapping3)
	
}


def destMidVar = destReturn.ChangeAcctInfoResultMsg

listMapping0.call(srcReturn.resultHeader,destMidVar.ResultHeader)

def destMidVar1 = destMidVar.ChangeAcctInfoResult

def srcMidVar1 = srcReturn.changeAccountBasicInfoResultInfo

mappingList(srcMidVar1.freeUnitChangeList,destMidVar1.FreeUnitChangeList,listMapping2)


