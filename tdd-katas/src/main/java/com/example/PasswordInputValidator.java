package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PasswordInputValidator {

    private final List<String> errors = new ArrayList<>();

    public ValidationResult validate(String password) {
        errors.clear();
        if (!isMinimumCharLength(password)) {
            errors.add("Password must be at least 8 characters");
        }
        if (!isContainNumbers(password)) {
            errors.add("Password must be at least 2 numbers");
        }
        if (!isContainCapitalLetter(password)) {
            errors.add("Password must be at least a capital letter");
        }
        if (!isContainSpecialChar(password)) {
            errors.add("Password must be at least a special character");
        }
        return new ValidationResult(errors.isEmpty(), errors);
    }

    private boolean isMinimumCharLength(String password) {
        return (password.length() >= 8);
    }

    private boolean isContainNumbers(String password) {
        final Pattern pattern = Pattern.compile("^.*\\d.*\\d.*$");
        return pattern.matcher(password).matches();
    }

    private boolean isContainCapitalLetter(String password) {
        final Pattern pattern = Pattern.compile("^.*[A-Z].*$");
        return pattern.matcher(password).matches();
    }

    private boolean isContainSpecialChar(String password) {
        String someSpecialCharsRegex = "^.*[-_\\.!\\?\\*\\+].*$";
        final Pattern pattern = Pattern.compile(someSpecialCharsRegex);
        return pattern.matcher(password).matches();
    }
    
    public class ValidationResult {

        private final boolean isValid;
        private final List<String> errors;

        ValidationResult(boolean isValid, List<String> errors) {
            this.isValid = isValid;
            this.errors = errors;
        }

        public boolean isValid() {
            return isValid;
        }

        public List<String> getErrors() {            
            return errors;
        }
    }
}
