package com.flowergarden.bouquet;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;
import static org.mockito.Mockito.*;

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
		MarriedBouquet mockBoquete =new MarriedBouquet();
		GeneralFlower flower1 = mock(GeneralFlower.class);
		when(flower1.getLenght()).thenReturn(15);
		GeneralFlower flower2 = mock(GeneralFlower.class);
		when(flower2.getLenght()).thenReturn(25);
		mockBoquete.addFlower(flower1);
		mockBoquete.addFlower(flower2);
		
		ArrayList<GeneralFlower> flowers = new ArrayList<>();
		flowers.add(new Rose(true, 15, 15, new FreshnessInteger(1)));
		flowers.add(new Rose(true, 25, 25, new FreshnessInteger(1)));
		
		//When
		ArrayList<GeneralFlower> result = (ArrayList<GeneralFlower>) mockBoquete.searchFlowersByLenght(15, 26);
		
		//Then
		Assert.assertEquals(flowers.get(0).getLenght(), result.get(0).getLenght());
	}
	
	@Test
	public void verifyGetPrice() {
		//Given
		GeneralFlower flower = mock(GeneralFlower.class);
		boquete.addFlower(flower);
		when(flower.getLenght()).thenReturn(12);
		
		
		//When
		boquete.getPrice();
		
		//Then
		verify(flower).getPrice();

	}

}
