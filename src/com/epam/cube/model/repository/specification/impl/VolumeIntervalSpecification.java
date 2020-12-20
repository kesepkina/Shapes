package com.epam.cube.model.repository.specification.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Shape3DProperties;
import com.epam.cube.model.repository.specification.Specification;
import com.epam.cube.model.warehouse.Shape3DPropertiesWarehouse;

public class VolumeIntervalSpecification implements Specification{

    private final double volumeFrom;
    private final double volumeTo;

    public VolumeIntervalSpecification(double volumeFrom, double volumeTo) {
        this.volumeFrom = volumeFrom;
        this.volumeTo = volumeTo;
    }

    @Override
    public boolean specify(Cube cube) {
        int id = cube.getId();
        Shape3DProperties cubeProperties = Shape3DPropertiesWarehouse.getInstance().getProperties(id);
        double volume = cubeProperties.getVolume();
        return (volume >= volumeFrom && volume <= volumeTo);
    }
}
