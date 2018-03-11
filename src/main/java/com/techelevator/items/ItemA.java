package com.techelevator.items;

public class ItemA extends Item {

	public ItemA(String product, String price) {
		super(product, price);
	}
	
	public void getSound() {
		System.out.println("Crunch Crunch, Yum!");
	}

}
