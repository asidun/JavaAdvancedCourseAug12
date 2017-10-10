package com.flowergarden.patterns.abstract_factory;

import com.flowergarden.patterns.abstract_factory.flowers.AbstractFlower;
import com.flowergarden.patterns.abstract_factory.flowers.HollandRose;
import com.flowergarden.patterns.abstract_factory.flowers.TeaRose;
import com.flowergarden.patterns.abstract_factory.refrigerators.AbstractRefrigerator;
import com.flowergarden.patterns.abstract_factory.refrigerators.RosesRefrigerator;

/**
 * Created by olena.kruchina on 10/5/2017.
 */
public class RunAbstractFactory {
    public static void main(String[] args) {
        AbstractFlower teaRose1 = new TeaRose(20, true, 15, 1);
        AbstractFlower teaRose2 = new TeaRose(23, false, 17, 2);
        AbstractFlower teaRose3 = new TeaRose(29, true, 14, 1);

        AbstractFlower hollandRose1 = new HollandRose(13, false, 30, 1);
        AbstractFlower hollandRose2 = new HollandRose(14, true, 25, 1);

        AbstractRefrigerator refrigerator = new RosesRefrigerator();
        refrigerator.fillRefrigerator(hollandRose1);
        refrigerator.fillRefrigerator(hollandRose2);
        refrigerator.fillRefrigerator(teaRose1);
        refrigerator.fillRefrigerator(teaRose2);
        refrigerator.fillRefrigerator(teaRose3);


        System.out.println(teaRose1.getLength());
        System.out.println("-----");
        for (AbstractFlower f : refrigerator.getStoredFlowers())
            System.out.println(f.getLength());
    }
}
