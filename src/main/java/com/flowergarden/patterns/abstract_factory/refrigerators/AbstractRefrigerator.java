package com.flowergarden.patterns.abstract_factory.refrigerators;

import com.flowergarden.patterns.abstract_factory.flowers.AbstractFlower;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by olena.kruchina on 10/5/2017.
 */
abstract public class AbstractRefrigerator {

    List<AbstractFlower> storedFlowers = new LinkedList<>();
    private int temperature;

    public abstract void fillRefrigerator(AbstractFlower flower);

    public int getTemperature() {
        return temperature;
    }

    void setTemperature(int t) {
        temperature = t;
    }

    public List<AbstractFlower> getStoredFlowers() {
        return storedFlowers;
    }

    public void emptyRefrigerator() {
        storedFlowers = new LinkedList<>();
    }
}
