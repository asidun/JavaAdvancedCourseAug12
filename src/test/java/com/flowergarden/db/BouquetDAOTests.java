package com.flowergarden.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.bouquet.MarriedBouquet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BouquetDAOTests {
	
	Connection conn;
	
	@Before
	public void setupTest() throws IOException, SQLException{
		File file = new File("flowergarden.db");
		String url = "jdbc:sqlite:"+file.getCanonicalFile().toURI();
		conn = DriverManager.getConnection(url);
	}
	
	@After
	public void finishTest() throws SQLException{
		conn.close();
	}
	
	
	
	@Test
	public void getBouquetTest() throws SQLException{
		//Given
		List<Bouquet>expectedBs = new ArrayList<>();
		expectedBs.add(new MarriedBouquet());
		
		BouquetDAO dao = new BouquetDAO();
		dao.setConnection(conn);
		
		//When
		List<Bouquet> bs = dao.getBouquets();
		
		//Then
		assertArrayEquals(expectedBs.toArray(), bs.toArray());
		
	}
	
	@Test
	public void getBouquetByIdTest() throws SQLException{
		//Given
		Bouquet expectedBouquet = new MarriedBouquet();
		
		BouquetDAO dao = new BouquetDAO();
		dao.setConnection(conn);
		
		//When
		Bouquet bouquet = dao.getBouquetById(1);
		
		//Then
		assertEquals(expectedBouquet, bouquet);
	}

}
