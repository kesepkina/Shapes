package com.epam.cube.model.observer;

import com.epam.cube.model.entity.AbstractShape3D;
import com.epam.cube.model.entity.Cube;

public interface Observable {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();
}
