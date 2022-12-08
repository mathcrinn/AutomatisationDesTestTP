package com.gildedrose;
public class BackstagePassesItem extends Item {
	
	public BackstagePassesItem(int sellIn, int quality, String name, int basePrice) {
		super(sellIn, quality, name, basePrice);
	}

	@Override
	public void update() {
		sellIn--;
		if(this.hasPassedSellInDate()) quality = 0;
		else {
			if(sellIn>10)quality++;
			else if(sellIn>5)quality = quality + 2;
			else quality = quality + 3;
		}
		if(this.quality<0)this.quality=0;
		if(this.quality>50)this.quality=50;
	}
	
}

