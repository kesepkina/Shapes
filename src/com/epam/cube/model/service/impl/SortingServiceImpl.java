package com.epam.cube.model.service.impl;

import com.epam.cube.model.comparator.CubeComparator;
import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.repository.CubeRepository;
import com.epam.cube.model.service.SortingService;

import java.util.List;

public class SortingServiceImpl implements SortingService {

    private final CubeRepository repository = CubeRepository.getInstance();

    @Override
    public List<Cube> sortById() {
        List<Cube> cubes = repository.getCubes();
        cubes.sort(CubeComparator.ID);
        return cubes;
    }

    @Override
    public List<Cube> sortBySideLength() {
        List<Cube> cubes = repository.getCubes();
        cubes.sort(CubeComparator.SIDE_LENGTH);
        return cubes;
    }

    @Override
    public List<Cube> sortByDistanceFromCenterToOrdinate() {
        List<Cube> cubes = repository.getCubes();
        cubes.sort(CubeComparator.DISTANCE_FROM_CENTER_TO_ORIGIN);
        return cubes;
    }
}
