package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy (id="Email")
	WebElement Loginemail;

	@FindBy (id = "Password")
	WebElement Loginpassword;

	@FindBy (id = "RememberMe")
	WebElement Rememberme;

	@FindBy (css = "input.button-1.login-button")
	WebElement Loginbtn;

	public void UserLogin(String mail , String password)
	{
		setTextElementText(Loginemail, mail);
		setTextElementText(Loginpassword, password);
		Checkingcheckbox(Rememberme);
		clickButton(Loginbtn);
	}

}
