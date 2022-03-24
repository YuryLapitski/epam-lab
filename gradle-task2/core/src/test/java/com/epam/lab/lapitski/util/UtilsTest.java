package com.epam.lab.lapitski.util;

import com.epam.lab.lapitski.exception.NumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    private static final String POSITIVE_NUMBER_1 = "10";
    private static final String POSITIVE_NUMBER_2 = "255";
    private static final String NEGATIVE_NUMBER = "-255";


    @Test
    void isAllPositiveNumbersPositive() throws NumberException {
        String[] numbers = {POSITIVE_NUMBER_1, POSITIVE_NUMBER_2};
        assertTrue(Utils.isAllPositiveNumbers(numbers));
    }

    @Test
    void isAllPositiveNumbersNegative() throws NumberException {
        String[] numbers = {POSITIVE_NUMBER_1, NEGATIVE_NUMBER};
        assertFalse(Utils.isAllPositiveNumbers(numbers));
    }
}
