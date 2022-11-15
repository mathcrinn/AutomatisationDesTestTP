package com.gildedrose;

public class BackstagePassesItem extends Item {

	public BackstagePassesItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.hasPassedSellInDate()) {
			quality = 0;
		}else {
			if(sellIn>10)quality++;
			else if(sellIn>5)quality = quality +2;
			else quality = quality +2;
			sellIn--;
		}
		
	}
	

}
