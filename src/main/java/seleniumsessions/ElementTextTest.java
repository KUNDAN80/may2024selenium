package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementTextTest 
{
	static WebDriver driver;
public static void main(String[] args) 
{
	driver =new ChromeDriver();
	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	driver.manage().window().maximize();
	
	By para1= By.xpath("//*[@id=\"content\"]/div/div[1]/div/p[2]");
	
	ElementUtil elutil = new ElementUtil(driver);
	 String m1  = elutil.getElementtext(para1);
	
	System.out.println(m1);
	
}	
}
