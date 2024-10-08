package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {

	public static void main(String[] args) 
	{
		String browser="opera";
		WebDriver driver=null;
		switch (browser) 
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("plz pass the right browser");
            throw new BrowserException("invalid  browser");
		}
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();

	}

}
