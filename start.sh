#!/bin/bash
# source /opt/rightel_cache_server/.venv/bin/activate

nohup /opt/rightel_crm_middleware/.venv/bin/python -m uvicorn main:app --host 0.0.0.0 --port 8000 --reload &
