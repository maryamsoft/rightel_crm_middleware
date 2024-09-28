
def create(instance, payload, db):
    try:
        request_instance = instance(**payload)
        db.add(request_instance)
        db.commit()
        db.refresh(request_instance)
        return request_instance
    except Exception as e:
        print(f'create_method_Error:{e}')

def read(instance, instance_id, db):
    row = db.query(instance).filter(instance.id==instance_id).first()
    if row:
        return row
    return None

def update(instance, instance_id, update_data, db):
    try:
        row = read(instance, instance_id, db)
        for key in update_data:
            setattr(row, key, update_data[key])
        db.add(row)
        db.commit()
        db.refresh(row)
        return row
    except Exception as e:
        print(f'update_method_error:{e}')