package com.epam.cube.model.observer;

import com.epam.cube.model.entity.AbstractShape3D;

public interface Observer<T extends AbstractShape3D> {

    void changeAllProperties(T shape);
}
