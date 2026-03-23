package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //contains only webelements and methods
	
	public WebDriver driver;
	//with page factory
	@FindBy(xpath="//input[@name='username']")WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")WebElement passwordfield;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")WebElement alert;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterTheUsername(String username)
	{
		usernamefield.sendKeys(username);
		return this;
	}
	
	public LoginPage enterThePassword(String password)
	{
		passwordfield.sendKeys(password);
		return this;
	}
	
	public HomePage clickOnSignInButton()
	{
		signin.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed(); 
		
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
