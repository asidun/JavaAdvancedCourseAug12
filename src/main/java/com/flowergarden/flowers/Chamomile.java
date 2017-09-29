package com.flowergarden.flowers;

import javax.xml.bind.annotation.XmlRootElement;

import com.flowergarden.properties.FreshnessInteger;

@XmlRootElement
public class Chamomile extends GeneralFlower {
	
	private int petals;
	
	public Chamomile(){
		
	}
	
	public Chamomile(int petals, int lenght, float price, FreshnessInteger fresh){
		super(lenght, price, fresh);
		this.petals = petals;
	}
	
	public boolean getPetal(){
		if (petals <=0) return false;
		petals =-1;
		return true;
	}
	
	public int getPetals(){
		return petals;
	}

	@Override
	public GeneralFlower getFlower() {
		return new Chamomile(5, 10, 12, new FreshnessInteger(1));
	}
	


}
