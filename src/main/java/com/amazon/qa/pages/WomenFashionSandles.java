package com.amazon.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.BaseClass;

public class WomenFashionSandles extends BaseClass{
	
	Select sortingOption;
	
	@FindBy(xpath = "//a[@title=\"Gold \"]")
	WebElement goldColor;
	
	@FindBy(xpath= "//a[.//i[@class=\"a-icon a-icon-star-medium a-star-medium-4\"]]")
	WebElement customerReview;
	
	
	@FindBy(xpath= "//select[@id=\"s-result-sort-select\"]")
	WebElement drpdwn;
	
	public WomenFashionSandles() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}
	
	public void CreateFilters() {
		goldColor.click();
		customerReview.click();
	}
	
	public void SortbyPrice() {
		sortingOption = new Select (drpdwn);
		sortingOption.selectByValue("price-asc-rank");
	}

}
