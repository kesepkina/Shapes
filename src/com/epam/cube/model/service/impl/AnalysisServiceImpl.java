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
