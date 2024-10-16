
from loguru import logger

# Configure the logger (if necessary)
#logger.add(sys.stderr, format="{time:MMMM D, YYYY > HH:mm:ss!UTC} | {level} | {message}", serialize=False)
logger.add("logs/file_{time}.log",rotation="12:00",compression="zip",format="{time:MMMM D, YYYY > HH:mm:ss!UTC} | {level} | {message}",enqueue=True)

# You can add more configurations here as needed

# Optionally, create functions for log level setup (optional)
def set_debug_mode():
    logger.remove()
    logger.add("debug.log", format="{time} {level} {message}", level="DEBUG")


