package com.flowergarden.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class RunMap {

	public static void main(String[] args) {
		HashMap<String, Double> hm = new HashMap<>();
		TreeSet<Integer> ts = new TreeSet<>();
		
		ts.add(3);
		ts.add(1);
		ts.add(5);
		
		System.out.println(ts);
		
		// Put elements to the map
		hm.put("Zara", new Double(3434.34));
		hm.put("Mahnaz", new Double(123.22));
		hm.put("Ayan", new Double(1378.00));
		hm.put("Daisy", new Double(99.22));
		hm.put("Qadir", new Double(-19.08));
		// Get a set of the entries
		Set<Entry<String, Double>> set = hm.entrySet();
		// Get an iterator
		Iterator<Entry<String, Double>> i = set.iterator();
		while (i.hasNext()) {
			Entry<String, Double> me = i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		// Deposit 1000 into Zara's account
		double balance = ((Double) hm.get("Zara")).doubleValue();
		hm.put("Zara", new Double(balance + 1000));
		System.out.println("Zara's new balance: " + hm.get("Zara"));

	}

}
