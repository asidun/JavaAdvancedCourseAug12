package com.flowergarden.store;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.flowergarden.flowers.GeneralFlower;

public class StoreRefregerator {

	private Map<String, Deque<GeneralFlower>> store = new HashMap<>();

	static private StoreRefregerator instance = new StoreRefregerator();

	private StoreRefregerator() {

	}

	public static StoreRefregerator getInstance() {
		return instance;
	}

	public void fill(int rose, int chamomile) {
		Deque<GeneralFlower> roseDeque = new LinkedList<>();
		Deque<GeneralFlower> chamomileDeque = new LinkedList<>();
		
		for (int i = 0; i < rose; i++) {
			// TODO
		}
		
		for (int i = 0; i < chamomile; i++) {
			// TODO
		}
		
		store.put("rose", roseDeque);
		store.put("chamomile", chamomileDeque);
		
	}
	
	public Map<String, Deque<GeneralFlower>> getStore(){
		return store;
	}

}
