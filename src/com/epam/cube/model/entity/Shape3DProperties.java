package com.epam.cube.model.entity;

import java.util.StringJoiner;

public class Shape3DProperties {

    private double surfaceArea;
    private double volume;

    public Shape3DProperties() {
    }

    public Shape3DProperties(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Shape3DProperties.class.getSimpleName() + "[", "]")
                .add("surfaceArea=" + surfaceArea)
                .add("volume=" + volume)
                .toString();
    }
}
