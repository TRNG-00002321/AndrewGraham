
import json
import employee
import json_handler
import logging
import sqlite3
logging.basicConfig(filename="activity.log",level=logging.DEBUG, format='%(asctime)s- %(name)s - %(levelname)s - %(message)s')




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
            logging.info("Viewed expenses")
            print(user.check_expense_status())
        elif action == "2":
            logging.info("Added expense")
            expense = input("Enter your expense: ")
            amount = int(input("Enter your amount: "))
            desc = input("Enter your description: ")
            date = input("Enter your date (YYYY-MM-DD): ")
            user.add_expense(expense, amount, desc, date, "pending")
        elif action == "3":
            logging.info("Edited expense")
            expense = input("Enter your expense: ")
            user.edit_expense(expense)
        elif action == "4":
            logging.info("remove expense")
            expense = input("Enter your expense: ")
            user.remove_expense(expense)
        elif action == "5":
            logging.info("Logged out")
            print("logging out")
            exit()
        else:
            print("invalid choice")

########################## main code body ##########################
logging.info("-------Activity started-------")
logged_in = False
current_user = employee.Employee()
while not logged_in:
    task = input("login or sign up: ")
    if task == "login":
        username = input("username: ")
        password = ""
        logging.info("Login attempt")
        current_user = employee.Employee.login2(current_user,username,password)
        if current_user:
            logged_in = True


    elif task == "sign up":
        print("signup attempt")
        name = input("name: ")
        username = input("username: ")
        password = ""
        emp = employee.Employee(name,username,password)
        logging.info("Sign up attempt")
        emp.sign_up2()
    else:
        print("invalid attempt")

if logged_in:
    print(current_user)
    view_actions(current_user)

# conn = sqlite3.connect('jdbc:sqlite:sqlite.db')
# cursor = conn.cursor()
# cursor.execute('''
#     CREATE TABLE users (
#         id INTEGER PRIMARY KEY,
#         name TEXT,
#         age INTEGER
#     )
# ''')
# cursor.execute("INSERT INTO users (name, age) VALUES ('Alice', 30)")
#
# conn.commit()
#
# conn.close()


