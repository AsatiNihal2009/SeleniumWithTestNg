package com.tests.SeleniumTestNgJenkinsIntegration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WIndowPopUp {
	SoftAssert soft = new SoftAssert();
	final String siteUrl = "https://www.output.jsbin.com/usidix/1";
	final String driverPath = "C:/Users/usver/Downloads/chromedriver.exe";
	WebDriver driver;

	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteUrl);
		
		driver.findElement(By.cssSelector("body > input[type=button]")).click();
		
		String alertMsg=driver.switchTo().alert().getText();
		
		String expectedAlertMsg="This is an alert box";
		
		System.out.println(alertMsg);
		soft.assertEquals(expectedAlertMsg,alertMsg);

	}
}
