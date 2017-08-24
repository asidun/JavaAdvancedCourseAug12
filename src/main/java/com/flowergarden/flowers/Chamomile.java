package com.flowergarden.flowers;

import com.flowergarden.properties.FreshnessInteger;

public class Chamomile extends GeneralFlower {

    private int petals;

    public Chamomile() {
        super(20, 10, new FreshnessInteger(1));
        this.petals = 12;
    }

    public Chamomile(int petals, int lenght, float price, FreshnessInteger fresh) {
        super(lenght, price, fresh);
        this.petals = petals;
    }

    public boolean getPetal() {
        if (petals <= 0) return false;
        petals = -1;
        return true;
    }

    public int getPetals() {
        return petals;
    }
}
