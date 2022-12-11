package com.gildedrose;

import java.util.ArrayList;

public class Shop {

	public ArrayList<Item> items;

	public Shop(ArrayList<Item> items) {
		this.items = items;
	}

	public void updateInventory() {
		for(Item item : items) {
			item.update();
		}
	}
	
	public void getInventory() {
		
	}
}
