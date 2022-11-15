package com.gildedrose;

public abstract class Item {
	protected String name;
	protected int sellIn;
	protected int quality;
	
	public Item(String name, int sellIn,int quality) {
		this.name = name;
		this.sellIn = sellIn;
		if(quality <= 50)this.quality = quality; //maximum quality is 50
		else this.quality = 0;
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
