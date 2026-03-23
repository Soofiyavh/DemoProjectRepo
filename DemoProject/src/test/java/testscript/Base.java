package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ScreenShotUtility;
import constant.Constant;

public class Base {

public WebDriver driver;
public Properties properties;
public FileInputStream fileinputstream;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser") //name of parameter and its value assigns to this browser eg:browser=Chrome
	public void browserInitialization(String browser) throws Exception     //it works according to the parameters
	{
		try {
			properties=new Properties();
			fileinputstream=new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(browser.equalsIgnoreCase("Chrome"))
		{
		driver=new ChromeDriver(); //opens the chrome browser
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
	        driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("invalid");
		}
		//driver.get("https://groceryapp.uniqassosiates.com/admin");   //opens the given url
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();       //used to maximize the window
		
	}

	//@AfterMethod(alwaysRun=true)
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus()==iTestResult.FAILURE) {
			ScreenShotUtility screenshot=new ScreenShotUtility();
			screenshot.getScreenShot(driver, iTestResult.getName()); //method to take srrenshot of failed testcases before browser close
		}
		
		driver.quit();
	}
}
