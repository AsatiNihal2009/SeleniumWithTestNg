package com.tests.SeleniumTestNgJenkinsIntegration;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	final String siteUrl = "https://github.com/login";
	final String driverPath = "C:/Users/usver/Downloads/chromedriver.exe";
	static WebDriver driver;

	@Test
	public static void loginApp() {

		WebElement email = driver.findElement(By.id("login_field"));
		System.out.println(email.getTagName());
		email.sendKeys("asatinihal2009@gmail.com");

		WebElement pass = driver.findElement(By.id("password"));
		System.out.println(pass.getTagName());
		pass.sendKeys("Haribol2!");

		WebElement submit = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[12]"));

		submit.submit();
	}

	@Before
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteUrl);
	}

	@After
	public void afterTest() {
		driver.quit();
	}

}
