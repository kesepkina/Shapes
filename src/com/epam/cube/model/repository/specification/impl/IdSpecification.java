package com.epam.cube.model.repository.specification.impl;

import com.epam.cube.model.entity.Cube;
import com.epam.cube.model.repository.specification.Specification;

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
