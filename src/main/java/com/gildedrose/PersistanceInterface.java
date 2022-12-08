package com.gildedrose;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

public class PersistanceInterface {
	
	public File file;
	public Shop shop;
	
	public PersistanceInterface(String filePath, Shop shop) {
		this.file = new File(filePath);
		this.shop = shop;
	}
	
	public void saveAllItems() throws MalformedURLException, IOException {
		FileWriter writer = new FileWriter(file);
		for (Item item : shop.items){
			if(item instanceof NormalItem)writer.write("Normal;");
			else if(item instanceof CheeseItem)writer.write("Cheese;");
			else if(item instanceof ConjuredItem)writer.write("Conjured;");
			else if(item instanceof LegendaryItem)writer.write("Legendary;");
			writer.write(item.getSellIn() + ";" + item.getQuality() + ";" + item.getName() + "\n");
		}
		writer.close();
	}
	
	public void loadAllItems() throws MalformedURLException, IOException {
		Item item = null;
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String[] parts = scanner.nextLine().split(";");
			if(parts[0].compareTo("Normal")==0)item = new NormalItem(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3]);
			else if(parts[0].compareTo("Cheese")==0)item = new CheeseItem(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3]);
			else if(parts[0].compareTo("Conjured")==0)item = new ConjuredItem(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3]);
			else if(parts[0].compareTo("Legendary")==0)item = new LegendaryItem(Integer.parseInt(parts[2]),parts[3]);
			shop.items.add(item);
		}
		scanner.close();
	}

}
