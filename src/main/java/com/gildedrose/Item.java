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
	
	/*
	 * TP5 protected String name;
	 * 
	 * public Item(String name, int sellIn, int quality) { this.name = name;
	 * this.sellIn = sellIn; if(quality <= 50)this.quality = quality; //maximum
	 * quality is 50 else this.quality = 0; } 
	 *
	 * 
	 * 
	 */
 
	/*TP 6 avant réfractor

	public void update() {
		this.sellIn--;
		if(this.name .compareTo("Aged Brie")==0) {
			this.quality++;
		}else {
			this.quality--;
			if (this.sellIn < 0)
				this.quality--;
			if(this.quality<0)this.quality=0;
			if(this.quality>50)this.quality=50;
		}
	}
	*/
}
