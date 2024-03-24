package dropdown;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandleWithXpathAxes {
	WebDriver driver;
	JavascriptExecutor js= (JavascriptExecutor)driver;
   @BeforeMethod
	public void launchApplication() {
     
	}
  
	@Test(enabled=false)
	public void select_a_speed() {
		WebElement speed= driver.findElement(By.xpath("//*[@name='speed']//self::select"));
		js.executeScript("arguments[0].scrollIntoView(true)", speed);
		Select select= new Select(speed);
		
		List<WebElement> speedlist=select.getOptions();
		int speedCount=speedlist.size();
		Reporter.log("speedCount: " + speedCount);
		
		for(WebElement data:speedlist) {
		   
			 String speedName= data.getText();
			 System.out.println("speedName : " + speedName);
			
		}
		driver.findElement(By.xpath("//input[@type='text' and @id='RESULT_TextField-3']//self::input")).sendKeys("9937243596");
		
	}
	@Test(enabled=true)
	public void textboxAutomate() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		WebElement phoneNumber=driver.findElement(By.xpath("//input[@type='text' and @id='RESULT_TextField-3']//self::input"));
		js.executeScript("arguments[0].scrollIntoView(true)", phoneNumber);
		phoneNumber.sendKeys("9937243596");
		String number=phoneNumber.getAttribute("value");
         
		System.out.println("number : " + number);
		driver.switchTo().defaultContent();
	}
}

