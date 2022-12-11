package com.gildedrose;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ShopInputBoundary {
	
	private ShopInteractor shopinter;

	public ShopInputBoundary() throws FileNotFoundException {
		shopinter = new ShopInteractor(new ItemsRepository("./inventory.csv"));
	}
	public void updateInventory() {
		try {
			shopinter.updateInventory();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void sellItem(SellItemRequest request) {
		try {
			ArrayList<Item> items = shopinter.getInventory();
			for(Item item : items) {
				if(item.getClass().getSimpleName().compareTo(request.type) == 0 || item.getQuality() == request.quality) {
					items.remove(item);
					break;
				}
			}
			shopinter.saveInventory(items);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
