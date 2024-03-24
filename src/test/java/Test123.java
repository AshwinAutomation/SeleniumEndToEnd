import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 14");
		driver.findElement(By.xpath("//input[contains(@id,'submit-button')]")).click();
		List<WebElement> iPhoneNames = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone 14')]"));

		List<WebElement> iPhonePrice = driver
				.findElements(By.xpath("//span[contains(text(),'₹')]//following::span[@class='a-price-whole']"));

		
		

		int phoneCount = iPhoneNames.size();
//		System.out.println("phoneCount : " + phoneCount);
//		System.out.println("iPhonePrice : " + iPhonePrice.size());
//		
		
		for (int i = 0; i < phoneCount; i++) {
			String	PhoneName = iPhoneNames.get(i).getText();
			
			
			//
		}
		

	
	
		for (int j = 0; j < iPhonePrice.size(); j++) {
			String printPhonePrice = iPhonePrice.get(j).getText();
			System.out.println("printPhonePrice : " + printPhonePrice);
			
	
		  
		}
		
		driver.quit();

	}
	

}
