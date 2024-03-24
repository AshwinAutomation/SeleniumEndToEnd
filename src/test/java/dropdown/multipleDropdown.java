package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multipleDropdown {
	@Test(enabled=true)
	public void textboxAutomate() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		String expectedFile="DOC file";
		boolean file=false;
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement files=driver.findElement(By.xpath("//select[@id='files']//self::select"));
		js.executeScript("arguments[0].scrollIntoView(true)", files);

		Select select= new Select(files);
		List<WebElement> filesCount= select.getOptions();
		int count=filesCount.size();
		System.out.println("count :" + count);
		for(WebElement allfiles:filesCount) {
			
			
			String filesName=allfiles.getText();
			System.out.println("filesName : " + filesName);
			boolean fileExist=true;
			if (expectedFile.equalsIgnoreCase(filesName)) {
				 fileExist=true;
				 
				break;
			}
			if (fileExist) {
				System.out.println(expectedFile+ "is present in the list" + "test pass");
			}
			
			else {
				System.out.println(expectedFile+ "is present in the list" + "test fail");
			}
		}
				
		
	}
}
