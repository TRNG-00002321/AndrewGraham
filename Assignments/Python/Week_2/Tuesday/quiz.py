import json
from functools import reduce

def ask_questions(questions, answers):
    for x in questions:
        print(x)
        answer = input("")
        answers.append(answer.capitalize())
    return answers
def check_grade(questions, answers):
    correct = 0
    for item1, item2, in zip(questions, answers):
        if questions[item1] == item2:
            correct+=1
    percentage = (correct/len(answers))*100
    return percentage

questions_list = {"What is 2 + 2?" : "4",
             "What is the capital of Texas" : "Austin",
             "What programming language is this program written in?" : "Python"}

answer_list =[]        
print(ask_questions(questions_list, answer_list))
grade = check_grade(questions_list, answer_list)

print(f"The grade is: {grade:.2f}%")

