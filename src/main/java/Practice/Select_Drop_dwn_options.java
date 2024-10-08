package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Drop_dwn_options 
{
static WebDriver driver;

public static void main(String[] args) 
{
	driver = new ChromeDriver();
	driver.get("https://www.orangehrm.com/30-day-free-trial");
	
     By country	= By.id("Form_getForm_Country");
     getDropDownOptionsTestList(country);
     
     if (getDropDownOptionsTestList(country).contains("India"))
     {
    	 System.out.println("Test case is passed");
     }
     else 
     {
    	 System.out.println("Test case is failed");
     }
     
     getDropDownOptionsTestList1(country);
     
     List<String> expected_country=Arrays.asList("India","Brazil");
     if (getDropDownOptionsTestList1(country).containsAll(expected_country))
     {
    	 System.out.println("Test case passed 1");
     }
     
      
      }
 public static WebElement getelement(By locator)
	{
		return driver.findElement(locator);
	}	

public static List<WebElement> getDropDownOptionsTestList(By locator)
{
	Select select = new Select(getelement(locator));
	List<WebElement>  alloptions = select.getOptions();
    System.out.println(alloptions.size());
    
    for (WebElement e:alloptions)
    {
  	  String text =e.getText();
  	  System.out.println(text);
    }
    return alloptions;
	
}

public static List<String> getDropDownOptionsTestList1(By locator)
{
	Select select = new Select(getelement(locator));
	List<WebElement>  alloptions = select.getOptions();
    System.out.println(alloptions.size());
    
    List<String> optionsTextList =new ArrayList<String>();
    
    for (WebElement e:alloptions)
    {
  	  String text = e.getText();
  	   optionsTextList.add(text);
  	}	
    return optionsTextList;
}




}
