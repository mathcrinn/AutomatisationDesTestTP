package com.gildedrose;

public class CheeseItem extends Item{
	
	public CheeseItem(int sellIn, int quality, String name) {
		super(sellIn, quality, name);
	}

	@Override
	public void update() {
		quality++;
		sellIn--;
		if(this.quality<0)this.quality=0;
		if(this.quality>50)this.quality=50;
	}

}
