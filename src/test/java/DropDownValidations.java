import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownValidations {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		 WebElement dropDownCountry = driver.findElement(By.xpath("//li[@id='Select Country']//following::select")); 

		 Select select= new Select(dropDownCountry );
		  List<WebElement> dropdownList = select.getOptions();
		 // System.out.println(dropdownList.size());
		  
		  for(int i=0; i<dropdownList.size();i++) {
			  WebElement countryCount= dropdownList.get(i);
				 String countriesName = countryCount.getText();
				 System.out.println("countriesName : " + countriesName);
		
			
			
		  }
		  
		  
		  System.out.println("Count all with frequency");
		    Set<Object> set = new HashSet<Object>(dropdownList);
		    for (Object r : set) {
		        System.out.println(r 	+ ": " + Collections.frequency(dropdownList, r));
		    }
	}

}
