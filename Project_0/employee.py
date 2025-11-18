from datetime import datetime
import numpy as np
import pandas as pd
import json_handler
#employee class
class Employee:
    #constructor
    def __init__(self, name, username, password):
        self.name = name
        self.username = username
        self.__password = password
        self.expense_report = {}

        employees = json_handler.json_load("employees.json")
        employees[username] = {name : self.expense_report}
        json_handler.json_dump("employees.json", employees)

        #add employee to credentials.json
        credentials = json_handler.json_load("credentials.json")
        credentials[username] = password
        json_handler.json_dump("credentials.json", credentials)
    #login checking credentials
    def login(self, username, password):
        if self.username == username and self.__password == password:
            return True
        else:
            return False
    #adding expenses
    def add_expense(self, expense: str, amount: int, description: str, date: str, status: str):
        self.expense_report[expense] = {"user" : self.username, "amount": amount, "description": description, "date": date, "status": status}

        json_handler.json_dump("expenses.json", self.expense_report)


    def check_expense_status(self, expense: str):
        return self.expense_report[expense]["status"]

