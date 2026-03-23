package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import Utilities.ExcelUtility;

public class ManageNewsTest extends Base{

	public HomePage homepage;
	public ManageNewsPage managenewspage;
	@Test
	public void verifyTheUserIsAbleToAddNewNewsAndDisplaysAlert() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		String news=ExcelUtility.readStringData(0, 0, "ManageNews");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//	loginpage.enterThePassword(password);
			homepage=loginpage.clickOnSignInButton();
		
		//ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage=homepage.clickOnManageNewsMoreInfo();
	    managenewspage.clickOnNewButton().enterTheNews(news).clickOnSave();
//	    managenewspage.enterTheNews(news);
//	    managenewspage.clickOnSave();
	    boolean successalert=managenewspage.isAlertDisplayed();
	    Assert.assertTrue(successalert);		
	}
	
}
