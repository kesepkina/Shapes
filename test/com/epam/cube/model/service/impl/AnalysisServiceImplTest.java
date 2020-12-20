package com.epam.cube.model.service.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.entity.Point3D;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AnalysisServiceImplTest {

    private final AnalysisServiceImpl analysisService = new AnalysisServiceImpl();

    @Test
    public void testIsCube() {
        Cube cube = new Cube();
        boolean isCube = analysisService.isCube(cube);
        assertTrue(isCube);
    }

    @Test
    public void testAdjoinsToAnyCoordinatePlate1() {
        Cube cube = new Cube(new Point3D(0, 1, 2), 4);
        boolean adjoins = analysisService.adjoinsToAnyCoordinatePlate(cube);
        assertTrue(adjoins);
    }

    @Test
    public void testAdjoinsToAnyCoordinatePlate2() {
        Cube cube = new Cube(new Point3D(-4, 1, 2), 4);
        boolean adjoins = analysisService.adjoinsToAnyCoordinatePlate(cube);
        assertTrue(adjoins);
    }

    @Test
    public void testAdjoinsToAnyCoordinatePlate3() {
        Cube cube = new Cube(new Point3D(-4, 1, 2), 5);
        boolean adjoins = analysisService.adjoinsToAnyCoordinatePlate(cube);
        assertFalse(adjoins);
    }

    @Test
    public void testAdjoinsToCoordinatePlateOxy() {
        Cube cube = new Cube(new Point3D(-4, 1, -2.4), 2.4);
        boolean adjoins = analysisService.adjoinsToCoordinatePlateOxy(cube);
        assertTrue(adjoins);
    }

    @Test
    public void testAdjoinsToCoordinatePlateOxz() {
        Cube cube = new Cube(new Point3D(-4, 1, 2), 5);
        boolean adjoins = analysisService.adjoinsToCoordinatePlateOxz(cube);
        assertFalse(adjoins);
    }

    @Test
    public void testAdjoinsToCoordinatePlateOyz() {
        Cube cube = new Cube(new Point3D(0, 1, 2), 243.5);
        boolean adjoins = analysisService.adjoinsToCoordinatePlateOyz(cube);
        assertTrue(adjoins);
    }
}