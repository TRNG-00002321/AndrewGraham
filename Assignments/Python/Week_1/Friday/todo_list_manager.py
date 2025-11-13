import sys

def add_todo(dictionary):
    input_task = input("What do you want to add to the to-do list? ")
    dictionary[input_task] = "not completed"
    print(dictionary)
    
def view_todo(dictionary):
    print(dictionary)
    
def complete_todo(dictionary):
    input_task = input("Which task do you want to complete? ")
    if input_task in dictionary:
        dictionary[input_task] = "completed"
    else:
        print("item not in list")
    
def remove_todo(dictionary):
    input_task = input("Which task do you want to remove? ")
    del dictionary[input_task]
    
todo_list = {"laundry" : "not completed",
             "dishes" : "not completed",
             "walk the dog" : "not completed"}
          
while True:
    input_str = input("Enter your action or type 'done': ")
    if input_str == "add":
        add_todo(todo_list)
    elif input_str == "view":
        view_todo(todo_list)
    elif input_str == "complete":
        complete_todo(todo_list)
    elif input_str == "remove":
        remove_todo(todo_list)
    elif input_str == "done":
        print("done")
        sys.exit()
    else:
        print("invalid input")

