package com.amazon.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//a[@id=\"nav-hamburger-menu\"]")
	@CacheLookup
	WebElement menuButton;
	
	@FindBy(xpath = "//a[@data-menu-id=\"10\"]")
	WebElement sideMenuItemWomenFashion;
	
	@FindBy(xpath ="//ul[@data-menu-id=\"10\"]//a[.//div[normalize-space()=\"Shoes\"]]")
	WebElement sideMenuItemShoes;

	
	public HomePage() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	public WomenShoes categorySelect() throws Exception  {
		menuButton.click();
		sideMenuItemWomenFashion.click();
		sideMenuItemShoes.click();
		return new WomenShoes();
	}

}
