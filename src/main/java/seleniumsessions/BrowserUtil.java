package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil 
{
WebDriver driver ;

/**
 * 
 * @param browserName
 * @return this returns driver
 */

public WebDriver initDriver(String browserName)
{
	System.out.println("browser name :" +browserName);
	
	switch (browserName) 
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
	return driver;
}

public void launchURL(String url)
{
	if (url.indexOf("http") != 0 || url.length() ==0)
	{
		throw new BrowserException("http missing url");
	}
	driver.get(url);
	}
public void launchURL(URL url)
{
	
	driver.navigate().to(url);
}

public String getPageTitle()
{
	return driver.getTitle();
}
public String getPageURL()
{
	return driver.getCurrentUrl();
}
public void quitBrowser()

{
	driver.quit();
}


}


