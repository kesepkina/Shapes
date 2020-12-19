package com.epam.cube.model.repository.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Point3D;
import com.epam.cube.model.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OctantSpecification implements Specification {

    private static final Logger log = LogManager.getLogger();

    private int octantNumber;

    public OctantSpecification(int octantNumber) {
        if (octantNumber > 8 || octantNumber < 1) {
            log.error("There is no octant with number {}", octantNumber);
        }
        this.octantNumber = octantNumber;
    }

    public OctantSpecification() {}

    @Override
    public boolean specify(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double x = basicPoint.getX();
        double y = basicPoint.getY();
        double z = basicPoint.getZ();
        double sideLength = cube.getSideLength();
        boolean result = switch(octantNumber){
            case 1 -> (x >= 0 && y >= 0 && z >= 0);
            case 2 -> (x < 0 && y >= 0 && z >= 0 && sideLength >= -x);
            case 3 -> (x < 0 && y < 0 && z >= 0 && sideLength >= -x && sideLength >= -y);
            case 4 -> (x >= 0 && y < 0 && z >= 0 && sideLength >= -y);
            case 5 -> (x >= 0 && y >= 0 && z < 0 && sideLength >= -z);
            case 6 -> (x < 0 && y >= 0 && z < 0 && sideLength >=x && sideLength >= z);
            case 7 -> (x < 0 && y < 0 && z < 0 && sideLength >= x && sideLength >= y && sideLength >=z);
            case 8 -> (x >= 0 && y < 0 && z < 0 && sideLength <= y && sideLength >= z);
            default -> false;
        };
        return result;
    }
}
