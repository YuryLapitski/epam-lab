package com.epam.lab.lapitski.util;

import static org.apache.commons.lang3.math.NumberUtils.isCreatable;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isPositiveNumber(String str) throws NumberFormatException {
        if (isCreatable(str)) {
            return toInt(str) >= 0;
        } else {
            throw new NumberFormatException(str + " is not number");
        }
    }
}
