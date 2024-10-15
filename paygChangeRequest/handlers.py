import os
import xml.etree.ElementTree as ET
from string import Template
from datetime import datetime
from fastapi import HTTPException, status
from utils.soap_client import BC_soap_client
from utils import body 
from .schemas import PaygChangeRequest


def payg_change_request(data:PaygChangeRequest):
    pass
    

def generate_response(cbs_response) :
    pass


