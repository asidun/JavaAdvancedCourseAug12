package com.flowergarden.bouquet;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.List; 

public class MockitoTests {
	
	@Test
	public void verifyTest(){
		List mockedList = mock(List.class); 
		mockedList.add("one"); 
		mockedList.clear(); 
		verify(mockedList).add("one"); 
		verify(mockedList).clear(); 

	}

}
