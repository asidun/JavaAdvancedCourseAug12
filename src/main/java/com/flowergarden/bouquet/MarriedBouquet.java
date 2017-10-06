package com.flowergarden.bouquet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.flowergarden.flowers.Flower;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.patterns.iterator.Iterator;
import com.flowergarden.patterns.iterator.MarriedBouquetIterator;
import com.flowergarden.patterns.observer.Seller;
import com.flowergarden.properties.FreshnessInteger;

@XmlRootElement
public class MarriedBouquet implements Bouquet<GeneralFlower>, Cloneable{
	@XmlElement
	private float assemblePrice = 120;
	@XmlElement
	private List<GeneralFlower> flowerList = new ArrayList<>();
	private List<Seller> sellers = new ArrayList<>();

	@Override
	public float getPrice() {
		float price = assemblePrice;
		for (GeneralFlower flower : flowerList) {
			price += flower.getPrice();
		}
		return price;
	}

	@Override
	public void addFlower(GeneralFlower flower) {
			flowerList.add(flower);
	}

	@Override
	public Collection<GeneralFlower> searchFlowersByLenght(int start, int end) {
		List<GeneralFlower> searchResult = new ArrayList<GeneralFlower>();
		for (GeneralFlower flower : flowerList) {
			if (flower.getLenght() >= start && flower.getLenght() <= end) {
				searchResult.add(flower);
			}
		}
		return searchResult;
	}

	@Override
	public void sortByFreshness() {
		Collections.sort(flowerList);
	}

	@Override
	public Collection<GeneralFlower> getFlowers() {
		return flowerList;
	}

	public void setAssembledPrice(float price) {
		assemblePrice = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(assemblePrice);
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
		MarriedBouquet other = (MarriedBouquet) obj;
		if (Float.floatToIntBits(assemblePrice) != Float.floatToIntBits(other.assemblePrice))
			return false;
		return true;
	}
	
	@Override
	public MarriedBouquet clone(){
		MarriedBouquet clone = new MarriedBouquet();
		clone.assemblePrice = this.assemblePrice;
		for (GeneralFlower generalFlower : flowerList) {
			clone.addFlower(generalFlower.clone());
		}
		return clone;
	}
	
	Iterator getIterator(){
		return new MarriedBouquetIterator(flowerList);
	}

	public void reduceFreshnes(){
		for (GeneralFlower generalFlower : flowerList) {
			generalFlower.setFreshness(new FreshnessInteger(
					generalFlower.getFreshness().getFreshness() - 1));
		}
		notifyObservers();
	}

	private void notifyObservers() {
				for (Seller seller : sellers) {
					seller.HandleEvent();
				}
	}
	
	public void addSeller(Seller seller){
		sellers.add(seller);
	}
	
	public void removeSeller(Seller seller){
		sellers.remove(seller);
	}
	
	
}
