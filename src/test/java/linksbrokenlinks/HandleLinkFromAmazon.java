package linksbrokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinkFromAmazon {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		System.out.println(allLink.size());
		for(WebElement link : allLink) {
			String href = link.getAttribute("href");
		//	System.out.println(href);
			//brokenLinks(url);
		
	
		if (href !=null && href.startsWith("https://www.google.com/") && href.contains("url?q=https://") && href.contains("&")) {
			System.out.println("inside IF");
			   href = href.split("url\\?q=")[1].split("&")[0];
               if (href.startsWith("https://www.google.com/url?q=https://")) {
                   href = href.substring("https://www.google.com/url?q=".length());
               }
               if (href.startsWith("http") && href.contains("://")) {
                   System.out.println(href);
               }
		

		}}
		
		driver.quit();

	}

	public static void brokenLinks(String links) throws IOException {
		URL url = new URL(links);
		URLConnection connect = url.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) connect;
		httpURLConnection.connect();

		if (httpURLConnection.getResponseCode() == 200) {
			//System.out.println(url + "--" + httpURLConnection.getResponseMessage());
		} else {
			System.out.println(url + "--" + httpURLConnection.getResponseMessage() + "--" + "is a broken links ");
		}

	}
}
