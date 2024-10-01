import os
from string import Template
from datetime import datetime
from utils.soap_client import soap_client



def ChangeSubOffering(data):
    # get current path
    app_path = os.path.dirname(os.path.abspath(__file__))
    with open(app_path+'/templates/payloads/ChangeSubOffering.txt', 'r') as file:
        changeSubOffering_template = file.read()
    changeSubOffering_template = Template(changeSubOffering_template)
    changeSubOffering = changeSubOffering_template.substitute({**data.__dict__,"datetime":datetime.now().strftime("%Y-%m-%dT%H:%M:%S"),"C_FREE_PAY_FLAG" : 0 if data.payFlag==1 else 1})
    soap_client.call_service('ChangeSubOffering', changeSubOffering)
    

