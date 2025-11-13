arr = [1, 2, 3, 4, 5, 6]

x = 5
set1 = set()

n = len(arr)

for element in arr:
    set1.add(element)

if x in set1:
    set1.remove(x)
    print("erased x")
else:
    print("not found")

for element in set1:
    print(element)