package com.flowergarden.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;

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
				MarriedBouquet mb = createMarriedBouquet(rs, flowerDao);
				result.add(mb);
				break;

			default:
				break;
			}
		}
		return result;
	}

	private MarriedBouquet createMarriedBouquet(ResultSet rs, FlowerDAO flowerDao) throws SQLException {
		MarriedBouquet mb = new MarriedBouquet();
		List<GeneralFlower> flowers = flowerDao.getFlowersByBouquet(rs.getInt("id"));
		for (GeneralFlower flower : flowers) {
			mb.addFlower(flower);
		}
		return mb;
	}

	public Bouquet getBouquetById(int id) throws SQLException {
		Bouquet<GeneralFlower> result = null;
		PreparedStatement stmt = conn.prepareStatement("select * from bouquet where id = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		FlowerDAO flowerDao = new FlowerDAO();
		flowerDao.setConnection(conn);
		switch (rs.getString("name")) {
		case "married":
			result = createMarriedBouquet(rs, flowerDao);
			break;

		default:
			break;
		}
		return result;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;		
	}

	public void addFlower(GeneralFlower flower) {
		// TODO Auto-generated method stub
		
	}

}
