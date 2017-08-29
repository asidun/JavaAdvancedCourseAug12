package com.flowergarden.flowers;

import javax.xml.bind.annotation.XmlElement;

import com.flowergarden.properties.FreshnessInteger;

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
	public int compareTo(GeneralFlower compareFlower) {
		int compareFresh = compareFlower.getFreshness().getFreshness();		
		return this.getFreshness().getFreshness() - compareFresh;
	}

}
