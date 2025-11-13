arr = [-12, 8, -7, 6, 12, -9, 14]

counter = 0
sum = 0
for x in arr:
    if x >= 0:
        counter +=1
        sum += x

print(f"The average of the postive entries is {sum/counter}")