package com.epam.cube.model.service.impl;

import com.epam.cube.model.entity.AbstractShape3D;
import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.CubePart;
import com.epam.cube.model.entity.Point3D;
import com.epam.cube.model.service.CubeService;

import java.util.EnumMap;
import java.util.Map;

public class CubeServiceImpl implements CubeService {


    @Override
    public double calculateSurfaceArea(Cube cube) {
        double sideLength = cube.getSideLength();
        double surfaceArea = 6 * Math.pow(sideLength, 2);
        return surfaceArea;
    }

    @Override
    public double calculateVolume(Cube cube) {
        double sideLength = cube.getSideLength();
        double volume = Math.pow(sideLength, 3);
        return volume;
    }

    @Override
    public Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlaneOxy(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double z = basicPoint.getZ();
        Map<CubePart, Double> volumesRatio = calculateVolumesRatioAfterCuttingByCoordinatePlane(z, cube, CubePart.UNDER_OXY_PLATE, CubePart.ABOVE_OXY_PLATE);
        return volumesRatio;
    }

    @Override
    public Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlaneOxz(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double y = basicPoint.getY();
        Map<CubePart, Double> volumesRatio = calculateVolumesRatioAfterCuttingByCoordinatePlane(y, cube, CubePart.ON_THE_LEFT_OF_OXZ_PLATE, CubePart.ON_THE_RIGHT_OF_OXZ_PLATE);
        return volumesRatio;
    }

    @Override
    public Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlaneOyz(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double x = basicPoint.getX();
        Map<CubePart, Double> volumesRatio = calculateVolumesRatioAfterCuttingByCoordinatePlane(x, cube, CubePart.BEHIND_OYX_PLATE, CubePart.IN_FRONT_OF_OYZ_PLATE);
        return volumesRatio;
    }

    private Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlane(double basicPointCoordinate, Cube cube, CubePart negativeSide, CubePart positiveSide) {
        Map<CubePart, Double> volumesRatio = new EnumMap<>(CubePart.class);
        if (basicPointCoordinate >= 0) {
            volumesRatio.put(negativeSide, 0.);
            volumesRatio.put(positiveSide, 1.);
        } else {
            double sideLength = cube.getSideLength();
            if (Math.abs(basicPointCoordinate) > sideLength) {
                volumesRatio.put(negativeSide, 1.);
                volumesRatio.put(positiveSide, 0.);
            } else {
                double rearPartVolume = Math.abs(basicPointCoordinate);
                double frontPartVolume = sideLength + basicPointCoordinate;
                volumesRatio.put(negativeSide, rearPartVolume);
                volumesRatio.put(positiveSide, frontPartVolume);
            }
        }
        return volumesRatio;
    }

    @Override
    public boolean isCube(AbstractShape3D o) {
        return (o.getClass() == Cube.class);
    }

    @Override
    public boolean adjoinsToAnyCoordinatePlate(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double x = basicPoint.getX();
        double y = basicPoint.getY();
        double z = basicPoint.getZ();
        return (x == 0 || y == 0 || z == 0);
    }

    @Override
    public boolean adjoinsToCoordinatePlateOxy(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double z = basicPoint.getZ();
        return (z == 0);
    }

    @Override
    public boolean adjoinsToCoordinatePlateOxz(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double y = basicPoint.getY();
        return (y == 0);
    }

    @Override
    public boolean adjoinsToCoordinatePlateOyz(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double x = basicPoint.getX();
        return (x == 0);
    }
}
