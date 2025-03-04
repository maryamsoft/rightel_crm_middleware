#!/bin/bash
# source /opt/rightel_cache_server/.venv/bin/activate

# nohup /opt/rightel_crm_middleware/.venv/bin/python -m uvicorn main:app --workers 20 --host 0.0.0.0 --port 8000 --reload&
#nohup  /opt/rightel_crm_middleware/.venv/bin/uvicorn  main:app --workers 20 --host 0.0.0.0 --port 8000 &
# nohup /opt/projects/fastapi/crm_middleware/.venv/bin/python -m uvicorn main:app --host 0.0.0.0 --port 8001 --reload &

source /opt/rightel_crm_middleware/.venv/bin/activate
nohup  /opt/rightel_crm_middleware/.venv/bin/uvicorn  main:app --workers 40 --host 0.0.0.0 --port 8000 --loop uvloop --http httptools 2> /dev/null &
