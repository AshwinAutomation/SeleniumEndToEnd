package com.qa.windowhandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	WebDriver driver;

	@Test
	public void automateMultipleWindows() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow : " + parentWindow);
		System.out.println("Title of parent page : "+driver.getTitle());
		driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();
		Set<String> allWindows =driver.getWindowHandles();
		System.out.println("Count windows : " +allWindows.size());
		System.out.println("all windows : " + allWindows);
		
		// method  :1
	/*	for(String child : allWindows) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				System.out.println("Title of child page : "+driver.getTitle());
				driver.close();
			}
		} */
		
		List<String> tabs = new ArrayList<String>(allWindows);
		driver.switchTo().window(tabs.get(0)); // Parent
		System.out.println("Title of parent page : "+driver.getTitle());
		driver.switchTo().window(tabs.get(1)); // Child
		System.out.println("Title of Child page : "+driver.getTitle());
		driver.close();
	}

	@AfterMethod
	public void windowCloes() {
		driver.quit();
	}
}
