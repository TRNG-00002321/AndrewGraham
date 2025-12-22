package monday;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    Calculator calculator = null;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }


    @Test
    @DisplayName("Adding two positive numbers")
    @Order(1)
    void add_twoPositiveNumbers_returnsEqual() {
        int num1 = 5;
        int num2 = 3;
        int exp_result = 8;
        assertEquals(exp_result, calculator.add(num1,num2));
    }

    @Test
    @DisplayName("Adding one positive number and one negative number")
    @Order(2)
    void add_onePositiveNumber_returnsEqual() {
        int num1 = 10;
        int num2 = -3;
        int exp_result = 7;
        assertEquals(exp_result, calculator.add(num1,num2));
    }

    @Test
    @DisplayName("Adding two negative numbers")
    @Order(3)
    void add_twoNegativeNumbers_returnsEqual() {
        int num1 = -5;
        int num2 = -3;
        int exp_result = -8;
        assertEquals(exp_result, calculator.add(num1,num2));
    }

    @Test
    @DisplayName("Adding zero")
    @Order(4)
    void add_addingZero_returnsEqual() {
        int num1 = 5;
        int num2 = 0;
        int exp_result = 5;
        assertEquals(exp_result, calculator.add(num1,num2));
    }

    @Test
    @DisplayName("Subtracting two numbers")
    @Order(5)
    void subtract_subtractTwoNumbers_returnsEqual() {
        int num1 = 5;
        int num2 = 3;
        int exp_result = 2;
        assertEquals(exp_result, calculator.subtract(num1,num2));
    }

    @Test
    @DisplayName("Subtracting larger number")
    @Order(6)
    void subtract_subtractLargerNumber_returnsEqual() {
        int num1 = 5;
        int num2 = 10;
        int exp_result = -5;
        assertEquals(exp_result, calculator.subtract(num1,num2));
    }

    @Test
    @DisplayName("Subtracting zero")
    @Order(7)
    void subtract_subtractZero_returnsEqual() {
        int num1 = 5;
        int num2 = 0;
        int exp_result = 5;
        assertEquals(exp_result, calculator.subtract(num1,num2));
    }

    @Test
    @DisplayName("even positive")
    @Order(8)
    void isEven_evenPositive_returnsTrue() {
        assertAll("positive even numbers",
                ()->assertTrue(calculator.isEven(2)),
                ()->assertTrue(calculator.isEven(4)),
                ()->assertTrue(calculator.isEven(100))
        );
    }

    @Test
    @DisplayName("odd positive")
    @Order(9)
    void isEven_oddPositive_returnsFalse() {
        assertAll("positive odd numbers",
                ()->assertFalse(calculator.isEven(1)),
                ()->assertFalse(calculator.isEven(3)),
                ()->assertFalse(calculator.isEven(99))
        );
    }

    @Test
    @DisplayName("zero even")
    @Order(10)
    void isEven_zero_returnsTrue() {
        assertTrue(calculator.isEven(0));
    }

    @Test
    @DisplayName("even negative numbers")
    @Order(11)
    void isEven_negativeNumbers_returnsBoth() {
        assertAll("Negative numbers",
                () -> assertTrue(calculator.isEven(-2)),
                () -> assertTrue(calculator.isEven(-100)),
                () -> assertFalse(calculator.isEven(-1)),
                () -> assertFalse(calculator.isEven(-99))
        );
    }

    @Test
    @DisplayName("positive numbers")
    @Order(12)
    void isPositive_positiveNumbers_returnsTrue() {
        assertAll("Positive numbers",
                ()-> assertTrue(calculator.isPositive(2)),
                ()-> assertTrue(calculator.isPositive(1)),
                ()-> assertTrue(calculator.isPositive(99)),
                ()-> assertTrue(calculator.isPositive(100))
        );
    }

    @Test
    @DisplayName("negative numbers")
    @Order(13)
    void isPositive_negativeNumbers_returnsFalse() {
        assertAll("Negative numbers",
                ()-> assertFalse(calculator.isPositive(-2)),
                ()-> assertFalse(calculator.isPositive(-1)),
                ()-> assertFalse(calculator.isPositive(-99)),
                ()-> assertFalse(calculator.isPositive(-100))
        );
    }

    @Test
    @DisplayName("is zero positive")
    @Order(14)
    void isPositive_zero_returnsFalse() {
        assertFalse(calculator.isPositive(0));
    }




}
