import requests
import os
from lxml import etree
from utils import body
from string import Template
from datetime import datetime
from utils.soap_client import AR_soap_client
import xml.etree.ElementTree as ET


def queryBalance(data):
    data.msisdn=9210451762
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/QueryBalance.txt', 'r') as file:
        queryBalance_template = file.read()
    queryBalance_template = Template(queryBalance_template)
    queryBalance = queryBalance_template.substitute({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),"C_FREE_PAY_FLAG" : 0 if data.payFlag==1 else 1})
    return AR_soap_client.call_service('QueryBalance', queryBalance)
    

def generate_response(cbs_response) :
     root = ET.fromstring(cbs_response)
        namespaces = {
        'soapenv': 'http://schemas.xmlsoap.org/soap/envelope/',
        'bcs': 'http://www.huawei.com/bme/cbsinterface/bcservices',
        'cbs': 'http://www.huawei.com/bme/cbsinterface/cbscommon',
        'bcc': 'http://www.huawei.com/bme/cbsinterface/bccommon'
    }

        result_code = root.find('.//cbs:ResultCode', namespaces)
        result_desc = root.find('.//cbs:ResultDesc', namespaces)
        if result_code is not None and result_code.text == '0':
            payload= '''
                <Data>
                    <header>
                        <ACTION_ID>QueryAllBalance</ACTION_ID>
                        <REQUEST_ID>025202408035956840257</REQUEST_ID>
                        <returnMsg>Successful</returnMsg>
                        <returnCode>0</returnCode>
                    </header>
                    <body>
                        <AllBalanceDtoList>
                            <AllBalanceDto>
                                <IsShowExpTime>Y</IsShowExpTime>
                                <GrossBal>0</GrossBal>
                                <InitBal>-26843545600</InitBal>
                                <Comments>3G Internet|اینترنت همراه 3G/4G</Comments>
                                <EffDate>2024-08-02 16:44:43</EffDate>
                                <BalanceName>Internet</BalanceName>
                                <IsExchange>N</IsExchange>
                                <ExpDate>2024-09-01 16:44:43</ExpDate>
                                <UnitType>4</UnitType>
                                <BalanceType>28</BalanceType>
                                <IsShowBal>Y</IsShowBal>
                                <BalanceValue>-26843545600</BalanceValue>
                            </AllBalanceDto>
                            <AllBalanceDto>
                                <IsShowExpTime>Y</IsShowExpTime>
                                <GrossBal>0</GrossBal>
                                <InitBal>-21474836480</InitBal>
                                <Comments>3G Internet|اینترنت همراه 3G/4G</Comments>
                                <EffDate>2024-07-04 23:30:22</EffDate>
                                <BalanceName>Internet</BalanceName>
                                <IsExchange>N</IsExchange>
                                <ExpDate>2024-08-03 23:30:22</ExpDate>
                                <UnitType>4</UnitType>
                                <BalanceType>28</BalanceType>
                                <IsShowBal>Y</IsShowBal>
                                <BalanceValue>-1374152918</BalanceValue>
                            </AllBalanceDto>
                            <AllBalanceDto>
                                <IsShowExpTime>Y</IsShowExpTime>
                                <GrossBal>0</GrossBal>
                                <InitBal>0</InitBal>
                                <Comments>Local Currency|اعتبار ریالی باقی مانده</Comments>
                                <EffDate>2015-09-02 12:53:18</EffDate>
                                <BalanceName>Local Currency</BalanceName>
                                <IsExchange>N</IsExchange>
                                <ExpDate/>
                                <UnitType>1</UnitType>
                                <BalanceType>1</BalanceType>
                                <IsShowBal>Y</IsShowBal>
                                <BalanceValue>-185501</BalanceValue>
                            </AllBalanceDto>
                        </AllBalanceDtoList>
                    </body>
                </Data> 
            '''

        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail= result_desc.text)
