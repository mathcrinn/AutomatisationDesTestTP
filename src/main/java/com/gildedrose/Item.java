package com.gildedrose;

public abstract class Item {
	protected int sellIn;
	protected int quality;
	protected String name;
	protected int basePrice;

	public Item(int sellIn, int quality, String name, int basePrice) {
		this.sellIn = sellIn;
		this.quality = quality;
		this.name = name;
		this.basePrice = basePrice;
	}
	
	public Item(int quality, String name, int basePrice) {
		this.quality = quality;
		this.name = name;
	}
	
	public abstract void update();
	
	
	protected boolean hasPassedSellInDate() { 
		return sellIn <= 0; 
	} 
	
	public int getValue() {
		return basePrice;
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
