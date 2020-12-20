package com.epam.cube.model.service;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.CubePart;

import java.util.Map;

public interface CalculatingService {

    double calculateSurfaceArea(Cube cube);

    double calculateVolume(Cube cube);

    double calculateDistanceFromCenterToOrigin(Cube cube);

    Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlaneOxy(Cube cube);

    Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlaneOxz(Cube cube);

    Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlaneOyz(Cube cube);
}
