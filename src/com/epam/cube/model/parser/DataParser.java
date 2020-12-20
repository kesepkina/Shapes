package com.epam.cube.model.parser;

import com.epam.cube.model.entity.Shape3DInternal;
import com.epam.cube.validation.CubeValidator;
import com.epam.cube.validation.PointValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;
import java.util.Map;

public class DataParser {

    private static final Logger log = LogManager.getLogger();
    private static final String DELIMITER = "\\s";

    public Map<Shape3DInternal, Double> parseCubeData(String inputtedData) {
        String[] splitData = inputtedData.trim().split(DELIMITER);
        Map<Shape3DInternal, Double> cubeData = new EnumMap<>(Shape3DInternal.class);

        if (splitData.length == 4 && PointValidator.isCoordinate(splitData[0]) && PointValidator.isCoordinate(splitData[1])
                && PointValidator.isCoordinate(splitData[2]) && CubeValidator.isLength(splitData[3])) {

            double x = Double.parseDouble(splitData[0]);
            double y = Double.parseDouble(splitData[1]);
            double z = Double.parseDouble(splitData[2]);
            double sideLength = Double.parseDouble(splitData[3]);

            cubeData.put(Shape3DInternal.X, x);
            cubeData.put(Shape3DInternal.Y, y);
            cubeData.put(Shape3DInternal.Z, z);
            cubeData.put(Shape3DInternal.SIDE_LENGTH, sideLength);
        } else {
            log.debug("String \"{}\" includes incorrect data. It was missed.", inputtedData);
        }

        return cubeData;
    }
}
