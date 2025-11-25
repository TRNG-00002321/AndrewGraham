import numpy as np
import pandas as pd
import json_handler
import logging
logging.basicConfig(filename="activity.log",level=logging.DEBUG, format='%(asctime)s- %(name)s - %(levelname)s - %(message)s')

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

#old login and sign in
    #login checking credentials
    # @staticmethod
    # def login(current_user, username, password):
    #     credentials = json_handler.json_load("credentials.json")
    #     employees = json_handler.json_load("employees.json")
    #     while True:
    #         #username = input("Enter your username or '-1' to exit: ")
    #         if username == '-1':
    #             logging.info("login aborted")
    #             exit()
    #         if username in credentials:
    #             #password = input("Enter your password: ")
    #             if credentials[username] == password:
    #                 logging.info("Login successful")
    #
    #                 return username
    #             else:
    #                 print("Incorrect password")
    #                 logging.info("Incorrect password")
    #                 #username = input("Enter your username or '-1' to exit: ")
    #                 password = input("Enter your password:")
    #
    #         else:
    #             print("Incorrect username")
    #             logging.info("Incorrect username")
    #             username = input("Enter your username or '-1' to exit: ")
    #             #password = input("Enter your password:")

#old sign in
    # def sign_up(self):
    #
    #     credentials = json_handler.json_load("credentials.json")
    #     while True:
    #         if self.username in credentials:
    #             print("Username already taken. Try again")
    #             self.username = input("Username: ")
    #         else:
    #             break
    #     self.__password = input("Password: ")
    #     logging.info("Sign up successful")
    #     credentials[self.username] = self.__password
    #     json_handler.json_dump("credentials.json", credentials)
    #
    #     employees = json_handler.json_load("employees.json")
    #     employees[self.username] = [self.name, self.__password, self.expense_report]
    #     json_handler.json_dump("employees.json", employees)

    def sign_up2(self):
        employees = json_handler.json_load("employees.json")
        while True:
            if self.username in employees:
                print("Username already taken. Try again")
                self.username = input("Username: ")
            else:
                break
        self.__password = input("Password: ")
        #logging.info("Sign up successful")


        employees[self.username] = [self.name, self.__password, self.expense_report]
        json_handler.json_dump("employees.json", employees)

    @staticmethod
    def login2(current_user, username, password):
        employees = json_handler.json_load("employees.json")
        if not employees:
            print("Employees not found. Login failed")
            logging.error("Employees not found. Login failed")
            exit()
        #counter = 0
        while True:

            # username = input("Enter your username or '-1' to exit: ")
            if username == '-1':
                logging.info("login aborted")
                exit()
            if username in employees:

                for counter in range(3):
                    password = input("Enter your password: ")
                    if employees[username][1] == password:
                        logging.info("Login successful")
                        logged_in = True
                        return Employee(employees[username][0], username, password, employees[username][2])
                    else:
                        print("Incorrect password")
                        print(f"Number of incorrect tries {counter+1}")
                print("Login failed")
                break

            else:
                print("Incorrect username")
                logging.info("Incorrect username")
                username = input("Enter your username or '-1' to exit: ")
                # password = input("Enter your password:")



    #adding expenses
    def add_expense(self, expense: str, amount: int, description: str, date: str, status: str):
        employees = json_handler.json_load("employees.json")
        expenses = json_handler.json_load("expenses.json")
        self.expense_report[expense] = [self.username,  amount,  description,  date,  status]

        employees[self.username] = [self.name, self.__password, self.expense_report]
        json_handler.json_dump("employees.json", employees)
        expenses[expense] = [self.username, amount, description, date, status]
        json_handler.json_dump("expenses.json", expenses)

    def remove_expense(self, expense: str):
        expenses = json_handler.json_load("expenses.json")
        employees = json_handler.json_load("employees.json")

        if expense in expenses:
            expenses.pop(expense)
            json_handler.json_dump("expenses.json", expenses)
            self.expense_report.pop(expense)
            employees[self.username] = [self.name, self.__password, self.expense_report]
            json_handler.json_dump("employees.json", employees)
        else:
            print("Expense not found")
            logging.info("no expense removed")

    def check_expense_status(self):
        return self.expense_report
    def edit_expense(self, expense: str):
        employees = json_handler.json_load("employees.json")
        expenses = json_handler.json_load("expenses.json")
        if expense in expenses:
            print("Which expense field would you like to edit: ")
            print("1. expense name")
            print("2. expense amount")
            print("3. expense description")
            print("4. expense date")
            field = input()
            new_name = expense
            if field == "1":
                new_name = input("Enter new expense name: ")
                self.expense_report[new_name] = self.expense_report.pop(expense)
            elif field == "2":
                new_amount = input("Enter new expense amount: ")
                self.expense_report[expense][1] = new_amount
            elif field == "3":
                new_description = input("Enter new expense description: ")
                self.expense_report[expense][2] = new_description
            elif field == "4":
                new_date = input("Enter new expense date: ")
                self.expense_report[expense][3] = new_date
            else:
                print("Incorrect expense field")
                logging.info("no expense changed")

            employees[self.username] = [self.name, self.__password, self.expense_report]
            json_handler.json_dump("employees.json", employees)
            expenses.pop(expense)
            expenses[new_name] = [self.username, self.expense_report[new_name][0], self.expense_report[new_name][1], self.expense_report[new_name][2], self.expense_report[new_name][3]]
            json_handler.json_dump("expenses.json", expenses)



