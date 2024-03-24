package com.qa.table;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable {

	WebDriver driver;

	@BeforeMethod
	public void initilizeBroswer() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setAcceptInsecureCerts(true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		options.merge(capabilities);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	// Print number of Rows
	@Test(priority = 1, enabled = false)
	public void staticWebTableRowCount() {
		WebElement bookTable = driver.findElement(By.name("BookTable"));
		List<WebElement> rowCount = bookTable.findElements(By.tagName("tr"));
		System.out.println(rowCount.size());
	}

	@Test(priority = 2, enabled = false)
	public void staticWebTableCoulumnCount() {
		WebElement bookTable = driver.findElement(By.name("BookTable"));
		List<WebElement> CoulumnCount = bookTable.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th"));
		System.out.println(CoulumnCount.size());
	}

	@Test(priority = 3, enabled = false)
	public void retriveSpecificRowAndColumn() {
		WebElement data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]/td[1]"));
		System.out.println(data.getText());
	}

	@Test
	public void retriveAllRecords() {
		WebElement bookTable = driver.findElement(By.name("BookTable"));
		List<WebElement> rowCount = bookTable.findElements(By.tagName("tr"));
		List<WebElement> CoulumnCount = bookTable.findElements(By.xpath("//table[@name='BookTable']//tr/td"));
		for (int i = 0; i < rowCount.size(); i++) {
			System.out.println("rows :" + rowCount.get(i).getText());
			for (int j = 0; j < CoulumnCount.size(); j++) {
				System.out.println("cells : " + CoulumnCount.get(j).getText());
				WebElement data = driver
						.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[" + j + "]"));
				String values = data.getText();
				System.out.println(values);
			}
			System.out.println();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
