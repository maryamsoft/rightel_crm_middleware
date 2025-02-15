
from loguru import logger
from datetime import datetime


filename="/var/log/cm/"+datetime.now().strftime("%Y-%m-%d")+".log"
# logger.remove()
logger.add(filename,rotation="00:00",format="{time:YYYY-MM-DD at HH:mm:ss} | {level} | {message}",enqueue=True)


def set_debug_mode():
    logger.remove()
    logger.add("debug.log", format="{time} {level} {message}", level="DEBUG")


