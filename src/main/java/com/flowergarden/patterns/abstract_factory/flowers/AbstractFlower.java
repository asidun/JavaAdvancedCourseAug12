package com.flowergarden.patterns.abstract_factory.flowers;

/**
 * Created by olena.kruchina on 10/5/2017.
 */
abstract public class AbstractFlower {

    private int length;

    private int freshness;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFreshness() {
        return freshness;
    }

    public void setFreshness(int freshness) {
        this.freshness = freshness;
    }
}
