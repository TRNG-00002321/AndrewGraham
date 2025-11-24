import json_handler
import SQLite_handler
import logging

logging.basicConfig(filename="activity.log",level=logging.DEBUG, format='%(asctime)s- %(name)s - %(levelname)s - %(message)s')

conn = SQLite_handler.db_connect()
cursor = conn.cursor()


#employee class
class Employee:
    #constructor


    def __init__(self, name=None, username=None, password=None, report=None):
        self.name = name
        self.username = username
        self.__password = password
        if report is None:
            self.expense_report = {}
        else:
            self.expense_report = report

    def __str__(self):
        return f"Name: {self.name}, Username: {self.username}"

    def get_password(self):
        return self.__password

    def login(self, username):
        SQLite_handler.get_username(cursor, username)
        while cursor.fetchone() is None:
            print("Wrong username")
            username = input("Enter username: ")
            SQLite_handler.get_username(cursor, username)

        for x in range(3):
            password = input("Enter password: ")
            SQLite_handler.get_password(cursor, username)
            db_password = cursor.fetchone()[0]
            if db_password == password:
                print("Logged in")
                self.username = username
                self.__password = db_password
                SQLite_handler.get_name(cursor, username)
                self.name = cursor.fetchone()[0]
                return True

            else:
                print("Wrong password")
                print(f"{x+1} incorrect attempts")
        print("Login failed")
        return False

    def signup(self, name, username):
        SQLite_handler.get_username(cursor, username)
        db_username = cursor.fetchone()

        while db_username is not None:
            print("Username already exists")
            username = input("Enter username: ")
            SQLite_handler.get_username(cursor, username)
            db_username = cursor.fetchone()
        self.name = name
        self.username = username
        self.__password = input("Enter password: ")
        SQLite_handler.add_employee(cursor, self)
        conn.commit()

    def add_expense(self, expense, amount, desc, date):

            SQLite_handler.add_expense(cursor, self.username, expense, amount, desc, date, "Pending")
            conn.commit()



    def view_all_expenses(self):
        SQLite_handler.view_all_expenses(cursor, self.username)
        expenses = cursor.fetchall()
        return expenses

    def edit_expense(self):
        print(self.view_all_expenses())
        expense = input("Enter your expense: ")
        SQLite_handler.get_expense(cursor, self.username, expense)
        db_expense = cursor.fetchone()
        while db_expense is None:
            print("Expense does not exist")
            expense = input("Enter your expense: ")
            SQLite_handler.get_expense(cursor, self.username, expense)
            db_expense = cursor.fetchone()

        SQLite_handler.get_expense_status(cursor, self.username, db_expense[0])
        status = cursor.fetchall()[0]
        if status[0] == "Pending":
            fields=["expense", "exp_cost", "exp_desc"]
            print("1. Expense name")
            print("2. Expense amount")
            print("3. Expense description")
            task = input("What would you like to edit (1-3): ")
            if task == '1' or task == '2' or task == '3':
                value = input("Enter new value: ")



                SQLite_handler.edit_expense(cursor, self.username, db_expense[0], fields[int(task)-1], value)
                conn.commit()

            else:
                print("Invalid input")
        else:
            print("Expense no longer pending. Editing is not allowed.")

    def remove_expense(self):
        expense = input("Enter your expense: ")
        SQLite_handler.get_expense(cursor, self.username, expense)
        db_expense = cursor.fetchone()
        while db_expense is None:
            print("Expense does not exist")
            expense = input("Enter your expense: ")
            SQLite_handler.get_expense(cursor, self.username, expense)
            db_expense = cursor.fetchone()

        SQLite_handler.delete_expense(cursor, self.username, db_expense[0])
        conn.commit()