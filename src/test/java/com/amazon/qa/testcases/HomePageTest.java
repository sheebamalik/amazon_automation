package com.amazon.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.WomenShoes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*public static Logger createLogger()  {
	  Logger aLogger = LogManager.getRootLogger();
	  aLogger.debug("\n" + "Inside createLogger - Logger is being set up. New test setup beginning.");
	  verificationErrors = new StringBuffer();
	  aLogger.info("Logger has been set up.");
	  return aLogger;
	 }

	 protected static void createLogFile (FirefoxProfile fp) throws Exception {
	  File outfile = new File(outfileName);
	  if (!outfile.exists())  
	   outfile.createNewFile();
	  fp.setPreference("webdriver.log.driver", "DEBUG");
	  fp.setPreference("webdriver.log.file", outfileName);
	 }
*/
public class HomePageTest extends BaseClass{
	
	WomenShoes womenShoes;
	HomePage homepage;
	
	HomePageTest() throws FileNotFoundException{
		super();
		
		//Logger log = Logger.getLogger("HomePageTest");
		//PropertyConfigurator.configure("log4j2.properties");
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
