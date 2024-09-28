
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker


#----------------------------MYSQL_CONNECTION----------------------------
mysql_connection = "mysql+mysqlconnector://dbUser:password@127.0.0.1:3306/crm_middleware_db"
mysql_engine = create_engine(mysql_connection)
SessionLocal_mysql = sessionmaker(autocommit=False, autoflush=False,bind=mysql_engine)
Base = declarative_base()
