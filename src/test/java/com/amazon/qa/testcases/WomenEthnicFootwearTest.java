package com.amazon.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.WomenEthnicFootwear;
import com.amazon.qa.pages.WomenShoes;

public class WomenEthnicFootwearTest extends BaseClass{


	WomenShoes womenShoes;
	HomePage homepage;
	WomenEthnicFootwear  womenEthnicFootwear;
	
	public WomenEthnicFootwearTest() throws FileNotFoundException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		OpenBrowser();
		homepage = new HomePage();
		womenShoes = homepage.categorySelect();
		womenEthnicFootwear = womenShoes.OpenEthnicFootwear();
	}
	
	@Test(priority=1)
	public void FilterSandals() {
		womenEthnicFootwear.CreateFilters();
		womenEthnicFootwear.SortbyPrice();
	}
	
	@AfterMethod
	public void tearoff() {
		driver.quit();
	}
}
