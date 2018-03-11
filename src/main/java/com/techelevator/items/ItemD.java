package com.techelevator.items;

public class ItemD extends Item{

	public ItemD(String product, String price) {
		super(product, price);
	}

	public void getSound() {
		System.out.println("Chew Chew, Yum!");
	}

}
