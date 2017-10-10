package com.flowergarden.bouquet.manage;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.properties.FreshnessInteger;
import com.flowergarden.sellers.Seller;

public class ChangeFreshnes<T extends GeneralFlower> {
	
	Bouquet<T> bouquet = null;
	
	
	public ChangeFreshnes(Bouquet<T> bouquet){
		this.bouquet = bouquet;
	}
	
	public void reduceFreshnes(){
		for (T generalFlower : bouquet.getFlowers()) {
			generalFlower.setFreshness(new FreshnessInteger(
					generalFlower.getFreshness().getFreshness() - 1));
		}
		notifyObservers();
	}

	private void notifyObservers() {
				for (Seller seller : bouquet.getSellerList().getSellers()) {
					seller.HandleEvent();
				}
	}

}
