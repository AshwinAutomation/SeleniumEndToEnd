package webtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OccuranceDataFromTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
		List<WebElement> status =driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td[4]"));
		//System.out.println(status.size());
		
		for (int i = 1; i <status.size(); i++) {
		String statusValue =	status.get(i).getText();
		//System.out.println("status count" + statusValue);
		Map<Object, Object> charMap = new HashMap<Object, Object>();
		
		for (WebElement c : status) {
			System.out.println("status count" + c);
			if (charMap.containsKey(c)) {
				charMap.put(c, charMap.get(c));
			}
			else {
				charMap.put(c,1);
			}
			//System.out.println(statusValue + ":" + charMap);
		}
		}
		
		driver.quit();
	}

}
