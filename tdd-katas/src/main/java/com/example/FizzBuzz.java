package com.example;

public class FizzBuzz {

    public String valueOf(int i) {
        String value = "";
        if ((i % 3) == 0) {
            value = "Fizz";
        }
        if ((i % 5) == 0) {
            value += "Buzz";
        }
        if (!value.isEmpty()) {
            return value;
        }
        return String.valueOf(i);
    }
}