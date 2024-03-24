package webtable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountRowforBranches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("txtuId")).sendKeys("Admin");
		driver.findElement(By.name("txtPword")).sendKeys("Admin");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']")).click();
		WebElement table = driver.findElement(By.id("tab_10"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<WebElement> cells;
		System.out.println("rows :" + rows.size());
		/*
		 * for (WebElement webElement : rows) { String rowValue= webElement.getText();
		 * //System.out.println("rowValue : " + rowValue); } for (WebElement webElement
		 * : cells) { String cellValue= webElement.getText();
		 * System.out.println("cellValue : " + cellValue); }
		 */

		for (int i = 0; i < rows.size(); i++) {
			// String rowValue = rows.get(i).getText();

			cells = rows.get(i).findElements(By.tagName("td"));
			String text = cells.get(i).getText();
			System.out.println("text : " + text);
		}
	}

}
