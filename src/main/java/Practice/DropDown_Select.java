package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_Select 
{
static WebDriver driver ;

public static void main(String[] args) throws InterruptedException 
{
	driver = new ChromeDriver();	
	driver.get("https://www.orangehrm.com/30-day-free-trial");
	By country=	By.id("Form_getForm_Country");
	//selectDropDownByVisibleText(country, "Brazil");
	//selectValueByIndex(country, 1);
	selectValueByValue(country, "Brazil");
	Thread.sleep(4000);
	driver.close();	
	
}
public static WebElement getelement(By locator)
	{
		return driver.findElement(locator);
	}
 public static void selectDropDownByVisibleText(By locator ,String country )
 {
	 Select select= new Select(getelement(locator));
	 select.selectByVisibleText(country);
 }
 
 public static void selectValueByIndex(By locator ,int index )
 {
	 Select select= new Select(getelement(locator));
	 select.selectByIndex(index);
 }
 
 public static void selectValueByValue(By locator ,String value )
 {
	 Select select= new Select(getelement(locator));
	 select.selectByValue(value);
 }

}
