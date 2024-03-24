package dropdown;

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

public class DropdownWithSelectClass {

	WebDriver driver;

	@BeforeMethod
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		this.driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement email = driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys("admin@yourstore.com");
		WebElement password = driver.findElement(By.id("Password"));
		password.clear();
		password.sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test
	public void getValuefromCountryDropdown() throws InterruptedException {
		driver.findElement(By.xpath("//p[normalize-space()='Sales']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[normalize-space()='Orders']")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//select[@name='BillingCountryId']/option"));
		element.click();
		List<WebElement> billingCountries = driver.findElements(By.xpath("//select[@name='BillingCountryId']/option"));
		DropdownWithSelectClass dropdown = new DropdownWithSelectClass();
		dropdown.genericDropdown(billingCountries, "Yemen");
		

	}

	public void genericDropdown(List<WebElement> options, String value) throws InterruptedException {
		for (WebElement option : options) {
			String optionItems = option.getText();
			if (optionItems.contains(value)) {
				Thread.sleep(3000);
				option.click();
				break;
			}

		}
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
