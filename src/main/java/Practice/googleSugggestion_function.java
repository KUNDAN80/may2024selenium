package Practice;

import java.security.PublicKey;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSugggestion_function 
{
	static WebDriver driver;


public static void main(String[] args) throws InterruptedException
{
	driver = new ChromeDriver();
	driver.get("https://www.google.com/");
	By searchField= By.name("q");
	By suggestions = By.xpath("//div[@class='wM6W7d']");
	dosearch1(searchField, "naveen automation", suggestions, "youtube");
	
	driver.close();
	
	
}
	public static void dosearch1(By searchfield,String input,By suggestions,String search_value) throws InterruptedException
	{
		driver.findElement(searchfield).sendKeys(input);
	    Thread.sleep(3000);
	    
	      List<WebElement>  alloptions = driver.findElements(suggestions);
	      System.out.println(alloptions.size());
	      
	      for(WebElement e:alloptions)
	      {
	    	String	text= e.getText();
	  		System.out.println(text);
	  		
	  		if (text.contains(search_value))
	  		{
	  			e.click();
	  			break;
	  		}
	      }
		
}
}

