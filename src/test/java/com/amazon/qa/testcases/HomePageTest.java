package com.amazon.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.WomenShoes;

public class HomePageTest extends BaseClass{
	
	WomenShoes womenShoes;
	HomePage homepage;
	
	HomePageTest() throws FileNotFoundException{
		super();
	}
	
	@BeforeMethod
	public void setup () throws FileNotFoundException {
		OpenBrowser();
		}
	
	@Test
	public void SearchWomenFashionTest() throws Exception {
		homepage = new HomePage();
		womenShoes = homepage.categorySelect();
		}
	
	@AfterMethod
	public void tearoff() {
		driver.quit();
		
	}

}
