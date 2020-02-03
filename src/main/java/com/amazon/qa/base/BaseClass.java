package com.amazon.qa.base;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.util.TestUtils;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static InputStream is;
	public static WebDriverWait wait;
	
	public BaseClass() throws FileNotFoundException{
		try {
		File file = new File("/home/home/sheeba-workspace/amazon_testing/src/main/java/com/amazon/qa/config/config.properties");
		is = new FileInputStream(file);
		prop.load(is);
		}
		catch (Exception e) {
			System.out.println("Config file not found");
		}
		System.out.println("1");
		
	}
	
	public void OpenBrowser() {
		String browser = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/home/home/sheeba-workspace/amazon_testing/webdrivers/chromedriver" );
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","/home/home/sheeba-workspace/amazon_testing/webdrivers/geckodriver" );
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		System.out.println("4");
	}
	
}
