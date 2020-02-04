package com.amazon.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import com.amazon.qa.base.BaseClass;

public class TestUtils extends BaseClass{
	
	public TestUtils() throws FileNotFoundException {
		super();
	}

	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT_TIME = 10;
	
	public void OpenNewTab(WebElement ethnicFootwear) throws AWTException {
		Actions action = new Actions(driver);
		action.contextClick(ethnicFootwear).perform();
		
		Robot robot = new Robot();   
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN); 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void SwitchBrowser(int i) {
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(i));
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File source_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(source_file, new File(currentDir + "/screenshots/"));
	}

}
