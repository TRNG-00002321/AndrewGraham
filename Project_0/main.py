#from datetime import datetime
#import numpy as np
#import pandas as pd
import json
import employee
import json_handler


def sign_up():
    name = input("Enter your name: ")
    employees = json_handler.json_load("employees.json")
    while True:
        username = input("username: ")
        if username in employees:
            print("Username already taken. Try again")
        else:
            break
    password = input("password: ")
    emp = employee.Employee(name, username, password)

current_user = ""
def login():

    employees = json_handler.json_load("employees.json")

    while True:
        username = input("Enter your username or '-1' to exit: ")
        if username =='-1':
            break
        if username in employees:
            password = input("Enter your password: ")
            if employees[username] == password:
                current_user = username
                break
            else:
                print("Incorrect password")

        else:
            print("Incorrect username")



# employee1 = employee.Employee("John Doe", "JDoe", "Password123")
# print(employee1.login("JDoe", "Password123"))
#
# employee1.add_expense("Expense 1", 100, "Description 1", "2020-05-14", "pending")
# print(employee1.expense_report)
# print(employee1.check_expense_status("Expense 1"))

while True:
    task = input("login or sign up: ")
    if task == "login":
        print(login())
    elif task == "sign up":
        sign_up()
    else:
        break


    break
