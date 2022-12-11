package com.gildedrose;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ItemsRepository {
	
	public File file;
	
	public ItemsRepository(String inventoryCsvFilePath) {
		this.file = new File(inventoryCsvFilePath);
	}
	
	public void saveInventory(ArrayList<Item> items) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (Item item : items){
			if(item instanceof NormalItem)writer.write("Normal;");
			else if(item instanceof CheeseItem)writer.write("Cheese;");
			else if(item instanceof ConjuredItem)writer.write("Conjured;");
			else if(item instanceof LegendaryItem)writer.write("Legendary;");
			writer.write(item.getSellIn() + ";" + item.getQuality() + ";" + item.getName() + ";" + item.getValue() + "\n");
		}
		writer.close();
	}
	
	public ArrayList<Item> getInventory() throws FileNotFoundException {
		Item item = null;
		ArrayList<Item> items = new ArrayList<Item>();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String[] parts = scanner.nextLine().split(";");
			if(parts[0].compareTo("Normal")==0)item = new NormalItem(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
			else if(parts[0].compareTo("Cheese")==0)item = new CheeseItem(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
			else if(parts[0].compareTo("Conjured")==0)item = new ConjuredItem(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
			else if(parts[0].compareTo("Legendary")==0)item = new LegendaryItem(Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
			items.add(item);
		}
		scanner.close();
		return items;
	}
	
	public Item findItem(String type,int quality) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		Item item = null;
		while (scanner.hasNextLine()) {
			String[] parts = scanner.nextLine().split(";");
			if((parts[0].compareTo(type) == 0) && Integer.parseInt(parts[2]) == quality) {
				scanner.close();
				if(parts[0].compareTo("Normal")==0)item = new NormalItem(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
				else if(parts[0].compareTo("Cheese")==0)item = new CheeseItem(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
				else if(parts[0].compareTo("Conjured")==0)item = new ConjuredItem(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
				else if(parts[0].compareTo("Legendary")==0)item = new LegendaryItem(Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]));
				return item;
			}
		}
		scanner.close();
		return null;
	}

}
