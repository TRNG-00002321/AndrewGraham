from functools import reduce


students = {"John":86,
            "Bob" : 92,
            "Charlie" : 78,
            "David" : 95}


def max_grade():
    max = reduce(lambda x, y: x if students[x] >= students[y] else y, students)
    return max
    

print(max_grade())