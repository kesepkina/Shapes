package com.epam.cube.model.warehouse;

import com.epam.cube.model.entity.Shape3DProperties;

import java.util.HashMap;
import java.util.Map;

public class Shape3DPropertiesWarehouse {

    private static final Shape3DPropertiesWarehouse instance = new Shape3DPropertiesWarehouse();
    private Map<Integer, Shape3DProperties> propertiesMap;

    private Shape3DPropertiesWarehouse() {
        this.propertiesMap = new HashMap<>();
    }

    public static Shape3DPropertiesWarehouse getInstance() {
        return instance;
    }

    public void setPropertiesMap(Map<Integer, Shape3DProperties> propertiesMap) {
        this.propertiesMap = propertiesMap;
    }

    public void putProperties(Integer shapeId, Shape3DProperties shapeProperties) {
        propertiesMap.put(shapeId, shapeProperties);
    }

    public void removeProperties(Integer shapeId) {
        propertiesMap.remove(shapeId);
    }

    public Shape3DProperties getProperties(Integer shapeId) {
        Shape3DProperties properties = propertiesMap.get(shapeId);
        Shape3DProperties propertiesCopy = new Shape3DProperties(properties);
        return propertiesCopy;
    }
}
