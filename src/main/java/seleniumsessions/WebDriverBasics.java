package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) 
	{
		//open browser
		//enter url
		//get the title
		//act vs exp
		//close browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println(title);
		
		if (title.equals("Google"))
		{
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		driver.quit();

	}

}
