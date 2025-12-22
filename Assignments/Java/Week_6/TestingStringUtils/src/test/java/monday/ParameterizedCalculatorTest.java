package monday;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedCalculatorTest {
    Calculator calculator = null;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    // repetitive and inefficient
//    @Test void isEven_2_returnsTrue() { assertTrue(calculator.isEven(2)); }
//    @Test void isEven_4_returnsTrue() { assertTrue(calculator.isEven(4)); }
//    @Test void isEven_100_returnsTrue() { assertTrue(calculator.isEven(100)); }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 100, 0, -2})
    void isEven_evenNumbers_returnsTrue(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 99, -1, -99})
    void isEven_oddNumbers_returnsFalse(int number) {
        assertFalse(calculator.isEven(number));
    }

    @ParameterizedTest(name = "Test case #{index}: Input = {0}")
    @ValueSource(ints = {1,2,4,9,100})
    void isPositive_positiveNumbers_returnsTrue(int number) {
        assertTrue(calculator.isPositive(number));
    }

    @ParameterizedTest(name = "Test case #{index}: Input = {0}")
    @ValueSource(ints = {-1,-2,-4,-9,-100})
    void isPositive_negativeNumbers_returnsFalse(int number) {
        assertFalse(calculator.isPositive(number));
    }

    @ParameterizedTest(name="{0}+{1}={2}")
    @CsvSource({
            "1, 2, 3",
            "0, 0, 0",
            "-1, 1, 0",
            "100, 200, 300",
            "12, -24, -12",
            "-15, -5, -20"
    })
    void add_variousInputs_returnsCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest(name="{0}-{1}={2}")
    @CsvSource({
            "1, 2, -1",
            "0, 0, 0",
            "15, 14, 1",
            "200, 100, 100",
            "12, 12, 0"
    })
    void subtract_variousInputs_returnsCorrectDifference(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @ParameterizedTest(name="{0}*{1}={2}")
    @CsvSource({
            "1, 2, 2",
            "10, 0, 0",
            "-1, 8, -8",
            "100, 2, 200",
            "-13, -2, 26"
    })
    void multiply_variousInputs_returnsCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    @ParameterizedTest(name="{0}/{1}={2}")
    @CsvSource({
            "2, 2, 1",
            "0, 4, 0",
            "-10, 5, -2",
            "1000, 250, 4"
    })
    void divide_variousInputs_returnsCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calculator.divide(a, b));
    }


    @ParameterizedTest
    @MethodSource("provideDivisionTestCases")
    void divide_variousCases_returnsCorrectQuotient(int a, int b, int expected) {
        assertEquals(expected, calculator.divide(a, b));
    }

    static Stream<Arguments> provideDivisionTestCases() {
        return Stream.of(
                Arguments.of(10, 2, 5),
                Arguments.of(9, 3, 3),
                Arguments.of(-10, 2, -5),
                Arguments.of(7, 2, 3)  // Integer division
        );
    }

    @ParameterizedTest(name = "{0}^{1}={2}")
    @MethodSource("providePowerTestCases")
    void power_variousCases_returnsCorrectValue(int a, int b, int expected) {
        assertEquals(expected, calculator.power(a, b));
    }

    static Stream<Arguments> providePowerTestCases() {
        return Stream.of(
                Arguments.of(10, 2, 100),
                Arguments.of(0, 3, 0),
                Arguments.of(4, 0, 1),
                Arguments.of(2, 2, 4)  // Integer division
        );
    }


    @ParameterizedTest(name = "Test case #{index}: Input = \"{0}\"")
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void isBlank_blankInputs_returnsTrue(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

}
