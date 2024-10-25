package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    final Pattern customDelimiterArgumentsPatter = Pattern.compile("//(\\D)\n(.*)");

    public int sum(String arguments) {
        if (arguments.isEmpty()) {
            return 0;
        }
        String delimiter = ",\n";
        if (isContainCustomDelimiter(arguments)) {
            delimiter = getCustomDelimiter(arguments);
            arguments = stripOutPrefix(arguments);
        }
        validate(arguments, delimiter);
        return sum(arguments, delimiter);
    }

    private String stripOutPrefix(String s) {
        Matcher matcher = customDelimiterArgumentsPatter.matcher(s);
        if (matcher.matches()) {
            return matcher.group(2);
        }
        throw new IllegalArgumentException("Arguments does not match valid format");
    }

    private String getCustomDelimiter(String s) {
        Matcher matcher = customDelimiterArgumentsPatter.matcher(s);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Arguments does not match valid format");
    }

    private boolean isContainCustomDelimiter(String s) {
        return customDelimiterArgumentsPatter.matcher(s).matches();
    }

    private int sum(String arguments, String delimiter) {
        int result = 0;
        final String[] addends = arguments.split("[" + delimiter + "]");
        for(String addend : addends) {
            result += Integer.valueOf(addend);
        }
        return result;
    }

    private void validate(String arguments, String delimiter) {
        final String regex = "^\\d+([" + delimiter + "]\\d+)*$";
        final Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(arguments).matches()) {
            throw new IllegalArgumentException("Invalid delimiter found");
        }
    }
}
