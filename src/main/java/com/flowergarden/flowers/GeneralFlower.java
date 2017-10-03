package com.flowergarden.flowers;

import javax.xml.bind.annotation.XmlElement;

import com.flowergarden.properties.FreshnessInteger;

public abstract class GeneralFlower implements Flower<Integer>, Comparable<GeneralFlower>{
	
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
	
	public abstract GeneralFlower getFlower();
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((freshness == null) ? 0 : freshness.hashCode());
		result = prime * result + lenght;
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeneralFlower other = (GeneralFlower) obj;
		if (freshness == null) {
			if (other.freshness != null)
				return false;
		} else if (!freshness.equals(other.freshness))
			return false;
		if (lenght != other.lenght)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}
	
	@Override
	public abstract GeneralFlower clone();

	
	
}
