package org.iti.app_tests;

import org.iti.app.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTests {
    private StringUtils stringUtils;

    @BeforeEach
    void beforeEachTest() {
        stringUtils = new StringUtils();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv")
    void testStringPalindrome(String text, String expected) {
        assertEquals(Boolean.parseBoolean(expected), stringUtils.isPalindrome(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"radar", "maram", "level", "racecar"})
    void testStringPalindrome2(String text) {
        assertTrue(stringUtils.isPalindrome(text), String.format("%s is not palindrome",text));
    }
}
