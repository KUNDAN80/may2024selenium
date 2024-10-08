package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept 
{
    static WebDriver driver;
	public static void main(String[] args) 
	{
		
      driver=new ChromeDriver(); //top casting
      //driver.get("https://classic.crmpro.com/");
      driver.get("https://app.hubspot.com/login");
      
      //interface casting
      
		/*
		 * JavascriptExecutor js =(JavascriptExecutor)driver; String title =
		 * js.executeScript("return document.title;").toString();
		 * System.out.println(title);
		 * 
		 * String url = js.executeScript("return document.URL;").toString();
		 * System.out.println(url);
		 */
      JavaScriptUtil jsutil=new JavaScriptUtil(driver);
      String title= jsutil.getPageTitle();
      System.out.println(title);
      
      //jsutil.generateJsAlert("i am on the login page");
      
      //String pageText = jsutil.getPageInnerText();
      //System.out.println(pageText);
        //WebElement scrltofgpwd=  driver.findElement(By.linkText("Forgot Password?"));
        //jsutil.scrollIntoView(scrltofgpwd);
        //jsutil.drawBorder(scrltofgpwd);
      
          WebElement emaild= driver.findElement(By.id("username"));
          jsutil.flash(emaild);
      
      }
	
	public static String getTitle()
	{
		JavascriptExecutor js  =(JavascriptExecutor)driver;
	      String title = js.executeScript("return document.title;").toString();
	      return title;	
	}
	
	public static String getURL()
	{
		JavascriptExecutor js  =(JavascriptExecutor)driver;
	      String url = js.executeScript("return document.URL;").toString();
	      return url;	
	}

}
