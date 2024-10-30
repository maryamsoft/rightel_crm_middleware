
from loguru import logger
from datetime import datetime
# Configure the logger (if necessary)
#logger.add(sys.stderr, format="{time:MMMM D, YYYY > HH:mm:ss!UTC} | {level} | {message}", serialize=False)
filename="logs/file_"+datetime.now().strftime("%Y-%m-%d")+".log"
logger.add(filename,rotation="00:00",compression="zip",format="{time:YYYY-MM-DD at HH:mm:ss} | {level} | {message}",enqueue=True)

# You can add more configurations here as needed

# Optionally, create functions for log level setup (optional)
def set_debug_mode():
    logger.remove()
    logger.add("debug.log", format="{time} {level} {message}", level="DEBUG")


