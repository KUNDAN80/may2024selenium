package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch 
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException 
	{
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		By searchField= By.name("q");
		By suggestions = By.xpath("//div[@class='wM6W7d']");
		dosearch(searchField,"naveen automation labs", suggestions, "youtube");
		
	}
	
	
	public static void dosearch(By searchField,String Searchkey,By suggestions, String search_value) throws InterruptedException
	{
		driver.findElement(searchField).sendKeys(Searchkey);
		Thread.sleep(4000);  
		
		List<WebElement> suggstlist = driver.findElements(suggestions);
		System.out.println(suggstlist.size());
		
		for (WebElement e: suggstlist)
		{
		String	text= e.getText();
		System.out.println(text);
		if(text.contains(search_value))
		{
			e.click(); //e is the element
			break;
		}
		else
		{
			System.out.println("element not present");
		}
			
		}
	}

}
