package com.epam.cube.model.repository.specification.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Shape3DProperties;
import com.epam.cube.model.repository.specification.Specification;
import com.epam.cube.model.warehouse.Shape3DPropertiesWarehouse;

public class SurfaceAreaIntervalSpecification implements Specification {

    private final double surfaceAreaFrom;
    private final double surfaceAreaTo;

    public SurfaceAreaIntervalSpecification(double surfaceAreaFrom, double surfaceAreaTo) {
        this.surfaceAreaFrom = surfaceAreaFrom;
        this.surfaceAreaTo = surfaceAreaTo;
    }

    @Override
    public boolean specify(Cube cube) {
        int id = cube.getId();
        Shape3DProperties cubeProperties = Shape3DPropertiesWarehouse.getInstance().getProperties(id);
        double surfaceArea = cubeProperties.getSurfaceArea();
        return (surfaceArea >= surfaceAreaFrom && surfaceArea <= surfaceAreaTo);
    }
}
