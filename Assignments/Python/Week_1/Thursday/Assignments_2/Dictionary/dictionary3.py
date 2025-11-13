employees = {
            "employee1" : {"name" : "Bob",
                           "age" : 30,
                           "salary" : 50000},
            "employee2" : {"name" : "Tim",
                           "age" : 45,
                           "salary" : 65000},
            "employee3" : {"name" : "sally",
                           "age" : 33,
                           "salary" : 55000}
            }

def raises(employees):
    for x in employees:
        employees[x]["salary"] *= 1.1
        
raises(employees)

print(employees)