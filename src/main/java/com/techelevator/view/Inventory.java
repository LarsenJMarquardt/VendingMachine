package com.techelevator.view;

import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Inventory {
	static LinkedHashMap<String, ArrayList<Item>> masterInventory = new LinkedHashMap<String, ArrayList<Item>>();
	static LinkedHashMap<String, ArrayList<Item>> displayInventory = new LinkedHashMap<String, ArrayList<Item>>();
//	private static final Item[] items = new Item[] {new ItemA(), new ItemB(), new ItemC(), new ItemD()};

	public static void inventoryToDisplay() throws FileNotFoundException {
		File productPath = gettingProduct();
		try(Scanner a = new Scanner(productPath))
		{
			while(a.hasNextLine()) {
				ArrayList<Item> allItems = new ArrayList<Item>();
				String eI = a.nextLine();
				String[] eachItem = eI.split("\\|");

				String helper = eachItem[0];
				if(helper.startsWith("A")) {
					for(int i = 0; i < 1; i++) {
						allItems.add(new ItemA(eachItem[1], eachItem[2]));
						displayInventory.put(eachItem[0], allItems);
					}
				} else if (helper.startsWith("B")) {
					for(int i = 0; i < 1; i++) {
						allItems.add(new ItemB(eachItem[1], eachItem[2]));
						displayInventory.put(eachItem[0], allItems);
					}
				} else if (helper.startsWith("C")) {
					for(int i = 0; i < 1; i++) {
						allItems.add(new ItemC(eachItem[1], eachItem[2]));
						displayInventory.put(eachItem[0], allItems);
					}
				} else if (helper.startsWith("D")) {
					for(int i = 0; i < 1; i++) {
						allItems.add(new ItemD(eachItem[1], eachItem[2]));
						displayInventory.put(eachItem[0], allItems);
					}
				}
			}
		}
	}

	public static LinkedHashMap<String, ArrayList<Item>> getDisplayInventory(){
		return displayInventory;
	}

	public static void productSelection() throws FileNotFoundException {
		File productPath = gettingProduct();
		try(Scanner a = new Scanner(productPath))
		{
			while(a.hasNextLine()) {
				ArrayList<Item> allItems = new ArrayList<Item>();

				String eI = a.nextLine();
				String[] eachItem = eI.split("\\|");

				String helper = eachItem[0];
				if(helper.startsWith("A")) {
					for(int i = 0; i < 5; i++) {
						allItems.add(new ItemA(eachItem[1], eachItem[2]));
						masterInventory.put(eachItem[0], allItems);
					}
				} else if (helper.startsWith("B")) {
					for(int i = 0; i < 5; i++) {
						allItems.add(new ItemB(eachItem[1], eachItem[2]));
						masterInventory.put(eachItem[0], allItems);
					}
				} else if (helper.startsWith("C")) {
					for(int i = 0; i < 5; i++) {
						allItems.add(new ItemC(eachItem[1], eachItem[2]));
						masterInventory.put(eachItem[0], allItems);
					}
				} else if (helper.startsWith("D")) {
					for(int i = 0; i < 5; i++) {
						allItems.add(new ItemD(eachItem[1], eachItem[2]));
						masterInventory.put(eachItem[0], allItems);
					}
				}
			}
		}
	}

	public static LinkedHashMap<String, ArrayList<Item>> getInventory(){
		return masterInventory;
	}


	public static File gettingProduct() {
		String path = "/Users/LJM/code/team2-java-week4-pair-exercise/m1-capstone/vendingmachine.csv";
		File product = new File(path);

		if(product.exists() == false) {
			System.out.println(path + " does not exist");
			System.exit(1);
		} else if(product.isFile() == false) {
			System.out.println(path + " is not a file");
			System.exit(1);
		}
		return product;
	}
}
