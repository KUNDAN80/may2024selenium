package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownHandleWithoutSelectClass {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		
		
		/*
		 * List<WebElement> optionsList=
		 * driver.findElements(By.xpath("//select[@id='Form_getForm_Country']/option"));
		 * for (WebElement e:optionsList) { String text=e.getText();
		 * System.out.println(text); if(text.equals("India")) { e.click(); break; }
		 */
			//
		selectDropDownvalue("//select[@id='Form_getForm_Country']/option", "India");
		
	}
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void selectDropDownvalue(String locator,String value)
	{
		List<WebElement> optionsList= driver.findElements(By.xpath(locator));
		for (WebElement e:optionsList)
		{
			String text=e.getText();
			System.out.println(text);
			if(text.equals(value))
			{
				e.click();
				break;
			}
			
		}
		
	}

}
