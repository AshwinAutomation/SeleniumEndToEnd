package textbox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionTextbox {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://redbus.in/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.findElement(By.id("src")).sendKeys("new");

	Thread.sleep(5000);
	List<WebElement> cityList = driver.findElements(By.xpath("//input[@id='src']//following::ul[1]/li"));
	
     System.out.println("cityList : " + cityList.size());
     
     try {
    	 for (WebElement webElement : cityList) {
        	 String cityName = webElement.getText();
        	 System.out.println("cityName : " + cityName);
        	 Thread.sleep(5000);
        	 if (cityName.contains("New Delhi Railway Station, Delhi")) {
    			webElement.click();
    		}
    	}
	} catch (Exception e) {
		// TODO: handle exception
		for (WebElement webElement : cityList) {
	    	 String cityName = webElement.getText();
	    	 System.out.println("cityName : " + cityName);
	    	 Thread.sleep(5000);
	    	 if (cityName.contains("New Delhi Railway Station, Delhi")) {
				webElement.click();
			}
	}
     
}}
}
