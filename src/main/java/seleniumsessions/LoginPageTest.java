package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest 
{
public static void main(String[] args) 
{
BrowserUtil brutil=new BrowserUtil();
WebDriver driver = brutil.initDriver("chrome");
driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

 By emailID = By.id("input-email");
 By password = By.id("input-password");
 
 ElementUtil eleutil= new ElementUtil(driver);
 eleutil.doSendkeys(emailID, "test@gmail.com");
 
 brutil.quitBrowser();
 
 
 
  

	
}
}
