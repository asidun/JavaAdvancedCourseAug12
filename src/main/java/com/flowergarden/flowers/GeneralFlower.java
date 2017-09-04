package com.flowergarden.flowers;

import com.flowergarden.properties.FreshnessInteger;

import javax.xml.bind.annotation.XmlElement;

//implements Comparable interface (its method compareTo()) to help Collections.sort()
public class GeneralFlower implements Flower<Integer>, Comparable<GeneralFlower> {
	
	private FreshnessInteger freshness;
	@XmlElement
	private float price;
	@XmlElement
	private int lenght;
	
	public GeneralFlower(int lenght, float price, FreshnessInteger fresh){
		this.lenght = lenght;
		this.price = price;
		this.freshness = fresh;
	}
	
	public GeneralFlower(){
		
	}
		
	public void setFreshness(FreshnessInteger fr){
		freshness = fr;
	}
	
	@Override
	public FreshnessInteger getFreshness() {
		return freshness;
	}

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public int getLenght() {
		return lenght;
	}

	@Override
	public int compareTo(GeneralFlower compareFlower) { //will help Collections.sort()
		int compareFresh = compareFlower.getFreshness().getFreshness();		
		return this.getFreshness().getFreshness() - compareFresh; //we'll get -1 or 0 or 1
	}
}
