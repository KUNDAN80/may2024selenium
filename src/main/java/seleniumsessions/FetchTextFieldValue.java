package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchTextFieldValue {

	static WebDriver driver;

	public static void main(String[] args) 
	{
		driver = new ChromeDriver();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		
		/*
		 * driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		 * driver.findElement(By.id("password")).sendKeys("8080808080");
		 * 
		 * String text = driver.findElement(By.id("password")).getAttribute("value");
		 * System.out.println(text);
		 */
		 By emailID  =  By.id("email");
		 By password  =  By.id("password");
		 doSendkeys(emailID, "Kundan@gmail.com");
		String v1 = doElementGetAttribute(emailID, "value");
		System.out.println(v1);
		 
		 
		
		
}
	public static void doSendkeys(By locator,String value)
	{
		getElement(locator).sendKeys(value);
	}

public static String doElementGetAttribute(By locator, String attrName)	
{
	return getElement(locator).getAttribute(attrName);
}
	
public static WebElement getElement(By locator)	
{
	return driver.findElement(locator);
	
}

}
