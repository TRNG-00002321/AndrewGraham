import pandas as pd
import csv

dataset = {"expense1" : {"date" : "2025-04-23",
                          "category" : "tech",
                          "amount": 100},
            "expense2" : {"date" : "monday",
                          "category" : "tech",
                          "amount": 100},
            }

expenses = pd.DataFrame(dataset)

expenses.to_csv('/Users/andrew/Desktop/Revature flask/Assignments/Tuesday/expenses.csv', index =True)

print(expenses)