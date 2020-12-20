package com.epam.cube.model.service.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Point3D;
import com.epam.cube.model.repository.CubeRepository;
import com.epam.cube.model.warehouse.WarehouseCreator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SortingServiceImplTest {

    private Cube cube1, cube2, cube3, cube4;
    private final CubeRepository repository = CubeRepository.getInstance();
    private final SortingServiceImpl sortingService = new SortingServiceImpl();

    @BeforeClass
    public void setUp() {
        cube1 = new Cube(new Point3D(0,99.3,0), 2);
        cube2 = new Cube(new Point3D(-2, -2, -2), 4);
        cube3 = new Cube(new Point3D(30,-45.6,53.4), 10);
        cube4 = new Cube(new Point3D(-20, -25, -18.7), 40.2);
        repository.add(cube1);
        repository.add(cube2);
        repository.add(cube3);
        repository.add(cube4);
        WarehouseCreator.fillShape3DWarehouse();
    }

    @Test
    public void testSortById1() {
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        expected.add(cube2);
        expected.add(cube3);
        expected.add(cube4);
        List<Cube> actual = sortingService.sortById();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortById2() {
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        expected.add(cube2);
        expected.add(cube4);
        expected.add(cube3);
        List<Cube> actual = sortingService.sortById();
        assertNotEquals(actual, expected);
    }

    @Test
    public void testSortBySideLength() {
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        expected.add(cube2);
        expected.add(cube3);
        expected.add(cube4);
        List<Cube> actual = sortingService.sortBySideLength();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByDistanceFromCenterToOrdinate() {
        List<Cube> expected = new ArrayList<>();
        expected.add(cube2);
        expected.add(cube4);
        expected.add(cube3);
        expected.add(cube1);
        List<Cube> actual = sortingService.sortByDistanceFromCenterToOrdinate();
        assertEquals(actual, expected);
    }
}