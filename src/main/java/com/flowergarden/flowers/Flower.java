package com.flowergarden.flowers;

import com.flowergarden.properties.Freshness;

public interface Flower<T> extends Cloneable {
	Freshness<T> getFreshness();
	float getPrice();
	int getLenght();
	Flower<T> clone();
}
