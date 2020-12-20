package com.epam.cube.model.service;

import com.epam.cube.model.entity.AbstractShape3D;
import com.epam.cube.model.entity.Cube;

public interface AnalysisService {

    boolean isCube(AbstractShape3D o);

    boolean adjoinsToAnyCoordinatePlate(Cube cube);

    boolean adjoinsToCoordinatePlateOxy(Cube cube);

    boolean adjoinsToCoordinatePlateOxz(Cube cube);

    boolean adjoinsToCoordinatePlateOyz(Cube cube);

}
