package com.epam.cube.model.service;

import com.epam.cube.model.entity.Cube;

import java.util.List;

public interface SortingService {

    List<Cube> sortById();

    List<Cube> sortBySideLength();

    List<Cube> sortByDistanceFromCenterToOrdinate();

}
