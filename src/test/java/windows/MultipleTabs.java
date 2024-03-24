package windows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleTabs {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.findElement(By.id("windowButton")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());
		System.out.println(allWindows);
		
		
		List<String> windows = new ArrayList<String>(allWindows);
		
		driver.switchTo().window(windows.get(1));
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		driver.switchTo().window(windows.get(0));
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,500)");
		
		js.executeScript("arguments[0].click();", "//span[text()='Modal Dialogs']");
	}

}
