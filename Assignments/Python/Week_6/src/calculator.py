"""
Calculator module - System Under Test for Python testing demos.
"""
import re

class Calculator:
    """A simple calculator class for demonstration purposes."""

    def add(self, a: int, b: int) -> int:
        """Add two numbers."""
        return a + b

    def subtract(self, a: int, b: int) -> int:
        """Subtract b from a."""
        return a - b

    def multiply(self, a: int, b: int) -> int:
        """Multiply two numbers."""
        return a * b

    def divide(self, a: int, b: int) -> float:
        """
        Divide a by b.

        Raises:
            ZeroDivisionError: If b is zero
        """
        if b == 0:
            raise ZeroDivisionError("Cannot divide by zero")
        return a / b

    def modulo(self, a: int, b: int) -> int:
        """
        Calculate a modulo b.

        Raises:
            ZeroDivisionError: If b is zero
        """
        if b == 0:
            raise ZeroDivisionError("Cannot calculate modulo with zero divisor")
        return a % b

    def power(self, base: int, exponent: int) -> int:
        """
        Calculate base raised to exponent.

        Raises:
            ValueError: If exponent is negative
        """
        if exponent < 0:
            raise ValueError("Exponent cannot be negative for integer power")
        return base ** exponent

    def absolute_value(self, value: int) -> int:
        """Return the absolute value."""
        return abs(value)

    def is_even(self, number: int) -> bool:
        """Check if a number is even."""
        return number % 2 == 0

    def is_positive(self, number: int) -> bool:
        """Check if a number is positive (greater than zero)."""
        return number > 0

    def max_value(self, a: int, b: int) -> int:
        """Return the larger of two numbers."""
        return max(a, b)

    def min_value(self, a: int, b: int) -> int:
        """Return the smaller of two numbers."""
        return min(a, b)


class StringCalculator:
    """Calculator that adds numbers from a string."""

    def add(self, numbers: str) -> int:
        """
        Add numbers from a delimited string.

        Rules:
        - Empty string returns 0
        - Single number returns that number
        - Numbers can be delimited by comma or newline
        - Custom delimiter: "//[delimiter]\n[numbers]"
        - Numbers > 1000 are ignored
        - Negative numbers raise ValueError
        """
        if not numbers:
            return 0

        delimiter = ","

        # Check for custom delimiter
        if numbers.startswith("//"):
            delimiter_end = numbers.index("\n")
            delimiter = numbers[2:delimiter_end]
            numbers = numbers[delimiter_end + 1:]

        # Replace newlines with delimiter
        numbers = numbers.replace("\n", delimiter)

        # Parse numbers
        num_list = [int(n) for n in numbers.split(delimiter) if n]

        # Check for negatives
        negatives = [n for n in num_list if n < 0]
        if negatives:
            raise ValueError(f"negatives not allowed: {negatives}")

        # Filter and sum (ignore > 1000)
        return sum(n for n in num_list if n <= 1000)