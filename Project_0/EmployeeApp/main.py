import logging
logging.basicConfig(filename="activity.log",level=logging.DEBUG, format='%(asctime)s- %(name)s - %(levelname)s - %(message)s')

import sqlite3
#import SQLite_handler

import employee


def view_actions(user:employee.Employee):
    action = ""
    while action !="6":
        print("What would you like to do?")
        print("1. View all expenses")
        print("2. View processed expenses")
        print("3. Add expense")
        print("4. Edit expense")
        print("5. Remove expense")
        print("6. Log Out")
        action = input("Enter your choice 1-6: ")
        if action == "1":

            user.view_all_expenses()
            logging.info("Viewed expenses")
        elif action == "2":
            user.view_processed_expenses()
            logging.info("Viewed processed expenses")
        elif action == "3":


            user.add_expense()
            logging.info("Added expense")
        elif action == "4":


            user.edit_expense()
            logging.info("Edited expense")
        elif action == "5":

            user.remove_expense()
            logging.info("remove expense")
        elif action == "6":
            logging.info("Logged out")
            print("logging out")
            exit()
        else:
            print("invalid choice")




logging.info("-----Activity Started-----")
logged_in = False
current_user = employee.Employee()
while not logged_in:
    print("1. Login")
    print("2. Sign up")
    print("3. Exit")
    task = input("What would you like to do? (1-3)")
    if task == "1":
        username = input("username: ")
        password = ""
        logged_in = current_user.login(username)
        logging.info(f"User {current_user.username} logged in")



    elif task == "2":
        print("signup attempt")
        name = input("name: ")
        username = input("username: ")
        password = ""
        emp = employee.Employee(name,username,password)
        emp.signup(name, username)
        logging.info(f"New user signed up")
    elif task == "3":
        print("exiting")
        logging.info("exiting")
        exit()
    else:
        print("invalid attempt")

if  logged_in:
    print(current_user)
    view_actions(current_user)






