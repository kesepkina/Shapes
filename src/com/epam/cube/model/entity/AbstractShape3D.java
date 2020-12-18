package com.epam.cube.model.entity;

import com.epam.cube.util.IdGenerator;

public abstract class AbstractShape3D {

    private int id = IdGenerator.generateIntId();
    private Point3D basicPoint3D;

    protected AbstractShape3D() {
    }

    protected AbstractShape3D(Point3D basicPoint3D) {
        this.basicPoint3D = basicPoint3D;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point3D getBasicPoint() {
        return basicPoint3D;
    }

    public void setBasicPoint(Point3D basicPoint3D) {
        this.basicPoint3D = basicPoint3D;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractShape3D abstractShape3D = (AbstractShape3D) o;

        if (id != abstractShape3D.id) return false;
        return basicPoint3D != null ? basicPoint3D.equals(abstractShape3D.basicPoint3D) : abstractShape3D.basicPoint3D == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (basicPoint3D != null ? basicPoint3D.hashCode() : 0);
        return result;
    }
}
