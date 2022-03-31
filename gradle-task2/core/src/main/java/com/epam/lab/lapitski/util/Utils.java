package com.epam.lab.lapitski.util;

import java.util.Arrays;

public class Utils {

    public static boolean isAllPositiveNumbers(String... str) throws NumberFormatException {

        return Arrays.stream(str).allMatch(StringUtils::isPositiveNumber);

    }
}
