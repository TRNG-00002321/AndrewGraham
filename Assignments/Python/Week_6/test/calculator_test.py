import pytest
from src.calculator import StringCalculator


@pytest.fixture
def string_calculator():
    return StringCalculator()

def test_add_method(string_calculator):
    """Create a fresh calculator for each test."""
    assert string_calculator.add("") == 0
    assert string_calculator.add("1") == 1
    assert string_calculator.add("1,2") == 3
    assert string_calculator.add("1,2,3,4,5") == 15


#@pytest.mark.skip(reason="Not implemented yet")
def test_add_newline_delimiter(string_calculator):
    # "1\n2,3" should equal 6
    assert string_calculator.add("1\n2,3") == 6

#@pytest.mark.skip(reason="Not implemented yet")
def test_add_custom_delimiter(string_calculator):
    # "//;\n1;2" uses ; as delimiter
    assert string_calculator.add("//;\n1;2") == 3

def test_add_ignores_numbers_over_1000(string_calculator):
    # Numbers > 1000 should be ignored
    assert string_calculator.add("2,1001") == 2
    assert string_calculator.add("1000,1001,2") == 1002  # 1000 + 0 + 2

def test_add_negative_number_raises_exception(string_calculator):
    with pytest.raises(ValueError) as exc_info:
        string_calculator.add("-1,2")

    assert "negatives not allowed" in str(exc_info.value)
    assert "-1" in str(exc_info.value)

def test_add_multiple_negatives_shows_all_in_message(string_calculator):
    with pytest.raises(ValueError) as exc_info:
        string_calculator.add("-1,-2,3,-4")

    error_message = str(exc_info.value)
    assert "-1" in error_message
    assert "-2" in error_message
    assert "-4" in error_message
