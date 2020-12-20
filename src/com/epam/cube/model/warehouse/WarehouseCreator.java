package com.epam.cube.model.warehouse;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Shape3DProperties;
import com.epam.cube.model.repository.CubeRepository;
import com.epam.cube.model.service.impl.CubeServiceImpl;

public class WarehouseCreator {

    private WarehouseCreator() {
    }

    public static void fillShape3DWarehouse () {

        CubeRepository cubeRepository = CubeRepository.getInstance();
        CubeServiceImpl cubeService = new CubeServiceImpl();
        Shape3DPropertiesWarehouse warehouse = Shape3DPropertiesWarehouse.getInstance();

        int size = cubeRepository.size();

        Cube cube;
        Shape3DProperties properties;
        for(int i = 0; i < size ; i++) {
            cube = cubeRepository.get(i);
            double surfaceArea = cubeService.calculateSurfaceArea(cube);
            double volume = cubeService.calculateVolume(cube);
            double distanceFromCenterToOrigin = cubeService.calculateDistanceFromCenterToOrigin(cube);
            properties = new Shape3DProperties(surfaceArea, volume, distanceFromCenterToOrigin);
            warehouse.putProperties(i, properties);
        }
    }
}