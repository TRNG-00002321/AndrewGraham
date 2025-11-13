dictionary1 = {"Name" : "Ram" ,
               "Age" : 23 ,
               "City" : "Salem",
               "Gender" : "Male"}

def dictionary_info(dictionary):
    for x in dictionary:
         print(x + " : " + str(dictionary[x]))
         
         
dictionary_info(dictionary1)