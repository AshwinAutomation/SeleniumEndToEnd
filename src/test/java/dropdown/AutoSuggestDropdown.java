package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {

	WebDriver driver;

	@BeforeMethod
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
	}

	@Test
	public void autosuggestDropdown() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(3000);
		List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='lnnVSe']/div[@class='wM6W7d']/span"));
		for (WebElement link : allLinks) {
			String allList = link.getText();
			System.out.println("allList : " + allList);
			if (allList.equals("selenium webdriver")) {
				link.click();
			}
		}

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
