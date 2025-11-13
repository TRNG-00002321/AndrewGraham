from functools import reduce


words = ["Python", "is", "awesome", "!"]


sentence = reduce(lambda x, y: x+ " "+ y, words)

print(sentence)