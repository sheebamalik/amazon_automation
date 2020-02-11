package com.amazon.qa.base;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.util.TestUtils;
import com.amazon.qa.util.WebEventListener;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static InputStream is;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public BaseClass() throws FileNotFoundException{
	
		try {
		File file = new File("src/main/java/com/amazon/qa/config/config.properties");
		is = new FileInputStream(file);
		prop.load(is);
		}
		catch (Exception e) {
			System.out.println("Config file not found");
		}
		
	}
	
	public void OpenBrowser() throws FileNotFoundException {
		String browser = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","webdrivers/chromedriver" );
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","webdrivers/geckodriver" );
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	}
	
}
