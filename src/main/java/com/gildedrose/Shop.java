package com.gildedrose;

import java.util.ArrayList;

public class Shop {

	public ArrayList<Item> items;

	public Shop(ArrayList<Item> items) {
		this.items = items;
	}
/* TP5
	private ArrayList<Item> items;

	public Shop(){
		items = new ArrayList<Item>();
	}
	
	public void updateQuality() {
		for (Item item : items) {
			item.update();
		}
	}
	public void addNormalItem(String name,int sellIn, int quality) {
		items.add(new NormalItem(name,sellIn,quality));
	}
*/

	public void updateInventory() {
		for(Item item : items) {
			item.update();
		}
		
	}
}
