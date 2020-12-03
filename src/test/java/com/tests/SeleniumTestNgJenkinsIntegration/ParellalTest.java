package com.tests.SeleniumTestNgJenkinsIntegration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParellalTest {

	SoftAssert soft = new SoftAssert();
	final String siteUrl = "https://www.amazon.in/";
	final String chromeDriverPath = "C:/Users/usver/Downloads/chromedriver.exe";
	final String firefoxDriverPath = "C:/Users/usver/Desktop/gekodriver.exe";
	WebDriver driver;
	private String facebooksiteUrl="https://www.facebook.in/";

	@Test(groups = "Chrome",threadPoolSize=5,invocationCount=23,timeOut=60000)
	public void launchChromTest() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(groups = "Chrome", dependsOnMethods = "launchChromTest")
	public void verifyAmazonTest() {
		System.out.println(Thread.currentThread().getId());
		soft.assertEquals(driver.getCurrentUrl(), siteUrl);
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[5]/div[2]/div/div/a[1]"));
	}

	@Test(groups = "Firefox")
	public void launchFirefox() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		driver = new FirefoxDriver();
		driver.get(facebooksiteUrl);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(groups = "Firefox", dependsOnMethods = "launchFirefox")
	public void verifyFirefoxTest() {
		System.out.println(Thread.currentThread().getId());
		soft.assertEquals(driver.getCurrentUrl(), facebooksiteUrl);
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("xyz");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
		assertTrue(true);
	}

}
