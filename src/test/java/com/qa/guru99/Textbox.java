package com.qa.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Textbox {

	String baseUrl = "http://demo.guru99.com/test/login.html";

	@Test
	public void textbox1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@id='email']//self::input")).sendKeys(String.valueOf(1234));
        driver.findElement(By.id("passwd")).sendKeys(String.valueOf(67890));
        Thread.sleep(5000);
        driver.findElement(By.id("SubmitLogin")).click();
	}

}
