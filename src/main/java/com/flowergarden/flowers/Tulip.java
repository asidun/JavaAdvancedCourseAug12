package com.flowergarden.flowers;


import com.flowergarden.properties.FreshnessInteger;

public class Tulip extends GeneralFlower {

    private String color;

    public Tulip() {
        super(20, 10, new FreshnessInteger(1));
        this.color = "red";
    }

    public Tulip(String color, int lenght, float price, FreshnessInteger fresh) {
        super(lenght, price, fresh);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
