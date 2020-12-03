package com.tests.SeleniumTestNgJenkinsIntegration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadProfile {
	final String siteUrl = "https://github.com/settings/profile";
	final String driverPath = "C:/Users/usver/Downloads/chromedriver.exe";
	static WebDriver driver;

	@Before
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		
		Login.loginApp();

		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteUrl);
	}

	@After
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void profileImageUploadTest() throws InterruptedException, IOException {

		// find edit button and click.
		WebElement editButton = driver.findElement(
				By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/div[2]/dl/dd/div/details/summary/div"));
		editButton.click();

		WebElement addFile = driver.findElement(By
				.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/div[2]/dl/dd/div/details/details-menu/label"));
		addFile.click();
		Thread.sleep(5000); // Image uploading delay.

		// Close windows popup
		Runtime.getRuntime().exec("J:/eclipse/autoitScript/ProfileUpload.exe");

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/details/details-dialog/form/div[2]/button")).click();
		Thread.sleep(2000); // Image uploading delay.

	}
}
