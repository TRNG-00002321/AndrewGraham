students = [
    {"name": "Alice", "grade": 85},
    {"name": "Bob", "grade": 92},
    {"name": "Charlie", "grade": 78},
    {"name": "David", "grade": 95}
]


students_90 = list(filter(lambda x: x.get("grade")>=90, students))


print(list(students_90))