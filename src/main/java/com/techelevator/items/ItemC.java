package com.techelevator.items;

public class ItemC extends Item{

	public ItemC(String product, String price) {
		super(product, price);
		
	}

	public void getSound() {
		System.out.println("Glug Glug, Yum!");
	}

}
