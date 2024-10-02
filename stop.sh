#!/bin/bash
PID=$(pgrep -f "uvicorn main:app")
if [ -n "$PID" ]; then
kill $PID
echo "fastapi-app stopped"
else
echo "fastapi-app is not running"
fi