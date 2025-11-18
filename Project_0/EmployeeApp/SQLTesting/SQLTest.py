import sqlite3

conn = sqlite3.connect('my_database.db')

cursor = conn.cursor()

cursor.execute('''
     CREATE TABLE IF NOT EXISTS users (
         id INTEGER PRIMARY KEY,
         name TEXT NOT NULL,
         age INTEGER
     )
 ''')

conn.commit()

cursor.execute("INSERT INTO users (name, age) VALUES (?, ?)", ('Alice', 30))
conn.commit()


cursor.execute("SELECT * FROM users")
rows = cursor.fetchall()  # Fetch all results
for row in rows:
    print(row)

conn.close()