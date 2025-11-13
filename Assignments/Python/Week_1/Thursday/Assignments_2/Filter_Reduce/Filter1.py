words = ["apple", "banana", "cat", "dog", "elephant", "frog"]

words_5 = list(filter(lambda x: len(x) > 5, words))

print(list(words_5))