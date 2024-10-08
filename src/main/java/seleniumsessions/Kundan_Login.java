package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kundan_Login 
{
public static void main(String[] args)
{
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/login/");
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kd9837");
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Kundan@88	");
	driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
	
}
}
