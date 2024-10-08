package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClick {
	static WebDriver driver;

	public static void main(String[] args) 
	{
	driver =new ChromeDriver();
	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	By LoginLink=By.linkText("Login");
	ElementUtil eleutil= new ElementUtil(driver);
	
	eleutil.doClick(LoginLink);
	}
	
}
	