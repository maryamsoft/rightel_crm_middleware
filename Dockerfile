FROM python:3.11-bookworm

# Set the working directory
ENV PYTHONUNBUFFERED 1

COPY requirements.txt requirements.txt
RUN pip install -r ./requirements.txt

# Get the fastapi project into the docker container
RUN mkdir /opt/project

COPY . /opt/project
WORKDIR /opt/project

# Expose the port the app runs on
EXPOSE 8000

# Serve the app
CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000", "--reload"]