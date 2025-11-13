s = "This is a string"

p = "string"

def patternCheck(string, pattern):
    return string.find(pattern)

print(f"the location of the pattern in the string is: {patternCheck(s, p)}")