package com.flowergarden.flowers;

import javax.xml.bind.annotation.XmlRootElement;

import com.flowergarden.properties.FreshnessInteger;

public class Rose extends GeneralFlower {
	
	private boolean spike;
	
	public Rose(boolean spike, int lenght, float price, FreshnessInteger fresh){
		super(lenght, price, fresh);
		this.spike = spike;
		
	}
	public Rose(){
		
	}
	
	public boolean getSpike(){
		return spike;
	}
	


}
