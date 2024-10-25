package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }
    
    @DisplayName("Should return sum when arguments with default delimiters are given")
    @Test
    void shouldReturnSum_whenArgumentsWithDefaultDelimitersAreGiven() {
        assertEquals(0, stringCalculator.sum(""));
        assertEquals(3, stringCalculator.sum("1,2"));
        assertEquals(5, stringCalculator.sum("1,4"));
        assertEquals(7, stringCalculator.sum("2\n5"));
        assertEquals(14, stringCalculator.sum("2\n5,7"));
    }

    @DisplayName("Should return sum when arguments with custom delimiter are given")
    @Test
    void shouldReturnSum_whenArgumentsWithCustomDelimitersAreGiven() {
        assertEquals(7, stringCalculator.sum("//|\n1|6"));
        assertEquals(7, stringCalculator.sum("//,\n1,6"));
        assertEquals(10, stringCalculator.sum("// \n1 6 3"));
        assertEquals(10, stringCalculator.sum("//s\n1s6s3"));
    }

    @DisplayName("Should throw an exception when a not valid arguments string is provided")
    @Test
    void shouldThrowException_whenArgumentInputStringIsNotValid() {
        Exception e = assertThrows(IllegalArgumentException.class, 
            () -> stringCalculator.sum("1,\n7"));
        assertEquals("Invalid delimiter found", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, 
            () -> stringCalculator.sum("1\n7,"));
        assertEquals("Invalid delimiter found", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, 
            () -> stringCalculator.sum("//|\n1|2,3"));
        assertEquals("Invalid delimiter found", e.getMessage());
    }
}
