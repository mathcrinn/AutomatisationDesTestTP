package com.gildedrose;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ConsoleUI {
	
	private static ItemsRepository repo;
	private static ArrayList<Item> items;
	private static Shop shop;
	
	public static void main(String[] args) {
		repo = new ItemsRepository("./inventory.csv");
		try {
			items = repo.GetInventory();
			shop = new Shop(items);
		
			for(int i=0;i<args.length;i++) {
				switch(args[i]) 
				{
					case "-displayItems" : 
						System.out.println("Type ; SellIn ; Quality ; Name ; Value");
						for(Item item : items) {
							System.out.println(item.getClass().getSimpleName() + ';' + item.getSellIn() + ';' + item.getQuality() + ';' + item.getName() + ';' + item.getValue());
						}
						break;
					case "-displayBalance" : 
						break;
					case "-updateInventory" :
						shop.updateInventory();
						repo.SaveInventory(shop.items);
						break;
					case "-sellItem" :
						break;
					default : 
						System.out.println("Argument \"" + args[i] + "\" non reconnu");
						
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
