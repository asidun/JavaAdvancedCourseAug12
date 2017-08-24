package com.flowergarden.bouquet;

import com.flowergarden.flowers.GeneralFlower;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by olena.kruchina on 8/24/2017.
 */
public class GeneralBouquet implements Bouquet<GeneralFlower> {

    private float price = 0;
    private List<GeneralFlower> flowerList = new ArrayList<>();

    @Override
    public float getPrice() {
        return price;
    }

    private void incrementPrice(float price) {
        this.price += price;
    }

    @Override
    public void addFlower(GeneralFlower flower) {
        flowerList.add(flower);
        incrementPrice(flower.getPrice());
    }

    public void addFlower(GeneralFlower flower, int count) {
        for (int i = 0; i < count; i++) {
            flowerList.add(flower);
            incrementPrice(flower.getPrice());
        }
    }

    @Override
    public Collection<GeneralFlower> searchFlowersByLenght(int start, int end) {
        List<GeneralFlower> searchResult = new ArrayList<GeneralFlower>();
        for (GeneralFlower flower : flowerList) {
            if (flower.getLenght() >= start && flower.getLenght() <= end) {
                searchResult.add(flower);
            }
        }
        return searchResult;
    }

    @Override
    public void sortByFreshness() {
        Collections.sort(flowerList);
    }

    @Override
    public Collection<GeneralFlower> getFlowers() {
        return flowerList;
    }
}
