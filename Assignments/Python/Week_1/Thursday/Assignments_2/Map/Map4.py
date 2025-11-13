first_names = ["John", "Jane"]
last_names = ["Doe", "Smith"]

full_names = list(map(lambda x, y: x + " " + y,first_names, last_names))


print(list(full_names))