package com.flowergarden.flowers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.flowergarden.properties.FreshnessInteger;

@XmlRootElement
public class Rose extends GeneralFlower {
	
	private boolean spike;
	
	public Rose(boolean spike, int lenght, float price, FreshnessInteger fresh){
		super(lenght, price, fresh);
		this.spike = spike;
		
	}
	public Rose(){
		
	}
	
	@XmlElement
	public boolean getSpike(){
		return spike;
	}
	
	public void setSpike(boolean spike) {
		this.spike = spike;
	}
	
	@Override
	public boolean equals(Object o){
		Rose rose = (Rose) o;
		if (rose.spike == spike 
				&& rose.getLenght() == getLenght() 
				&& rose.getPrice() == getPrice() 
				&& rose.getFreshness().getFreshness() == getFreshness().getFreshness() ){
			return true;
		}
		
		return false;
		
	}
	@Override
	public GeneralFlower getFlower() {
		return new Rose(true, 12, 35, new FreshnessInteger(1));
	}
	


}
