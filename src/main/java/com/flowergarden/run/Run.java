package com.flowergarden.run;

import java.util.Scanner;

import com.flowergarden.bouquet.MarriedBouquet;
import com.flowergarden.store.StoreRefregerator;

public class Run {

	public static void main(String[] args) {

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

	}

}
