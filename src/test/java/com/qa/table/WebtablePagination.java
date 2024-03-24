package com.qa.table;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebtablePagination {

	WebDriver driver = null;

	@BeforeSuite
	public void initialBrowser() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setAcceptInsecureCerts(true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.merge(capabilities);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/admin/index.php");
	}

	@Test
	public void webTablePagination() throws InterruptedException {
		WebElement userName = driver.findElement(By.name("username"));
		WebElement Password = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		userName.clear();
		Password.clear();
		userName.sendKeys("demo");
		Password.sendKeys("demo");
		loginButton.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[normalize-space()='Orders'])[1]")).click();
		Thread.sleep(2000);

		// find total number of pages
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println("text: " + text); //Showing 1 to 10 of 26 (3 Pages)
		
		int totalPages =Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		System.out.println("totalPages: " + totalPages);
		
		for (int i = 1; i <=totalPages; i++) {
			WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li/span"));
			System.out.println("activePage : " + activePage.getText());
			activePage.click();
			
			int rowCount =driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tr")).size();
			System.out.println("rowCount :" + rowCount);
			
			
			String pageno = Integer.toString(i+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='"+pageno+"']")).click();
		}
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
