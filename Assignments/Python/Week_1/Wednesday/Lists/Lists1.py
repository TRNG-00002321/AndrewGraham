numbers = [1,2,3,4,5]


def listSum(numbers):
    sum = 0
    for x in numbers:
        sum += x
    return sum

print(f"The sum of the elements in the list is {listSum(numbers)}")

