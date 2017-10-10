package com.flowergarden.bouquet;
import java.util.Collection;

import com.flowergarden.flowers.Flower;
import com.flowergarden.sellers.ISellerList;

public interface Bouquet<T> {
	float getPrice();
	Collection<T> searchFlowersByLenght(int start, int end);
	void sortByFreshness();
	Collection<T> getFlowers();
	public ISellerList getSellerList();
	public void setSellerList(ISellerList sellerList);
	void addFlower(T flower);
}
