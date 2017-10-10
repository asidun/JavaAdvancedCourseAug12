package com.flowergarden.bouquet;
import java.util.Collection;

import com.flowergarden.sellers.SellerList;

public interface Bouquet<T> {
	float getPrice();
	void addFlower(T flower);
	Collection<T> searchFlowersByLenght(int start, int end);
	void sortByFreshness();
	Collection<T> getFlowers();
	public SellerList getSellerList();
	public void setSellerList(SellerList sellerList);
}
