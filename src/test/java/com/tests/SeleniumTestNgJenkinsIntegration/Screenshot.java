package com.tests.SeleniumTestNgJenkinsIntegration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;

public class Screenshot {
	SoftAssert soft;
	final String siteUrl = "https://www.output.jsbin.com/usidix/1";
	final String driverPath = "C:/Users/usver/Downloads/chromedriver.exe";
	WebDriver driver;
	TakesScreenshot ts;
	File src;
	
	@Test
	public void f() throws IOException {
		ts=(TakesScreenshot)driver;
		src=ts.getScreenshotAs(OutputType.FILE); 
		FileHandler.copy(src, new File("J://eclipse/screenshot/test.png"));
	}
  @BeforeTest
  public void beforeTest() {
	  soft = new SoftAssert();
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  driver.get(siteUrl);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  soft=null;
	  ts=null;
	  src=null;
  }

}
