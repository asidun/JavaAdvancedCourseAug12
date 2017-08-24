package com.flowergarden.run;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.bouquet.GeneralBouquet;
import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.bouquet.MyBouquet;
import com.flowergarden.flowers.GeneralFlower;
import com.flowergarden.store.StoreRefregerator;
import com.sun.org.apache.xml.internal.security.keys.storage.StorageResolver;

public class Run {

	public static void main(String[] args) {
		GeneralBouquet bouquet = new MyBouquet();

		System.out.println("-My custom bouquet-");
		System.out.println("Price: " + bouquet.getPrice());

		bouquet.sortByFreshness();

		Iterator<GeneralFlower> f = bouquet.getFlowers().iterator();
		while (f.hasNext()) {
			GeneralFlower generalFlower = f.next();
			System.out.print(generalFlower.getClass().getSimpleName() + ": ");
			System.out.print("price- " + generalFlower.getPrice()+ ", ");
			System.out.print("freshness- " + generalFlower.getFreshness().getFreshness() + ", ");
			System.out.println("length- " + generalFlower.getLenght());
		}

		System.out.println("--Flowers corresponding to requested length' scope--");
		Collection foundFlowers = bouquet.searchFlowersByLenght(30, 35);
		Iterator<GeneralFlower> it = foundFlowers.iterator();
		while (it.hasNext()) {
			GeneralFlower next = it.next();
			System.out.println(next.getClass().getSimpleName() + ": " + next.getLenght());
		}

		/*
		System.out.print("Enter count of roses: ");
		Scanner sc = new Scanner(System.in);
		int roses = sc.nextInt();
		System.out.print("Enter count of chamomiles: ");
		int cham = sc.nextInt();
		sc.close();

		StoreRefregerator.getInstance().fill(roses, cham);
		MarriedBouquet bouquet = new MarriedBouquet();
		for (int i = 0; i < 5; i++) {
			bouquet.addFlower(StoreRefregerator.getInstance().getStore().get("rose").removeLast());
		}
		for (int i = 0; i < 2; i++) {
			bouquet.addFlower(StoreRefregerator.getInstance().getStore().get("chamomile").removeLast());
		}

		System.out.println(bouquet.getPrice());
*/
	}

}
