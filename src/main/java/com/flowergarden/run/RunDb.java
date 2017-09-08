package com.flowergarden.run;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunDb {
	public static void main(String[] args) throws SQLException, IOException  {
		File file = new File("flowergarden.db");
		String url = "jdbc:sqlite:"+file.getCanonicalFile().toURI();
		System.out.println(url);
		Connection conn = DriverManager.getConnection(url);
		
		PreparedStatement pstmt = conn.prepareStatement("select * from bouquet where name = ?");		
		String marriedBouquetName = "married";
		
		pstmt.setString(1, marriedBouquetName);
		ResultSet result = pstmt.executeQuery();
		System.out.println(result);
		
		Statement ctmt = conn.createStatement();
		ctmt.executeQuery("select * from bouquet");
		
		CallableStatement prep = conn.prepareCall("sql");
		prep.execute();
		
		
	}

}
