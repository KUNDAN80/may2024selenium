package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) 
	{
		BrowserUtil brUtil = new BrowserUtil ();
		
		brUtil.initDriver("chrome");
		
		brUtil.launchURL("https://www.amazon.com/");
		
		String title  = brUtil.getPageTitle();
		System.out.println(title);
		brUtil.quitBrowser();
		
	}

}