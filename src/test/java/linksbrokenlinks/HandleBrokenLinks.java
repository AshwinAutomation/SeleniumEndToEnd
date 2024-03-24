package linksbrokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zlti.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			WebElement linkCount = links.get(i);
			String linkURL = linkCount.getAttribute("href");
			URL url = new URL(linkURL);
			URLConnection connect = url.openConnection();
			HttpURLConnection httpURLconnection = (HttpURLConnection) connect;
			httpURLconnection.connect();
			if (httpURLconnection.getResponseCode() == 200) {
				System.out.println(linkURL + "------" + httpURLconnection.getResponseMessage());
			} else {
				System.err.println(linkURL + "------" + httpURLconnection.getResponseMessage());
			}
		}
	}
}

