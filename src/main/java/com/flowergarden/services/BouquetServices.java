package com.flowergarden.services;

import java.sql.SQLException;
import java.util.List;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.db.BouquetDAO;

public class BouquetServices {
	
	BouquetDAO bouquetDAO;
	
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
		Bouquet bouquet = bouquetDAO.getBouquetById(id);
		return bouquet;	
	}

}
