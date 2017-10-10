package com.flowergarden.patterns.abstract_factory.flowers;

/**
 * Created by olena.kruchina on 10/5/2017.
 */
public class HollandRose extends AbstractFlower {

    private int petals;

    private boolean hasAroma;

    public HollandRose(int petals, boolean hasAroma, int length, int freshness) {
        setPetals(petals);
        setHasAroma(hasAroma);
        setLength(length);
        setFreshness(freshness);
    }

    public int getPetals() {
        return petals;
    }

    public void setPetals(int petals) {
        this.petals = petals;
    }

    public boolean isHasAroma() {
        return hasAroma;
    }

    public void setHasAroma(boolean hasAroma) {
        this.hasAroma = hasAroma;
    }
}
