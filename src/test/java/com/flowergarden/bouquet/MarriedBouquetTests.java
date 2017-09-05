package com.flowergarden.bouquet;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

import org.junit.Assert;

public class MarriedBouquetTests {
	
	private MarriedBouquet boquete = new MarriedBouquet();
	
	@Before
	public void makeBoquete(){
		boquete.addFlower(new Rose(true, 15, 15, new FreshnessInteger(1)));
		boquete.addFlower(new Rose(true, 25, 25, new FreshnessInteger(1)));
		boquete.addFlower(new Rose(true, 5, 5, new FreshnessInteger(1)));
		boquete.addFlower(new Rose(true, 2, 2, new FreshnessInteger(1)));
		boquete.addFlower(new Rose(true, 10, 10, new FreshnessInteger(1)));
	}
	
	@Test
	public void searchFlowersByLenghtTest(){
		//Given
		Collection<GeneralFlower> flowers = new ArrayList<>();
		flowers.add(new Rose(true, 15, 15, new FreshnessInteger(1)));
		flowers.add(new Rose(true, 25, 25, new FreshnessInteger(1)));
		
		//When
		Collection<GeneralFlower> result = boquete.searchFlowersByLenght(15, 26);
		
		//Then
		Assert.assertEquals(flowers, result);
	}

}
