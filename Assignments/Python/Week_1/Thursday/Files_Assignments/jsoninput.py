import json
name = input("Enter your name: ")
age = int(input("Enter your age: "))
city = input("Enter your city: ")

info = {"name" : name,
        "age" : age,
        "city" : city}

with open("/Users/andrew/Desktop/revature python/week_1/Assignments/Thursday/Files_Assignments/info.json", "r") as file:
    if file is not None:
       content = json.load(file)
    



with open("/Users/andrew/Desktop/revature python/week_1/Assignments/Thursday/Files_Assignments/info.json", "a") as file:
    json.dump(info, file, indent=2)
    