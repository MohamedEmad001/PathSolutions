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
	
	public void OpenRegister ()
	{
		clickButton(Registerlink);
	}
	
	public void OpenLogin()
	{
		clickButton(Loginlink);
	}

}
