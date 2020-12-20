package com.epam.cube.model.service.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.CubePart;
import com.epam.cube.model.entity.Point3D;
import com.epam.cube.model.repository.CubeRepository;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.testng.Assert.*;

public class CalculatingServiceImplTest {

    private final CubeRepository cubeRepository = CubeRepository.getInstance();
    private final CalculatingServiceImpl calculatingService = new CalculatingServiceImpl();
    private Cube cube;

    @BeforeClass
    public void setCube() {
        cube = new Cube(new Point3D(0,0,0), 2);
        cubeRepository.add(new Cube(new Point3D(0, 0, 0), 3));
        cubeRepository.add(new Cube(new Point3D(-1, 2, 0), 3));
        cubeRepository.add(new Cube(new Point3D(3, 0, -9), 2));
        cubeRepository.add(new Cube(new Point3D(0, -6.7, -7.9), 3.5));
        cubeRepository.add(new Cube(new Point3D(-3.5, -7, 4), 2));
        cubeRepository.add(new Cube(new Point3D(-19, -13.5, -12.75), 10));
        cubeRepository.add(new Cube(new Point3D(5, -9, 5), 3.43));
        cubeRepository.add(new Cube(new Point3D(-45.5, 3, -90), 45));
        cubeRepository.add(new Cube(new Point3D(6, 2, 3.6), 3));
        cubeRepository.add(new Cube(new Point3D(-23.4, 0, 5), 13));
    }

    @Test
    public void testCalculateSurfaceArea() {
        double expected = 24;
        double actual = calculatingService.calculateSurfaceArea(cube);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateVolume() {
        double expected = 8;
        double actual = calculatingService.calculateVolume(cube);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateDistanceFromCenterToOrigin() {
        double expected = Math.sqrt(3);
        double actual = calculatingService.calculateDistanceFromCenterToOrigin(cube);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateVolumesRatioAfterCuttingByCoordinatePlaneOxy() {
        Cube customCube = new Cube(new Point3D(0,0,-1), 2);
        Map<CubePart, Double> expected = new EnumMap<>(CubePart.class);
        expected.put(CubePart.ABOVE_OXY_PLATE, 1.);
        expected.put(CubePart.UNDER_OXY_PLATE, 1.);
        Map<CubePart, Double> actual = calculatingService.calculateVolumesRatioAfterCuttingByCoordinatePlaneOxy(customCube);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateVolumesRatioAfterCuttingByCoordinatePlaneOxz() {
        Cube customCube = new Cube(new Point3D(0,-1,0), 2);
        Map<CubePart, Double> expected = new EnumMap<>(CubePart.class);
        expected.put(CubePart.ON_THE_LEFT_OF_OXZ_PLATE, 1.);
        expected.put(CubePart.ON_THE_RIGHT_OF_OXZ_PLATE, 1.);
        Map<CubePart, Double> actual = calculatingService.calculateVolumesRatioAfterCuttingByCoordinatePlaneOxz(customCube);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateVolumesRatioAfterCuttingByCoordinatePlaneOyz() {
        Cube customCube = new Cube(new Point3D(-1,0,0), 2);
        Map<CubePart, Double> expected = new EnumMap<>(CubePart.class);
        expected.put(CubePart.IN_FRONT_OF_OYZ_PLATE, 1.);
        expected.put(CubePart.BEHIND_OYZ_PLATE, 1.);
        Map<CubePart, Double> actual = calculatingService.calculateVolumesRatioAfterCuttingByCoordinatePlaneOyz(customCube);
        assertEquals(actual, expected);
    }
}