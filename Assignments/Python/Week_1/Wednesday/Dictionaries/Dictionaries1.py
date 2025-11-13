arr = [2, 5, 7, 4, 3, 9, 6, 1, 1]
elementCount = {}
repeated = []

for element in arr:
    elementCount[element] = elementCount.get(element, 0) + 1

for item, count in elementCount.items():
    if count > 1:
        repeated.append(item)

if(len(repeated) !=0):
    repeatedIndex = arr.index(repeated[0])
else:
    repeatedIndex = -1

print(f"The index of the first repeated element is: {repeatedIndex}")