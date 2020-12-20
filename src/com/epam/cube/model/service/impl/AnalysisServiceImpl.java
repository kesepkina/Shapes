package com.epam.cube.model.service.impl;

import com.epam.cube.model.entity.AbstractShape3D;
import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Point3D;
import com.epam.cube.model.service.AnalysisService;

public class AnalysisServiceImpl implements AnalysisService {

    @Override
    public boolean isCube(AbstractShape3D o) {
        return (o.getClass() == Cube.class);
    }

    @Override
    public boolean adjoinsToAnyCoordinatePlate(Cube cube) {
        boolean adjoinsToCoordinatePlateOxy = adjoinsToCoordinatePlateOxy(cube);
        boolean adjoinsToCoordinatePlateOxz = adjoinsToCoordinatePlateOxz(cube);
        boolean adjoinsToCoordinatePlateOyz = adjoinsToCoordinatePlateOyz(cube);
        return (adjoinsToCoordinatePlateOxy || adjoinsToCoordinatePlateOxz || adjoinsToCoordinatePlateOyz);
    }

    @Override
    public boolean adjoinsToCoordinatePlateOxy(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double z = basicPoint.getZ();
        double sideLength = cube.getSideLength();
        double z2 = z + sideLength;
        return (z == 0 || z2 == 0);
    }

    @Override
    public boolean adjoinsToCoordinatePlateOxz(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double y = basicPoint.getY();
        double sideLength = cube.getSideLength();
        double y2 = y + sideLength;
        return (y == 0 || y2 == 0);
    }

    @Override
    public boolean adjoinsToCoordinatePlateOyz(Cube cube) {
        Point3D basicPoint = cube.getBasicPoint();
        double x = basicPoint.getX();
        double sideLength = cube.getSideLength();
        double x2 = x + sideLength;
        return (x == 0 || x2 == 0);
    }
}
