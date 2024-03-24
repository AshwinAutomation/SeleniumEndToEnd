package svgautomate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GraphAutomate {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// *[local-name()='svg']//*[name()='g' and
		// @class='highcharts-series-group']//*[name()='rect']

		List<WebElement> barList = driver.findElements(By.xpath(
				"//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']"));
		
		System.out.println("barList count : " + barList.size());
		Actions act = new Actions(driver);
		for (WebElement elememt : barList) {
			act.moveToElement(elememt).perform();
			String text=driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']")).getText();
		   System.out.println("text : " + text);
		   
		}

	}

}
