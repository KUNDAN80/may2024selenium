package Action_clas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling 
{
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException 
{
	driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	Actions act= new Actions(driver);
	//partial scrolling
	//act.sendKeys(Keys.PAGE_DOWN).perform();
	
	
	//scroll to footer of the page
	//act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
	//Thread.sleep(2000);
	
	//scroll to top of the page
	//act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	
	act.scrollToElement(driver.findElement(By.linkText("Careers"))).click(driver.findElement(By.linkText("Careers"))).perform();
	
	
	

}

}
