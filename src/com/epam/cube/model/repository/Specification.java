package com.epam.cube.model.repository;

import com.epam.cube.model.entity.Cube;

@FunctionalInterface
public interface Specification {
    boolean specify(Cube cube);
}
