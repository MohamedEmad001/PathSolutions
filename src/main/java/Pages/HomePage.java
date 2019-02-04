package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (linkText = "Register")
	WebElement Registerlink;
	
	@FindBy (linkText = "Log in")
	WebElement Loginlink;
	
	@FindBy (linkText = "My account")
	WebElement MyAccount;
	
	public void OpenRegister ()
	{
		clickButton(Registerlink);
	}
	
	public void OpenLogin()
	{
		clickButton(Loginlink);
	}
	
	public void OpenMyAccount()
	{
		clickButton(MyAccount);
	}

}
