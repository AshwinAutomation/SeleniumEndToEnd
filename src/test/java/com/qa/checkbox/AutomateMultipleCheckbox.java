package com.qa.checkbox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateMultipleCheckbox {

	WebDriver driver;

	@BeforeMethod
	public void initalizeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");

	}

	// Scenario 1 : Select specific Check box
	@Test(enabled = false)
	public void selectSpecificCheckbox() throws InterruptedException {
		driver.findElement(By.xpath(
				"//input[@id='concessionBooking']//following::label[text()='Person With Disability Concession']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='OK']")).click();
	}

	// Scenario 2 : Select Multiple Check box
	@Test(enabled = false)
	public void selectMultipleCheckbox() throws InterruptedException {
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@type='checkbox']//following::label[@class='css-label_c t_c']"));
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkboxCount = checkboxes.get(i);
			String allCheckbox = checkboxCount.getText();
			System.out.println("allCheckbox : " + allCheckbox);
			if (allCheckbox.contains("Person With Disability Concession")) {
				checkboxCount.click();
				driver.findElement(By.xpath("//span[text()='OK']")).click();
			} else if (allCheckbox.contains("Flexible With Date")) {
				checkboxCount.click();
			} else if (allCheckbox.contains("Train with Available Berth")) {
				checkboxCount.click();
			} else if (allCheckbox.contains("Railway Pass Concession")) {

				checkboxCount.click();
			}
			Thread.sleep(2000);
		}
	}

	// Scenario 3 : Select Check boxes by choice
	@Test(enabled = false)
	public void selectCheckBoxesByChoice() throws InterruptedException {
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@type='checkbox']//following::label[@class='css-label_c t_c']"));
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkboxesCount = checkboxes.get(i);
			String checkBoxesName = checkboxesCount.getAttribute("for");
			System.out.println("checkBoxesName : " + checkBoxesName);

			if (checkBoxesName.equals("dateSpecific") || checkBoxesName.equals("availableBerth")) {
				checkboxesCount.click();
			}
			Thread.sleep(2000);
		}
	}

	// Scenario 4 : Select last two check boxes
	@Test(enabled = false)
	public void selectLastTwoCheckboxes() throws InterruptedException {
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@type='checkbox']//following::label[@class='css-label_c t_c']"));
		for (int i = checkboxes.size() - 2; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		Thread.sleep(2000);
	}

	// Scenario 5 : Select first two check boxes
	@Test
	public void selectFirstTwoCheckboxes() {
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@type='checkbox']//following::label[@class='css-label_c t_c']"));

		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkboxCount = checkboxes.get(i);
			String allCheckbox = checkboxes.get(i).getText();

			if (i < 2) {
				if (allCheckbox.contains("Person With Disability Concession")) {
					checkboxCount.click();
					driver.findElement(By.xpath("//span[text()='OK']")).click();
				} else if (allCheckbox.contains("Flexible With Date")) {
					checkboxCount.click();
				}
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
