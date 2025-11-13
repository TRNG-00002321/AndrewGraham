dictionary1 = {"name" : "John",
               "age" : 35,
               "job" : "doctor"}


def key_check(dictionary, key_value):
    if key_value in dictionary:
        return "key is in dictionary"
    else:
        return "key is not in dictionary"
            
        
        
            
            
            
print(key_check(dictionary1, "name"))

