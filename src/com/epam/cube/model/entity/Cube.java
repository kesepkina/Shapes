package com.epam.cube.model.entity;

import com.epam.cube.model.observer.Observable;
import com.epam.cube.model.observer.Observer;

import java.util.StringJoiner;

public class Cube extends AbstractShape3D implements Observable {

    // basicPoint is the farthest lower left corner of cube

    private double sideLength;
    private Observer observer;

    public Cube() {
        sideLength = 1;
    }

    public Cube(Point3D basicPoint3D) {
        super(basicPoint3D);
        sideLength = 1;
    }

    public Cube(Point3D basicPoint3D, double sideLength) {
        super(basicPoint3D);
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
        notifyObserver();
    }

    @Override
    public void attach(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void detach(Observer observer) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if(observer != null) {
            observer.changeAllProperties(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cube cube = (Cube) o;

        return Double.compare(cube.sideLength, sideLength) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(sideLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cube.class.getSimpleName() + "[", "]")
                .add("id=" + super.getId())
                .add("basicPoint=" + super.getBasicPoint())
                .add("sideLength=" + sideLength)
                .toString();
    }
}
