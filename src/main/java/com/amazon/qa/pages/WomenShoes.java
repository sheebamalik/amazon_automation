package com.amazon.qa.pages;

import java.awt.AWTException;
import java.io.FileNotFoundException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.util.TestUtils;

public class WomenShoes extends BaseClass{
	static TestUtils testutils;
	 
	@FindBy(xpath = "//a[.//span[text()= \"Fashion Sandals\"]]")
	static WebElement fashionSandals;
	
	@FindBy(xpath = "//a[.//span[text()= \"Ethnic Footwear\"]]")
	static WebElement ethnicFootwear;
	
	public WomenShoes() throws Exception{
		PageFactory.initElements(driver, this);
		testutils = new TestUtils();
	}
	
	public WomenFashionSandles SearchFashionSandals() throws FileNotFoundException {
		fashionSandals.click();
		return new WomenFashionSandles();
	}
	
	public WomenEthnicFootwear OpenEthnicFootwear() throws FileNotFoundException, AWTException {
		
		
		testutils.OpenNewTab(ethnicFootwear);
		testutils.SwitchBrowser(1);
		return new WomenEthnicFootwear();
	}
	
}
