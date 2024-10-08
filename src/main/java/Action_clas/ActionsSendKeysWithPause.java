package Action_clas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysWithPause 
{
	static WebDriver driver;
public static void main(String[] args) 
	{
	driver = new ChromeDriver();
	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	By FirstName	=By.id("input-firstname");
	
	doActionSendKeysWithPause(FirstName, "Naveen Automation", 500);	
	}
public static void doActionSendKeysWithPause(By locator, String value, long pauseTime)
{
	Actions act= new Actions(driver);
	char ch[] = value.toCharArray();
	for (char c :ch)
	{
		act.sendKeys(getElement(locator), String.valueOf(c)).pause(pauseTime).perform();
	}
}

public static WebElement getElement(By locator) {
	return driver.findElement(locator);
}

}
