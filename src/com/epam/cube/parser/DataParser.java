package com.epam.cube.parser;

import com.epam.cube.entity.ShapeProperty;
import com.epam.cube.validation.CubeValidator;
import com.epam.cube.validation.PointValidator;

import java.util.EnumMap;
import java.util.Map;

public class DataParser {

    private static final String DELIMITER = "\\s";

    public Map<ShapeProperty, Double> parseCubeData(String inputtedData) {
        String[] splitData = inputtedData.trim().split(DELIMITER);
        Map<ShapeProperty, Double> cubeData = new EnumMap<>(ShapeProperty.class);

        if (splitData.length == 4 && PointValidator.isCoordinate(splitData[0]) && PointValidator.isCoordinate(splitData[1])
                && PointValidator.isCoordinate(splitData[2]) && CubeValidator.isLength(splitData[3])) {

            double x = Double.parseDouble(splitData[0]);
            double y = Double.parseDouble(splitData[1]);
            double z = Double.parseDouble(splitData[2]);
            double sideLength = Double.parseDouble(splitData[3]);

            cubeData.put(ShapeProperty.X, x);
            cubeData.put(ShapeProperty.Y, y);
            cubeData.put(ShapeProperty.Z, z);
            cubeData.put(ShapeProperty.SIDE_LENGTH, sideLength);
        }

        return cubeData;
    }
}
