package com.example;

import com.example.PasswordInputValidator.ValidationResult;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class PasswordInputValidatorTest {

    private PasswordInputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new PasswordInputValidator();
    }
    
    @DisplayName("Should fail when invalid passwords are given")
    @Test
    void shouldFail_whenInvalidPasswordsAreGiven() {
        ValidationResult result = inputValidator.validate("");
        assertFalse(result.isValid());
        assertAllValidationErrors(result.getErrors());

        result = inputValidator.validate("invalid");
        assertFalse(result.isValid());
        assertAllValidationErrors(result.getErrors());
    }

    void assertAllValidationErrors(List<String> errors) {
        assertEquals(4, errors.size());
        assertTrue(errors.contains("Password must be at least 8 characters"));
        assertTrue(errors.contains("Password must be at least 2 numbers"));
        assertTrue(errors.contains("Password must be at least a capital letter"));
        assertTrue(errors.contains("Password must be at least a special character"));
    }

    @DisplayName("Should succeed when valid password is given")
    @Test
    void shouldSucceed_whenValidPasswordIsGiven() {
        ValidationResult result = inputValidator.validate("_1a?b5Yc");
        assertTrue(result.isValid());
        List<String> errors = result.getErrors();
        assertEquals(0, errors.size());
    }
}
