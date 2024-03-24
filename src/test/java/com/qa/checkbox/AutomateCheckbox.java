package com.qa.checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateCheckbox {

	WebDriver driver;
	@Test
	public void checkboxAutomate() {
		
		
	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)", "");
		List<WebElement> allCheckbox=driver.findElements(By.xpath("//span[text()='What days of the week are you consistently available?']//following::input[@type='checkbox']"));
		System.out.println(allCheckbox.size());
		//js.executeScript("arguments[0].scrollIntoView(true)", allCheckbox);
		
		for (WebElement days : allCheckbox) {
			System.out.println("inside loop");
			String daysName=days.getText();
			System.out.println("daysName : " + daysName);
		}
		
	}
}
