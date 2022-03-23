package com.epam.lab.lapitski.util;

import com.epam.lab.lapitski.exception.NumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    private static final String POSITIVE_NUMBER = "5";
    private static final String NEGATIVE_NUMBER = "-5";
    private static final String NOT_NUMBER = "Not_number";

    @Test
    void isPositiveNumberTrue() throws NumberException {
        assertTrue(StringUtils.isPositiveNumber(POSITIVE_NUMBER));
    }

    @Test
    void isPositiveNumberFalse() throws NumberException {
        assertFalse(StringUtils.isPositiveNumber(NEGATIVE_NUMBER));
    }

    @Test
    void isPositiveNumberException() {
        try {
            StringUtils.isPositiveNumber(NOT_NUMBER);
            fail("Should throw NumberException");
        } catch (NumberException e) {
            assertTrue(true);
        }
    }
}
