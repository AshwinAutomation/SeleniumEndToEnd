package com.qa.svg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CovidReportFromWorldometer {

	public static void main(String[] args) {
		dailyNewCovidCases();
	}

	
	
	public static void dailyNewCovidCases() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/coronavirus/");
				
			List<WebElement> dailyNewCovidCasesGraph=	driver.findElements(By.xpath("(//*[local-name()='svg'])[7]//*[name()='rect']"));
			Actions act = new Actions(driver);
			for(WebElement element : dailyNewCovidCasesGraph) {
				
				act.moveToElement(element).build().perform();
				
				
				String text=driver.findElement(By.xpath("//*[@id=\"highcharts-ext36sv-3023\"]/svg/g[5]/g[4]")).getText();
				System.out.println(text);
			}
			}
			
		
		
}
