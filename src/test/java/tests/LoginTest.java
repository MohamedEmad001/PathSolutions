package tests;

import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends TestBase {

	String UserName = "administrator";
	String UserPass = "admin12";
	
	
	@Test (priority = 1)
	public void CheckLogin() throws InterruptedException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(UserName, UserPass);

	}

}
