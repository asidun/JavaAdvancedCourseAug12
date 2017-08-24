package com.flowergarden.bouquet;

import com.flowergarden.flowers.Chamomile;
import com.flowergarden.flowers.Rose;
import com.flowergarden.flowers.Tulip;
import com.flowergarden.properties.FreshnessInteger;

/**
 * Created by olena.kruchina on 8/24/2017.
 */
public class MyBouquet extends GeneralBouquet {
    public MyBouquet() {
        addFlower(new Rose(), 1);
        addFlower(new Rose(false, 25, 25, new FreshnessInteger(3)), 1);
        addFlower(new Chamomile(), 1);
        addFlower(new Chamomile(15, 35, 10, new FreshnessInteger(1)), 1);
        addFlower(new Tulip("yellow", 25, 20, new FreshnessInteger(2)), 1);
    }
}
