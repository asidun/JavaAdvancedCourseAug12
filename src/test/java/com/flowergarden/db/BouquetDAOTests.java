package com.flowergarden.db;

import org.junit.Test;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.bouquet.MarriedBouquet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BouquetDAOTests {
	
	@Test
	public void getBouquetTest() throws SQLException{
		//Given
		List<Bouquet>expectedBs = new ArrayList<>();
		expectedBs.add(new MarriedBouquet());
		
		Connection mockConn = mock(Connection.class);
		BouquetDAO dao = new BouquetDAO();
		dao.setConnection(mockConn);
		
		//When
		List<Bouquet> bs = dao.getBouquets();
		
		//Then
		assertArrayEquals(expectedBs.toArray(), bs.toArray());
		
	}
	
	@Test
	public void getBouquetByIdTest(){
		
	}

}
