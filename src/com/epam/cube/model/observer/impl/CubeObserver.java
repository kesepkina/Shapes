package com.epam.cube.model.observer.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Shape3DProperties;
import com.epam.cube.model.observer.Observer;
import com.epam.cube.model.service.impl.CubeServiceImpl;
import com.epam.cube.model.warehouse.Shape3DPropertiesWarehouse;

public class CubeObserver implements Observer<Cube> {

    private static final CubeServiceImpl cubeService = new CubeServiceImpl();

    @Override
    public void changeAllProperties(Cube shape) {
        double surfaceArea = cubeService.calculateSurfaceArea(shape);
        double volume = cubeService.calculateVolume(shape);
        double distanceFromCenterToOrigin = cubeService.calculateDistanceFromCenterToOrigin(shape);
        Shape3DProperties properties = new Shape3DProperties(surfaceArea, volume, distanceFromCenterToOrigin);
        int id = shape.getId();
        Shape3DPropertiesWarehouse.getInstance().putProperties(id, properties);
    }
}
