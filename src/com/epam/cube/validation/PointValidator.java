package com.epam.cube.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointValidator {

    private static final Pattern COORDINATE = Pattern.compile("\\-?\\d+(\\.\\d+)?");

    private PointValidator() {
    }

    public static boolean isCoordinate(String instance) {
        Matcher matcher= COORDINATE.matcher(instance);
        boolean isCoordinate = matcher.matches();
        return isCoordinate;
    }
}
