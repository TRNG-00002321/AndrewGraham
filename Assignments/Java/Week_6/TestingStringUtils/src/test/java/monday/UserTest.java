package monday;

import org.junit.jupiter.api.Test;
//import org.mockito.internal.util.StringUtil;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    UserValidation validator = new UserValidation();

    @Test
    void validateEmail_multipleInvalidInputs_allThrowsExceptions() {
        assertAll("Email validation exceptions",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> validator.validateEmail(null)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> validator.validateEmail("")),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> validator.validateEmail("invalid")),
                () -> assertThrows(IllegalArgumentException.class,
                        () ->validator.validateEmail("test@"))
        );
    }

    @Test
    void validateEmail_invalidEmail_hasCorrectMessage() {
        IllegalArgumentException nullEx = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateEmail(null)
        );
        IllegalArgumentException emptyEx = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateEmail("")
        );
        IllegalArgumentException noSymbolEx = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateEmail("invalid")
        );
        IllegalArgumentException symbolEx1 = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateEmail("email@")
        );
        IllegalArgumentException symbolEx2 = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateEmail("@email")
        );
        assertAll("Exception message validation",
                ()-> assertTrue(nullEx.getMessage().contains("cannot be null")),
                ()-> assertTrue(emptyEx.getMessage().contains("cannot be empty")),
                ()-> assertTrue(noSymbolEx.getMessage().contains("must contain @")),
                ()-> assertTrue(symbolEx1.getMessage().contains("has invalid format")),
                ()-> assertTrue(symbolEx2.getMessage().contains("has invalid format"))
                );

    }

    @Test
    void validateEmail_validEmail_noException() {
        assertDoesNotThrow(() ->
            validator.validateEmail("valid@email.com")
        );
    }

    @Test
    void validatePassword_multipleInvalidPassword_allThrowsException() {
        assertAll("Password validation exceptions",
                () -> assertThrows(ValidationException.class,
                        () -> validator.validatePassword(null)),
                () -> assertThrows(ValidationException.class,
                        () ->  validator.validatePassword("Pass")),
                () -> assertThrows(ValidationException.class,
                        () -> validator.validatePassword("password123")),
                () -> assertThrows(ValidationException.class,
                        () -> validator.validatePassword("PASSWORD123"))
        );
    }

    @Test
    void validatePassword_invalidPassword_hasCorrectMessage() {
        ValidationException nullEx = assertThrows(
                ValidationException.class,
                () -> validator.validatePassword(null)
        );
        ValidationException lengthEx = assertThrows(
                ValidationException.class,
                () -> validator.validatePassword("Pass")
        );
        ValidationException noCapEx = assertThrows(
                ValidationException.class,
                () -> validator.validatePassword("password123")
        );
        ValidationException noLowEx = assertThrows(
                ValidationException.class,
                () -> validator.validatePassword("PASSWORD123")
        );
        assertAll("Message validation",
                () -> assertTrue(nullEx.getMessage().contains("Password cannot be null")),
                () -> assertTrue(lengthEx.getMessage().contains("Password must be at least 8 characters")),
                () -> assertTrue(noCapEx.getMessage().contains("Password must contain an uppercase letter")),
                () -> assertTrue(noLowEx.getMessage().contains("Password must contain a lowercase letter"))
        );

    }

    @Test
    void validatePassword_validPassword_noException() {
        assertDoesNotThrow(() ->
            validator.validatePassword("PassWord123")
        );
    }

    @Test
    void validateAge_multipleInvalidAge_allThrowsException() {
        assertAll("Age validation exceptions",
                ()-> assertThrows(IllegalArgumentException.class,
                        ()-> validator.validateAge(-1)),
                () -> assertThrows(IllegalArgumentException.class,
                                ()-> validator.validateAge(151))
        );


    }

    @Test
    void validateAge_invalidAge_hasCorrectMessage() {
        IllegalArgumentException negativeEx = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateAge(-1)
        );
        IllegalArgumentException tooOldEx = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateAge(151)
        );
        assertAll("Exception message validation",
                () -> assertTrue(negativeEx.getMessage().contains("cannot be negative")),
                () -> assertTrue(tooOldEx.getMessage().contains("cannot exceed 150"))
        );
    }

    @Test
    void validateAge_validAge_noException() {
        assertDoesNotThrow(() -> validator.validateAge(149));
    }


}
