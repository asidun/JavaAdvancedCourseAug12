package com.flowergarden.run;

import java.util.LinkedList;
import java.util.List;

public class RunList {

	public static void main(String[] args) {
		List<String> stringList = new LinkedList<String>();
		stringList.add("Item1");
		stringList.add("Item2");
		stringList.add("12");
		stringList.add(1, "12");
		int size = stringList.size();
		int index = stringList.indexOf("Item2");
		System.out.println("Size: " + size + ". Index Item2 " + index);
		String element = "";
		for (int i = 0; i < stringList.size(); i++) {
			String item = (String) stringList.get(i);
			System.out.println("Item " + i + " : " + item);
		}
		stringList.remove(0);
		stringList.remove("12");
		stringList.remove("12");
		for (Object item : stringList) {
			System.out.println("retrieved element: " + item);
		}
		boolean result = stringList.isEmpty();
		System.out.println(" stringList.isEmpty : " + result);
		if (stringList.size() == 0) {
			System.out.println("ArrayList is empty");
		}

		LinkedList<String> copyOfStringList = new LinkedList<String>();
		copyOfStringList.addAll(stringList);
		for (String item : copyOfStringList) {
			System.out.println("retrieved element: " + item);
		}
		stringList.add(1, "Item3");
		System.out.println(stringList);
		stringList.clear();

	}

}
