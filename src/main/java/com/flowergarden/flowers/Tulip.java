package com.flowergarden.flowers;


public class Tulip extends GeneralFlower {

	@Override
	public GeneralFlower getFlower() {
		return new Tulip();
	}	

}
