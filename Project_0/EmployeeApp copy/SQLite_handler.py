import sqlite3

db_path = '/Users/andrew/Desktop/Revature/Project_0/my_database.db'

def db_connect():
    conn = sqlite3.connect(db_path)
    return conn

def add_employee(cursor, employee):
    cursor.execute("insert into employees values (?,?,?)", (employee.username, employee.get_password(), employee.name))



def get_username(cursor, username):
    cursor.execute("select username from employees where username = ?", (username,))
def get_password(cursor, username):
    cursor.execute("select password from employees where username = ?", (username,))

def get_name(cursor, username):
    cursor.execute("select name from employees where username = ?", (username,))

def add_expense(cursor, username, expense, amount, desc, date, status):
    cursor.execute("insert into expenses values(?,?,?,?,?,?)", (username, expense, amount, desc, date, status))

def edit_expense(cursor, username, expense, field, value):
    query = f"update expenses set {field} = ? where emp_username = ? and expense = ?"
    cursor.execute(query, (value, username, expense))

def view_all_expenses(cursor, username):
    cursor.execute("select * from expenses where emp_username = ?", (username,))

def get_expense(cursor, username, expense):
    cursor.execute("select expense from expenses where expense = ? and emp_username = ?", (expense,username))

def delete_expense(cursor, username, expense):
    cursor.execute("delete from expenses where expense = ? and emp_username = ? and exp_status = 'Pending'", (expense,username))

def get_expense_status(cursor, username, expense):
    cursor.execute("select exp_status from expenses where expense = ? and emp_username = ?", (expense,username))


