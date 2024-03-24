package textbox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleAutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.co.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(3000);
		List<WebElement> seleniumContent = driver.findElements(By.xpath("//*[@jsname='bw4e9b']//li"));
		
		System.out.println("selenniumContent :" + seleniumContent.size());
		
		for (WebElement webElement : seleniumContent) {
			String couresename = webElement.getText().trim();
			System.out.println("couresename :" + couresename);
			
			
			if (couresename.equals("selenium webdriver")) {
				webElement.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
