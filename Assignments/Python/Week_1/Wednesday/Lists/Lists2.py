k = 5
arr = [6, 0, 1, 4, 16, 9, 11, 3, 2]

lessThan = []

for x in arr:
    if x < k:
        lessThan.append(x)

for x in lessThan:
    print(x)