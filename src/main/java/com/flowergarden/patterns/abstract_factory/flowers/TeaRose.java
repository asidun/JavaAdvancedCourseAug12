package com.flowergarden.patterns.abstract_factory.flowers;

/**
 * Created by olena.kruchina on 10/5/2017.
 */
public class TeaRose extends AbstractFlower {

    private int petals;

    private boolean isReadyToInfuse;

    public TeaRose(int petals, boolean isReadyToInfuse, int length, int freshness) {
        setPetals(petals);
        setReadyToInfuse(isReadyToInfuse);
        setLength(length);
        setFreshness(freshness);
    }

    public int getPetals() {
        return petals;
    }

    public void setPetals(int petals) {
        this.petals = petals;
    }

    public boolean isReadyToInfuse() {
        return isReadyToInfuse;
    }

    public void setReadyToInfuse(boolean readyToInfuse) {
        isReadyToInfuse = readyToInfuse;
    }
}
