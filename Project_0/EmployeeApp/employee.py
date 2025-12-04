#import json_handler
from numpy.matlib import empty
from sqlalchemy import values
from prettytable import PrettyTable
import SQLite_handler
import logging
from datetime import date


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

    def add_expense(self):
        expense = input("Enter your expense: ")
        amount = -1
        while amount <=0:
            amount = float(input("Enter your amount: "))
            if amount <= 0:
                print("value must be greater than 0")
        desc = input("Enter your description: ")
        exp_date = input("Enter your expense date (YYYY-MM-DD): ")
        valid_date = False
        while not valid_date:
            if len(exp_date)==10:
                if exp_date[0].isdigit() and exp_date[1].isdigit() and exp_date[2].isdigit() and exp_date[3].isdigit():
                    if exp_date[4] == "-" and exp_date[7] == "-":
                        if exp_date[5].isdigit() and exp_date[5].isdigit():
                            valid_date = True
            if not valid_date:
                exp_date = input("Incorrect format.\nEnter your expense date (YYYY-MM-DD): ")

        print("Enter expense category (1-5)")
        print("1. Food")
        print("2. Travel")
        print("3. Business")
        print("4. Personal")
        print("5. Other")
        category = input()
        SQLite_handler.add_expense(cursor, self.username, expense, amount, desc, exp_date, "Pending", category)
        conn.commit()

    def view_all_pending_expenses(self):
        SQLite_handler.view_all_pending_expenses(cursor, self.username)
        expenses = cursor.fetchall()
        if not expenses:
            return False
        table = PrettyTable()
        table.field_names = ["Expense", "Expense amount", "Expense description", "Expense date", "Expense status",
                             "Expense category"]
        for expense in expenses:
            table.add_row([expense[2], expense[3], expense[4], expense[5], expense[6], expense[7]])
            # print(f"Expense: {expense[2]}")
            # print(f"    Expense amount: ${expense[3]}")
            # print(f"    Expense description: {expense[4]}")
            # print(f"    Expense date: {expense[5]}")
            # print(f"    Status: {expense[6]}")
            # print(f"    Expense category: {expense[7]}")
        print(table)
        return True

    def view_all_expenses(self):
        SQLite_handler.view_all_expenses(cursor, self.username)
        expenses = cursor.fetchall()
        table = PrettyTable()
        table.field_names = ["Expense", "Expense amount", "Expense description", "Expense date", "Expense status","Expense category"]
        for expense in expenses:
            table.add_row([ expense[2], expense[3], expense[4], expense[5], expense[6], expense[7]])
            # print(f"Expense: {expense[2]}")
            # print(f"    Expense amount: ${expense[3]}")
            # print(f"    Expense description: {expense[4]}")
            # print(f"    Expense date: {expense[5]}")
            # print(f"    Status: {expense[6]}")
            # print(f"    Expense category: {expense[7]}")
        print(table)

    def edit_expense(self):
        if not self.view_all_pending_expenses():
            print("No pending expenses found.\n")
            return
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
            fields=["expense", "exp_cost", "exp_desc", "exp_date", "exp_category"]
            print("1. Expense name")
            print("2. Expense amount")
            print("3. Expense description")
            print("4. Expense date")
            print("5. Expense category")
            task = input("What would you like to edit (1-5): ")
            if task == '1':
                value = input("Enter new expense name: ")
                SQLite_handler.edit_expense(cursor, self.username, db_expense[0], fields[int(task) - 1], value)
            elif task == '2':
                value = input("Enter new expense amount: ")
                SQLite_handler.edit_expense(cursor, self.username, db_expense[0], fields[int(task) - 1], value)
            elif task == '3':
                value = input("Enter new expense description: ")
                SQLite_handler.edit_expense(cursor, self.username, db_expense[0], fields[int(task) - 1], value)
            elif task == '4':
                value = input("Enter your expense date (YYYY-MM-DD): ")
                valid_date = False
                while not valid_date:
                    if len(value) == 10:
                        if value[0].isdigit() and value[1].isdigit() and value[2].isdigit() and value[
                            3].isdigit():
                            if value[4] == "-" and value[7] == "-":
                                if value[5].isdigit() and value[5].isdigit():
                                    valid_date = True
                    if not valid_date:
                        value = input("Incorrect format.\nEnter your expense date (YYYY-MM-DD): ")
                SQLite_handler.edit_expense(cursor, self.username, db_expense[0], fields[int(task) - 1], value)

            elif task == '5':

                print("1. Food")
                print("2. Travel")
                print("3. Business")
                print("4. Personal")
                print("5. Other")
                while True:
                    try:
                        value = int(input("Enter new expense category (1-5): "))
                        if 0 < value < 6:
                            break
                        else:
                            print("Invalid input")
                    except ValueError:
                        print("invalid input")

                SQLite_handler.edit_expense(cursor, self.username, db_expense[0], fields[int(task) - 1], value)
            else:
                print("Invalid input")


            conn.commit()
        else:
            print("Expense no longer pending. Editing is not allowed.")

    def remove_expense(self):
        if not self.view_all_pending_expenses():
            print("No pending expenses found.\n")
            return
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

            SQLite_handler.delete_expense(cursor, self.username, db_expense[0])
            conn.commit()
        else:
            print("Expense no longer pending. Editing is not allowed.")


    def view_processed_expenses(self):
        SQLite_handler.view_all_processed_expenses(cursor, self.username)
        expenses = cursor.fetchall()

        table = PrettyTable()
        table.field_names = ["Expense", "Amount", "Employee", "Manager", "Status", "Comments"]

        for expense in expenses:
            table.add_row([expense[0], expense[1], expense[2], expense[3],expense[4], expense[5]])
            # print(f"Expense: {expense[0]}")
            # print(f"    Employee: {expense[1]}")
            # print(f"    Manager: {expense[2]}")
            # print(f"    Status: {expense[3]}")
            # print(f"    Comments: {expense[4]}")
        print(table)