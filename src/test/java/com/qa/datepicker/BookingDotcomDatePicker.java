package com.qa.datepicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingDotcomDatePicker {

	public static void main(String[] args) {
		
		String year ="2024";
		String month = "June";
		String date = "20";
		
		findDate(year,month,date);
		
	}
	
	public static void findDate(String year, String month,String date) {
		System.out.println(year+ "--" + month + "--" + date );
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setAcceptInsecureCerts(true);
		ChromeOptions options = new ChromeOptions();
		options.merge(capabilities);
		options.addArguments("-disable-notifications");
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("booking.com");
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ENTER);
		WebElement element =driver.findElement(By.xpath("//a[@href='https://www.booking.com/']"));
//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		driver.findElement(By.xpath("//span[text()='Search']//preceding::div[3]")).click();
		
		List<WebElement> yearAndMonth = driver.findElements(By.xpath("//h3[@aria-live='polite']"));
		
		for (int i = 0; i <yearAndMonth.size(); i++) {
			WebElement YearMonthCount = yearAndMonth.get(i);
			String yearMonth =YearMonthCount.getText();
			
			if (yearMonth.equalsIgnoreCase("May 2025")) {
				System.out.println("inside the loop");
				System.out.println(yearMonth);
				break;
			}
			
			else {
				driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
			}
		}
		
		
	}
	
}
