package com.gildedrose;

import java.util.Calendar;
import java.util.Date;

public class Article {
	private int id;
	private String name;
	private int sellIn;
	private int quality;
	
	public Article(int id, int sellIn,int quality) {
		this.id = id;
		this.sellIn = sellIn;
		this.quality = quality;
	}
	

}
