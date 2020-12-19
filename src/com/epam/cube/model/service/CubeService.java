package com.epam.cube.model.service;

import com.epam.cube.model.entity.AbstractShape3D;
import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.CubePart;

import java.util.Map;

public interface CubeService {

    public double calculateSurfaceArea(Cube cube);
    public double calculateVolume(Cube cube);

    public Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlaneOxy(Cube cube);
    public Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlaneOxz(Cube cube);
    public Map<CubePart, Double> calculateVolumesRatioAfterCuttingByCoordinatePlaneOyz(Cube cube);

    public boolean isCube(AbstractShape3D o);

    public boolean adjoinsToAnyCoordinatePlate(Cube cube);
    public boolean adjoinsToCoordinatePlateOxy(Cube cube);
    public boolean adjoinsToCoordinatePlateOxz(Cube cube);
    public boolean adjoinsToCoordinatePlateOyz(Cube cube);
    }
