package com.epam.lab.lapitski.util;

import com.epam.lab.lapitski.exception.NumberException;

import static org.apache.commons.lang3.math.NumberUtils.isCreatable;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class StringUtils {

    public static boolean isPositiveNumber(String str) throws NumberException {

        if (isCreatable(str)) {
            return toInt(str) >= 0;
        } else {
            throw new NumberException("This is not number: " + str);
        }
    }
}
