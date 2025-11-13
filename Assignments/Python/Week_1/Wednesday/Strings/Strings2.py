s = "Racecar"
def isPalindrome(string):

    rev_s = s[::-1]

    if s.lower() == rev_s.lower():
        return True
    else:
        return False

print(f"Is {s} a palindrome: {isPalindrome(s)}")