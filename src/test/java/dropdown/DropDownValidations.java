package dropdown;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownValidations {

	public static void main(String[] args) {

		//dropdowncheck("//li[@id='Select Country']//following::select","India");
		selectValue("//li[@id='Select Country']//following::select","Ind");

	}

	public static void dropdowncheck(String element, String value) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		WebElement dropDownCountry = driver.findElement(By.xpath(element));
		Select select = new Select(dropDownCountry);
		List<WebElement> dropdownList = select.getOptions();
		// System.out.println(dropdownList.size());
		for (int i = 0; i < dropdownList.size(); i++) {
			WebElement countryCount = dropdownList.get(i);
			String countriesName = countryCount.getText();
			System.out.println("countriesName : " + countriesName);
			
			if (countriesName.equalsIgnoreCase(value)) {
				countryCount.click();
			}
		/*	Set<Object> set = new HashSet<Object>(dropdownList);
			for (Object r : set) {
				System.out.println(r + ": " + Collections.frequency(dropdownList, r));
			}*/
		}

	}
   
	
	public static void selectValue(String attribute,Object value) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		WebElement dropDownCountry = driver.findElement(By.xpath(attribute)); 
		Select select = new Select(dropDownCountry);
		
		Object valueformat = value;
		System.out.println(valueformat);
	      String data=(String) valueformat ;
	      int size=data.length();
	      System.out.println("size"+ size);
		if (valueformat.equals(value.toString())) {
			System.out.println("inside if");

			  select.selectByVisibleText((String) valueformat);
		}
	   	
		else if (valueformat.equals(value)) {
			System.out.println("inside else if");

			select.selectByValue((String) value);
		} 
		else {
			System.out.println("inside else ");
			select.selectByIndex((Integer) valueformat);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
