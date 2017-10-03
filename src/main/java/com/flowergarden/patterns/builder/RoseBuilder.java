package com.flowergarden.patterns.builder;

import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

public class RoseBuilder {
	
	private boolean spike;
	private FreshnessInteger freshness;	
	private float price;
	private int lenght;
	
	public RoseBuilder setSpike(boolean spike){
		this.spike = spike;
		return this;
	}
	
	public RoseBuilder setFreshness(int fresh) {
		FreshnessInteger freshness = new FreshnessInteger(fresh);
		this.freshness = freshness;
		return this;
	}

	public RoseBuilder setPrice(float price) {
		this.price = price;
		return this;
	}

	public RoseBuilder setLenght(int lenght) {
		this.lenght = lenght;
		return this;
	}
	
	public Rose build(){
		return new Rose(spike, lenght, price, freshness);
	}

}
