package com.flowergarden.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.flowers.GeneralFlower;

public class BouquetDAO {
	
	private Connection conn;

	public List<Bouquet> getBouquets() throws SQLException {
		List<Bouquet> result = new ArrayList<>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from bouquet");
		while(rs.next()){
			FlowerDAO flowerDao = new FlowerDAO();
			flowerDao.setConnection(conn);
			switch (rs.getString("name")) {
			case "married":
				MarriedBouquet mb = new MarriedBouquet();
				List<GeneralFlower> flowers = flowerDao.getFlowersByBouquet(rs.getInt("id"));
				for (GeneralFlower flower : flowers) {
					mb.addFlower(flower);
				}
				result.add(mb);
				break;

			default:
				break;
			}
		}
		return null;
	}

	public Bouquet getBouquetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;		
	}

}
