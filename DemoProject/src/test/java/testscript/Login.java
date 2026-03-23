package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends Base {

	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredentials()
	{
	String username="admin";
	String password="admin";
	
	WebElement usrnamefield=driver.findElement(By.xpath("//input[@name='username']"));
	usrnamefield.sendKeys(username);
	
	WebElement pswdfield=driver.findElement(By.xpath("//input[@name='password']"));
	pswdfield.sendKeys(password);
	
	WebElement sighin=driver.findElement(By.xpath("//button[text()='Sign In']"));
	sighin.click();
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidUsernameAndInvalidPassword()
	{
		String username="admin";
		String password="admin12";
		
		WebElement usrnamefield=driver.findElement(By.xpath("//input[@name='username']"));
		usrnamefield.sendKeys(username);
		
		WebElement pswdfield=driver.findElement(By.xpath("//input[@name='password']"));
		pswdfield.sendKeys(password);
		
		WebElement sighin=driver.findElement(By.xpath("//button[text()='Sign In']"));
		sighin.click();
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndValidPassword()
	{
		String username="admin1234";
		String password="admin";
		
		WebElement usrnamefield=driver.findElement(By.xpath("//input[@name='username']"));
		usrnamefield.sendKeys(username);
		
		WebElement pswdfield=driver.findElement(By.xpath("//input[@name='password']"));
		pswdfield.sendKeys(password);
		
		WebElement sighin=driver.findElement(By.xpath("//button[text()='Sign In']"));
		sighin.click();
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndInvalidPassword()
	{
		String username="admin1456";
		String password="admin13";
		
		WebElement usrnamefield=driver.findElement(By.xpath("//input[@name='username']"));
		usrnamefield.sendKeys(username);
		
		WebElement pswdfield=driver.findElement(By.xpath("//input[@name='password']"));
		pswdfield.sendKeys(password);
		
		WebElement sighin=driver.findElement(By.xpath("//button[text()='Sign In']"));
		sighin.click();
	}
	
}
