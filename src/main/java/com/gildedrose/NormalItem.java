package com.gildedrose;

public class NormalItem extends Item{

	public NormalItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		if(this.hasPassedSellInDate()) {
			if(quality == 1) quality = 0;
			else quality = quality - 2; //degrades twice as fast
		}else {
			quality--;
			sellIn--;
		}
	}

}
