package com.epam.cube.model.repository;

import com.epam.cube.model.entity.Cube;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepository {

    private static final CubeRepository instance = new CubeRepository();
    List<Cube> cubes;

    public CubeRepository() {
        this.cubes = new ArrayList<>();
    }

    public int size() {
        return cubes.size();
    }

    public boolean isEmpty() {
        return cubes.isEmpty();
    }

    public boolean contains(Object o) {
        return cubes.contains(o);
    }

    public boolean add(Cube cube) {
        return cubes.add(cube);
    }

    public boolean remove(Object o) {
        return cubes.remove(o);
    }

    public boolean addAll(Collection<? extends Cube> c) {
        return cubes.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return cubes.removeAll(c);
    }

    public Cube get(int index) {
        return cubes.get(index);
    }

    public Cube set(int index, Cube element) {
        return cubes.set(index, element);
    }

    public void add(int index, Cube element) {
        cubes.add(index, element);
    }

    public Cube remove(int index) {
        return cubes.remove(index);
    }

    public List<Cube> query(Specification specification) {
        List<Cube> resultList = cubes.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        return resultList;
    }
    //sorts
}
