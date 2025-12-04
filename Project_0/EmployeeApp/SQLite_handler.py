import sqlite3
import logging
logging.basicConfig(filename="activity.log",level=logging.DEBUG, format='%(asctime)s- %(name)s - %(levelname)s - %(message)s')

db_path = '/Users/andrew/Desktop/Revature/Project_0/my_database.db'

def db_connect():
    conn = sqlite3.connect(db_path)
    logging.info("Connected to database")
    return conn

def add_employee(cursor, employee):
    cursor.execute("insert into employees values (?,?,?)", (employee.username, employee.get_password(), employee.name))
    logging.info("add_employee queried")


def get_username(cursor, username):
    cursor.execute("select username from employees where username = ?", (username,))
    logging.info("get_username queried")

def get_password(cursor, username):
    cursor.execute("select password from employees where username = ?", (username,))
    logging.info("get_password queried")

def get_name(cursor, username):
    cursor.execute("select name from employees where username = ?", (username,))
    logging.info("get_name queried")

def add_expense(cursor, username, expense, amount, desc, date, status, category):
    cursor.execute("insert into expenses (emp_username, expense, exp_cost, exp_desc, exp_date, exp_status, exp_category)values(?,?,?,?,?,?,?)", (username, expense, amount, desc, date, status, category))
    logging.info("add_expense queried")

def edit_expense(cursor, username, expense, field, value):
    query = f"update expenses set {field} = ? where emp_username = ? and expense = ?"
    cursor.execute(query, (value, username, expense))
    logging.info("edit_expense queried")

def view_all_pending_expenses(cursor, username):
    cursor.execute("select exp_id, emp_username, expense, exp_cost, exp_desc, exp_date, exp_status, categories.category from expenses join categories on exp_category=id where emp_username = ? and exp_status = 'Pending'", (username,))
    logging.info("view_all_pending_expenses queried")

def view_all_expenses(cursor, username):
    cursor.execute("select exp_id, emp_username, expense, exp_cost, exp_desc, exp_date, exp_status, categories.category from expenses join categories on exp_category=id where emp_username = ?", (username,))
    logging.info("view_all_expenses queried")

def get_expense(cursor, username, expense):
    cursor.execute("select expense from expenses where expense = ? and emp_username = ?", (expense,username))
    logging.info("get_expense queried")

def delete_expense(cursor, username, expense):
    cursor.execute("delete from expenses where expense = ? and emp_username = ? and exp_status = 'Pending'", (expense,username))
    logging.info("delete_expense queried")

def get_expense_status(cursor, username, expense):
    cursor.execute("select exp_status from expenses where expense = ? and emp_username = ?", (expense,username))
    logging.info("get_expense_status queried")

def view_all_processed_expenses(cursor, username):
    cursor.execute("select e.expense, e.exp_cost, p.emp_username, p.manager_username, p.exp_status, p.comments from expenses as e join processed_expenses as p on p.exp_id=e.exp_id where p.emp_username = ?", (username,))
    logging.info("view_all_processed_expenses queried")
