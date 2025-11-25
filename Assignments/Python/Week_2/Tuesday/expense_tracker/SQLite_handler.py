import sqlite3
def db_connect():
    conn = sqlite3.connect('/Users/andrew/Desktop/Revature/Project_0/my_database.db')
    cursor = conn.cursor()
    return cursor
def db_initialize(cursor):
    cursor.execute('''
        create table employees(
                                username varchar(50) primary key,
                                password varChar(50) not null,
                                name varchar(50) not null
                                );
    ''')

    conn.commit()