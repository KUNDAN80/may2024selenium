package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;



public class RelativeLocatorsWithLabels 
{

	public static void main(String[] args) 
{
	WebDriver driver = new ChromeDriver();
	
      driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
      driver.manage().window().maximize();
      WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
      checkbox.click();
      
      String cookie_policy=driver.findElement(with(By.tagName("a")).toLeftOf(checkbox)).getText();
      if (cookie_policy.equals("Privacy Policy"))
      {
    	  System.out.println("Pass");
      }
      else {
		System.out.println("Fail");
	}
      
      System.out.println(cookie_policy);
      
      driver.quit();
      
      
      
    
      //driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
  	
  	//WebElement emailLabel = driver.findElement(By.xpath("//label[text()='E-Mail Address']"));
  	//WebElement pwdLabel = driver.findElement(By.xpath("//label[text()='Password']"));
      
	//driver.findElement(with(By.id("input-email")).below(emailLabel)).sendKeys("mianl@gmail.com");
	//driver.findElement(with(By.id("input-email")).below(emailLabel).above(pwdLabel)).sendKeys("minal@gmail.com");		
}
}
