package com.flowergarden.services;

import org.junit.Test;

import com.flowergarden.exceptions.BouquetException;

public class BouquetServicesTests {

	@Test(expected=BouquetException.class)
	public void addFlowerExceptionTest() throws BouquetException{
		//Given
		BouquetServices services = new BouquetServices();
		
		//When		
		services.addRose(1);
	}
	
	@Test
	public void addFlowerETest() throws BouquetException{
		//Given
		BouquetServices services = new BouquetServices();
		
		//When		
		services.addRose(2);
	}
	
}
