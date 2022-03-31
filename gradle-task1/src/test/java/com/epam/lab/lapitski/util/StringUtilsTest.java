package com.epam.lab.lapitski.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class StringUtilsTest {

    private static final String POSITIVE_NUMBER = "5";
    private static final String NEGATIVE_NUMBER = "-5";
    private static final String NOT_NUMBER = "Not_number";

    @Test
    void isPositiveNumberTrue() throws NumberFormatException {
        assertTrue(StringUtils.isPositiveNumber(POSITIVE_NUMBER));
    }

    @Test
    void isPositiveNumberFalse() throws NumberFormatException {
        assertFalse(StringUtils.isPositiveNumber(NEGATIVE_NUMBER));
    }

    @Test
    void isPositiveNumberException() {
        try {
            StringUtils.isPositiveNumber(NOT_NUMBER);
            fail("Should throw NumberException");
        } catch (NumberFormatException e) {
            assertTrue(true);
        }
    }
}
