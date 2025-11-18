#from datetime import datetime
#import numpy as np
#import pandas as pd
import json
import employee
import json_handler
import logging
logging.basicConfig(filename="activity.log",level=logging.DEBUG, format='%(asctime)s- %(name)s - %(levelname)s - %(message)s')

logging.info("Activity started")
def sign_up():
    logging.info("Sign up attempt")
    name = input("Enter your name: ")
    employees = json_handler.json_load("credentials.json")
    while True:
        username = input("username: ")
        if username in employees:
            print("Username already taken. Try again")
            logging.warning("Attempted duplicate username")
        else:
            break
    password = input("password: ")
    emp = employee.Employee(name, username, password)
    logging.info("User created successfully")

def login():
    logging.info("Login attempt")
    employees = json_handler.json_load("credentials.json")

    while True:
        username = input("Enter your username or '-1' to exit: ")
        if username =='-1':
            logging.info("login aborted")
            exit()
            break
        if username in employees:
            password = input("Enter your password: ")
            if employees[username] == password:
                logging.info("Login successful")
                return username
            else:
                print("Incorrect password")
                logging.info("Incorrect password")

        else:
            print("Incorrect username")
            logging.info("Incorrect username")

def actions():
    print("What would you like to do?")
    print("1. View expenses")
    print("2. Add expense")
    print("3. Log Out")
    action = input("Enter your choice 1-3: ")
    if action == "1":
        logging.info("Viewed expenses")
        print("view expenses")
    elif action == "2":
        logging.info("Added expense")
        print("add expense")
    elif action == "3":
        logging.info("Logged out")
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


