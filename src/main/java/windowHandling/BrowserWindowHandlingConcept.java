package windowHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserWindowHandlingConcept 
{

	public static void main(String[] args) 
	{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.orangehrm.com/30-day-free-trial/"); //parent window
	
	 WebElement exeprofile= driver.findElement(By.xpath("//footer//a[contains(text(),'Profile')]"));
	  Actions act = new Actions(driver);
	  act.click(exeprofile).build().perform(); //child window
	  
	  //1. fetch the window ids for parent and child windows
	  
	   String pid= driver.getWindowHandle();
	   System.out.println(pid);
	  
	  Set<String> handles= driver.getWindowHandles();//IT WILL store the session id but not in order.
	  Iterator<String>  IT=  handles.iterator();//it will store in order
	   String p_id  = IT.next();
	   System.out.println("PARENT ID IS" + p_id ); // it will return the output as pid
	   
	   String child_id  = IT.next();
	   System.out.println("Child id is" + child_id);
	   
	   //switching work:
	   driver.switchTo().window(child_id);
	   //currently focus is on child  
	   
	   
	   
	   
	   
	   
			   
	  
	  
	  
	  
	}

}
