package com.flowergarden.services;

import java.sql.SQLException;
import java.util.List;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.db.BouquetDAO;
import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

public class BouquetServices {
	
	BouquetDAO bouquetDAO;
	public static final int MAX_FLOWER_IN_MARRIED_BOUQUET = 5;
	
	private BouquetServices() {
	}
	
	public BouquetServices(BouquetDAO dao) {
		bouquetDAO = dao;
	}
	
	public List<Bouquet> getBouquets(){		
		List<Bouquet> bouquets = null;
		try {
			bouquets = bouquetDAO.getBouquets();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bouquets;		
	}
	
	
	public Bouquet getBouquetById(int id){
		Bouquet bouquet = null;
		try {
			bouquet = bouquetDAO.getBouquetById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bouquet;	
	}
	
	public void addRose(int bouquetId){
		if (getBouquetById(bouquetId).getFlowers().size() <= MAX_FLOWER_IN_MARRIED_BOUQUET){
			bouquetDAO.addFlower(new Rose(true, 15, 13, new FreshnessInteger(1)));
		}
	}

}
