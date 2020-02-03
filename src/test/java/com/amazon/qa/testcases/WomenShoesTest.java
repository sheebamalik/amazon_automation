package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.WomenEthnicFootwear;
import com.amazon.qa.pages.WomenFashionSandles;
import com.amazon.qa.pages.WomenShoes;

public class WomenShoesTest extends BaseClass{
	
	WomenShoes womenShoes;
	HomePage homepage;
	WomenEthnicFootwear womenEthnicFootwear;
	WomenFashionSandles womenFashionSandles;
	
	WomenShoesTest() throws Exception{
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		OpenBrowser();
		homepage = new HomePage();
		womenShoes = homepage.categorySelect();
	}
	
	@Test(priority=1)
	public void openFashionSandals() throws Exception {
		womenFashionSandles = womenShoes.SearchFashionSandals();	
	}
	
	@Test(priority=2)
	public void openEthnicSandals() throws Exception {
		womenEthnicFootwear = womenShoes.OpenEthnicFootwear();
		
	}
	
   @AfterMethod
	public void tearoff() {
		driver.quit();
	}
}
