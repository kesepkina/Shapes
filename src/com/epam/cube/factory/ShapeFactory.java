package com.epam.cube.factory;

import com.epam.cube.entity.AbstractShape3D;
import com.epam.cube.entity.ShapeProperty;

import java.util.Map;

public interface ShapeFactory<T extends AbstractShape3D> {

    T createShape();
    T createShape(Map<ShapeProperty, Double> shapeData);
}
