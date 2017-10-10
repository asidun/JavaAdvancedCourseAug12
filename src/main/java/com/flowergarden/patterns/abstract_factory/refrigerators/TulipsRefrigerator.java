package com.flowergarden.patterns.abstract_factory.refrigerators;

import com.flowergarden.patterns.abstract_factory.flowers.AbstractFlower;

/**
 * Created by olena.kruchina on 10/5/2017.
 */
public class TulipsRefrigerator extends AbstractRefrigerator {

    @Override
    public void fillRefrigerator(AbstractFlower flower) {
        getStoredFlowers().add(flower);
        setTemperature(15);
    }
}
