from flask import Flask, render_template, request

import json

app = Flask(__name__)

def json_dump():
    with open('/Users/andrew/Desktop/Revature flask/Assignments/data.json', 'w') as f:
        json.dump(todo_list, f, indent=4)
todo_list = {}
        
with open('/Users/andrew/Desktop/Revature flask/Assignments/data.json', 'r') as f:
    todo_list = json.load(f)


@app.route('/')
def result():
   
   return render_template('todo_list.html', result = todo_list)

@app.route('/add', methods=['GET','POST'])
def add():
    if request.method == 'POST':
        todo_list[request.form['task']] = "not completed"
    else:
        todo_list[request.args.get('nm')] = "not completed"
    json_dump()
    return render_template('todo_list.html', result = todo_list)

@app.route('/complete', methods=['GET','POST'])
def complete():
    if request.form['task'] in todo_list:
        if request.method == 'POST':
            todo_list[request.form['task']] = "completed"
        else:
            todo_list[request.args.get('nm')] = "completed"
        json_dump()
    return render_template('todo_list.html', result = todo_list)

@app.route('/remove', methods=['GET','POST'])
def remove():
    if request.form['task'] in todo_list:
        if request.method == 'POST':
            del todo_list[request.form['task']]
        else:
            del todo_list[request.args.get('nm')]
        json_dump()
    return render_template('todo_list.html', result = todo_list)

if __name__ == '__main__':
   app.run(port=8000,debug = True)