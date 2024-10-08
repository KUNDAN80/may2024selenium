package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil 
{
    private WebDriver driver;
    private Actions act;
public ElementUtil(WebDriver driver)
{
	this.driver=driver;
	act = new Actions(driver);
}
public void doClick(By locator)
{
	driver.findElement(locator).click();
}
public void doClick(By locator, int timeOut) 
{
	waitForElementVisible(locator, timeOut).click();
}
public void doSendkeys(By locator,String value)
    {
    	driver.findElement(locator).sendKeys(value);
    }

public void doSendKeys(By locator, String value, int timeOut) 
{
	waitForElementVisible(locator, timeOut).sendKeys(value);
}
public void doSendkeys(By locator,CharSequence...value)
{
	driver.findElement(locator).sendKeys(value);
}
public WebElement getElement(By locator)   //call by reference
  {
return driver.findElement(locator);
  }
public List<WebElement> getElements(By locator)   //call by reference
{
	return driver.findElements(locator);
}
public String  doElementGetAttribute(By locator, String attrName)	
{
	return getElement(locator).getAttribute(attrName);
}
 public String getElementtext(By locator)
{
	String eleText= driver.findElement(locator).getText();
	
	if (eleText!=null)
	{
		return eleText;
	}
	else {
		System.out.println("Element text is Null");
		return null;
	}
	}
public  boolean isElementDisplayed(By locator)
{
	try {
		return getElement(locator).isDisplayed();
		
	} 
	catch (NoSuchElementException e) 
	{
	System.out.println("Element is not displayed " + locator);
	return false;
	}	
}
public  void printElementTextList(By locator)
{
	List<String> eleTextList = getElementsTextList(locator);
	for (String e:eleTextList)
	{
		System.out.println(e);
	}
}
public  List<String> getElementsTextList(By locator)
{
	List<WebElement> eleList= getElements(locator);
	List<String> eleTextList = new ArrayList<String>();// Starting it is blank
	
	for(WebElement e: eleList)
	{
	String eleText	= e.getText();
	if(eleText.length()!=0)
	{
		eleTextList.add(eleText);
	}
	
	}
	return eleTextList;
}
public  void dosearch(By searchField,String Searchkey,By suggestions, String search_value ) throws InterruptedException
{
	doSendkeys(searchField, Searchkey);
	Thread.sleep(4000);  
	
	
	List<WebElement> suggstlist    = getElements(suggestions);
	           int totalsuggetion  = suggstlist.size();
	System.out.println("total number of suggestions" +totalsuggetion);
	
	if (totalsuggetion==0)
	{
		System.out.println("No siggestions found....");
		throw new FrameWorkException();
	}
	
	for (WebElement e: suggstlist)
	{
	String	text= e.getText();
	System.out.println(text);
	if(text.contains(search_value))
	{
		e.click(); //e is the element
		break;
	}
		
	}
}
///for drop down
private Select getSelect(By locator)
{
	return new Select(getElement(locator));
	
}


public  int getDropDownOptionsCount(By locator)
{
	 return getSelect(locator).getOptions().size();
}

public  void SelectDropDownByVisibleText(By locator,String visibleText) 
{
getSelect(locator).selectByVisibleText(visibleText);	
}

public  void SelectDropDownByIndex(By locator,int index) 
{
Select select = new Select(getElement(locator));
getSelect(locator).selectByIndex(index);	
}

public void SelectDropDownByValue(By locator,String Value) 
{
getSelect(locator).selectByValue(Value);
}

public  List<String> getDropDownOptionsTextList(By locator ) //IT WILL STORE THE DATA.
{
	 List<WebElement> optionsList = getSelect(locator).getOptions();
	 System.out.println(optionsList.size());
	  List<String> optionsTextList = new ArrayList<String>();//for storing the data
	   for (WebElement e:optionsList)
	   {
		   String text= e.getText();
		   optionsTextList.add(text);   
	   }
	   return optionsTextList;
}

public  void selectDropDownValueUsingSelect(By locator,String value ) //IT WILL STORE THE DATA.
{
	   List<WebElement> optionsList = getSelect(locator).getOptions();
	   /*System.out.println(optionsList.size());
	   	   
	   for (WebElement e:optionsList)
	   {
		   String text= e.getText();
		   System.out.println(text);
			if(text.equals(value))
			{
				e.click();
				break;
			}
		     
	   }*/
	   selectDropDown(optionsList, value);
}

//select drop down without using class	
public void selectDropDownvalue(By locator,String value)
{
	List<WebElement> optionsList= getElements(locator);
	
	/*System.out.println("total size" +optionsList.size());
	for (WebElement e:optionsList)
	{
		String text=e.getText();
		System.out.println(text);
		if(text.equals(value))
		{
			e.click();
			break;
		}}}*/
	selectDropDown(optionsList, value);
}
     private void selectDropDown(List<WebElement> optionsList,String value)
	{
    	 System.out.println("total size" +optionsList.size());
    		for (WebElement e:optionsList)
    		{
    			String text=e.getText();
    			System.out.println(text);
    			if(text.equals(value))
    			{
    				e.click();
    				break;
    			}}
    		
	
	}
     
     //************************************************ Actions Class
     
     
     
     public  void ParentChildMenu(By parentMenu,By childMenu) throws InterruptedException
 	{
 		/*
 		 * By addons= By.xpath("//div[text()='Add-ons']"); By visaServices =
 		 * By.xpath("//div[text()='Visa Services']");
 		 */
 		act.moveToElement(getElement(parentMenu)).perform();
 		Thread.sleep(5000);
 		doClick(childMenu);
 	}
 	
 		public  void ParentChildMenu(String parentMenu,String childMenu) throws InterruptedException
 		{
 			/*
 			 * By addons= By.xpath("//div[text()='Add-ons']"); By visaServices =
 			 * By.xpath("//div[text()='Visa Services']");
 			 */
 			act.moveToElement(getElement(By.xpath("//*[text()='"+parentMenu+"']"))).perform();
 			Thread.sleep(5000);
 			
 			getElement(By.xpath("//*[text()='"+childMenu+"']")).click();
 		}
 		
 		//*************2 level
 		
 		public  void ParentChildMenu(By level1, By level2, By level3, By level4) throws InterruptedException 
 		{		
 			getElement(level1).click();
 			Thread.sleep(1000);
 			act.moveToElement(getElement(level2)).perform();
 			Thread.sleep(1000);
 			act.moveToElement(getElement(level3)).perform();
 			Thread.sleep(1000);
 			getElement(level4).click();
 		}
 		
 		public void doActionsClick(By locator) {
 			Actions act = new Actions(driver);
 			act.click(getElement(locator)).perform();
 		}
 		
 		public void doActionsSendKeys(By locator, String value) {
 			Actions act = new Actions(driver);
 			act.sendKeys(getElement(locator), value).perform();
 		}
 		
 		public  void doActionSendKeysWithPause(By locator, String value, long pauseTime)
 		{
 			Actions act= new Actions(driver);
 			char ch[] = value.toCharArray();
 			for (char c :ch)
 			{
 				act.sendKeys(getElement(locator), String.valueOf(c)).pause(pauseTime).perform();
 			}
 		}
 		
 	// ***********wait utils********//

 		/**
 		 * An expectation for checking that an element is present on the DOM of a page.
 		 * This does not necessarily mean that the element is visible on the page.
 		 * 
 		 * @param locator
 		 * @param timeOut
 		 * @return
 		 */
 		public WebElement waitForElementPresence(By locator, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
 		}

 		/**
 		 * An expectation for checking that an element is present on the DOM of a page
 		 * and visible on the page as well. Visibility means that the element is not
 		 * only displayed but also has a height and width that is greater than 0.
 		 * default polling time/interval time = 500ms
 		 * @param locator
 		 * @param timeOut
 		 * @return
 		 */
 		public WebElement waitForElementVisible(By locator, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
 		}
 		
 		public WebElement waitForElementVisible(By locator, int timeOut, int intervalTime) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
 			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
 		}
 		
 		/**
 		 * An expectation for checking an element is visible and enabled such that you can click it.
 		 */
 		public void waitForElementAndClick(By locator, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
 		}
 		
 		/**
 		 * An expectation for checking that all elements present on the web page that match the locator are visible.
 		 *  Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
 		 * @param locator
 		 * @param timeOut
 		 * @return
 		 */
 		public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
 		}
 		
 		/**
 		 * An expectation for checking that there is at least one element present on a web page.
 		 * @param locator
 		 * @param timeOut
 		 * @return
 		 */
 		public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
 		}
 		
 		
 		public String getPageTitleIs(String expectedTitle, int timeOut) {
 			if(waitForTitleIs(expectedTitle, timeOut)) {
 				return driver.getTitle();
 			}
 			else {
 				return "-1";
 			}
 		}
 		
 		public String getPageTitleContains(String expectedTitle, int timeOut) {
 			if(waitForTitleContains(expectedTitle, timeOut)) {
 				return driver.getTitle();
 			}
 			else {
 				return "-1";
 			}
 		}
 		

 		public boolean waitForTitleIs(String expectedTitle, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			try {
 				return wait.until(ExpectedConditions.titleIs(expectedTitle));//if title is not matched, it will be throw timeOut exception
 			} catch (TimeoutException e) {
 				System.out.println("title is not matched");
 				return false;
 			}
 		}
 		
 		
 		public boolean waitForTitleContains(String fractionTitle, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			try {
 				return wait.until(ExpectedConditions.titleContains(fractionTitle));
 			} catch (TimeoutException e) {
 				System.out.println("title is not matched");
 				return false;
 			}
 		}
 		
 		
 		public String waitForTitleContainsAndReturn(String fractionTitle, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			try {
 				 wait.until(ExpectedConditions.titleContains(fractionTitle));
 				 return driver.getTitle();
 			} catch (TimeoutException e) {
 				System.out.println("title is not matched");
 				return "-1";
 			}
 		}
 			
 		
 		public String getPageURLContains(String fractionURL, int timeOut) {
 			if(waitForURLContains(fractionURL, timeOut)) {
 				return driver.getCurrentUrl();
 			}
 			else {
 				return "-1";
 			}
 		}
 			
 		
 		public boolean waitForURLContains(String fractionURL, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			try {
 				return wait.until(ExpectedConditions.urlContains(fractionURL));//true
 			} catch (TimeoutException e) {
 				System.out.println("URL is not matched");
 				return false;
 			}
 			
 		}
 		
 		
 		public String waitForURLContainsAndReturn(String fractionURL, int timeOut) {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
 			try {
 				 wait.until(ExpectedConditions.urlContains(fractionURL));//true
 				return driver.getCurrentUrl();
 			} catch (TimeoutException e) {
 				System.out.println("URL is not matched");
 				return "-1";
 			}
 			
 		}
 		
 		
 		
 		
 		
	}
	
