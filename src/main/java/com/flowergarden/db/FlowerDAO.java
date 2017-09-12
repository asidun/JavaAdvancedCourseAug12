package com.flowergarden.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.flowers.Chamomile;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

public class FlowerDAO {

	private static final String CHAMOMILE_NAME = "chamomile";
	private static final String ROSE_NAME = "rose";
	private Connection conn;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public List<GeneralFlower> getFlowersByBouquet(int bouquetId) throws SQLException {
		List<GeneralFlower> result = new ArrayList<>();
		PreparedStatement pstmt = conn.prepareStatement("select * from flower where bouquet_id = ?");
		pstmt.setInt(1, bouquetId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			switch (rs.getString("name")) {
			case ROSE_NAME:
				result.add(new Rose(rs.getBoolean("spike"), rs.getInt("lenght"), 
						rs.getFloat("price"), new FreshnessInteger(rs.getInt("freshness"))));
				break;
			case CHAMOMILE_NAME:
				result.add(new Chamomile(rs.getInt("petals"), rs.getInt("lenght"), 
						rs.getFloat("price"), new FreshnessInteger(rs.getInt("freshness"))));
				break;

			default:
				break;
			}
		}
		
		return result;
	}
	
	private void showMetadata(ResultSet rst) throws SQLException{
		System.out.println("\n\nResultSet metadata info:");
		ResultSetMetaData meta = (ResultSetMetaData) rst.getMetaData();
		int n = meta.getColumnCount();
		for (int i=1;i<=n;i++)  {
		    System.out.printf("%d = %s <%s>",
		            i,
		            meta.getColumnName(i),
		            meta.getColumnTypeName(i));
		    if (meta.isNullable(i)==meta.columnNoNulls) System.out.print(" NOT NULL");
		    if (meta.isAutoIncrement(i)) System.out.print(" AUTO");
		    System.out.println("");
		} 

	}

}
