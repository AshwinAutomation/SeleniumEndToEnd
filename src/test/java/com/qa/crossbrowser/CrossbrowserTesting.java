package com.qa.crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossbrowserTesting {

	WebDriver driver;

	@Test(priority = 1, enabled = false)
	public void chrome() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Automation World\\Automation\\WebAutomation\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}

	@Test(priority = 2)
	public void firefox() {
//	System.setProperty("webdriver.gecko.driver", "E:\\Automation World\\Automation\\WebAutomation\\Driver\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
	}

}
