def stringLength(input_str):
    return len(input_str)

words = ["apple", "banana", "cherry"]

letter_count = list(map(lambda x: stringLength(x), words))

print(list(letter_count))