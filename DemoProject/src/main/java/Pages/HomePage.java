package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	//with page factory
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement managenewsmoreinfo;
	
	
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminicon;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logouticon;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ManageNewsPage clickOnManageNewsMoreInfo()
	{
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	
	
	
	
	
	
	public void clickOnAdminIcon()
	{
		adminicon.click();
	}
	
	public void clickOnLogout()
	{
		logouticon.click();
	}
	
	public boolean isSighnButtonDisplayed()
	{
		return signin.isDisplayed(); 
		
	}
}
