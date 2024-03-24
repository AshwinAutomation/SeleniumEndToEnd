package linksbrokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksAndBrokenlinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/guide/how-to-find-broken-links-in-selenium");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		String linkURl;
		for (WebElement link : allLinks) {
			linkURl = link.getAttribute("href");
			brokenlinks(linkURl);
		}
		driver.close();
	}

	public static void brokenlinks(String links) throws MalformedURLException {
		System.out.println(links);
		URL url = new URL(links);
		URLConnection connection;
		try {
			connection = url.openConnection();
			HttpURLConnection httpurlConnection = (HttpURLConnection) connection;
			httpurlConnection.setConnectTimeout(3000);
			httpurlConnection.connect();
			if (httpurlConnection.getResponseCode() == 200) {
				System.out.println(links + "----------" + httpurlConnection.getResponseMessage());
			} else {
				System.err.println(
						links + "-------------" + httpurlConnection.getResponseMessage() + " is a broken links");
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println(links + "is a broken links");
		}

	}
}
