package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHnadling {
	static WebDriver driver;


	public static void main(String[] args) 
	{
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		By country=By.id("Form_getForm_Country"); 
		  
		
		/*
		 * WebElement countrylist =driver.findElement(country);
		 * 
		 * Select select=new Select(countrylist);
		 */
		 
			/*
			 * select.selectByIndex(1); select.selectByValue("Belgium");
			 * select.selectByVisibleText("Brazil");
			 */
		 
		/*
		 * SelectDropDownByVisibleText(country, "India"); 
		 * SelectDropDownByIndex(country,5);
		 */
		/*
		 * List<WebElement> optionsList= select.getOptions();
		 * System.out.println(optionsList.size());
		 */
		       int count= getDropDownOptionsCount(country);
		       System.out.println(count-1);
}
	     public static int getDropDownOptionsCount(By locator)
	     {
	    	 Select select = new Select(getElement(locator));
	    	 return select.getOptions().size();
		}
	public static void SelectDropDownByVisibleText(By locator,String visibleText) 
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);	
	}
	public static void SelectDropDownByIndex(By locator,int index) 
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);	
	}
	public static void SelectDropDownByValue(By locator,String Value) 
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(Value);
	}
	
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
}
