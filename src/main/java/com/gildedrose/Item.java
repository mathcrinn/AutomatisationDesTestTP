package com.gildedrose;

public abstract class Item {
	protected int sellIn;
	protected int quality;
	protected String name;

	public Item(int sellIn, int quality, String name) {
		this.sellIn = sellIn;
		this.quality = quality;
		this.name = name;
	}
	
	public Item(int quality, String name) {
		this.quality = quality;
		this.name = name;
	}
	
	public abstract void update();
	
	protected boolean hasPassedSellInDate() { 
		return sellIn <= 0; 
	} 
	
	public String getName() { 
		return name; 
	}
	
	public int getSellIn() {
		return sellIn;
	}

	public int getQuality() {
		return quality;
	}
	
}
