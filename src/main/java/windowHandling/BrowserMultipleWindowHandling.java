package windowHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserMultipleWindowHandling 
{
public static void main(String[] args) throws InterruptedException 
{
	WebDriver driver = new ChromeDriver();	
	driver.get("https://www.orangehrm.com/30-day-free-trial/");// parent window
	
	 String   P_id= driver.getWindowHandle();
	 System.out.println(P_id);
	 
	 WebElement executiveProfile = driver.findElement(By.xpath("//footer//a[contains(text(),'Executive Profile')]"));
		WebElement pressReleases = driver.findElement(By.xpath("//footer//a[contains(text(),'Press Releases')]"));
		WebElement newsArticles = driver.findElement(By.xpath("//footer//a[contains(text(),'News Articles')]"));
		WebElement csSupport = driver.findElement(By.xpath("//footer//a[contains(text(),'CS & Support')]"));
	 
	 Actions act = new Actions(driver);
		act.click(executiveProfile).perform();
		act.click(pressReleases).perform();
		act.click(newsArticles).perform();
		act.click(csSupport).perform();
	 
	   Set<String>  handles  = driver.getWindowHandles();
	     Iterator<String>  it  = handles.iterator();
	     
	     while (it.hasNext())
	     {
	    	 String WID =it.next();
	    	 driver.switchTo().window(WID);
	    	 System.out.println(driver.getTitle());
	    	 
	    	 if (!WID.equals(P_id))
	    	 {
	    		 driver.close();
	    	 }
	    	 Thread.sleep(1500);
			}

			driver.switchTo().window(P_id);

			System.out.println("parent window title: " + driver.getTitle());	    	 
	    	 
	   
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	     }

}


