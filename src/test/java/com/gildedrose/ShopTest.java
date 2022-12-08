package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopTest {
	Shop shop;

	@BeforeEach
	void setup() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new NormalItem(6, 10, "normal 1",5));
		items.add(new NormalItem(0, 10, "normal 2",5));
		items.add(new NormalItem(0, -2, "normal 3",5));
		items.add(new CheeseItem(10, 10,"Aged Brie",5));
		items.add(new NormalItem(10, 60,"Quality+50",5));
		items.add(new LegendaryItem(80, "Sulfuras",5));
		items.add(new BackstagePassesItem(12,10, "Backstage passes",5));
		items.add(new ConjuredItem(27,10, "Conjured",5));
		items.add(new NormalItem(27,10, "Conjured",7));
		
		this.shop = new Shop(items);
	}

	@Test
	void shouldUpdateItemSellIn() {
		this.shop.updateInventory();
		assertEquals(5, this.shop.items.get(0).getSellIn());
	}

	@Test
	void shouldUpdateItemQuality() {
		this.shop.updateInventory();
		assertEquals(9, this.shop.items.get(0).getQuality());
	}

	@Test
	void shouldUpdateQualityTwiceAsFastForExpiredItems() {
		this.shop.updateInventory();
		assertEquals(8, this.shop.items.get(1).getQuality());
	}

	@Test
	void shouldUpdateQualityIfIsNegative() {
		this.shop.updateInventory();
		assertEquals(0, this.shop.items.get(2).getQuality());
	}
	
	@Test
	void shouldUpdateQualityForCheese() {
		this.shop.updateInventory();
		assertEquals(11, this.shop.items.get(3).getQuality());
	}
	
	@Test
	void shouldQualityLessThan50() {
		this.shop.updateInventory();
		assertEquals(50, this.shop.items.get(4).getQuality());
	}
	
	@Test
	void shouldLegendaryItem() {
		this.shop.updateInventory();
		assertEquals(80, this.shop.items.get(5).getQuality());
	}
	
	@Test
	void shouldBackstagePassesItem() {
		this.shop.updateInventory();
		assertEquals(11, this.shop.items.get(6).getQuality());
		this.shop.updateInventory();
		assertEquals(13, this.shop.items.get(6).getQuality());
		for (int i=0;i<5;i++)this.shop.updateInventory();
		assertEquals(24, this.shop.items.get(6).getQuality());
		for (int i=0;i<5;i++)this.shop.updateInventory();
		assertTrue(this.shop.items.get(6).hasPassedSellInDate());
		assertEquals(0, this.shop.items.get(6).getQuality());
	}
	
	@Test
	void shouldConjuredItem() {
		this.shop.updateInventory();
		assertEquals(25, this.shop.items.get(7).getSellIn());
	}
	
	@Test
	void shouldGetValue() {
		assertEquals(7, this.shop.items.get(8).getValue());
	}

}
