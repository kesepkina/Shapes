package com.epam.cube.factory.impl;

import com.epam.cube.entity.Cube;
import com.epam.cube.entity.ShapeProperty;
import com.epam.cube.entity.Point3D;
import com.epam.cube.entity.AbstractShape3D;
import com.epam.cube.factory.ShapeFactory;

import java.util.Map;

public class CubeFactory implements ShapeFactory {

    @Override
    public AbstractShape3D createShape() {
        return new Cube();
    }

    @Override
    public AbstractShape3D createShape(Map shapeData) {
        Map<ShapeProperty, Double> cubeData = shapeData;
        Point3D basicPoint3D = new Point3D(cubeData.get(ShapeProperty.X), cubeData.get(ShapeProperty.Y), cubeData.get(ShapeProperty.Z));
        Cube newCube = new Cube(basicPoint3D, cubeData.get(ShapeProperty.SIDE_LENGTH));
        return newCube;
    }
}
