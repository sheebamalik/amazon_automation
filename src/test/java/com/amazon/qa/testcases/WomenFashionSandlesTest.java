package com.amazon.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.WomenFashionSandles;
import com.amazon.qa.pages.WomenShoes;

public class WomenFashionSandlesTest extends BaseClass{
	
	WomenShoes womenShoes;
	HomePage homepage;
	 WomenFashionSandles  womenFashionSandles;
	
	public WomenFashionSandlesTest() throws FileNotFoundException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		OpenBrowser();
		homepage = new HomePage();
		womenShoes = homepage.categorySelect();
		womenFashionSandles = womenShoes.SearchFashionSandals();
	}
	
	@Test(priority=1)
	public void FilterSandals() {
		womenFashionSandles.CreateFilters();
		womenFashionSandles.SortbyPrice();
	}
	
	@AfterMethod
	public void tearoff() {
		driver.quit();
	}

}
