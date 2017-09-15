package com.flowergarden.services;

import java.sql.SQLException;
import java.util.List;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.db.BouquetDAO;
import com.flowergarden.exceptions.BouquetException;
import com.flowergarden.exceptions.MaxFlowersInBouquetException;
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
	
	public List<Bouquet> getBouquets() throws BouquetException{		
		List<Bouquet> bouquets = null;
		try {
			bouquets = bouquetDAO.getBouquets();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BouquetException("You can not get all bouquets. "
					+ "See log file for detailed information");
		}
		return bouquets;		
	}
	
	
	public Bouquet getBouquetById(int id) throws BouquetException{
		Bouquet bouquet = null;
		try {
			bouquet = bouquetDAO.getBouquetById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BouquetException("You can not get this bouquet. "
					+ "See log file for detailed information");
		}
		return bouquet;	
	}
	
	public void addRose(int bouquetId) throws BouquetException{
		if (getBouquetById(bouquetId).getFlowers().size() <= MAX_FLOWER_IN_MARRIED_BOUQUET){
			bouquetDAO.addFlower(bouquetId, new Rose(true, 15, 13, new FreshnessInteger(1)));
		}else{
			throw new MaxFlowersInBouquetException("Bouquet rich maximum size." 
		+ MAX_FLOWER_IN_MARRIED_BOUQUET + "flowers");
		}
	}

}
