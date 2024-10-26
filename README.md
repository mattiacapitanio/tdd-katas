# Test-Driven Development Katas
Hands-on Test-Driven Development Katas

### FizzBuzz kata

1. Write a method that accepts a number as input and returns it as a String
1. For multiples of three return "Fizz" instead of the number
1. For the multiples of five return "Buzz"
1. For numbers that are multiples of both three and five return "FizzBuzz"

### Password input validator kata

Create a function to validate a password. The validation function takes a string as an input and returns a validation result. The validation result contains a boolean indicating if the password is valid or not, and a list with the possible validation errors.

Requirements:

1. The password must be at least 8 characters long, otherwise an error should be returned

1. The password must contain at least 2 numbers, otherwise an error should be returned

1. The validation function should handle multiple validation errors

1. The password must contain at least one capital letter, otherwise an error should be returned

1. The password must contain at least one special letter, otherwise an error should be returned

### String calculator kata

Create a simple calculator that takes a String and returns an integer

Requirements:

1. The method can take up an unknown number of numbers, separated by commas or newline, and will return their sum as a result

1. For an empty string, it will return 0

1. Add validation to not to allow a separator at the end or more than one separator between two numbers

1. Allow the add method to handle different delimiters. To change the delimiter, the beginning of the input will contain a separate line that looks like this: //[delimiter]\n[numbers]

### Search functionality

Implement a city search functionality. The function takes a string as input and returns the found cities which corresponds to the search text.

Prerequisites:
Create a collection of strings that will act as a database for the city names.

Requirements:

1. If the search text is fewer than 2 characters, then should return no results.

1. If the search text is equal to or more than 2 characters, then it should return all the city names that conteins the search text.

1. The search functionality should be case insensitive

1. If the search text is a “*” (asterisk), then it should return all the city names.