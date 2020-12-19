package com.epam.cube.model.factory.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Shape3DInternal;
import com.epam.cube.model.entity.Point3D;
import com.epam.cube.model.entity.AbstractShape3D;
import com.epam.cube.model.factory.ShapeFactory;

import java.util.Map;

public class CubeFactory implements ShapeFactory {

    @Override
    public AbstractShape3D createShape() {
        return new Cube();
    }

    @Override
    public AbstractShape3D createShape(Map shapeData) {
        Map<Shape3DInternal, Double> cubeData = shapeData;
        Point3D basicPoint3D = new Point3D(cubeData.get(Shape3DInternal.X), cubeData.get(Shape3DInternal.Y), cubeData.get(Shape3DInternal.Z));
        Cube newCube = new Cube(basicPoint3D, cubeData.get(Shape3DInternal.SIDE_LENGTH));
        return newCube;
    }
}
