package com.techelevator.view;

import com.techelevator.change.Coin;
import com.techelevator.change.MakeChange;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class PurchaseMenu {

    private static MakeChange returnChange = new MakeChange();
	private static double balance = 0.0;
	private static Scanner menuInput = new Scanner(System.in);

	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		PurchaseMenu.balance = balance;
	}

	public static void displayMenu() throws FileNotFoundException {
		while (true) {
			printMainMenu();
			int choice = menuInput.nextInt();
			menuInput.nextLine();
			switch (choice) {
				case 1:
					PurchaseMenu.feedMoney();
					break;
				case 2:
					PurchaseMenu.selectProduct();
					break;
				case 3:
					PurchaseMenu.finishTransaction();
					break;
				default:
					PurchaseMenu.displayMenu();
			}
		}
	}

	public static void printMainMenu() {
		System.out.println("(1) FeedMoney");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction");
		System.out.println("Current Money Provided: $ " + PurchaseMenu.getBalance());
	}

	public static void feedMoney() throws FileNotFoundException {
		System.out.println("Please enter a whole dollar amount between 1 and 10");
		if (menuInput.hasNextInt()) {
			int temp = menuInput.nextInt();
			menuInput.nextLine();
			if (temp > 0 && temp <= 10) {
				balance += temp;
				PurchaseMenu.setBalance(balance);
			} else {
				System.out.println("Invalid Amount");
			}
		}
		PurchaseMenu.displayMenu();
	}

	public static void selectProduct() throws FileNotFoundException {
		VendingMachine.displaySelection();
		System.out.println("Please select a Slot Number\n");
		String slotChoice = menuInput.nextLine();
		menuInput.nextLine();
		if (slotChoice.length() != 2) {
			System.out.println("Please enter a valid Slot Number\n");
			PurchaseMenu.selectProduct();
		} else {
			for (String slotNumber : Inventory.getInventory().keySet()) {
				if (slotNumber.equals(slotChoice)) {
					VendingMachine.productAvailability(slotChoice);
				}
			}
			System.out.println("Please select a valid Slot Number\n");
			PurchaseMenu.selectProduct();
		}
	}

	public static void finishTransaction() {
        BigDecimal changeReturn = new BigDecimal(returnChange.change(balance));
        System.out.println("Returned: " + NumberFormat.getCurrencyInstance().format(changeReturn));
        balance = 0.0;
	}
}
