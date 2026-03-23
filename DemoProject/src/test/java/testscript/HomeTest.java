package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import Pages.LoginPage;
import Pages.HomePage;
import Utilities.ExcelUtility;

public class HomeTest extends Base{

	@Test(description = "Verify if the user can logout successfully")
	public void verifyTheUserIsAbleToLogoutSuccessfully() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignInButton();

		HomePage logout = new HomePage(driver);
		logout.clickOnAdminIcon();
		logout.clickOnLogout();
		boolean loginpagelogout = logout.isSighnButtonDisplayed();
		Assert.assertTrue(loginpagelogout,Constant.LOGOUT);
	}
}
