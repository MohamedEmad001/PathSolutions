package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;


public class MyAccountTest extends TestBase {
	
	HomePage homepage;
	UserRegistrationPage registrationPage;
	MyAccountPage MyAccount;
	String firstpassword = "123456";
	String newpassword = "123456789";
	String Firstname = "mohamed";
	String Lastname = "emad";
	String email = "med1o11233@gmail.com";
	
	
	
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homepage = new HomePage(driver);
		homepage.OpenRegister();
		registrationPage = new UserRegistrationPage(driver);
		registrationPage.userRegistration(Firstname, Lastname,email,firstpassword);
		Assert.assertTrue(registrationPage.successMessage.getText().contains("Your registration completed"));
	}
	
	
	@Test(priority = 2)
	public void ChangePasswordSuccessfully()
	{
		homepage = new HomePage(driver);
		homepage.OpenMyAccount();
		MyAccount = new MyAccountPage(driver);
		MyAccount.OpenChangePassword();
		MyAccount.ChangePassword(firstpassword, newpassword);
		Assert.assertTrue(MyAccount.ResultStatus.getText().contains("Password was changed"));
	}
	
	@Test (priority = 3)
	public void UserLogOut()
	{
		registrationPage.userLogout();
	}
	
	@Test (priority = 4)
	public void UserCanLoginSuccessfully()
	{
		homepage.OpenLogin();
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.UserLogin(email, newpassword);
		Assert.assertTrue(registrationPage.logoutLink.getText().contains("Log out"));
	}

}
