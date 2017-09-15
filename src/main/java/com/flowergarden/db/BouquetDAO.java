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
import com.flowergarden.flowers.Chamomile;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

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

	public void addFlower(int bouquetId, GeneralFlower flower) throws SQLException {			
		String name = flower.getClass().getSimpleName().toLowerCase();
		
		switch (name) {
		case "rose":
			long id;
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO flower "
					+ "(name, spike, lenght, price, freshness, bouquet_id) VALUES (?, ?, ?, ?, ?, ?)");
			Rose rose = (Rose)flower;
			stmt.setString(1, name);
			stmt.setBoolean(2, rose.getSpike());
			stmt.setInt(3, rose.getLenght());
			stmt.setFloat(4, rose.getPrice());
			stmt.setInt(5, rose.getFreshness().getFreshness());
			stmt.setInt(6, bouquetId);
			stmt.executeUpdate();
			
// Example. Get inserted ID
//			ResultSet generatedKeys = stmt.getGeneratedKeys();
//	        if (generatedKeys.next()) {
//	                id = generatedKeys.getLong(1);
//	        }else{
//	        	throw new SQLException("Can not get autogenered key");
//	        }
			
			break;
			
		case "chamomile":
			
			break;

		default:
			break;
		}
		
		
	}

}
