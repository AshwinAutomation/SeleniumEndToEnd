package windows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://demoqa.com/browser-windows");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	String parentWindow = driver.getWindowHandle();
	System.out.println(parentWindow);
    driver.findElement(By.id("windowButton")).click();
    
    Set<String> allWindows=driver.getWindowHandles();
    System.out.println(allWindows);
    System.out.println(allWindows.size());
    
    for (String childWindow : allWindows) {
		 if (!childWindow.equals(parentWindow)) {
			  driver.switchTo().window(childWindow);
			  driver.manage().window().maximize();
			 String childWinowMessage=  driver.findElement(By.id("sampleHeading")).getText();
			 System.out.println(childWinowMessage);
			 driver.switchTo().window(parentWindow);
			  
		}
	}
    
    
    
    
    
    
    
    
    
    
	}

}
