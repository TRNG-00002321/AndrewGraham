import logging
logging.basicConfig(filename="activity.log",level=logging.DEBUG, format='%(asctime)s- %(name)s - %(levelname)s - %(message)s')

import sqlite3
from datetime import date
#import SQLite_handler

import employee


def view_actions(user:employee.Employee):
    action = ""
    while action !="5":
        print("What would you like to do?")
        print("1. View expenses")
        print("2. Add expense")
        print("3. Edit expense")
        print("4. Remove expense")
        print("5. Log Out")
        action = input("Enter your choice 1-5: ")
        if action == "1":
            #logging.info("Viewed expenses")
            print(user.view_all_expenses())
        elif action == "2":
            #logging.info("Added expense")
            expense = input("Enter your expense: ")
            amount = float(input("Enter your amount: "))
            desc = input("Enter your description: ")
            exp_date = date.today()
            user.add_expense(expense, amount, desc, exp_date)
        elif action == "3":
            #logging.info("Edited expense")

            user.edit_expense()
        elif action == "4":
            #logging.info("remove expense")

            user.remove_expense()
        elif action == "5":
            #logging.info("Logged out")
            print("logging out")
            exit()
        else:
            print("invalid choice")





logged_in = False
current_user = employee.Employee()
while not logged_in:
    print("login, sign up or ")
    task = input("type '-1' to quit: ")
    if task == "login":
        username = input("username: ")
        password = ""
        logged_in = current_user.login(username)



    elif task == "sign up":
        print("signup attempt")
        name = input("name: ")
        username = input("username: ")
        password = ""
        emp = employee.Employee(name,username,password)
        emp.signup(name, username)
    elif task == "-1":
        print("exiting")
        exit()
    else:
        print("invalid attempt")

if  logged_in:
    print(current_user)
    view_actions(current_user)






