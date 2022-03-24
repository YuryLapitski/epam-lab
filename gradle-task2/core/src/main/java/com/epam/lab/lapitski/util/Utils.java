package com.epam.lab.lapitski.util;

import com.epam.lab.lapitski.exception.NumberException;

public class Utils {

    public static boolean isAllPositiveNumbers(String... str) throws NumberException {

        boolean result = true;
        for (String var : str) {
            if (!StringUtils.isPositiveNumber(var)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
