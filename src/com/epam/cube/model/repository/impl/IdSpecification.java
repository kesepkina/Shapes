package com.epam.cube.model.repository.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.repository.Specification;

public class IdSpecification implements Specification {

    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cube cube) {
        return (cube.getId() == id);
    }
}
