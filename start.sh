#!/bin/bash
# source /opt/rightel_cache_server/.venv/bin/activate

nohup /opt/projects/fastapi/crm_middleware/.venv/bin/python -m uvicorn main:app --host 0.0.0.0 --port 8001 --reload &
