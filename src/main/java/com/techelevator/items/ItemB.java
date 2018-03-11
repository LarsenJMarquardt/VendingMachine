package com.techelevator.items;

public class ItemB extends Item {

	public ItemB(String product, String price) {
		super(product, price);
	}
	
	public void getSound() {
		System.out.println("Munch Munch, Yum!");
	}
	
}
