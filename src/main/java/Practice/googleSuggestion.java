package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSuggestion {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		 
		By searchfield= By.name("q");
		By suggestion= By.xpath("//ul/li//div[@class='wM6W7d']/span");
		
	    driver.findElement(searchfield).sendKeys("Naveen Automation");
	    Thread.sleep(3000);
	    
	      List<WebElement>  alloptions = driver.findElements(suggestion);
	      System.out.println(alloptions.size());
	      
	      for(WebElement e:alloptions)
	      {
	    	String	text= e.getText();
	  		System.out.println(text);
	  		
	  		if (text.contains("youtube"))
	  		{
	  			e.click();
	  			break;
	  		}
	      }
	    
}

}
