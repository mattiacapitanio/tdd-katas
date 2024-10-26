package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFunctionality {

    private final List<String> cities;
    
    SearchFunctionality(List<String> cities) {
        this.cities = cities;
    }

    public List<String> search(String searchText) {
        validateInput(searchText);        
        if (searchText.equals("*")) {
            return cities;
        }
        if (searchText.length() < 2) {
            return new ArrayList<>();
        }
        return filter(searchText);
    }

    private List<String> filter(String searchText) {
        String regex = "^([^\n]*" + searchText + "[^\n]*)$";
        int flags = Pattern.MULTILINE | Pattern.CASE_INSENSITIVE;
        Pattern pattern = Pattern.compile(regex, flags);
        Matcher matcher = pattern.matcher(String.join("\n", cities));
        List<String> results = new ArrayList<>();
        while(matcher.find()) {
            results.add(matcher.group());
        }
        return results;
    }

    private void validateInput(String searchText) {
        Pattern pattern = Pattern.compile("^\\*|[a-zA-Z\\s]*$");
        if (pattern.matcher(searchText).matches()) {
            return;
        }
        throw new IllegalArgumentException("Only word characters, whitespace characters or '*' allowed");
    }
}
