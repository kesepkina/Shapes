package com.epam.cube.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubeValidator {

    private static final Pattern LENGTH = Pattern.compile("\\d+(\\.\\d+)?");

    private CubeValidator() {
    }

    public static boolean isLength(String sideLength) {
        Matcher matcher= LENGTH.matcher(sideLength);
        boolean isLength = matcher.matches();
        double lengthNumber = Double.parseDouble(sideLength);
        return (isLength && lengthNumber > 0);
    }
}
