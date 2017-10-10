package com.flowergarden.sellers;

import java.util.ArrayList;
import java.util.List;

public class SellerList implements ISellerList {	

	private List<Seller> sellers = new ArrayList<>();

	public List<Seller> getSellers() {
		return sellers;
	}

	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}
	
	public void addSeller(Seller seller){
		sellers.add(seller);
	}
	
	public void removeSeller(Seller seller){
		sellers.remove(seller);
	}
	

}
