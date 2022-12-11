package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemsRepositoryTest {
	ItemsRepository repo;
	ArrayList<Item> items;

	@BeforeEach
	void setup() {
		repo = new ItemsRepository("./inventory.csv");
		items = new ArrayList<Item>();
		NormalItem item = new NormalItem(10,20,"InventorySave",5);
		items.add(item);
	}
	
	@Test
	void shouldSaveInventory() {
		try {
			repo.saveInventory(items);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File f = new File("./inventory.csv");
		assertTrue(f.exists());
	}
	
	@Test
	void shouldGetInventory() {
		try {
			items = repo.getInventory();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(items);
		assertEquals("InventorySave",items.get(0).getName());
	}

	@Test
	void shouldFindItem() {
		try {
			assertNotNull(repo.findItem("Normal",20));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
