package com.epam.lab.lapitski.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    private static final String POSITIVE_NUMBER_1 = "10";
    private static final String POSITIVE_NUMBER_2 = "255";
    private static final String NEGATIVE_NUMBER = "-255";

    @Test
    void isAllPositiveNumbersPositive() throws NumberFormatException {
        String[] numbers = {POSITIVE_NUMBER_1, POSITIVE_NUMBER_2};
        assertTrue(Utils.isAllPositiveNumbers(numbers));
    }

    @Test
    void isAllPositiveNumbersNegative() throws NumberFormatException {
        String[] numbers = {POSITIVE_NUMBER_1, NEGATIVE_NUMBER};
        assertFalse(Utils.isAllPositiveNumbers(numbers));
    }
}
