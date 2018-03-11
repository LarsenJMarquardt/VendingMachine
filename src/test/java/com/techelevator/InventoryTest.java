package com.techelevator;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.view.Inventory;

public class InventoryTest {

	@Test
	public void testing_String_eI() {
//		String everything = Inventory.productSelection();
	}
	
	@Test
	public void eachItem_string_array() {
		
	}
	
	@Test
	public void test_startsWith_A() {
		
	}
	
	
	@Test
	public void getting_the_File_Path() {
		File testFile = Inventory.gettingProduct();
		String path = testFile.getAbsolutePath();
		Assert.assertEquals("Should be this path: ",
				 "/Users/lmarquardt/Development/workspace/Techelevator/Pair"
				+ "/team2-java-week4-pair-exercise/m1-capstone/vendingmachine.csv",
				testFile.getAbsolutePath());
	}
	
}
