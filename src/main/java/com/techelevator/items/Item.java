package com.techelevator.items;

public abstract class Item {

	private String product;
	private String price;

	public Item(String product, String price){
	this.product = product;
	this.price = price;
	}

	public String getName() {
		return product;
	}

	public String getPrice() {
		return price;
	}
	
	public abstract void getSound();
}
