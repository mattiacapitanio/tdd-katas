package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class FizzBuzzTest {
    
    @DisplayName("Should return the FizzBuzz string value given an integer")
    @Test
    void shouldReturnTheFizzBuzzStringValue() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("1", fizzBuzz.valueOf(1));
        assertEquals("7", fizzBuzz.valueOf(7));
        assertEquals("Fizz", fizzBuzz.valueOf(9));
        assertEquals("Fizz", fizzBuzz.valueOf(3));
        assertEquals("Buzz", fizzBuzz.valueOf(5));
        assertEquals("Buzz", fizzBuzz.valueOf(20));
        assertEquals("FizzBuzz", fizzBuzz.valueOf(15));
        assertEquals("FizzBuzz", fizzBuzz.valueOf(30));
    }
}