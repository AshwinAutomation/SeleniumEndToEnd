package com.qa.svg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PriceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.busonlineticket.com/booking/cameron-highlands-to-kuala-lumpur-bus-tickets");
          List<WebElement> busPrices  = driver.findElements(By.xpath("//table[@class='table-style-1 spacer']/tbody/tr/td[6]"));
          for(int i=0; i<busPrices.size(); i++){
        	  WebElement busCount =   busPrices.get(i);
        	  String busesPriceVale = busCount.getText();
        	  busesPriceVale = busesPriceVale.substring(2).trim();
           ArrayList<String> price = new ArrayList<String>();
           price.add(busesPriceVale);
           System.out.println("price : " + price);
        	  
           
          }
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
          
          
	}

}
