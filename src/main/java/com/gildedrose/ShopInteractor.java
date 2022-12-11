package com.gildedrose;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ShopInteractor {

	public ArrayList<Item> items;
	public ItemsRepository repo;

	public ShopInteractor(ItemsRepository repo) throws FileNotFoundException {
		this.items = repo.getInventory();
		this.repo = repo;
	}

	public void updateInventory() throws FileNotFoundException {
		this.items = this.getInventory();
		for(Item item : items) {
			item.update();
		}
	}
	
	public ArrayList<Item> getInventory() throws FileNotFoundException {
		return repo.getInventory();
	}
	
	public Item findItem(String name, int quality) throws FileNotFoundException {
		return repo.findItem(name, quality);
	}

	public void saveInventory(ArrayList<Item> items) throws IOException {
		repo.saveInventory(items);
	}
}