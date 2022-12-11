package com.gildedrose;

import java.io.FileNotFoundException;

public class ShopOutputBoundary {
	
	private ShopInteractor shopinter;

	public ShopOutputBoundary() throws FileNotFoundException {
		shopinter = new ShopInteractor(new ItemsRepository("./inventory.csv"));
	}
	
	public void displayInventory (ItemResponse[] inventory) throws FileNotFoundException {
		System.out.println("Type ; SellIn ; Quality ; Name ; Value");
		for(Item item : shopinter.getInventory()) {
			System.out.println(item.getClass().getSimpleName() + ';' + item.getSellIn() + ';' + item.getQuality() + ';' + item.getName() + ';' + item.getValue());
		}
	}
	
	public void displayBalance(int balance) {
		System.out.println("Balance : " + 0);
	}

}
