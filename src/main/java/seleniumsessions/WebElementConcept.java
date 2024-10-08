package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept 
{
	static WebDriver driver;
public static void main(String[] args) 
{
 driver = new ChromeDriver();	
 driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//1st way

/* driver.findElement(By.id("input-email")).sendKeys("test@gmail.com"); */

//2nd way

/*
 * WebElement emailid2 = driver.findElement(By.id("input-email"));
 * emailid2.sendKeys("abc@gmail.com") ;
 */
       
  //3rd way :By locator 
       
	
	/*
	 * By email3 = By.id("input-email"); WebElement emailid_3=
	 * driver.findElement(email3); emailid_3.sendKeys("mail3@gmail.com")
	 */;
	 
        
   //4th way: By locator + Generic Method for Webelement
        
	/*
	 * By email4 = By.id("input-email"); WebElement abc1 = getElement(email4);
	 * abc1.sendKeys("4th way");
	 */
        
   //5th way:  By locator + Generic Method for Webelement and action method    
	/*
	 * By email5 = By.id("input-email"); doSendkeys(email5, "Neha");
	 */
   //6th way: By locator + generic method for webelement and action in ElementUtil class     
        By email6 = By.id("input-email");
        ElementUtil elutil=new ElementUtil(driver);
        elutil.doSendkeys(email6, "wer@gmail.com");
        
              
}	     
  
    public static void doSendkeys(By locator,String Sendkeys)
    {
    	driver.findElement(locator).sendKeys(Sendkeys);
    }

    public static WebElement getElement(By locator)   //call by reference
  {
	  return driver.findElement(locator);
  }
        
        
        
       
       








	
	
}