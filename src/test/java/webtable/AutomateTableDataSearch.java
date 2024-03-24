package webtable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateTableDataSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Table']")).click();
		List<WebElement> tableList = driver.findElements(By.xpath("//a[starts-with(@href,'./table')]"));
		System.out.println(tableList.size());
        for (int i = 0; i < tableList.size(); i++) {
			WebElement tableOptions =tableList.get(i);
			String tableNames = tableOptions.getText();
			System.out.println("tableNames : " + tableNames );
			if (tableNames.contains("Table Data Search")) {
				tableOptions.click();
				break;
			}
		}
        
	}
}
