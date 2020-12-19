package com.epam.cube.model.factory;

import com.epam.cube.model.entity.AbstractShape3D;
import com.epam.cube.model.entity.Shape3DInternal;

import java.util.Map;

public interface ShapeFactory<T extends AbstractShape3D> {

    T createShape();
    T createShape(Map<Shape3DInternal, Double> shapeData);
}
