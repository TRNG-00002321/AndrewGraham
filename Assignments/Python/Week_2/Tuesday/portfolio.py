from flask import Flask, render_template, request
import json


app = Flask(__name__)

project_data = {}
        
with open('/Users/andrew/Desktop/Revature flask/Assignments/Tuesday/projectdata.json', 'r') as f:
    project_data = json.load(f)

@app.route('/')
def result():
    return "hello"

@app.route('/home')
def home():
    return render_template('home.html')

@app.route('/projects')
def projects():
    return render_template('projects.html', result = project_data)

@app.route('/contact')
def contact():
    return render_template('contact.html')

if __name__ == '__main__':
   app.run(port=8000,debug = True)