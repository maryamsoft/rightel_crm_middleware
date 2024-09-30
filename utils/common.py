def is_do_service(string_of_xml):
    if 'doService>' in string_of_xml:
        return True
    
    else:
        return False