package com.techelevator.view;

import com.techelevator.items.Item;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

public class VendingMachine {
	
	String allProducts;

	public static void displaySelection() throws FileNotFoundException {
		System.out.println("SlotNumber   Item    Price    Quantity");
		for(Map.Entry<String, ArrayList<Item>> product : Inventory.getDisplayInventory().entrySet()) {
			String slot = product.getKey();
			String name = product.getValue().get(0).getName();
			String price = product.getValue().get(0).getPrice();
			String num = VendingMachine.getQuantity(product.getKey());
			System.out.println(slot + " " + name + " " + price + " " + num);
		}
	}

	private static String getQuantity(String key) {
		if(Inventory.getInventory().get(key).isEmpty()) {
			return "SOLD OUT!!!";
		}
		else {
			return Integer.toString(Inventory.getInventory().get(key).size());
		}
	}

	public static void productAvailability(String slotNumber) throws FileNotFoundException {
		for(Map.Entry<String, ArrayList<Item>> item : Inventory.getInventory().entrySet()) {
			if(!item.getValue().isEmpty() && slotNumber.equals(item.getKey())) {
				double price = Double.parseDouble(item.getValue().get(0).getPrice());
				if(price <= PurchaseMenu.getBalance()) {
					double newBalance = PurchaseMenu.getBalance();
					newBalance -= price;
					int temp = (int) Math.round(newBalance * 100);
					newBalance = temp / 100.0;
					PurchaseMenu.setBalance(newBalance);
					item.getValue().get(0).getSound();
					item.getValue().remove(0);
					PurchaseMenu.displayMenu();
				} else {
					System.out.println("Insufficient balance");
					PurchaseMenu.displayMenu();
				}
			}
		}	System.out.println("Item sold out");
		PurchaseMenu.displayMenu();
	}

	public static void transaction() {

	}

}
