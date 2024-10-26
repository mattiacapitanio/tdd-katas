package com.example;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchFunctionalityTest {

    final List<String> cities = Arrays.asList("Paris", "Budapest", "Skopje", 
        "Rotterdam", "Valencia", "Vancouver", "Amsterdam", "San Fernando Valley",
        "Vienna", "Sydney", "New York City", "London", 
        "Bangkok", "Hong Kong", "Dubai", "Rome", "Istanbul");

    private SearchFunctionality searchFunctionality;

    @BeforeEach
    void setup() {
        searchFunctionality = new SearchFunctionality(cities);
    }

    @Test 
    void shouldReturnCities_whenSearchTextIsGiven() {
        List<String> result = searchFunctionality.search("");
        assertTrue(result.isEmpty());
        result = searchFunctionality.search("a");
        assertTrue(result.isEmpty());
        result = searchFunctionality.search("Va");
        assertTrue(result.contains("Valencia"));
        assertTrue(result.contains("Vancouver"));
        assertTrue(result.contains("San Fernando Valley"));
        result = searchFunctionality.search("dam");
        assertTrue(result.contains("Rotterdam"));
        assertTrue(result.contains("Amsterdam"));
        result = searchFunctionality.search("lo");
        assertTrue(result.contains("London"));
        result = searchFunctionality.search("*");
        assertTrue(cities.containsAll(result));
        result = searchFunctionality.search(" y");
        assertTrue(cities.contains("New York City"));
    }

    @Test
    void shouldThrowException_whenInvalidInputCharIsPassed() {
        assertThrows(IllegalArgumentException.class, 
            () -> searchFunctionality.search("1"));
        assertThrows(IllegalArgumentException.class, 
            () -> searchFunctionality.search("**"));
        assertThrows(IllegalArgumentException.class, 
            () -> searchFunctionality.search("!"));
        assertThrows(IllegalArgumentException.class, 
            () -> searchFunctionality.search("val."));
    }
}
