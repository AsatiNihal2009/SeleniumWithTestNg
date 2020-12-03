package com.tests.SeleniumTestNgJenkinsIntegration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNg {
	
	SoftAssert soft=new SoftAssert();
	final String siteUrl="https://www.google.com";
	final String driverPath="C:/Users/usver/Downloads/chromedriver.exe";
	WebDriver driver;
  @Test
  public void f() {
	  OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(1000, TimeUnit.SECONDS)
  			.readTimeout(12000, TimeUnit.SECONDS)
  			.writeTimeout(12000, TimeUnit.SECONDS)
  			.build();
  	okHttpClient.retryOnConnectionFailure();
	    System.setProperty("webdriver.chrome.driver",driverPath);
	    driver=new ChromeDriver();
	    driver.get(siteUrl);
	    soft.assertEquals(siteUrl, driver.getCurrentUrl());

  }


  @BeforeTest
  public void beforeTest() {
	  Reporter.log("Fb Login");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
