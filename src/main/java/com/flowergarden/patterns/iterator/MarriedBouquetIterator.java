package com.flowergarden.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

import com.flowergarden.flowers.Flower;
import com.flowergarden.flowers.GeneralFlower;

public class MarriedBouquetIterator implements Iterator {
	
	private List<GeneralFlower> list;
	private int index = 0;
	
	public MarriedBouquetIterator(List<GeneralFlower> flowerList) {
		this.list = flowerList;
	}

	@Override
	public Flower<Integer> getNext() {
		index +=1;
		return list.get(index);
	}

	@Override
	public Flower<Integer> getPrevious() {
		index -=1;
		return list.get(index);
	}

	@Override
	public Flower<Integer> getCurrent() {
		return list.get(index);
	}

}
