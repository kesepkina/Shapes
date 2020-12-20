package com.epam.cube.model.observer;

public interface Observable {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();
}
