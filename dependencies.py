from database import SessionLocal_mysql, mysql_engine
# from database import SessionLocal_mysql, oracle_bigpro_engine_offline
from database import oracle_bigpro_engine

# # customer.Base.metadata.create_all(bind=engine)
# # payg.Base.metadata.create_all(bind=engine)
# scores_model.Base.metadata.create_all(bind=mysql_engine)

def get_database_mysql():
    try:
        db = SessionLocal_mysql()
        yield db
    finally:
        db.close()
        
        
        
        