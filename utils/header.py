from datetime import datetime


def body_header_tag(method_name):
    return f'''
        <RequestHeader>
            <cbs:Version>1</cbs:Version>
            <cbs:BusinessCode>{method_name}</cbs:BusinessCode>
            <cbs:MessageSeq>{datetime.now()}</cbs:MessageSeq>
            <cbs:AccessSecurity>
            <cbs:LoginSystemCode>102</cbs:LoginSystemCode>
            <cbs:Password>7/PuyYwNpRtSX7jDpxnl2ECAvuVYH2Mu9zxqgPGJrPYYK73MCZN7DvrDepA=</cbs:Password>
            </cbs:AccessSecurity>
            <cbs:OperatorInfo>
            <cbs:OperatorID>101</cbs:OperatorID>
            </cbs:OperatorInfo>
        </RequestHeader>'''
        
        
def body_content_tag(data):
    C_FREE_PAY_FLAG = 0 if data.payFlag==1 else 1
    return f'''
        <ChangeSubOfferingRequest>
                    <bcs:SubAccessCode>
                    <bcc:PrimaryIdentity>{data.msisdn}</bcc:PrimaryIdentity>
                    </bcs:SubAccessCode>
                    <bcs:SupplementaryOffering>
                    <bcs:AddOffering>
                        <bcc:OfferingKey>
                            <bcc:OfferingCode>sms_rate_language</bcc:OfferingCode>
                            <bcc:PurchaseSeq>{data.offerCode}</bcc:PurchaseSeq>
                        </bcc:OfferingKey>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_CHANNEL_ID</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.channelId}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>C_FREE_FIRSTMRC</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{C_FREE_PAY_FLAG}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_PAY_FLAG</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.payFlag}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_AU</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.au}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_FIRST_AMOUNT</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.amount}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_BANK_ID</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.bankId}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcc:OInstProperty>
                            <bcc:PropCode>CN_CALLER_ID</bcc:PropCode>
                            <bcc:PropType>1</bcc:PropType>
                            <bcc:Value>{data.CallerID}</bcc:Value>
                        </bcc:OInstProperty>
                        <bcs:EffectiveTime>
                            <bcc:Mode>I</bcc:Mode>
                        </bcs:EffectiveTime>
                    </bcs:AddOffering>
                    </bcs:SupplementaryOffering>
                    <bcs:OperationCode>4052485</bcs:OperationCode>
                </ChangeSubOfferingRequest>'''