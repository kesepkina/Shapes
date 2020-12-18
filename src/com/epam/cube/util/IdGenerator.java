package com.epam.cube.util;

public class IdGenerator {
    private static int counter = 0;

    private IdGenerator() {}

    public static int generateIntId() {
        return ++counter;
    }
}
