package com.qa.svg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CovidcaseGraphForIndia {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/search?q=covid+cases+in+india");
		List<WebElement> graphList = driver
				.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[1]//*[name()='rect']"));
		Actions act = new Actions(driver);
		for (WebElement element : graphList) {
			act.moveToElement(element).build().perform();
			String text = driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText();
			System.out.println(text);
		}

	}
}
