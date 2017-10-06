package com.flowergarden.patterns.iterator;

import com.flowergarden.flowers.Flower;

public interface Iterator {
	
	Flower<Integer> getNext();
	Flower<Integer> getPrevious();
	Flower<Integer> getCurrent();

}
