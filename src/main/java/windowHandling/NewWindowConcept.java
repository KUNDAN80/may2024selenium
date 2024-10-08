package windowHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowConcept 
{
public static void main(String[] args) 
{
 WebDriver driver= new ChromeDriver();
 driver.get("https://www.orangehrm.com/30-day-free-trial/");
 
 driver.switchTo().newWindow(WindowType.WINDOW);
 //driver.switchTo().newWindow(WindowType.TAB); it is for tab
 driver.get("https://classic.crmpro.com/");
}
}
