from functools import reduce

numbers = [10, 3, 25, 7, 18]

max_num = reduce(lambda x, y: x if x > y else y, numbers)


print(max_num)