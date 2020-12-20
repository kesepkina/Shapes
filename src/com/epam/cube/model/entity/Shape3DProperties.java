package com.epam.cube.model.entity;

import java.util.StringJoiner;

public class Shape3DProperties {

    private double surfaceArea;
    private double volume;
    private double distanceFromCenterToOrigin;

    public Shape3DProperties() {
    }

    public Shape3DProperties(double surfaceArea, double volume, double distanceFromCenterToOrigin) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
        this.distanceFromCenterToOrigin = distanceFromCenterToOrigin;
    }

    public Shape3DProperties(Shape3DProperties properties) {
        this(properties.getSurfaceArea(), properties.getVolume(), properties.getDistanceFromCenterToOrigin());
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

    public double getDistanceFromCenterToOrigin() {
        return distanceFromCenterToOrigin;
    }

    public void setDistanceFromCenterToOrigin(double distanceFromCenterToOrigin) {
        this.distanceFromCenterToOrigin = distanceFromCenterToOrigin;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Shape3DProperties.class.getSimpleName() + "[", "]")
                .add("surfaceArea=" + surfaceArea)
                .add("volume=" + volume)
                .add("distanceFromCenterToOrigin=" + distanceFromCenterToOrigin)
                .toString();
    }
}
