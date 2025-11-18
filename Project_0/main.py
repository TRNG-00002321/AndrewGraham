#from datetime import datetime
#import numpy as np
#import pandas as pd
import json
import employee
import json_handler


def sign_up():
    name = input("Enter your name: ")
    employees = json_handler.json_load("credentials.json")
    while True:
        username = input("username: ")
        if username in employees:
            print("Username already taken. Try again")
        else:
            break
    password = input("password: ")
    emp = employee.Employee(name, username, password)


def login():

    employees = json_handler.json_load("credentials.json")

    while True:
        username = input("Enter your username or '-1' to exit: ")
        if username =='-1':
            exit()
            break
        if username in employees:
            password = input("Enter your password: ")
            if employees[username] == password:
                return username
                break
            else:
                print("Incorrect password")

        else:
            print("Incorrect username")

def actions():
    print("What would you like to do?")
    print("1. View expenses")
    print("2. Add expense")
    print("3. Log Out")
    action = input("Enter your choice 1-3: ")
    if action == "1":
        print("view expenses")
    elif action == "2":
        print("add expense")
    elif action == "3":
        print("logging out")
        exit()


logged_in = False
current_user = ""
while True:


    while not logged_in:
        print("type '/exit' to exit")
        task = input("login or sign up: ")

        if task == "login":
            current_user = login()
            logged_in = True
            print(f"Logged in as {current_user}")
            break
        elif task == "sign up":
            sign_up()
        elif task =="/exit":
            exit()
        else:
            print("Invalid Input")


    actions()


