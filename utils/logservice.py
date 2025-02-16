
from loguru import logger
from datetime import datetime

current_date  = datetime.now().strftime("%Y-%m-%d")
# filename="/var/log/cm/File_"+datetime.now().strftime("%Y-%m-%d")+".log"
filename= f"/var/log/cm/File_{current_date}.log"
# logger.remove()
logger.add(filename,rotation="00:00",format="{time:YYYY-MM-DD at HH:mm:ss} | {level} | {message}",enqueue=True)


def set_debug_mode():
    logger.remove()
    logger.add("debug.log", format="{time} {level} {message}", level="DEBUG")


