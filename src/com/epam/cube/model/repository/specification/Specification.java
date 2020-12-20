package com.epam.cube.model.repository.specification;

import com.epam.cube.model.entity.Cube;

@FunctionalInterface
public interface Specification {
    boolean specify(Cube cube);
}
