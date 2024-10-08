package mytests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGFeatures 
{
	@BeforeSuite
public void connectWithDB()
{
System.out.println("Before Suite");	
}

@BeforeTest
public void createUser()
{
System.out.println("BeforeTest");	
}

@BeforeClass
public void openBrowser()
{
System.out.println("BeforeClass");	
}

@BeforeMethod
public void loginToApp()
{
System.out.println("BeforeMethod");	
}
@Test
public void searchTest1()
{
System.out.println("Test1");
}
@Test
public void searchTest2()
{
System.out.println("Test2");
}
@Test
public void searchTest3()
{
System.out.println("Test3");
}

@AfterMethod

public void AfterMethod()
{
	System.out.println("AfterMethod");	
}

@AfterClass

public void AfterClass()
{
	System.out.println("AfterClass");	
}

@AfterTest
public void AfterTest()
{
	System.out.println("AfterTest");	
}

@AfterSuite
public void AfterSuite()
{
	System.out.println("AfterSuite");	
}

}
