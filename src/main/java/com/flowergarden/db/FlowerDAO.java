package com.flowergarden.db;

import java.sql.Connection;
import java.util.List;

import com.flowergarden.flowers.GeneralFlower;

public class FlowerDAO {

	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;		
	}

	public List<GeneralFlower> getFlowersByBouquet(int bouquetId) {
		// TODO Auto-generated method stub
		return null;
	}

}
