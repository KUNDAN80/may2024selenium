package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NullWithSendKeys 
{
static WebDriver driver;
	
public static void main(String[] args) 
{
	driver =new ChromeDriver();
	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
	driver.findElement(By.id("input-email")).sendKeys(""); //we can not send null in sendkeys. It will throw 
	    //  IIlegalArgument exception :Keys to send should be in not null charsequence
	
	String name= "";
	System.out.println(name.length());
	driver.findElement(By.id("input-email")).sendKeys(name);
	
	
	
	
	
}
	
	
}
