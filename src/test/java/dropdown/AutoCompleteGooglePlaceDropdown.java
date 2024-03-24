package dropdown;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlaceDropdown {
	WebDriver driver;

	@Test
	public void automateAutoCompleteGooglePlaceDropdown() throws InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setAcceptInsecureCerts(true);

		ChromeOptions options = new ChromeOptions();
		options.merge(capabilities);
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.twoplugs.com/");
		driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();

		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		searchBox.clear();
		searchBox.sendKeys("los");
		Thread.sleep(3000);

		String text;

		do {
			searchBox.sendKeys(Keys.ARROW_DOWN);
			text = searchBox.getAttribute("value");
			System.out.println("text :" + text);
			if (text.equals("Los Andes, Chile")) {
				searchBox.sendKeys(Keys.ENTER);
				break;
			}
		} while (!text.isEmpty());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
