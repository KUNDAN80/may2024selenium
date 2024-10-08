package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		driver =new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		By parentMenu= By.xpath("//div[text()='Add-ons']");
		 
		By childMenu = By.xpath("//div[text()='Visa Services']");
		
		/*Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(addons)).perform();
		Thread.sleep(1500);
		
		driver.findElement(visaServices).click();
		*/
		ParentChildMenu(parentMenu, childMenu);
	
	}
	
	public static void ParentChildMenu(By parentMenu,By childMenu) throws InterruptedException
	{
		/*
		 * By addons= By.xpath("//div[text()='Add-ons']"); By visaServices =
		 * By.xpath("//div[text()='Visa Services']");
		 */
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(5000);
		
		getElement(childMenu).click();
	}
	
		public static void ParentChildMenu(String parentMenu,String childMenu) throws InterruptedException
		{
			/*
			 * By addons= By.xpath("//div[text()='Add-ons']"); By visaServices =
			 * By.xpath("//div[text()='Visa Services']");
			 */
			Actions act = new Actions(driver);
			act.moveToElement(getElement(By.xpath("//*[text()='"+parentMenu+"']"))).perform();
			Thread.sleep(5000);
			
			getElement(By.xpath("//*[text()='"+childMenu+"']")).click();
		}
		
		public static WebElement getElement(By locator)
		{
			return driver.findElement(locator);
		}
		

	}


