dictionary1 = {"name" : "Ram",
               "age" : 23}

add_key = {"city" : "Salem"}


def updateDict(dictionary, added_key):
    dictionary.update(added_key)
    
updateDict(dictionary1, add_key)

print(dictionary1)