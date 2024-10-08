package Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSPopUpHandling {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1. Normal alert
		
		//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//Thread.sleep(2000);
		//Alert alert=driver.switchTo().alert();
		//String text=alert.getText();
		//System.out.println(text);
		//alert.accept(); //click on ok
		//alert.dismiss();//just cancel this alert
		
		//2. confirm alert:
		
		//driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		// Alert alert=driver.switchTo().alert();
		//alert.accept(); //click on ok
				//alert.dismiss();//just cancel this alert
		
		//3. Alert :in this user take INPUT.
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Testing");
		
		alert.accept();
		
		
		
		
				
				
		
		
}
}
