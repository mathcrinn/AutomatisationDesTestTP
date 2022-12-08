package com.gildedrose;

public class NormalItem extends Item{

	public NormalItem(int sellIn, int quality, String name, int basePrice) {
		super(sellIn, quality, name, basePrice);
	}

	@Override
	public void update() {
		if(this.hasPassedSellInDate()) quality = quality - 2;
		else {
			quality--;
			sellIn--;
		}
		if(this.quality<0)this.quality=0;
		if(this.quality>50)this.quality=50;
	}

}
