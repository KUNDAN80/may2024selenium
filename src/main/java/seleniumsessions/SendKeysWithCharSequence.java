package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysWithCharSequence 
{
	static WebDriver driver;
public static void main(String[] args) 
{
	driver =new ChromeDriver();
	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
	
	String name ="Naveen";
	StringBuilder sb=new StringBuilder("Automation");
	StringBuffer sf=new StringBuffer("labs");
	String Lastname =null;
	
	driver.findElement(By.id("input-email")).sendKeys(name," ",sb," ",sf, Lastname);
	
	
	
	
}
}
